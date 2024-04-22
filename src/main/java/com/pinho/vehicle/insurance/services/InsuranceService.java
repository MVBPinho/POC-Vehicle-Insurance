package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.dto.InsuranceDTO;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.exceptions.ResourceNotFoundException;
import com.pinho.vehicle.insurance.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository repository;

    private Logger logger = Logger.getLogger(InsuranceService.class.getName());

    @Transactional(readOnly = true)
    public List<InsuranceDTO> findAll() {
        logger.info("Finding all insurances!");

        List<Insurance> list = repository.findAll();
        return list.stream().map(x -> new InsuranceDTO(x)).collect(Collectors.toList());
    }

    public InsuranceDTO findById(Long id) {
        logger.info("Finding one insurance!");
        return repository.findById(id)
                .map(this::toMapInsurance)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public InsuranceDTO create(InsuranceDTO dto) {
        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one insurance!");

        Insurance insurance = new Insurance(dto.getId(), dto.getType(), dto.getCost());

        var entity = repository.save(insurance);
        return new InsuranceDTO(entity);
    }

    public InsuranceDTO update(InsuranceDTO dto) {
        if (dto == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one insurance!");

        Insurance insurance = new Insurance(dto.getId(), dto.getType(), dto.getCost());

        var entity = repository.findById(insurance.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setType(insurance.getType());
        entity.setCost(insurance.getCost());

        entity = repository.save(entity);
        return new InsuranceDTO(entity);
    }

    public void delete(Long id) {
        if (id == null) throw new RequiredObjectIsNullException();
        logger.info("Deleting one insurance!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        Insurance insurance = new Insurance(entity.getId(), entity.getType(), entity.getCost());

        repository.delete(insurance);
    }

    public InsuranceDTO toMapInsurance(Insurance insurance) {
        return new InsuranceDTO(
                insurance.getId(),
                insurance.getType(),
                insurance.getCost()
        );
    }
}
