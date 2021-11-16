package com.finanzas.finanzasback.resource;

import java.util.Date;

public class FeeReceiptResource {

    private Long id;

    private Boolean currency_type;

    private Date issue_date;

    private Date payment_date;
    private double     valor_neto;
    private double retention;
    private double    total_final_costs;
    private double total_starting_costs;
    private double   discount_rate;
    private double discount;
    private double    net_worth;
    private double received_value;
    private double     delivered_value;
    private double tcea;
    private int dias;
    private double tea;
    private double tasa_efectiva_a_dias;

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

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }


    public double getRetention() {
        return retention;
    }

    public void setRetention(double retention) {
        this.retention = retention;
    }

    public double getTotal_final_costs() {
        return total_final_costs;
    }

    public void setTotal_final_costs(double total_final_costs) {
        this.total_final_costs = total_final_costs;
    }

    public double getTotal_starting_costs() {
        return total_starting_costs;
    }

    public void setTotal_starting_costs(double total_starting_costs) {
        this.total_starting_costs = total_starting_costs;
    }

    public double getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(double net_worth) {
        this.net_worth = net_worth;
    }

    public double getReceived_value() {
        return received_value;
    }

    public void setReceived_value(double received_value) {
        this.received_value = received_value;
    }

    public double getDelivered_value() {
        return delivered_value;
    }

    public void setDelivered_value(double delivered_value) {
        this.delivered_value = delivered_value;
    }

    public double getTcea() {
        return tcea;
    }

    public void setTcea(double tcea) {
        this.tcea = tcea;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getTea() {
        return tea;
    }

    public void setTea(double tea) {
        this.tea = tea;
    }

    public double getTasa_efectiva_a_dias() {
        return tasa_efectiva_a_dias;
    }

    public void setTasa_efectiva_a_dias(double tasa_efectiva_a_dias) {
        this.tasa_efectiva_a_dias = tasa_efectiva_a_dias;
    }

    public double getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(double valor_neto) {
        this.valor_neto = valor_neto;
    }
}
