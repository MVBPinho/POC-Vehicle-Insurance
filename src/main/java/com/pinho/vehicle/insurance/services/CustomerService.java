package com.pinho.vehicle.insurance.services;

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

    public List<Customer> findAll() {
        logger.info("Finding all customers!");
        return repository.findAll();
    }

    public Customer findById(Long id) {
        logger.info("Finding one customers!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Customer create(Customer customer) {
        if (customer == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one customer!");

        try {
            return repository.save(customer);
        } catch (Exception e) {
            throw new UniqueConstraintViolationException("Unique constraint violation: " + e.getMessage());
        }
    }

    public Customer update(Customer customer) {
        if (customer == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one customer!");

        var entity = repository.findById(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(customer.getName());
        entity.setAge(customer.getAge());
        entity.setLocation(customer.getLocation());
        entity.setValueVehicle(customer.getValueVehicle());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one customer!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}