package com.finanzas.finanzasback.domain.model;

import javax.persistence.*;


@Entity
@Table(name = "wallets")
public class Wallet  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean currency_type;
    private float total_value;
    private float tir;

    public Wallet(){}
    public Wallet(Long id, String name, String description, Boolean currency_type, float total_value, float tir) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currency_type = currency_type;
        this.total_value = total_value;
        this.tir = tir;
    }

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
