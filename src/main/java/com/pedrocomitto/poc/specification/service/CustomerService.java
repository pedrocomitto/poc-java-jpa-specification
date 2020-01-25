package com.pedrocomitto.poc.specification.service;

import com.pedrocomitto.poc.specification.domain.entity.CustomerEntity;
import com.pedrocomitto.poc.specification.repository.CustomerRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.pedrocomitto.poc.specification.specification.CustomerSpecification.isActive;
import static com.pedrocomitto.poc.specification.specification.CustomerSpecification.isBelowSalaryCap;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(final CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerEntity> findAllByCriteria(final Boolean active, final BigDecimal salaryCap) {

        Specification<CustomerEntity> specification = getSpecification(active, salaryCap);

        return repository.findAll(specification);
    }

    private Specification<CustomerEntity> getSpecification(Boolean active, BigDecimal salaryCap) {
        return (Specification<CustomerEntity>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (active != null) {
                predicates.add(isActive(active).toPredicate(root, query, criteriaBuilder));
            }

            if (salaryCap != null) {
                predicates.add(isBelowSalaryCap(salaryCap).toPredicate(root, query, criteriaBuilder));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }

}
