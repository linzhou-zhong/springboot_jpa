package com.linzhou.springboot_hibernate.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOME")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 25)
    private String name;

    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "SALARY")
    private int salary;
}
