package ru.rowi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/references")
public class ReferenceController {
    @GetMapping
    public ResponseEntity<?> getReferences(){
        return ResponseEntity.ok("references");
    }
}
