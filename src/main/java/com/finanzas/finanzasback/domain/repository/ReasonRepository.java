package com.finanzas.finanzasback.domain.repository;

import com.finanzas.finanzasback.domain.model.Reason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {
    public Page<Reason> findById(Long Id, Pageable page);
}
