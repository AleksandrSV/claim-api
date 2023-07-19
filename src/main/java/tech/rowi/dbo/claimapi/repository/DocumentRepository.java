package tech.rowi.dbo.claimapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.rowi.dbo.claimapi.model.Document;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
