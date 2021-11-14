package com.finanzas.finanzasback.service;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Wallet;
import com.finanzas.finanzasback.domain.repository.WalletRepository;
import com.finanzas.finanzasback.domain.service.WalletService;
import com.finanzas.finanzasback.exception.ResourceNotFoundException;
import com.finanzas.finanzasback.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Wallet createWallet(Wallet wallet,int userId) {
        return  usuarioRepository.findById(userId).map(usuario -> {
            wallet.setUsuario(usuario);
        return walletRepository.save(wallet);
        }).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", userId));
    }

    @Override
    public Wallet getWalletById(Long walletId) {

            return  walletRepository.findById(walletId).orElseThrow(() -> new ResourceNotFoundException("WalletId", "Id", walletId));

    }
}