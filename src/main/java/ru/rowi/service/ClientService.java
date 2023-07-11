package ru.rowi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rowi.model.Client;
import ru.rowi.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;

    public Client save(Client client) {
        return repo.save(client);
    }
}
