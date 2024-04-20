package com.pinho.vehicle.insurance.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

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
    private Double valueVehicle;

    public Customer( ) {}

    public Customer(Long id, String name, String cpf, Integer age, String location, Double valueVehicle) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.location = location;
        this.valueVehicle = valueVehicle;
    }

    public Customer(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        cpf = customer.getCpf();
        age = customer.getAge();
        location = customer.getLocation();
        valueVehicle = customer.getValueVehicle();
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