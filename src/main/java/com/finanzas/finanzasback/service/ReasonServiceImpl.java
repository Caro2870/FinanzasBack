package com.finanzas.finanzasback.service;

import com.finanzas.finanzasback.domain.model.Reason;
import com.finanzas.finanzasback.domain.repository.ReasonRepository;
import com.finanzas.finanzasback.domain.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReasonServiceImpl implements ReasonService {
    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Reason createReason(Reason reason) {
        return reasonRepository.save(reason);
    }

    @Override
    public Page<Reason> getAllReasons(Pageable pageable) {
        return reasonRepository.findAll(pageable);
    }
}
