package com.pinho.vehicle.insurance.controllers;

import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.services.InsuranceService;
import com.pinho.vehicle.insurance.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON})
    public List<Insurance> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    public Insurance findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON})
    public Insurance create(@RequestBody Insurance insurance) {
        return service.create(insurance);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON}, produces = { MediaType.APPLICATION_JSON})
    public Insurance update(@RequestBody Insurance insurance) {
        return service.update(insurance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Insurance> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}