package com.linzhou.springboot_hibernate.Service;

import com.linzhou.springboot_hibernate.entities.Customer;
import com.linzhou.springboot_hibernate.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer add(Customer customer){
        Customer c = null;

        if (customer != null) {
            c = customerRepository.save(customer);
        }

        return c;
    }

    public List<Customer> find(){
        List<Customer> c = null;

        c = customerRepository.findAll();

        return c;
    }

    public Customer findById(Long id){
        Customer c = null;

        if (id != null){
            if (customerRepository.findById(id).isPresent())
                c = customerRepository.findById(id).get();
        }

        return c;
    }

    public List<Customer> findByName(String name){
        List<Customer> c = null;

        if (name != null){
            c = customerRepository.findByNameContains(name);
        }

        return c;
    }

    public List<Customer> findBySalary(int salary){
        List<Customer> c = null;

        if (salary >= 0){
            c = customerRepository.findBySalary(salary);
        }

        return c;
    }

    public boolean removeById(Long id){
        if (id != null){
            customerRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
