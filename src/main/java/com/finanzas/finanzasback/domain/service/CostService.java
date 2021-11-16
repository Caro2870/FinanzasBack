package com.finanzas.finanzasback.domain.service;

import com.finanzas.finanzasback.domain.model.Cost;

public interface CostService {
    Cost createCost(Cost cost,Long reasonId, Long fee_receiptId);
    Cost getCostById(Long costId);
}
