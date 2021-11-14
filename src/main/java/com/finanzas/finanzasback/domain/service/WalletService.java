package com.finanzas.finanzasback.domain.service;

import com.finanzas.finanzasback.domain.model.Rate;
import com.finanzas.finanzasback.domain.model.Wallet;

public interface WalletService {
    Wallet createWallet(Wallet wallet,int userId);
    Wallet getWalletById(Long walletId);
}
