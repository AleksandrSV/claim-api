package ru.rowi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rowi.dto.reference.ReferenceResponse;

import javax.persistence.Access;

@RestController
@RequestMapping("/references")
public class ReferenceController {
    @Autowired
    ReferenceResponse referenceResponse;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getReferences() {
        return ResponseEntity.ok(referenceResponse);
    }

}
