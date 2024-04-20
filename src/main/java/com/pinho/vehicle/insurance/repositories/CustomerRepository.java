package com.pinho.vehicle.insurance.repositories;

import com.pinho.vehicle.insurance.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}