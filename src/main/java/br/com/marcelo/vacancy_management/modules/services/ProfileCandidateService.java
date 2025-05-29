package br.com.marcelo.vacancy_management.modules.services;

import br.com.marcelo.vacancy_management.modules.dto.ProfileCandidateResponseDTO;
import br.com.marcelo.vacancy_management.modules.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidato){
        var candidate = this.candidateRepository.findById(idCandidato)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getEmail())
                .email(candidate.getEmail())
                .id(candidate.getId())
                .name(candidate.getName())
                .build();

        return candidateDTO;

    }

}
