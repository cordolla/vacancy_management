package br.com.marcelo.vacancy_management.modules.controllers;


import br.com.marcelo.vacancy_management.exceptions.UserFoundException;
import br.com.marcelo.vacancy_management.modules.entities.CandidateEntity;
import br.com.marcelo.vacancy_management.modules.repositories.CandidateRepository;
import br.com.marcelo.vacancy_management.modules.services.CreateCandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateService createCandidateService;

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
        try {
            var result = this.createCandidateService.execute(candidate);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public List<CandidateEntity> findAll() {
        return candidateRepository.findAll();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id) {
        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new UserFoundException();
        }

    }
}


