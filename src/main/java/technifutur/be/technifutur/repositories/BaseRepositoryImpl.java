package technifutur.be.technifutur.repositories;

import technifutur.be.technifutur.exceptions.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.postgresql.core.ConnectionFactory.openConnection;

public abstract class BaseRepositoryImpl<TEntity> implements BaseRepository<TEntity>{

    private final String tableName;
    private final String columnIdName;

    public BaseRepositoryImpl(String tableName, String columnIdName) {
        this.tableName = tableName;
        this.columnIdName = columnIdName;
    }

    protected abstract TEntity buildEntity(ResultSet rs);
    protected Connection openConnection(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/JavaWebb", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public TEntity getOne(Integer id) {
        try {
            Connection conn = openConnection();

            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE " + columnIdName + " = ?");

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

    @Override
    public List<TEntity> getMany() {
        try {
            Connection conn = openConnection();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM " + tableName);

            List<TEntity> entities = new ArrayList<>();

            while (rs.next()) {

                entities.add(buildEntity(rs));
            }

            conn.close();
            return entities;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public abstract TEntity add(TEntity entity,Connection conn);
    @Override
    public abstract TEntity add(TEntity entity);

    @Override
    public abstract boolean update(Integer id, TEntity entity);
    @Override
    public boolean delete(Integer id) {
        try {
            Connection conn = openConnection();
            PreparedStatement psmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE " + columnIdName + " = ?");
            psmt.setInt(1,id);

            int nbRow = psmt.executeUpdate();
            conn.close();
            return  nbRow == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
