package technifutur.be.technifutur.services;

import technifutur.be.technifutur.exceptions.EntityNotFoundException;
import technifutur.be.technifutur.models.entities.Client;
import technifutur.be.technifutur.repositories.ClientRepository;
import technifutur.be.technifutur.repositories.ClientRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl {

    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    public Client getOne(Integer id){
        return clientRepository.getOne(id);
    }

    public List<Client> getMany(){
        return clientRepository.getMany();
    }

    public Client add(Client client) {

       return clientRepository.add(client);

    }

    public boolean delete(Integer id){
        if(!clientRepository.delete(id))
            throw new EntityNotFoundException();

        return true;
    }

    public boolean update(Integer id, Client client){
        if(!clientRepository.update(id, client))
            throw new EntityNotFoundException();

        return true;
    }

    public Client getAllInfoById(Integer id){
        return clientRepository.getAllInfoById(id);
    }

}
