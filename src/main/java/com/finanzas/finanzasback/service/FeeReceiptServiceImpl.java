package com.finanzas.finanzasback.service;


import com.finanzas.finanzasback.domain.model.FeeReceipt;

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

        return   rateRepository.findById(rateId).map(rate -> {
            feeReceipt.setRate(rate);
            walletRepository.findById(walletId).map(wallet -> {
            feeReceipt.setWallet(wallet);



                return feeRepository.save(
                        feeReceipt.setPayment_date(feeReceipt.getPayment_date())
                                .setIssue_date(feeReceipt.getIssue_date())
                                .setDias(algoritmos.getDayCount(rate.getDiscount_date(),feeReceipt.getPayment_date()))
                                .setDiscount(algoritmos.descuento(feeReceipt.getDias(),rate.getRate_term(),feeReceipt.getTotal_to_receive(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                .setCurrency_type(feeReceipt.getCurrency_type())
                                .setDelivered_value(feeReceipt.getDelivered_value())
                                .setDiscount_rate(algoritmos.tasa_descontada(feeReceipt.getDias(),rate.getRate_term(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                .setNet_worth(feeReceipt.getNet_worth())
                                .setTotal_to_receive(feeReceipt.getTotal_to_receive())
                                .setTotal_starting_costs(algoritmos.tasa_a_periodo_de_dias(feeReceipt.getDias(),rate.getPercentage(),rate.getRate_term(),rate.getCapitalization(),rate.getRate_type()))
                                .setTotal_final_costs(feeReceipt.getTotal_final_costs())
                                .setTcea(feeReceipt.getTcea())
                                .setRetention(0.08)
                                .setReceived_value(feeReceipt.getReceived_value()));



            }).orElseThrow(() -> new ResourceNotFoundException("Rate", "Id", rateId));


                    return feeRepository.save(
                            feeReceipt.setPayment_date(feeReceipt.getPayment_date())
                                    .setIssue_date(feeReceipt.getIssue_date())
                                    .setDias(algoritmos.getDayCount(rate.getDiscount_date(),feeReceipt.getPayment_date()))
                                    .setDiscount(algoritmos.descuento(feeReceipt.getDias(),rate.getRate_term(),feeReceipt.getTotal_to_receive(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                    .setCurrency_type(feeReceipt.getCurrency_type())
                                    .setDelivered_value(feeReceipt.getDelivered_value())
                                    .setDiscount_rate(algoritmos.tasa_descontada(feeReceipt.getDias(),rate.getRate_term(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                    .setNet_worth(feeReceipt.getNet_worth())
                                    .setTotal_to_receive(feeReceipt.getTotal_to_receive())
                                    .setTotal_starting_costs(algoritmos.tasa_a_periodo_de_dias(feeReceipt.getDias(),rate.getPercentage(),rate.getRate_term(),rate.getCapitalization(),rate.getRate_type()))
                                    .setTotal_final_costs(feeReceipt.getTotal_final_costs())
                                    .setTcea(feeReceipt.getTcea())
                                    .setRetention(0.08)
                                    .setReceived_value(feeReceipt.getReceived_value()));
        }).orElseThrow(() -> new ResourceNotFoundException("Wallet", "Id", walletId));


    }

    @Override
    public FeeReceipt getFeeReceiptById(Long feeReceiptId) {
        return  feeRepository.findById(feeReceiptId).orElseThrow(() -> new ResourceNotFoundException("FeeRecepeit", "Id", feeReceiptId));
    }
}