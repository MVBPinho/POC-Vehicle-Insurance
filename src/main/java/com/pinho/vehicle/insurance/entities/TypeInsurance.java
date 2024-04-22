package com.pinho.vehicle.insurance.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_type_insurance")
public class TypeInsurance implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "type_insurance_id")
    private Long id;

    @Column(nullable = false, length = 10)
    private String type;

    @Column(nullable = false, length = 3)
    private Integer cost;

    public TypeInsurance() {
    }

    public TypeInsurance(Long id) {
        this.id = id;
    }

    public TypeInsurance(Long id, String type, Integer cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public TypeInsurance(String type, Integer cost) {
        this.type = type;
        this.cost = cost;
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
        TypeInsurance insurance = (TypeInsurance) o;
        return Objects.equals(id, insurance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}