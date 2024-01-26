package br.com.desafio.desafio.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record CustomerCreateDto(@NotBlank String name,
                                @NotBlank @Pattern(regexp = EMAIL_REGEX,message = "Email invalid") String email,
                                @NotBlank @Pattern(regexp = CPF_REGEX,
                                   message = "CPF inválido")
                           String cpf,
                                @NotBlank String password,
                                BigDecimal money) {

    private static final String CPF_REGEX ="^(?!000\\.000\\.000-00|111\\.111\\.111-11|222\\.222\\.222-22|333\\.333\\.333-33|444\\.444\\.444-44|555\\.555\\.555-55|666\\.666\\.666-66|777\\.777\\.777-77|888\\.888\\.888-88|999\\.999\\.999-99)[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$" ;
    private static final String EMAIL_REGEX ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
}
