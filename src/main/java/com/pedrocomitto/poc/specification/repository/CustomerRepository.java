package com.pedrocomitto.poc.specification.repository;

import com.pedrocomitto.poc.specification.entity.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {

    List<CustomerEntity> findAll(Specification<CustomerEntity> specification);
}
