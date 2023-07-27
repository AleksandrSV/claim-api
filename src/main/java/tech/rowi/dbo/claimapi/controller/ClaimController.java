package tech.rowi.dbo.claimapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.rowi.dbo.claimapi.dto.reference.*;
import tech.rowi.dbo.claimapi.dto.request.*;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.service.ClaimService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;

    // 2
    @GetMapping
    public ResponseEntity<?> getClaims(
            @Positive @RequestParam(required = false) Integer pageNum,
            @Positive @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) CategoriesEnum category,
            @RequestParam(required = false) ChannelsEnum channel,
            @RequestParam(required = false) InitiatorTypeEnum initiatorType,
            @RequestParam(value = "isFirstLine", required = false) Boolean isFirstLine,
            @RequestParam(required = false) ClaimTypesEnum claimType,
            @RequestParam(required = false) ClaimThemesEnum claimTheme,
            @RequestParam(required = false) PriorityEnum priority,
            @RequestParam(required = false) StatusesEnum status,
            @RequestParam(required = false) String assignee,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime pauseTillFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime pauseTillTill,
            @RequestParam(required = false) @Pattern(regexp = "^(([0-9]{12})|([0-9]{10}))?$", message = "Не соответствует формату ИНН") String clientInn,
            @RequestParam(required = false) @Pattern(regexp = "^([0-9]{9})?$", message = "Не соответствует формату КПП") String clientKpp,
            @RequestParam(required = false) @Pattern(regexp = "^([0-9]{13})?$", message = "Не соответствует формату ОГРН") String clientOgrn
    ) {
        ClaimFilterRequest request = new ClaimFilterRequest(
                pageNum, pageSize,
                category,
                channel,
                initiatorType,
                isFirstLine,
                claimType, claimTheme,
                priority,
                status,
                assignee,
                pauseTillFrom, pauseTillTill,
                clientInn, clientKpp, clientOgrn);
        Page<Claim> claimsPage = claimService.getClaimsByFilters(request);
        List<Claim> claimsList = claimsPage.getContent();
        return ResponseEntity.ok(claimsList);
    }

    // 3
    @GetMapping("/{id}")
    public ResponseEntity<?> getClaimById(@PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.getClaimById(id));
    }

    // 4
    // creating
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createClaim(@Valid @RequestBody ClaimPostRequest request){
        return ResponseEntity.ok(claimService.createClaim(request));
    }

    // editing
    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> editClaim(@Valid @RequestBody ClaimPostRequest request, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.editClaim(request, id));
    }

    // 5
    @PatchMapping(value = "/{id}/update", produces = "application/json")
    public ResponseEntity<?> patchClaim(@Valid @RequestBody ClaimUpdateRequest claimUpdateRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.updateClaim(claimUpdateRequest, id));
    }

    // 6
    @PatchMapping(value = "/{id}/assign", produces = "application/json")
    public ResponseEntity<?> assignClaim(@PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.assignClaim(id));
    }

    // 7.1
    @PatchMapping(value = "/{id}/reassign", produces = "application/json")
    public ResponseEntity<?> reassignClaim(@Valid @RequestBody ClaimReassignRequest claimReassignRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.reassignClaim(claimReassignRequest, id));
    }

    // 7.2
    @PatchMapping(value = "/{id}/forward", produces = "application/json")
    public ResponseEntity<?> forwardClaim(@Valid @RequestBody ClaimForwardRequest claimForwardRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.forwardClaim(claimForwardRequest, id));
    }

    // 8
    @PatchMapping(value = "/{id}/close", produces = "application/json")
    public ResponseEntity<?> closeClaim(@Valid @RequestBody ClaimCloseRequest claimCloseRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.closeClaim(claimCloseRequest, id));
    }

    // 9
    @PatchMapping(value = "/{id}/pause", produces = "application/json")
    public ResponseEntity<?> takeClaim(@RequestBody ClaimPauseRequest claimPauseRequest, @PathVariable Long id) throws FileNotFoundException {
        return ResponseEntity.ok(claimService.pauseClaim(claimPauseRequest, id));
    }
}
