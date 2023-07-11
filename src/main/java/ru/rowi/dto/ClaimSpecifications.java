package ru.rowi.dto;

import org.springframework.data.jpa.domain.Specification;
import ru.rowi.dto.request.ClaimFilterRequest;
import ru.rowi.model.Claim;

import javax.persistence.criteria.Predicate;

public class ClaimSpecifications {

    public static Specification<Claim> findByFilters(ClaimFilterRequest request) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (request.getCategory() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("category"), request.getCategory()));
            }
            if (request.getChannel() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("channel"), request.getChannel()));
            }
            if (request.getInitiatorType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("initiatorType"), request.getInitiatorType()));
            }

            if (request.getIsFirstLine() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("isFirstLine"), request.getIsFirstLine()));
            }
            if (request.getClaimType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("claimType"), request.getClaimType()));
            }
            if (request.getClaimTheme() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("claimTheme"), request.getClaimTheme()));
            }
            if (request.getPriority() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("priority"), request.getPriority()));
            }
            if (request.getStatus() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), request.getStatus()));
            }
            if (request.getAssignee() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("assignee"), request.getAssignee()));
            }
            if (request.getGlobalCompanyId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("clientId").get("globalCompanyId"), request.getGlobalCompanyId()));
            }
            if (request.getClientInn() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("clientId").get("inn"), request.getClientInn()));
            }
            if (request.getClientKpp() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("clientId").get("kpp"), request.getClientKpp()));
            }
            if (request.getClientOgrn() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("clientId").get("ogrn"), request.getClientOgrn()));
            }

            return predicate;
        };
    }
}
