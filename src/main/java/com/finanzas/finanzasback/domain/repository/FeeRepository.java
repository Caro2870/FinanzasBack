package com.finanzas.finanzasback.domain.repository;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<FeeReceipt, Long> {
}
