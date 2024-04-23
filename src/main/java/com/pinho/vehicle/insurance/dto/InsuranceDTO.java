package com.pinho.vehicle.insurance.dto;

import com.pinho.vehicle.insurance.entities.Insurance;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class InsuranceDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String type;
    private Integer cost;

    public InsuranceDTO() {
    }

    public InsuranceDTO(Long id, String type, Integer cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public InsuranceDTO(String type, Integer cost) {
        this.type = type;
        this.cost = cost;
    }

    public InsuranceDTO(Insurance insurance) {
        id = insurance.getId();
        type = insurance.getType();
        cost = insurance.getCost();
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceDTO that = (InsuranceDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
