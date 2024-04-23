package com.pinho.vehicle.insurance.dto;

import com.pinho.vehicle.insurance.entities.Customer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeInsuranceCustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private List<CostTypeInsuranceDTO> insurances = new ArrayList<>();

    public TypeInsuranceCustomerDTO() {
    }

    public TypeInsuranceCustomerDTO(String name) {
        this.name = name;
    }

    public TypeInsuranceCustomerDTO(Customer customer) {
        name = customer.getName();
        insurances = customer.getInsurances().stream().map(CostTypeInsuranceDTO::new).collect(Collectors.toList());
    }

    public TypeInsuranceCustomerDTO(String name, List<CostTypeInsuranceDTO> insurances) {
        this.name = name;
        this.insurances = insurances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CostTypeInsuranceDTO> getInsurances() {
        return insurances;
    }
}