package com.finanzas.finanzasback.domain.repository;



import com.finanzas.finanzasback.domain.model.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface rateRepository extends JpaRepository<Rate, Long> {
    public Page<Rate> findById(Long Id, Pageable page);
}
