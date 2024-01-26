package br.com.desafio.desafio.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

@MappedSuperclass
public abstract class User {

    private final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    @Column(name ="name")
    private String name;
    @Column(name = "email")
    @Pattern(regexp = EMAIL_REGEX ,message = "formato invalido")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "money")
    private BigDecimal money;

    private boolean deleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
