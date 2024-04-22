package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.exceptions.ResourceNotFoundException;
import com.pinho.vehicle.insurance.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository repository;

    private Logger logger = Logger.getLogger(InsuranceService.class.getName());

    public List<Insurance> findAll() {
        logger.info("Finding all insurances!");
        return repository.findAll();
    }

    public Insurance findById(Long id) {
        logger.info("Finding one insurance!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Insurance create(Insurance insurance) {
        if (insurance == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one insurance!");
        return repository.save(insurance);
    }

    public Insurance update(Insurance insurance) {
        if (insurance == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one insurance!");
        var entity =  repository.findById(insurance.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setType(insurance.getType());
        entity.setCost(insurance.getCost());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one insurance!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
