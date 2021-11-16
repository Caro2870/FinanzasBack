package com.finanzas.finanzasback.service;

import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.repository.CostRepository;
import com.finanzas.finanzasback.domain.repository.FeeRepository;
import com.finanzas.finanzasback.domain.repository.ReasonRepository;
import com.finanzas.finanzasback.domain.service.CostService;
import com.finanzas.finanzasback.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    private CostRepository costRepository;

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Cost createCost(Cost cost, Long reasonId, Long fee_recepeitId) {

        return reasonRepository.findById(reasonId).map(reason -> {
            cost.setReason(reason);
            feeRepository.findById(fee_recepeitId).map(fee_recepeit -> {
                cost.setFeeReceipt(fee_recepeit);


                return costRepository.save(cost);


            }).orElseThrow(() -> new ResourceNotFoundException("Reason", "Id", reasonId));


            return costRepository.save(cost);
        }).orElseThrow(() -> new ResourceNotFoundException("Fee_Recepeit", "Id", fee_recepeitId));


    }


    @Override
    public Cost getCostById(Long costId) {
        return  costRepository.findById(costId).orElseThrow(() -> new ResourceNotFoundException("Cost", "Id", costId));
    }
}
