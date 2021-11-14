package com.finanzas.finanzasback.domain.service;


import com.finanzas.finanzasback.domain.model.FeeReceipt;


public interface FeeReceiptService {
  FeeReceipt createFeeReceipt(FeeReceipt feeReceipt,Long rateId, Long walletId);
  FeeReceipt getFeeReceiptById(Long feeReceiptId);
}
