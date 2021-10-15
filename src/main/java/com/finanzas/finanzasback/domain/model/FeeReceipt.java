package com.finanzas.finanzasback.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fee_receipts")
public class FeeReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean currency_type;

    private LocalDate issue_date;

    private LocalDate payment_date;
    private Float     total_to_receive;
    private Float retention;
    private Float    total_final_costs;
    private Float total_starting_costs;
    private Float   discount_rate;
    private Float discount;
    private Float    net_worth;
    private Float received_value;
    private Float     delivered_value;
    private Float tcea;

    public  FeeReceipt(){}
    public FeeReceipt(Long id, Boolean currency_type, LocalDate issue_date, LocalDate payment_date, Float total_to_receive, Float retention, Float total_final_costs, Float total_starting_costs, Float discount_rate, Float discount, Float net_worth, Float received_value, Float delivered_value, Float tcea) {
        this.id = id;
        this.currency_type = currency_type;
        this.issue_date = issue_date;
        this.payment_date = payment_date;
        this.total_to_receive = total_to_receive;
        this.retention = retention;
        this.total_final_costs = total_final_costs;
        this.total_starting_costs = total_starting_costs;
        this.discount_rate = discount_rate;
        this.discount = discount;
        this.net_worth = net_worth;
        this.received_value = received_value;
        this.delivered_value = delivered_value;
        this.tcea = tcea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCurrency_type() {
        return currency_type;
    }

    public void setCurrency_type(Boolean currency_type) {
        this.currency_type = currency_type;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public Float getTotal_to_receive() {
        return total_to_receive;
    }

    public void setTotal_to_receive(Float total_to_receive) {
        this.total_to_receive = total_to_receive;
    }

    public Float getRetention() {
        return retention;
    }

    public void setRetention(Float retention) {
        this.retention = retention;
    }

    public Float getTotal_final_costs() {
        return total_final_costs;
    }

    public void setTotal_final_costs(Float total_final_costs) {
        this.total_final_costs = total_final_costs;
    }

    public Float getTotal_starting_costs() {
        return total_starting_costs;
    }

    public void setTotal_starting_costs(Float total_starting_costs) {
        this.total_starting_costs = total_starting_costs;
    }

    public Float getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(Float discount_rate) {
        this.discount_rate = discount_rate;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(Float net_worth) {
        this.net_worth = net_worth;
    }

    public Float getReceived_value() {
        return received_value;
    }

    public void setReceived_value(Float received_value) {
        this.received_value = received_value;
    }

    public Float getDelivered_value() {
        return delivered_value;
    }

    public void setDelivered_value(Float delivered_value) {
        this.delivered_value = delivered_value;
    }

    public Float getTcea() {
        return tcea;
    }

    public void setTcea(Float tcea) {
        this.tcea = tcea;
    }
}
