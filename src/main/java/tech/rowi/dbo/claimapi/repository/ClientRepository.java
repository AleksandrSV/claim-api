package tech.rowi.dbo.claimapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.rowi.dbo.claimapi.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
