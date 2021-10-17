package com.finanzas.finanzasback.service;

import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Rate;
import com.finanzas.finanzasback.domain.repository.*;
import com.finanzas.finanzasback.domain.service.FeeReceiptService;
import com.finanzas.finanzasback.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeReceiptServiceImpl implements FeeReceiptService {

    @Autowired
    private feeRepository feeRepository;
    @Autowired
    private Algoritmos algoritmos;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private rateRepository rateRepository;

    @Override
    public FeeReceipt createFeeReceipt(FeeReceipt feeReceipt, Long rateId, Long walletId) {

        return  walletRepository.findById(walletId).map(wallet -> {
            feeReceipt.setWallet(wallet);
         rateRepository.findById(rateId).map(rate -> {
            feeReceipt.setRate(rate);


                return feeRepository.save(
                        feeReceipt.setPayment_date(feeReceipt.getPayment_date())
                                .setIssue_date(feeReceipt.getIssue_date())
                                .setDias(algoritmos.hallar_n(feeReceipt.getPayment_date(), rate.getDiscount_date()))
                                .setDiscount(feeReceipt.getDiscount())
                                .setCurrency_type(feeReceipt.getCurrency_type())
                                .setDelivered_value(feeReceipt.getDelivered_value())
                                .setDiscount_rate(feeReceipt.getDiscount_rate())
                                .setDiscount(feeReceipt.getDiscount())
                                .setNet_worth(feeReceipt.getNet_worth())
                                .setTotal_to_receive(feeReceipt.getTotal_to_receive())
                                .setTotal_starting_costs(feeReceipt.getTotal_starting_costs())
                                .setTotal_final_costs(feeReceipt.getTotal_final_costs())
                                .setTcea(feeReceipt.getTcea())
                                .setRetention(feeReceipt.getRetention())
                                .setReceived_value(feeReceipt.getReceived_value()));


            }).orElseThrow(() -> new ResourceNotFoundException("Rate", "Id", rateId));


                    return feeRepository.save(
                            feeReceipt.setPayment_date(feeReceipt.getPayment_date())
                                    .setIssue_date(feeReceipt.getIssue_date())
                                    .setDias(algoritmos.hallar_n(feeReceipt.getPayment_date(), feeReceipt.getIssue_date()))
                                    .setDiscount(feeReceipt.getDiscount())
                                    .setCurrency_type(feeReceipt.getCurrency_type())
                                    .setDelivered_value(feeReceipt.getDelivered_value())
                                    .setDiscount_rate(feeReceipt.getDiscount_rate())
                                    .setDiscount(feeReceipt.getDiscount())
                                    .setNet_worth(feeReceipt.getNet_worth())
                                    .setTotal_to_receive(feeReceipt.getTotal_to_receive())
                                    .setTotal_starting_costs(feeReceipt.getTotal_starting_costs())
                                    .setTotal_final_costs(feeReceipt.getTotal_final_costs())
                                    .setTcea(feeReceipt.getTcea())
                                    .setRetention(feeReceipt.getRetention())
                                    .setReceived_value(feeReceipt.getReceived_value()));
        }).orElseThrow(() -> new ResourceNotFoundException("Wallet", "Id", walletId));


    }
}