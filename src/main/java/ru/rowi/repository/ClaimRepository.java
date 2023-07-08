package ru.rowi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rowi.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
