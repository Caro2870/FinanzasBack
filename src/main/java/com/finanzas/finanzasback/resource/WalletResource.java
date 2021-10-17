package com.finanzas.finanzasback.resource;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class WalletResource {

    private Long id;
    private String name;
    private String description;
    private Boolean currency_type;
    private float total_value;
    private float tir;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCurrency_type() {
        return currency_type;
    }

    public void setCurrency_type(Boolean currency_type) {
        this.currency_type = currency_type;
    }

    public float getTotal_value() {
        return total_value;
    }

    public void setTotal_value(float total_value) {
        this.total_value = total_value;
    }

    public float getTir() {
        return tir;
    }

    public void setTir(float tir) {
        this.tir = tir;
    }
}
