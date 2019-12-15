package com.pedrocomitto.poc.specification.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String document;

    private Boolean active;

    @Column(name = "monthly_income")
    private BigDecimal monthlyIncome;

}
