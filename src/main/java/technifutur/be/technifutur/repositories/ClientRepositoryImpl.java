package technifutur.be.technifutur.repositories;

import technifutur.be.technifutur.exceptions.EntityException;
import technifutur.be.technifutur.exceptions.EntityNotFoundException;
import technifutur.be.technifutur.models.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepositoryImpl extends BaseRepositoryImpl<Client> implements ClientRepository{

    public ClientRepositoryImpl(){
        super("CLIENT", "CLIENT_ID");
    }

    @Override
    protected Client buildEntity(ResultSet rs){

        try {
            return Client.builder()
                    .id(rs.getInt("CLIENT_ID"))
                    .firstName(rs.getString("FIRSTNAME"))
                    .lastName(rs.getString("LASTNAME"))
                    .email(rs.getString("EMAIL"))
                    .phoneNumber(rs.getString("PHONENUMBER"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client add(Client client, Connection conn){

        try{
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO  CLIENT (FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER) VALUES (?,?,?,?) RETURNING * ");
            psmt.setString(1, client.getFirstName());
            psmt.setString(2, client.getLastName());
            psmt.setString(3, client.getEmail());
            psmt.setString(4, client.getPhoneNumber());
            ResultSet rs = psmt.executeQuery();
            if(!rs.next())
                throw new EntityException("Failed");

            return buildEntity(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Client add(Client client) {

        return add(client,openConnection());
    }

    @Override
    public boolean update(Integer id, Client client) {

        try {
            Connection conn = openConnection();
            PreparedStatement psmt = conn.prepareStatement("UPDATE CLIENT SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONENUMBER = ? WHERE CLIENT_ID = ?");
            psmt.setString(1, client.getFirstName());
            psmt.setString(2, client.getLastName());
            psmt.setString(3, client.getEmail());
            psmt.setString(4, client.getPhoneNumber());
            psmt.setInt(5, id);

            int nbRows = psmt.executeUpdate();

            conn.close();

            return nbRows == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client getAllInfoById(Integer id) {

        try {
            Connection conn = openConnection();

            PreparedStatement psmt = conn.prepareStatement("select * from CLIENT where CLIENT_ID = ?");

            psmt.setInt(1,id);

            ResultSet rs = psmt.executeQuery();

            if(!rs.next()){
                throw new EntityNotFoundException();
            }
            conn.close();
            return buildEntity(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
