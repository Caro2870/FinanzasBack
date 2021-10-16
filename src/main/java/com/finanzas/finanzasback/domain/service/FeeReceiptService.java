package com.finanzas.finanzasback.domain.service;

import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Rate;

public interface FeeReceiptService {
  FeeReceipt createFeeReceipt(FeeReceipt feeReceipt);
}
