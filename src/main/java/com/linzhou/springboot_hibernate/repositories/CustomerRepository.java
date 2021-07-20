package com.linzhou.springboot_hibernate.repositories;

import com.linzhou.springboot_hibernate.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByNameContains(String s);
    public Page<Customer> findByNameContains(String name, Pageable pageable);
    public List<Customer> findByBirthDate(Data data);
    public List<Customer> findBySalary(int s);
}
