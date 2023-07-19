package tech.rowi.dbo.claimapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.rowi.dbo.claimapi.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
