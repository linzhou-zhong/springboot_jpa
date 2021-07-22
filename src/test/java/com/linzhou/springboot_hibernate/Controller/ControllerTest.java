package com.linzhou.springboot_hibernate.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.linzhou.springboot_hibernate.Controller.CustomerController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(customerController).isNotNull();
    }

    @Test
    public void checkDefaultReturn() throws Exception{
        assertThat(customerController.welcome()).isEqualTo("Connected to Server successfully!");
    }
}
