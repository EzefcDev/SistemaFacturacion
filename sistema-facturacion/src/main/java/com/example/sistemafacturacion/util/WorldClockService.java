package com.example.sistemafacturacion.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WorldClockService {

    @Autowired
    private WorldClockRestApi worldClockRestApi;

    public Date getcurrentDateTime(){
        Date dateNow = worldClockRestApi.getcurrentDateTime().getCurrentDateTime();
        if(dateNow == null){
            dateNow = new Date();
        }
        return dateNow;
    }
}
