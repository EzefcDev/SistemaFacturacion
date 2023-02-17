package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.util.WorldClockService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Hidden
public class WorldClockController {

    @Autowired
    WorldClockService worldClockService;

    @GetMapping(value = "/fecha", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getFecha(){
        Date result = worldClockService.getcurrentDateTime();
        return ResponseEntity.ok(result);
    }
}
