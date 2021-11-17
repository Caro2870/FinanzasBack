package com.finanzas.finanzasback.domain.service;


import com.finanzas.finanzasback.domain.model.Reason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReasonService {
    Reason createReason(Reason reason);
    public Page<Reason> getAllReasons(Pageable pageable);
}
