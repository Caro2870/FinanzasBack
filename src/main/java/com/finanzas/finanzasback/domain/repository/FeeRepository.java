package com.finanzas.finanzasback.domain.repository;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<FeeReceipt, Long> {
    Page<FeeReceipt> findByWalletId(Long walletId, Pageable pageable);
}
