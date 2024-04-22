package com.pinho.vehicle.insurance.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pinho.vehicle.insurance.utils.CalculatorTypeInsuranceVehicle;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 2)
    private Integer age;

    @Column(nullable = false, length = 2)
    private String location;

    @Column(name = "value_vehicle")
    @JsonProperty("value_vehicle")
    private Double valueVehicle;

    @ManyToMany
    @JoinTable(name = "tb_customer_insurance",
            joinColumns = @JoinColumn (name = "id_customer"),
            inverseJoinColumns = @JoinColumn (name = "id_insurance"))
    private List<Insurance> insurances = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id, String name, String cpf, Integer age, String location, Double valueVehicle, List<Insurance> insurances) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.location = location;
        this.valueVehicle = valueVehicle;
        this.insurances = insurances;
    }

    public Customer(String name, List<Insurance> insurances) {
        this.name = name;
        this.insurances = insurances;
    }

    public Long getId() {
        return id;
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

    public List<Insurance> getInsurances() {
        CalculatorTypeInsuranceVehicle calculatorTypeInsuranceVehicle = new CalculatorTypeInsuranceVehicle();
        List<Insurance> insurances = calculatorTypeInsuranceVehicle.calculateInsurance(valueVehicle, age, location);
        for (Insurance x : insurances) {
            addInsurance(x);
        }
        return insurances;
    }

    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }

    public void removeInsurance(Insurance insurance) {
        insurances.remove(insurance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}