package technifutur.be.technifutur.repositories;

import technifutur.be.technifutur.models.entities.Client;


public interface ClientRepository extends BaseRepository<Client> {

    public abstract Client getAllInfoById(Integer id);

}
