package com.pinho.vehicle.insurance.controllers;

import com.pinho.vehicle.insurance.data.vo.v1.CustomerInsuranceVO;
import com.pinho.vehicle.insurance.data.vo.v1.CustomerVO;
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
    public List<CustomerVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/insurance")
    public ResponseEntity<CustomerInsuranceVO> findCustomerWithInsurancesById() {
        CustomerInsuranceVO customer = service.findCustomerWithInsurancesById();
        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    public CustomerVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON})
    public CustomerVO create(@RequestBody CustomerVO customer) {
        return service.create(customer);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON}, produces = { MediaType.APPLICATION_JSON})
    public CustomerVO update(@RequestBody CustomerVO customer) {
        return service.update(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerVO> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}