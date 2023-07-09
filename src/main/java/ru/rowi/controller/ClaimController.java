package ru.rowi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rowi.model.Claim;
import ru.rowi.service.ClaimService;

import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    // 2
    @GetMapping
    public ResponseEntity<?> getClaims(){
        return ResponseEntity.ok("Получить список обращений");
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
    public ResponseEntity<?> createClaim(){
        return ResponseEntity.ok("Создание обращения");
    }
    // editing
    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> editClaim(@PathVariable String id){
        return ResponseEntity.ok("Редактирование обращения");
    }

    // 5
    @PatchMapping(value = "/{id}/update", produces = "application/json")
    public ResponseEntity<?> patchClaim(@PathVariable String id){
        return ResponseEntity.ok("Обновление обращения");
    }

    // 6
    @PatchMapping(value = "/{id}/assign", produces = "application/json")
    public ResponseEntity<?> assignClaim(@PathVariable String id){
        return ResponseEntity.ok("Взять обращение в работу");
    }

    // 7
    @PatchMapping(value = "/{id}/forward", produces = "application/json")
    public ResponseEntity<?> forwardClaim(@PathVariable String id){
        return ResponseEntity.ok("Перевести в другое подразделение");
    }

    // 8
    @PatchMapping(value = "/{id}/close", produces = "application/json")
    public ResponseEntity<?> closeClaim(@PathVariable String id){
        return ResponseEntity.ok("Закрыть обращение");
    }

    // 9
    @PatchMapping(value = "/{id}/pause", produces = "application/json")
    public ResponseEntity<?> takeClaim(@PathVariable String id){
        return ResponseEntity.ok("Перевести в ожидание");
    }
}
