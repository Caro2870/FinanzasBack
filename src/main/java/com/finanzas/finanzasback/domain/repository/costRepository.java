package com.finanzas.finanzasback.domain.repository;

import com.finanzas.finanzasback.domain.model.Cost;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface costRepository extends JpaRepository<Cost, Long> {

    public Page<Cost> findById(Long Id, Pageable page);
}
