package com.finanzas.finanzasback.domain.repository;


import com.finanzas.finanzasback.domain.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Page<Wallet>  findById (Long Id, Pageable page);
    @Query(nativeQuery = true, value = "select dias from fee_receipts where wallet_id = :wallet_id ")
    List<Number> dias_por_walletId(@Param("wallet_id")Integer wallet_id);

    @Query(nativeQuery = true, value = "select received_value from fee_receipts where wallet_id = :wallet_id ")
    List<Number> received_value_por_walletId(@Param("wallet_id")Integer wallet_id);

    @Query(nativeQuery = true, value = "select delivered_value from fee_receipts where wallet_id = :wallet_id ")
    List<Number> delivered_value_por_walletId(@Param("wallet_id")Integer wallet_id);

    Page<Wallet> findByUsuarioId(int userId, Pageable pageable);

    Wallet findByUsuarioIdAndId(int usuarioId, Long walletId);
}

