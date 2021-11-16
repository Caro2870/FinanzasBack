package com.finanzas.finanzasback.service;


import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.model.FeeReceipt;

import com.finanzas.finanzasback.domain.repository.*;
import com.finanzas.finanzasback.domain.service.FeeReceiptService;
import com.finanzas.finanzasback.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class FeeReceiptServiceImpl implements FeeReceiptService {

    @Autowired
    private FeeRepository feeRepository;
    @Autowired
    private Algoritmos algoritmos;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private CostRepository costRepository;



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
                                .setDiscount(algoritmos.descuento(feeReceipt.getDias(),rate.getRate_term(),feeReceipt.getNet_worth(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                .setCurrency_type(feeReceipt.getCurrency_type())
                                .setDelivered_value(feeReceipt.getDelivered_value())
                                .setDiscount_rate(algoritmos.tasa_descontada(feeReceipt.getDias(),rate.getRate_term(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                .setNet_worth(feeReceipt.getNet_worth())
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
                                    .setDiscount(algoritmos.descuento(feeReceipt.getDias(),rate.getRate_term(),feeReceipt.getNet_worth(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                    .setCurrency_type(feeReceipt.getCurrency_type())
                                    .setDelivered_value(feeReceipt.getDelivered_value())
                                    .setDiscount_rate(algoritmos.tasa_descontada(feeReceipt.getDias(),rate.getRate_term(),rate.getPercentage(),rate.getCapitalization(),rate.getRate_type()))
                                    .setNet_worth(feeReceipt.getNet_worth())
                                    .setTasa_efectiva_a_dias(algoritmos.tasa_a_periodo_de_dias(feeReceipt.getDias(),rate.getPercentage(),rate.getRate_term(),rate.getCapitalization(),rate.getRate_type())*100)
                                    .setTotal_starting_costs(0)
                                    .setTotal_final_costs(feeReceipt.getTotal_final_costs())
                                    .setTcea(feeReceipt.getTcea())
                                    .setTea(algoritmos.tasa_a_periodo_de_dias(rate.getRate_term(),rate.getPercentage(),rate.getRate_term(),rate.getCapitalization(),rate.getRate_type())*100)
                                    .setRetention(0.0)
                                    .setReceived_value(feeReceipt.getReceived_value()));
        }).orElseThrow(() -> new ResourceNotFoundException("Wallet", "Id", walletId));


    }

    @Override
    public FeeReceipt getFeeReceiptById(Long feeReceiptId) {
        return  feeRepository.findById(feeReceiptId).orElseThrow(() -> new ResourceNotFoundException("FeeRecepeit", "Id", feeReceiptId));
    }

    @Override
    public FeeReceipt updateFeeReceipt(Long feeReceiptId, Long rateId, Long walletId, FeeReceipt feeReceiptdetails) {
        if(!rateRepository.existsById(rateId))
            throw new ResourceNotFoundException("Rate","Id",rateId);
            //Comprobamos que exista el wallet
        else if (!walletRepository.existsById(walletId))
            throw new ResourceNotFoundException("Wallet","Id",walletId);

        return feeRepository.findById(feeReceiptId).map(feeReceipt -> {
            return   rateRepository.findById(rateId).map(rate -> {
                feeReceipt.setRate(rate);
            feeReceipt.setReceived_value((feeReceipt.getNet_worth()-feeReceipt.getDiscount())-total_inicial(feeReceiptId,feeReceipt.getNet_worth())-feeReceipt.getRetention())
                    .setDelivered_value((feeReceipt.getNet_worth())+total_final(feeReceiptId,feeReceipt.getNet_worth())-feeReceipt.getRetention())
                    .setTotal_starting_costs(total_inicial(feeReceiptId,feeReceipt.getNet_worth()))
                    .setTotal_final_costs(total_final(feeReceiptId,feeReceipt.getNet_worth()))
                    .setTcea((Math.pow((((feeReceipt.getNet_worth())+total_final(feeReceiptId,feeReceipt.getNet_worth())-feeReceipt.getRetention())/((feeReceipt.getNet_worth()-feeReceipt.getDiscount())-(total_inicial(feeReceiptId,feeReceipt.getNet_worth()))-feeReceipt.getRetention())),(rate.getRate_term()/feeReceipt.getDias()))-1)*100)
                    .setValor_neto((feeReceipt.getNet_worth()-feeReceipt.getDiscount()));
            ;

            return  feeRepository.save(feeReceipt);
        }).orElseThrow(() -> new ResourceNotFoundException("Rate Id" + rateId + "Wallet Id" + walletId));
        }).orElseThrow(() -> new ResourceNotFoundException("Rate Id" + rateId + "Wallet Id" + walletId));
    }

    @Override
    public double total_inicial(Long fee_recepeit,double valor_networth) {

        double resultado_valor=0;
        double resultado_porcentaje=0;
        double total=0;
        for(int i=0;i<=costRepository.valorInicial_valor(Math.toIntExact(fee_recepeit)).size()-1;i++){
            resultado_valor +=(double) costRepository.valorInicial_valor(Math.toIntExact(fee_recepeit)).get(i);
        }


        for(int i=0;i<=costRepository.valorInicial_porcentaje(Math.toIntExact(fee_recepeit)).size()-1;i++){
            resultado_porcentaje += ((double) costRepository.valorInicial_porcentaje(Math.toIntExact(fee_recepeit)).get(i)/100)*valor_networth;
        }

        total= resultado_valor+resultado_porcentaje;
        return total;
    }


    @Override
    public double total_final(Long fee_recepeit,double valor_networth) {

        double resultado_valor=0;
        double resultado_porcentaje=0;
        double total=0;
        for(int i=0;i<=costRepository.valorFinal_valor(Math.toIntExact(fee_recepeit)).size()-1;i++){
            resultado_valor +=(double) costRepository.valorFinal_valor(Math.toIntExact(fee_recepeit)).get(i);
        }


        for(int i=0;i<=costRepository.valorFinal_porcentaje(Math.toIntExact(fee_recepeit)).size()-1;i++){
            resultado_porcentaje += ((double) costRepository.valorFinal_porcentaje(Math.toIntExact(fee_recepeit)).get(i)/100)*valor_networth;
        }

        total= resultado_valor+resultado_porcentaje;
        return total;
    }


}