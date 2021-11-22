package com.finanzas.finanzasback.domain.service;


import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface FeeReceiptService {
  FeeReceipt createFeeReceipt(FeeReceipt feeReceipt,Long rateId, Long walletId);
  FeeReceipt getFeeReceiptById(Long feeReceiptId);
  FeeReceipt updateFeeReceipt(Long feeReceiptId, Long rateId, Long walletId, FeeReceipt feeReceipt);
  double total_inicial(Long feeRecepeit,double valor_networth);
  double total_final(Long feeRecepeit,double valor_networth);
  Page<FeeReceipt>  getAllFeeReceiptsByWalletId(Long walletId, Pageable pageable);
  public ResponseEntity<?> deleteFeeReceipt(Long feeReceiptId);

}
