package br.com.desafio.desafio.controller;

import br.com.desafio.desafio.dto.client.CustomerCreateDto;
import br.com.desafio.desafio.dto.client.CustomerDto;
import br.com.desafio.desafio.model.Customer;
import br.com.desafio.desafio.service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> list(){
        List<Customer> customers = customerService.list();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) throws Exception {
        CustomerDto customerDto = customerService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDto);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Validated CustomerCreateDto customerCreateDto) throws Exception {
        Customer customer = customerService.save(customerCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
        String customerDeleted = customerService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDeleted);
    }

}
