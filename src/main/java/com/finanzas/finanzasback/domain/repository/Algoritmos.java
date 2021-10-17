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

            //time is always 00:00:00, so rounding should help to ignore the missing hour when going from winter to summer time, as well as the extra hour in the other direction
            diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (int) 86400000);
        } catch (Exception e) {

        }
        return diff;
    }
}