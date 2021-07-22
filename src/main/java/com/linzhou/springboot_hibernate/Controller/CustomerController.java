package com.linzhou.springboot_hibernate.Controller;

import com.linzhou.springboot_hibernate.Service.CustomerService;
import com.linzhou.springboot_hibernate.entities.Customer;
import com.linzhou.springboot_hibernate.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String welcome(){
        return "Connected to Server successfully!";
    }

    @GetMapping("/customers")
    public List<Customer> customers(){
        return customerService.find();
    }

    @GetMapping("/customers/name/{name}")
    public List<Customer> customer(@PathVariable String name){
        return customerService.findByName(name);
    }

    @GetMapping("/customers/id/{id}")
    public Customer customer(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(final @RequestBody Customer customer){
        return customerService.add(customer);
    }

    @DeleteMapping("/customers/id/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.removeById(id);
    }

}
