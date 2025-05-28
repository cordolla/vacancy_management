package br.com.marcelo.vacancy_management.modules.controllers;

import br.com.marcelo.vacancy_management.modules.entities.JobEntity;
import br.com.marcelo.vacancy_management.modules.services.CreateJobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping(value = "/")
    public JobEntity create(@Valid @RequestBody JobEntity job){
        return createJobService.execute(job);
    }
}
