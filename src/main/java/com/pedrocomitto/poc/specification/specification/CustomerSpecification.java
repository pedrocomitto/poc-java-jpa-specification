package com.pedrocomitto.poc.specification.specification;

import com.pedrocomitto.poc.specification.entity.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class CustomerSpecification {

    public static Specification<CustomerEntity> isActive(final Boolean active) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), active);
    }

    public static Specification<CustomerEntity> isBelowSalaryCap(final BigDecimal salaryCap) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("monthlyIncome"), salaryCap);
    }

}
