package com.example.sistemafacturacion.controller;


import com.example.sistemafacturacion.dto.InvoiceDto;
import com.example.sistemafacturacion.entity.InvoiceEntity;
import com.example.sistemafacturacion.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/factura")
    public InvoiceEntity createdInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceService.createdInovice(invoiceDto);
    }

}
