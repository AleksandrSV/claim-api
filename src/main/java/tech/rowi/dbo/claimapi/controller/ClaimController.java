package tech.rowi.dbo.claimapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.rowi.dbo.claimapi.dto.request.*;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.service.ClaimService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;

    // 2
    @GetMapping
    public ResponseEntity<?> getClaims(@RequestBody ClaimFilterRequest request) {
        Page<Claim> claimsPage = claimService.getClaimsByFilters(request);
        List<Claim> claimsList = claimsPage.getContent();
        return ResponseEntity.ok(claimsList);
    }

    // 3
    @GetMapping("/{id}")
    public ResponseEntity<?> getClaimById(@PathVariable Long id){
        Optional<Claim> claim = claimService.getClaimById(id);
        if(claim.isEmpty())
            return ResponseEntity.status(404).body("Not found");
        return ResponseEntity.ok(claim.get());
    }

    // 4
    // creating
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createClaim(@RequestBody ClaimPostRequest request){
        return ResponseEntity.ok(claimService.createClaim(request));
    }

    // editing
    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> editClaim(@PathVariable String id){
        return ResponseEntity.ok("Редактирование обращения");
    }

    // 5
    @PatchMapping(value = "/{id}/update", produces = "application/json")
    public ResponseEntity<?> patchClaim(@RequestBody ClaimUpdateRequest claimUpdateRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.updateClaim(claimUpdateRequest, id));
    }

    // 6
    @PatchMapping(value = "/{id}/assign", produces = "application/json")
    public ResponseEntity<?> assignClaim(@PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.assignClaim(id));
    }

    // 7.1
    @PatchMapping(value = "/{id}/reassign", produces = "application/json")
    public ResponseEntity<?> reassignClaim(@RequestBody String assignee, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.reassignClaim(assignee, id));
    }

    // 7.2
    @PatchMapping(value = "/{id}/forward", produces = "application/json")
    public ResponseEntity<?> forwardClaim(@RequestBody ClaimForwardRequest claimForwardRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.forwardClaim(claimForwardRequest, id));
    }

    // 8
    @PatchMapping(value = "/{id}/close", produces = "application/json")
    public ResponseEntity<?> closeClaim(@RequestBody ClaimCloseRequest claimCloseRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.closeClaim(claimCloseRequest, id));
    }

    // 9
    @PatchMapping(value = "/{id}/pause", produces = "application/json")
    public ResponseEntity<?> takeClaim(@RequestBody ClaimPauseRequest claimPauseRequest, @PathVariable Long id){
        return ResponseEntity.ok("Перевести в ожидание");
    }
}
