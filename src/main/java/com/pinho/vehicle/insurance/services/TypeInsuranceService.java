package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.dto.TypeInsuranceDTO;
import com.pinho.vehicle.insurance.entities.TypeInsurance;
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
public class TypeInsuranceService {

    @Autowired
    private InsuranceRepository repository;

    private Logger logger = Logger.getLogger(TypeInsuranceService.class.getName());

    @Transactional(readOnly = true)
    public List<TypeInsuranceDTO> findAll() {
        logger.info("Finding all types insurances!");

        List<TypeInsurance> list = repository.findAll();
        return list.stream().map(x -> new TypeInsuranceDTO(x)).collect(Collectors.toList());
    }

    public TypeInsuranceDTO findById(Long id) {
        logger.info("Finding one type insurance!");
        return repository.findById(id)
                .map(this::toMapInsurance)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public TypeInsuranceDTO create(TypeInsuranceDTO dto) {
        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one type insurance!");

        TypeInsurance insurance = new TypeInsurance(dto.getId(), dto.getType(), dto.getCost());

        var entity = repository.save(insurance);
        return new TypeInsuranceDTO(entity);
    }

    public TypeInsuranceDTO update(TypeInsuranceDTO dto) {
        if (dto == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one type insurance!");

        TypeInsurance insurance = new TypeInsurance(dto.getId(), dto.getType(), dto.getCost());

        var entity = repository.findById(insurance.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setType(insurance.getType());
        entity.setCost(insurance.getCost());

        entity = repository.save(entity);
        return new TypeInsuranceDTO(entity);
    }

    public void delete(Long id) {
        if (id == null) throw new RequiredObjectIsNullException();
        logger.info("Deleting one type insurance!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        TypeInsurance insurance = new TypeInsurance(entity.getId(), entity.getType(), entity.getCost());

        repository.delete(insurance);
    }

    public TypeInsuranceDTO toMapInsurance(TypeInsurance insurance) {
        return new TypeInsuranceDTO(
                insurance.getId(),
                insurance.getType(),
                insurance.getCost()
        );
    }
}
