package tech.rowi.dbo.claimapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.dto.reference.PriorityEnum;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.model.StatusHistory;
import tech.rowi.dbo.claimapi.repository.StatusHistoryRepository;

@Service
@RequiredArgsConstructor
public class StatusHistoryService {
    private final StatusHistoryRepository repo;

    public void save(Claim claim) {
        StatusHistory statusHistory = new StatusHistory();
        statusHistory.setPriority(claim.getPriority());
        statusHistory.setPriorityReason(claim.getPriorityReason());
        statusHistory.setStatus(claim.getStatus());
        statusHistory.setStatusReason(claim.getStatusReason());
        statusHistory.setComment(claim.getComment());
        statusHistory.setClaim(claim);
        repo.save(statusHistory);
    }

}
