package com.finanzas.finanzasback.service;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Rate;
import com.finanzas.finanzasback.domain.repository.rateRepository;
import com.finanzas.finanzasback.domain.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private rateRepository rateRepository;

    @Override
    public Rate createRate(Rate rate) {
        return rateRepository.save(rate);
    }
}
