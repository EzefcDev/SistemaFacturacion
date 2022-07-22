package com.example.sistemafacturacion.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldClockService {

    @Autowired
    private WorldClockRestApi worldClockRestApi;

    public String getcurrentDateTime(){
        return worldClockRestApi.getcurrentDateTime().getCurrentDateTime();
    }
}
