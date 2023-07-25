package tech.rowi.dbo.claimapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.model.Client;
import tech.rowi.dbo.claimapi.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repo;

    public Client save(Client client) {
        if (client.getId() == null && repo.exists(Example.of(client))) {
            return repo.findOne(Example.of(client)).get();
        }
        return repo.save(client);
    }
}
