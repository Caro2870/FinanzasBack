package com.finanzas.finanzasback.domain.repository;

import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class Algoritmos {

    public int conversor(Date fecha){
        SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
        String datos;
        int resultado;
        datos = formateadorFecha.format(fecha);
        String info[]= datos.split("/");


        int mes=0;
        resultado= Integer.parseInt(info[0])+mes+Integer.parseInt(info[2])*365;
        switch(info[1]){
            case "01": mes=30;
                break;
            case "02": mes=59;
                break;
            case "03": mes=90;
                break;
            case "04": mes=120;
                break;
            case "05": mes=151;
                break;
            case "06": mes=181;
                break;
            case "07": mes=212;
                break;
            case "08": mes=243;
                break;
            case "09": mes=273;
                break;
            case "10": mes=304;
                break;
            case "11": mes=334;
                break;
            case "12": mes=365;
                break;
        }

        return resultado;
    }


    public int hallar_n(Date discountDate, Date paymentDate){
        int n=0;

        n=conversor(discountDate)-conversor(paymentDate);
        return n;
    }

}
