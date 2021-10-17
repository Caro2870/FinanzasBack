package com.finanzas.finanzasback.domain.repository;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;





@Repository
public class Algoritmos {


    public static int getDayCount(Date start, Date end) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int diff = -1;
        try {
            Date dateStart = simpleDateFormat.parse(simpleDateFormat.format(start));
            Date dateEnd = simpleDateFormat.parse(simpleDateFormat.format(end));


            diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (int) 86400000);
        } catch (Exception e) {

        }
        return diff;
    }


    public double tasa_a_periodo_de_dias(int N,double porcentaje,int plazo_de_tasa,int capitalizacion,boolean tipo_de_tasa){
        double tep=0;
        if(tipo_de_tasa) {
            double arriba;
            double abajo;
            arriba=(1+(porcentaje/100));
            System.out.println(arriba);
            System.out.println(plazo_de_tasa);

            abajo=((double)N/plazo_de_tasa);
            System.out.println(N);
            System.out.println(abajo);
            tep=Math.pow(arriba,abajo)-1;

        }
        else {
           tep=Math.pow((1+(porcentaje/100)/(plazo_de_tasa/(double)capitalizacion)),N/capitalizacion)-1;
            System.out.println(tep);
        }

        return tep;

    }



    public double tasa_descontada(int N,int plazo_de_tasa,double porcentaje,int capitalizacion,boolean tipo_de_tasa){

        double tep;
        tep= tasa_a_periodo_de_dias(N,porcentaje,plazo_de_tasa,capitalizacion,tipo_de_tasa);


        tep=(tep)/(1+(tep));
        return tep*100;
    }


    public double descuento(int N,int plazo_de_tasa,double valor_nominal,double porcentaje,int capitalizacion,boolean tipo_de_tasa){
        double descuento=0;
        descuento= tasa_descontada(N,plazo_de_tasa,porcentaje,capitalizacion,tipo_de_tasa)*valor_nominal;
        return descuento/100;
    }
}