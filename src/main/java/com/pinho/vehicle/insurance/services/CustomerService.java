package com.pinho.vehicle.insurance.services;

import com.pinho.vehicle.insurance.dto.CustomerDTO;
import com.pinho.vehicle.insurance.dto.InsuranceDTO;
import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.exceptions.ResourceNotFoundException;
import com.pinho.vehicle.insurance.exceptions.UniqueConstraintViolationException;
import com.pinho.vehicle.insurance.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    private Logger logger = Logger.getLogger(CustomerService.class.getName());

    public Customer findCustomerWithInsurancesById() {
        List<Object[]> result = repository.findCustomerInsuranceDetails();

        Customer customer = new Customer();
        for (Object[] row : result) {

            Insurance insurance = new Insurance();

            String customerName = (String) row[1];
            String insuranceType = (String) row[2];
            Integer insuranceCost = (Integer) row[3];

            customer.setName(customerName);
            insurance.setType(insuranceType);
            insurance.setCost(insuranceCost);

            customer.addInsurance(insurance);
        }
        return customer;
    }

    public List<CustomerDTO> findAll() {
        logger.info("Finding all customers!");

        List<Customer> list = repository.findAll();
        return list.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    public CustomerDTO findById(Long id) {
        if (id == null) throw new RequiredObjectIsNullException();
        logger.info("Finding one customers!");

        return repository.findById(id)
                .map(this::toMapCustomer)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    private CustomerDTO toMapCustomer(Customer customer) {
        return  new CustomerDTO(customer.getId(), customer.getName(), customer.getCpf(),
                customer.getAge(), customer.getLocation(), customer.getValueVehicle());
    }

    public InsuranceDTO toMapInsurance(Insurance insurance) {
        return new InsuranceDTO(
                insurance.getId(),
                insurance.getType(),
                insurance.getCost()
        );
    }

    public CustomerDTO create(CustomerDTO dto) {
        if (dto == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one customer!");

        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getCpf(), dto.getAge(),
                dto.getLocation(), dto.getValueVehicle());

        try {
            customer = repository.save(customer);
            return new CustomerDTO(customer);
        } catch (Exception e) {
            throw new UniqueConstraintViolationException("Unique constraint violation: " + e.getMessage());
        }
    }

    public CustomerDTO update(CustomerDTO dto) {
        if (dto == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one customer!");

        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getCpf(), dto.getAge(),
                dto.getLocation(), dto.getValueVehicle());

        var entity = repository.findById(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(customer.getName());
        entity.setAge(customer.getAge());
        entity.setLocation(customer.getLocation());
        entity.setValueVehicle(customer.getValueVehicle());

        entity = repository.save(entity);
        return new CustomerDTO(entity);
    }

    public void delete(Long id) {
        if (id == null) throw new RequiredObjectIsNullException();
        logger.info("Deleting one customer!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        Customer customer = new Customer(entity.getId());

        repository.delete(customer);
    }
}