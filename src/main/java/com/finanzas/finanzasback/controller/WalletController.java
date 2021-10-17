package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.Wallet;
import com.finanzas.finanzasback.domain.service.WalletService;
import com.finanzas.finanzasback.resource.SaveWalletResource;
import com.finanzas.finanzasback.resource.WalletResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/wallets/user/{userId}")
    public WalletResource createReate(@Valid @RequestBody SaveWalletResource resource,@PathVariable int userId) {
        Wallet wallet = convertToEntity(resource);

        return convertToResource(walletService.createWallet(wallet,userId));
    }

    private Wallet convertToEntity(SaveWalletResource resource) {
        return mapper.map(resource, Wallet.class);
    }

    private WalletResource convertToResource(Wallet entity) {
        return mapper.map(entity, WalletResource.class);
    }
}
