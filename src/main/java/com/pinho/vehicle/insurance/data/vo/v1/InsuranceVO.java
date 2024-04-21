package com.pinho.vehicle.insurance.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import com.pinho.vehicle.insurance.entities.Insurance;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class InsuranceVO extends RepresentationModel<InsuranceVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String type;
    private Integer cost;

    public InsuranceVO() {
    }

    public InsuranceVO(Insurance insurance) {
        type = insurance.getType();
        cost = insurance.getCost();
    }

    public Long getKey() {
        return key;
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
        if (!super.equals(o)) return false;
        InsuranceVO that = (InsuranceVO) o;
        return Objects.equals(key, that.key) && Objects.equals(type, that.type) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, type, cost);
    }
}
