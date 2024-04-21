package com.pinho.vehicle.insurance.repositories;

import com.pinho.vehicle.insurance.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query(value = "SELECT c.id AS customer_id, c.name AS customer_name, i.type, i.cost FROM TB_CUSTOMER c INNER JOIN TB_INSURANCE i ON c.id = i.customer_id", nativeQuery = true)
    List<Object[]> findCustomerInsuranceDetails();
}