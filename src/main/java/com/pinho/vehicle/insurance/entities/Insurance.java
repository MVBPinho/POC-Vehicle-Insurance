package com.pinho.vehicle.insurance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_insurance")
public class Insurance implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String type;

    @Column(nullable = false, length = 3)
    private Integer cost;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "tb_customer_insurance",
            joinColumns = @JoinColumn (name = "id_insurance"),
            inverseJoinColumns = @JoinColumn (name = "id_customer"))
    private List<Customer> customers = new ArrayList<>();

    public Insurance() {
    }

    public Insurance(Long id) {
        this.id = id;
    }

    public Insurance(Long id, String type, Integer cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public Insurance(String type, Integer cost) {
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

    @JsonBackReference
    public List<Customer> getCustomer() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurance insurance = (Insurance) o;
        return Objects.equals(id, insurance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}