package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.exceptions.ResourceNotFoundException;
import com.pinho.vehicle.insurance.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository repository;


    public List<Insurance> findAll() {
        return repository.findAll();
    }

    public Insurance findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Insurance create(Insurance insurance) {
        if (insurance == null) throw new RequiredObjectIsNullException();
        return repository.save(insurance);
    }

    public Insurance update(Insurance insurance) {
        if (insurance == null) throw new RequiredObjectIsNullException();

        var entity =  repository.findById(insurance.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setType(insurance.getType());
        entity.setCost(insurance.getCost());

        return repository.save(entity);
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
