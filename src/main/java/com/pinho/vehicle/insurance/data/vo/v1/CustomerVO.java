package com.pinho.vehicle.insurance.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import com.pinho.vehicle.insurance.entities.Customer;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@JsonPropertyOrder({"customer"})
public class CustomerVO extends RepresentationModel<CustomerVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String name;
    private String cpf;
    private Integer age;
    private String location;
    @JsonProperty("value_vehicle")
    private Double valueVehicle;

    private List<InsuranceVO> insurances = new ArrayList<>();

    public CustomerVO() {
    }

    public CustomerVO(Customer customer) {
        key = customer.getId();
        name = customer.getName();
        age = customer.getAge();
        location = customer.getLocation();
        valueVehicle = customer.getValueVehicle();
        insurances = customer.getInsurances().stream().map(InsuranceVO::new).collect(Collectors.toList());
    }

    public Long getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
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

    public List<InsuranceVO> getInsurances() {
        return insurances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerVO that = (CustomerVO) o;
        return Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(cpf, that.cpf) && Objects.equals(age, that.age) && Objects.equals(location, that.location) && Objects.equals(valueVehicle, that.valueVehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, cpf, age, location, valueVehicle);
    }
}
