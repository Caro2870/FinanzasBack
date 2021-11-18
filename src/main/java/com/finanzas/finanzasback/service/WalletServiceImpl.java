package com.finanzas.finanzasback.service;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.model.Wallet;
import com.finanzas.finanzasback.domain.repository.WalletRepository;
import com.finanzas.finanzasback.domain.service.WalletService;
import com.finanzas.finanzasback.exception.ResourceNotFoundException;
import com.finanzas.finanzasback.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Wallet createWallet(Wallet wallet,int userId) {
        return  usuarioRepository.findById(userId).map(usuario -> {
            wallet.setUsuario(usuario)
            ;
        return walletRepository.save(wallet);
        }).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", userId));
    }




    @Override
    public Wallet getWalletById(Long walletId) {

            return  walletRepository.findById(walletId).orElseThrow(() -> new ResourceNotFoundException("WalletId", "Id", walletId));

    }

    public Page<Wallet> getAllWalletsByUserId(int userId, Pageable pageable) {
        return walletRepository.findByUsuarioId(userId,pageable);
    }


    @Override
    public Wallet updateWallet(Long walletId, int userId, Wallet walletDetails) {
        if(!usuarioRepository.existsById(userId))
            throw new ResourceNotFoundException("User","Id",userId);

        return walletRepository.findById(walletId).map(wallet -> {

            wallet.setTir(calc_tcea(walletId));
            wallet.setTotal_value(val_recibido_total(walletId));



            return walletRepository.save(wallet);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "Wallet","Id",walletId));
    }

    @Override
    public double va( Long walletId, double tasa) {
        double vas = 0;
        double entregado=0,recibido = 0,dias=0 ;

            for (int i = 0; i <= walletRepository.received_value_por_walletId(Math.toIntExact(walletId)).size()-1 ; i++) {

                entregado = (double) walletRepository.delivered_value_por_walletId(Math.toIntExact(walletId)).get(i);
                recibido =  (double) walletRepository.received_value_por_walletId(Math.toIntExact(walletId)).get(i);
                dias = (int)  walletRepository.dias_por_walletId(Math.toIntExact(walletId)).get(i);

                System.out.println("entregado"+entregado);
                System.out.println("recibido"+recibido);
                System.out.println("dias"+dias);
                vas -= recibido;
                System.out.println("vas1"+vas);
                vas += entregado/(Math.pow((1+tasa),(dias/360)));
                System.out.println("vas2"+vas);
            }



        return vas;
    }

    @Override
    public boolean en_rango(Long walletId,double tasa_inf, double tasa_sup) {

       double inf = va(walletId,tasa_inf);
       double sup = va(walletId,tasa_sup);

        if (inf*sup<=0){
            return true;
        }

       else{
        return false;}

    }

    @Override
    public double calc_tcea(Long walletId) {

        double superior = 100;
        double inferior = 0;
        double pivote = (superior + inferior) / 2;

        double diff = 1;



        while (diff >= 0.000000001) {
            if (en_rango(walletId,inferior, pivote)) {
                superior = pivote;
            } else {
                inferior = pivote;
            }
            pivote = (superior + inferior) / 2;
            diff = superior - inferior;

        }


        return pivote;
    }

    @Override
    public double val_recibido_total(Long walletId) {
        double recibido=0;
        for (int i = 0; i <= walletRepository.received_value_por_walletId(Math.toIntExact(walletId)).size()-1 ; i++) {


            recibido +=  (double) walletRepository.received_value_por_walletId(Math.toIntExact(walletId)).get(i);


        }
        return recibido;
    }


}