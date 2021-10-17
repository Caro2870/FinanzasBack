package com.finanzas.finanzasback.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="rates")
public class Rate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private boolean rate_type;
    private int rate_term;
    private double percentage;
    private int capitalization;
    @DateTimeFormat
    private Date discount_date;


    public Long getId() {
        return id;
    }

    public Rate setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean getRate_type() {
        return rate_type;
    }

    public Rate setRate_type(boolean rate_type) {
        this.rate_type = rate_type;
        return this;
    }

    public int getRate_term() {
        return rate_term;
    }

    public Rate setRate_term(int rate_term) {
        this.rate_term = rate_term;
        return this;
    }

    public double getPercentage() {
        return percentage;
    }

    public Rate setPercentage(double percentage) {
        this.percentage = percentage;
        return this;
    }

    public int getCapitalization() {
        return capitalization;
    }

    public Rate setCapitalization(int capitalization) {
        this.capitalization = capitalization;
        return this;
    }

    public Date getDiscount_date() {
        return discount_date;
    }

    public void setDiscount_date(Date discount_date) {
        this.discount_date = discount_date;
    }
}
