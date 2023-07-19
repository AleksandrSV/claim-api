package tech.rowi.dbo.claimapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.rowi.dbo.claimapi.dto.response.ReferenceResponse;


@RestController
@RequestMapping("/api/references")
public class ReferenceController {
    @Autowired
    ReferenceResponse referenceResponse;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getReferences() {
        return ResponseEntity.ok(referenceResponse);
    }

}
