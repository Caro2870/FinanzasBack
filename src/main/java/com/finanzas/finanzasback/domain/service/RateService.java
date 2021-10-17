package com.finanzas.finanzasback.domain.service;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Rate;

public interface RateService {
    Rate createRate(Rate rate);
}
