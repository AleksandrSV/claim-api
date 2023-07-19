package tech.rowi.dbo.claimapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.rowi.dbo.claimapi.model.StatusHistory;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long> {
}
