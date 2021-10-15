package com.finanzas.finanzasback.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "costs")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean cost_type;
    private Boolean value_type;
    private Float    value;

    public Cost(){}
    public Cost(Long id, Boolean cost_type, Boolean value_type, Float value) {
        this.id = id;
        this.cost_type = cost_type;
        this.value_type = value_type;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCost_type() {
        return cost_type;
    }

    public void setCost_type(Boolean cost_type) {
        this.cost_type = cost_type;
    }

    public Boolean getValue_type() {
        return value_type;
    }

    public void setValue_type(Boolean value_type) {
        this.value_type = value_type;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
