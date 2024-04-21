package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.controllers.CustomerController;
import com.pinho.vehicle.insurance.data.vo.v1.CustomerInsuranceVO;
import com.pinho.vehicle.insurance.data.vo.v1.CustomerVO;
import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.exceptions.ResourceNotFoundException;
import com.pinho.vehicle.insurance.mapper.DozerMapper;
import com.pinho.vehicle.insurance.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerInsuranceVO findCustomerWithInsurancesById() {
        List<Object[]> result = repository.findCustomerInsuranceDetails();
        Customer customer = new Customer();
        for (Object[] row : result) {
            Long customerId = (Long) row[0];
            String customerName = (String) row[1];
            String insuranceType = (String) row[2];
            Integer insuranceCost = (Integer) row[3];

            customer.setName(customerName);
            customer.addInsurance(new Insurance(insuranceType, insuranceCost));
        }
        return DozerMapper.parseObject(customer, CustomerInsuranceVO.class);
    }

    public List<CustomerVO> findAll() {
        var customers = DozerMapper.parseListObjects(repository.findAll(), CustomerVO.class);
        customers.forEach(customer ->
                customer.add(linkTo(methodOn(
                        CustomerController.class)
                        .findById(customer.getKey()))
                        .withSelfRel()));
        return customers;
    }

    public CustomerVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        CustomerVO vo = DozerMapper.parseObject(entity, CustomerVO.class);
        vo.add(linkTo(methodOn(CustomerController.class).findById(id)).withSelfRel());
        return vo;
    }

    public CustomerVO create(CustomerVO customer) {
        if (customer == null) throw new RequiredObjectIsNullException();
        var entity = DozerMapper.parseObject(customer, Customer.class);
        var vo = DozerMapper.parseObject(repository.save(entity), CustomerVO.class);
        vo.add(linkTo(methodOn(CustomerController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public CustomerVO update(CustomerVO customer) {
        if (customer == null) throw new RequiredObjectIsNullException();

        var entity = repository.findById(customer.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(customer.getName());
        entity.setAge(customer.getAge());
        entity.setLocation(customer.getLocation());
        entity.setValueVehicle(customer.getValueVehicle());


        var vo = DozerMapper.parseObject(repository.save(entity), CustomerVO.class);
        vo.add(linkTo(methodOn(CustomerController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
