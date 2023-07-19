package tech.rowi.dbo.claimapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.model.Client;
import tech.rowi.dbo.claimapi.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;

    public Client save(Client client) {
        return repo.save(client);
    }
}
