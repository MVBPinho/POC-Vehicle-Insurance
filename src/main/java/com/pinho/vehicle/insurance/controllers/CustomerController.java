package com.pinho.vehicle.insurance.controllers;

import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.services.CustomerService;
import com.pinho.vehicle.insurance.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<Customer> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/insurance")
    public Customer findCustomerWithInsurancesById() {
        return service.findCustomerWithInsurancesById();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    public Customer findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON})
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON}, produces = { MediaType.APPLICATION_JSON})
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}