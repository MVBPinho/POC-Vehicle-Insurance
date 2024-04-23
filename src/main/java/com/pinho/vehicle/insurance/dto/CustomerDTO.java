package com.pinho.vehicle.insurance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pinho.vehicle.insurance.entities.Customer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private String location;

    @JsonProperty("value_vehicle")
    private Double valueVehicle;

    private List<CostTypeInsuranceDTO> insurances = new ArrayList<>();

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String cpf, Integer age, String location, Double valueVehicle) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.location = location;
        this.valueVehicle = valueVehicle;
    }

    public CustomerDTO(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        cpf = customer.getCpf();
        age = customer.getAge();
        location = customer.getLocation();
        valueVehicle = customer.getValueVehicle();
        insurances = customer.getInsurances().stream().map(CostTypeInsuranceDTO::new).collect(Collectors.toList());
    }

    public CustomerDTO(String name, List<CostTypeInsuranceDTO> insurances) {
        this.name = name;
        this.insurances = insurances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getValueVehicle() {
        return valueVehicle;
    }

    public void setValueVehicle(Double valueVehicle) {
        this.valueVehicle = valueVehicle;
    }

    public List<CostTypeInsuranceDTO> getInsurances() {
        return insurances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO customer = (CustomerDTO) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}