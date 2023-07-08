package ru.rowi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rowi.model.StatusHistory;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long> {
}
