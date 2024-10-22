package com.iitposs.pos.repo;

import com.iitposs.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerReo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByActiveStateEquals(boolean state);
}
