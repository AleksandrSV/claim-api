package ru.rowi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rowi.model.Claim;
import ru.rowi.repository.ClaimRepository;

import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository repo;

    // 3
    public Optional<Claim> getClaimById(Long id) {
        return repo.findById(id);
    }

}
