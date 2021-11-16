package com.finanzas.finanzasback.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fee_receipts")

public class FeeReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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





    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rate_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rate rate;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wallet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wallet wallet;

    public Long getId() {
        return id;
    }

    public FeeReceipt setId(Long id) {
        this.id = id;return this;
    }

    public Boolean getCurrency_type() {
        return currency_type;
    }

    public FeeReceipt setCurrency_type(Boolean currency_type) {
        this.currency_type = currency_type;return this;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public FeeReceipt setIssue_date(Date issue_date) {
        this.issue_date = issue_date;return this;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public FeeReceipt setPayment_date(Date payment_date) {
        this.payment_date = payment_date;return this;
    }


    public double getRetention() {
        return retention;
    }

    public FeeReceipt setRetention(double retention) {
        this.retention = retention;return this;
    }

    public double getTotal_final_costs() {
        return total_final_costs;
    }

    public FeeReceipt setTotal_final_costs(double total_final_costs) {
        this.total_final_costs = total_final_costs;return this;
    }

    public double getTotal_starting_costs() {
        return total_starting_costs;
    }

    public FeeReceipt setTotal_starting_costs(double total_starting_costs) {
        this.total_starting_costs = total_starting_costs;return this;
    }

    public double getDiscount_rate() {
        return discount_rate;
    }

    public FeeReceipt setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;return this;
    }

    public double getDiscount() {
        return discount;
    }

    public FeeReceipt setDiscount(double discount) {
        this.discount = discount;return this;
    }

    public double getNet_worth() {
        return net_worth;
    }

    public FeeReceipt setNet_worth(double net_worth) {
        this.net_worth = net_worth;return this;
    }

    public double getReceived_value() {
        return received_value;
    }

    public FeeReceipt setReceived_value(double received_value) {
        this.received_value = received_value;return this;
    }

    public double getDelivered_value() {
        return delivered_value;
    }

    public FeeReceipt setDelivered_value(double delivered_value) {
        this.delivered_value = delivered_value;return this;
    }

    public double getTcea() {
        return tcea;
    }

    public FeeReceipt setTcea(double tcea) {
        this.tcea = tcea;
        return this;
    }


    public int getDias() {
        return dias;
    }

    public FeeReceipt setDias(int dias) {
        this.dias = dias;
        return this;
    }

    public Rate getRate() {
        return rate;
    }

    public FeeReceipt setRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public FeeReceipt setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }

    public double getTea() {
        return tea;
    }

    public FeeReceipt setTea(double tea) {
        this.tea = tea;
        return this;
    }

    public double getTasa_efectiva_a_dias() {
        return tasa_efectiva_a_dias;
    }

    public FeeReceipt setTasa_efectiva_a_dias(double tasa_efectiva_a_dias) {
        this.tasa_efectiva_a_dias = tasa_efectiva_a_dias;
        return this;
    }

    public double getValor_neto() {
        return valor_neto;
    }

    public FeeReceipt setValor_neto(double valor_neto) {
        this.valor_neto = valor_neto;
        return this;
    }
}
