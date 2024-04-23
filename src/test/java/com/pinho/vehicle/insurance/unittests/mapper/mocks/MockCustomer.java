package com.pinho.vehicle.insurance.unittests.mapper.mocks;

import com.pinho.vehicle.insurance.dto.CustomerDTO;
import com.pinho.vehicle.insurance.dto.TypeInsuranceCustomerDTO;
import com.pinho.vehicle.insurance.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class MockCustomer {

    public Customer mockEntity() {
        return mockEntity(0);
    }

    public CustomerDTO mockCustomerDTO() {
        return mockCustomerDTO(0);
    }

    public TypeInsuranceCustomerDTO mockTypeInsuranceCustomerDTO() {
        return mockTypeInsuranceCustomerDTO(0);
    }

    public List<Customer> mockEntityList() {
        List<Customer> listEntity = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listEntity.add(mockEntity(i));
        }
        return listEntity;
    }

    public List<CustomerDTO> mockDTOList() {
        List<CustomerDTO> listDTO = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listDTO.add(mockCustomerDTO(i));
        }
        return listDTO;
    }

    public List<TypeInsuranceCustomerDTO> mockTypeInsuranceCustomerDTOList() {
        List<TypeInsuranceCustomerDTO> listDTO = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listDTO.add(mockTypeInsuranceCustomerDTO(i));
        }
        return listDTO;
    }

    public Customer mockEntity(Integer number) {
        Customer customer = new Customer();
        customer.setId(number.longValue());
        customer.setName("Name Test" + number);
        customer.setLocation("Location Test" + number);
        customer.setAge(25 + number);
        customer.setCpf(number + "23.45" + number + ".789-1" + number);
        customer.setValueVehicle(20000 * number.doubleValue());
        return customer;
    }

    public CustomerDTO mockCustomerDTO(Integer number) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(number.longValue());
        dto.setName("Name Test" + number);
        dto.setLocation("Location Test" + number);
        dto.setAge(25 + number);
        dto.setCpf(number + "23.45" + number + ".789-1" + number);
        dto.setValueVehicle(20000 * number.doubleValue());
        return dto;
    }

    public TypeInsuranceCustomerDTO mockTypeInsuranceCustomerDTO(Integer number) {
        TypeInsuranceCustomerDTO dto = new TypeInsuranceCustomerDTO();
        dto.setName("Name Test " + number);
        return dto;
    }
}
