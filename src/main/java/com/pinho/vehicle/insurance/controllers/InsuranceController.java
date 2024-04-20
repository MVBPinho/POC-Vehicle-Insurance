package com.pinho.vehicle.insurance.controllers;

import com.pinho.vehicle.insurance.data.vo.v1.InsuranceVO;
import com.pinho.vehicle.insurance.utils.MediaType;
import com.pinho.vehicle.insurance.services.InsuranceService;
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
    public List<InsuranceVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    public InsuranceVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON})
    public InsuranceVO create(@RequestBody InsuranceVO insurance) {
        return service.create(insurance);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON}, produces = { MediaType.APPLICATION_JSON})
    public InsuranceVO update(@RequestBody InsuranceVO insurance) {
        return service.update(insurance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}