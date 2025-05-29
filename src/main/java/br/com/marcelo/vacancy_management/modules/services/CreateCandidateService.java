package br.com.marcelo.vacancy_management.modules.services;

import br.com.marcelo.vacancy_management.exceptions.UserFoundException;
import br.com.marcelo.vacancy_management.modules.entities.CandidateEntity;
import br.com.marcelo.vacancy_management.modules.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidate) {
        candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        var password = passwordEncoder.encode(candidate.getPassword());
        candidate.setPassword(password);

        return candidateRepository.save(candidate);
    }
}
