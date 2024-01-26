package br.com.desafio.desafio.repository;

import br.com.desafio.desafio.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT c FROM client c WHERE c.email = :email AND c.deleted != true")
    Optional<Customer> findByEmail(String email);

    @Query("SELECT c FROM client c WHERE c.cpf = :cpf AND c.deleted != true")
    Optional<Customer> findbyCpf(String cpf);
}
