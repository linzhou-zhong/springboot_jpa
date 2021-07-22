package com.linzhou.springboot_hibernate.Service;

import com.linzhou.springboot_hibernate.entities.Customer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @Order(1)
    public void testAddCustomer(){
        Customer customer = new Customer(null, "linzhou", new Date(), 1000);
        Customer customer_added = customerService.add(customer);
        assertThat(customer_added).isNotNull();
        assertThat(customer_added.getId()).isNotNull();
        assertThat(customer_added.getName()).isEqualTo("linzhou");
    }

    @Test
    @Order(2)
    public void testGetCustomer(){
        Customer customer_found = customerService.findById(1L);
        assertThat(customer_found).isNotNull();
        assertThat(customer_found.getId()).isNotNull();
        assertThat(customer_found.getName()).isEqualTo("linzhou");
    }

    @Test
    @Order(3)
    public void testDeleteCustomer(){
        boolean removed = customerService.removeById(1L);
        assertThat(removed).isTrue();
    }
}
