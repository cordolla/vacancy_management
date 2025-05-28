package br.com.marcelo.vacancy_management.modules.services;

import br.com.marcelo.vacancy_management.exceptions.CompanyFoundException;
import br.com.marcelo.vacancy_management.modules.entities.CompanyEntity;
import br.com.marcelo.vacancy_management.modules.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public CompanyEntity execute(CompanyEntity company) {
        companyRepository
                .findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent((x) -> {
                    throw new CompanyFoundException();
                });

        var password = passwordEncoder.encode(company.getPassword());
        company.setPassword(password);

        return companyRepository.save(company);

    }
}
