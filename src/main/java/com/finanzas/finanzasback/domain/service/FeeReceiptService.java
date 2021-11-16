package com.finanzas.finanzasback.domain.service;


import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.model.FeeReceipt;


public interface FeeReceiptService {
  FeeReceipt createFeeReceipt(FeeReceipt feeReceipt,Long rateId, Long walletId);
  FeeReceipt getFeeReceiptById(Long feeReceiptId);
  FeeReceipt updateFeeReceipt(Long feeReceiptId, Long rateId, Long walletId, FeeReceipt feeReceipt);
  double total_inicial(Long feeRecepeit,double valor_networth);
  double total_final(Long feeRecepeit,double valor_networth);


}
