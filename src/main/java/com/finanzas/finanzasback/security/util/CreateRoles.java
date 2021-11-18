package com.finanzas.finanzasback.security.util;

import com.finanzas.finanzasback.domain.model.Reason;
import com.finanzas.finanzasback.domain.service.ReasonService;
import com.finanzas.finanzasback.security.entity.Rol;
import com.finanzas.finanzasback.security.enums.RolNombre;
import com.finanzas.finanzasback.security.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    ReasonService reasonService;


    @Override
    public void run(String... args) throws Exception {
         /*
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
       
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        */
        Reason portes = new Reason(1L,"Portes");
        Reason fotocopias = new Reason(2L,"Fotocopias");
        Reason comision_de_estudio = new Reason(3L,"Comision de estudio");
        Reason comision_de_desembolso = new Reason(4L,"Comision de desembolso");
        Reason comision_de_intermediacion = new Reason(5L,"Comision de intermediacion");
        Reason gastos_administracion = new Reason(6L,"Gastos administracion");
        Reason gastos_notariales = new Reason(7L,"Gastos notariales");
        Reason gastos_registrales = new Reason(8L,"Gastos registrales");
        Reason seguro = new Reason(9L,"Seguro");
        Reason otros_gastos = new Reason(10L,"Otros gastos");


        reasonService.createReason(portes);
        reasonService.createReason(fotocopias);
        reasonService.createReason(comision_de_estudio);
        reasonService.createReason(comision_de_desembolso);
        reasonService.createReason(comision_de_intermediacion);
        reasonService.createReason(gastos_administracion);
        reasonService.createReason(gastos_notariales);
        reasonService.createReason(gastos_registrales);
        reasonService.createReason(seguro);
        reasonService.createReason(otros_gastos);
    }
   
}
