package com.pinho.vehicle.insurance.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.pinho.vehicle.insurance.entities.Customer;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonRootName("Customer")
public class CustomerInsuranceVO extends RepresentationModel<CustomerInsuranceVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<InsuranceVO> insurances = new ArrayList<>();

    public CustomerInsuranceVO(){}

    public CustomerInsuranceVO(Customer customer) {
        name = customer.getName();
        insurances = customer.getInsurances().stream().map(InsuranceVO::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InsuranceVO> getInsurances() {
        return insurances;
    }
}
