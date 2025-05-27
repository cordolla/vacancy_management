package br.com.marcelo.vacancy_management.modules.repositories;

import br.com.marcelo.vacancy_management.modules.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
