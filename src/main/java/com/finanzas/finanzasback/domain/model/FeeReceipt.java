package com.finanzas.finanzasback.domain.model;

import com.finanzas.finanzasback.security.entity.Usuario;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
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
    private int dias;



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

    public Float getTotal_to_receive() {
        return total_to_receive;
    }

    public FeeReceipt setTotal_to_receive(Float total_to_receive) {
        this.total_to_receive = total_to_receive;return this;
    }

    public Float getRetention() {
        return retention;
    }

    public FeeReceipt setRetention(Float retention) {
        this.retention = retention;return this;
    }

    public Float getTotal_final_costs() {
        return total_final_costs;
    }

    public FeeReceipt setTotal_final_costs(Float total_final_costs) {
        this.total_final_costs = total_final_costs;return this;
    }

    public Float getTotal_starting_costs() {
        return total_starting_costs;
    }

    public FeeReceipt setTotal_starting_costs(Float total_starting_costs) {
        this.total_starting_costs = total_starting_costs;return this;
    }

    public Float getDiscount_rate() {
        return discount_rate;
    }

    public FeeReceipt setDiscount_rate(Float discount_rate) {
        this.discount_rate = discount_rate;return this;
    }

    public Float getDiscount() {
        return discount;
    }

    public FeeReceipt setDiscount(Float discount) {
        this.discount = discount;return this;
    }

    public Float getNet_worth() {
        return net_worth;
    }

    public FeeReceipt setNet_worth(Float net_worth) {
        this.net_worth = net_worth;return this;
    }

    public Float getReceived_value() {
        return received_value;
    }

    public FeeReceipt setReceived_value(Float received_value) {
        this.received_value = received_value;return this;
    }

    public Float getDelivered_value() {
        return delivered_value;
    }

    public FeeReceipt setDelivered_value(Float delivered_value) {
        this.delivered_value = delivered_value;return this;
    }

    public Float getTcea() {
        return tcea;
    }

    public FeeReceipt setTcea(Float tcea) {
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
}
