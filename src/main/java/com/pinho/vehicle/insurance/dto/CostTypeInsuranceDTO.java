package com.pinho.vehicle.insurance.dto;

import com.pinho.vehicle.insurance.entities.Insurance;

import java.io.Serial;
import java.io.Serializable;

public class CostTypeInsuranceDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String type;
    private Integer cost;

    public CostTypeInsuranceDTO() {
    }

    public CostTypeInsuranceDTO(String type, Integer cost) {
        this.type = type;
        this.cost = cost;
    }

    public CostTypeInsuranceDTO(Insurance insurance) {
        type = insurance.getType();
        cost = insurance.getCost();
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
}
