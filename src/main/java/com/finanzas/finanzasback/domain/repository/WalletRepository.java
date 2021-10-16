package com.finanzas.finanzasback.domain.repository;


import com.finanzas.finanzasback.domain.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import org.springframework.data.domain.Pageable;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Page<Wallet>  findById (Long Id, Pageable page);
}

