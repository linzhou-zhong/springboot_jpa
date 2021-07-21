package com.linzhou.springboot_hibernate.web;

import com.linzhou.springboot_hibernate.entities.Customer;
import com.linzhou.springboot_hibernate.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String welcome(){
        return "Connected to Server successfully!";
    }

    @GetMapping("/customers")
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/name/{name}")
    public List<Customer> customer(@PathVariable String name){
        return customerRepository.findByNameContains(name);
    }

    @GetMapping("/customers/id/{id}")
    public Customer customer(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public Customer saveCustomer(final @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @DeleteMapping("/customers/id/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
    }

}
