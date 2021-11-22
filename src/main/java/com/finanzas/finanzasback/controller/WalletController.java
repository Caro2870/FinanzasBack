package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.Wallet;
import com.finanzas.finanzasback.domain.service.WalletService;

import com.finanzas.finanzasback.resource.SaveWalletResource;
import com.finanzas.finanzasback.resource.WalletResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
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

    @DeleteMapping("/wallets/{walletId}")

    public ResponseEntity<?> deleteWallet(@PathVariable Long walletId) {
        return walletService.deleteWallet(walletId);
    }


    @GetMapping("/{walletId}/wallets/")
    public WalletResource getWalletById(@PathVariable Long walletId) {
        return convertToResource(walletService.getWalletById(walletId));
    }

    @PutMapping("/users/{userId}/wallets/{walletId}")
    public WalletResource updateWallet(
            @PathVariable int userId,
            @PathVariable Long walletId,
            @Valid @RequestBody SaveWalletResource resource) {
        return convertToResource(walletService.updateWallet( walletId,userId, convertToEntity(resource)));
    }

    @GetMapping("/usuarios/{usuarioId}/wallets/{walletId}/wallets")
    public WalletResource getWalletByUsuarioIdAndWalletId(@PathVariable int usuarioId,@PathVariable Long walletId ){
        return convertToResource(walletService.getWalletByUsuarioIdAndWalletId(usuarioId,walletId));
    }


    @GetMapping("/users/{userId}/wallets")
    public Page<WalletResource> getAllWalletsByUserId(@PathVariable int userId, Pageable pageable) {
        Page<Wallet> walletPage = walletService.getAllWalletsByUserId(userId, pageable);
        List<WalletResource> resources = walletPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private Wallet convertToEntity(SaveWalletResource resource) {
        return mapper.map(resource, Wallet.class);
    }

    private WalletResource convertToResource(Wallet entity) {
        return mapper.map(entity, WalletResource.class);
    }
}
