package ru.rowi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rowi.model.Document;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
