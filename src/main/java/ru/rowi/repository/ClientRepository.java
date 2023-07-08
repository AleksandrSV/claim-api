package ru.rowi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rowi.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
