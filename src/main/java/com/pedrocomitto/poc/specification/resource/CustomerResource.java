package com.pedrocomitto.poc.specification.resource;

import com.pedrocomitto.poc.specification.domain.entity.CustomerEntity;
import com.pedrocomitto.poc.specification.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    private final CustomerService service;

    public CustomerResource(final CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerEntity> customers(@RequestParam(value = "active", required = false, defaultValue = "true") final Boolean active,
                                          @RequestParam(value = "salaryCap", required = false) final BigDecimal salaryCap) {
        return service.findAllByCriteria(active, salaryCap);
    }

}
