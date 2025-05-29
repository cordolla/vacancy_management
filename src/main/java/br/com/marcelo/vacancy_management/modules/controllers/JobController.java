package br.com.marcelo.vacancy_management.modules.controllers;

import br.com.marcelo.vacancy_management.modules.dto.CreateJobDTO;
import br.com.marcelo.vacancy_management.modules.entities.JobEntity;
import br.com.marcelo.vacancy_management.modules.services.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping(value = "/")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create(@Valid @RequestBody CreateJobDTO dto, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder()
                .benefits(dto.getBenefits())
                .companyId(UUID.fromString(companyId.toString()))
                .description(dto.getDescription())
                .level(dto.getLevel())
                .build();

        return createJobService.execute(jobEntity);
    }
}
