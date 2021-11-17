package com.finanzas.finanzasback.domain.service;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Rate;
import com.finanzas.finanzasback.domain.model.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WalletService {
    Wallet createWallet(Wallet wallet,int userId);
    Wallet getWalletById(Long walletId);
    Wallet updateWallet(Long walletId, int userId, Wallet walletDetails);
    double va(Long walletId, double tasa);
    boolean en_rango(Long walletId,double tasa_inf,double tasa_sup);
    double calc_tcea(Long walletId);
    double val_recibido_total(Long walletId);
    Page<Wallet> getAllWalletsByUserId(int userId, Pageable pageable);
}
