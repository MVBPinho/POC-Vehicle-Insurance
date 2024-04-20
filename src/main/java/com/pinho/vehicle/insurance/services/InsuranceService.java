package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.controllers.InsuranceController;
import com.pinho.vehicle.insurance.data.vo.v1.InsuranceVO;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.exceptions.ResourceNotFoundException;
import com.pinho.vehicle.insurance.mapper.DozerMapper;
import com.pinho.vehicle.insurance.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository repository;


    public List<InsuranceVO> findAll() {
        var insurance = DozerMapper.parseListObjects(repository.findAll(), InsuranceVO.class);
        insurance.forEach(customer ->
                customer.add(linkTo(methodOn(
                        InsuranceController.class)
                        .findById(customer.getKey()))
                        .withSelfRel()));
        return insurance;
    }

    public InsuranceVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        InsuranceVO vo = DozerMapper.parseObject(entity, InsuranceVO.class);
        vo.add(linkTo(methodOn(InsuranceController.class).findById(id)).withSelfRel());
        return vo;
    }

    public InsuranceVO create(InsuranceVO insurance) {
        if (insurance == null) throw new RequiredObjectIsNullException();
        var entity = DozerMapper.parseObject(insurance, Insurance.class);
        var vo = DozerMapper.parseObject(repository.save(entity), InsuranceVO.class);
        vo.add(linkTo(methodOn(InsuranceController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public InsuranceVO update(InsuranceVO insurance) {
        if (insurance == null) throw new RequiredObjectIsNullException();

        var entity = repository.findById(insurance.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setType(insurance.getType());
        entity.setCost(insurance.getCost());

        var vo = DozerMapper.parseObject(repository.save(entity), InsuranceVO.class);
        vo.add(linkTo(methodOn(InsuranceController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
