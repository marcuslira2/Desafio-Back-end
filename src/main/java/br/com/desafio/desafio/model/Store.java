package br.com.desafio.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity(name = "store")
public class Store extends User{

    private final String CNPJ_REGEX = "^(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}|\\d{14})$";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cnpj")
    @Pattern(regexp = CNPJ_REGEX, message = "CNPJ inválido")
    private String cnpj;

    public Store() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
