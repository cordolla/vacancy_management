package br.com.marcelo.vacancy_management.modules.services;

import br.com.marcelo.vacancy_management.modules.entities.JobEntity;
import br.com.marcelo.vacancy_management.modules.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity job){
        return jobRepository.save(job);
    }
}
