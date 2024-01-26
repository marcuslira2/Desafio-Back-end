package br.com.desafio.desafio.service;

import br.com.desafio.desafio.dto.client.CustomerCreateDto;
import br.com.desafio.desafio.dto.client.CustomerDto;
import br.com.desafio.desafio.model.Customer;
import br.com.desafio.desafio.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto customerToDto(Customer customer){
        return new CustomerDto(
              customer.getName(),
              customer.getMoney()
        );
    }

    public Customer save(CustomerCreateDto customerCreateDto) throws Exception {
        Optional<Customer> clientEmailvalidate = customerRepository.findByEmail(customerCreateDto.email());
        Optional<Customer> clientCpfValidate = customerRepository.findbyCpf(customerCreateDto.cpf());
        if (clientEmailvalidate.isPresent()){
            throw new Exception("User exists, try another email");
        }
        if (clientCpfValidate.isPresent()){
            throw new Exception("User exists, try another cpf");
        }

        Customer customer = new Customer();

        customer.setCpf(customerCreateDto.cpf());
        customer.setEmail(customerCreateDto.email());
        customer.setName(customerCreateDto.name());
        customer.setMoney(customerCreateDto.money());
        customer.setPassword(customerCreateDto.password());

        return customerRepository.save(customer);
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public CustomerDto findById(Long id) throws Exception {
        Optional<Customer> customerById = customerRepository.findById(id);
        Customer customer = customerById.orElseThrow(()-> new Exception("User does not exists"));
        CustomerDto customerDto = this.customerToDto(customer);

        return customerDto;
    }


    public String delete (Long id) throws Exception {
        Optional<Customer> customerById = customerRepository.findById(id);
        Customer customer = customerById.orElseThrow(()-> new Exception("User does not exists"));
        customer.setDeleted(true);
        customerRepository.save(customer);
        return "Custumer "+customer.getName()+" was deleted";
    }
}
