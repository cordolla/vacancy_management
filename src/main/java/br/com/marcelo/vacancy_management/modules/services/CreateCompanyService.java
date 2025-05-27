package br.com.marcelo.vacancy_management.modules.services;

import br.com.marcelo.vacancy_management.exceptions.CompanyFoundException;
import br.com.marcelo.vacancy_management.modules.entities.CompanyEntity;
import br.com.marcelo.vacancy_management.modules.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity company){
        companyRepository
                .findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent((x) -> {
                    throw new CompanyFoundException();
                });

        return companyRepository.save(company);

    }
}
