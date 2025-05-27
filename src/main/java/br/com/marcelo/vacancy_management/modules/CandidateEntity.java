package br.com.marcelo.vacancy_management.modules;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
public class CandidateEntity {

    @Id
    private UUID id;
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo não deve conter espaço")
    private String username;

    @Email(message = "O campo deve conter um email valido")
    private String email;

    @Length(min = 8, max = 30)
    private String password;
    private String description;
    private String curriculum;
}
