package com.finanzas.finanzasback.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="rates")
public class Rate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private int rate_type;
    private int rate_term;
    private int percentage;
    private int capitalization;
    @DateTimeFormat
    private LocalDate discount_date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate_type() {
        return rate_type;
    }

    public void setRate_type(int rate_type) {
        this.rate_type = rate_type;
    }

    public int getRate_term() {
        return rate_term;
    }

    public void setRate_term(int rate_term) {
        this.rate_term = rate_term;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(int capitalization) {
        this.capitalization = capitalization;
    }

    public LocalDate getDiscount_date() {
        return discount_date;
    }

    public void setDiscount_date(LocalDate discount_date) {
        this.discount_date = discount_date;
    }
}
