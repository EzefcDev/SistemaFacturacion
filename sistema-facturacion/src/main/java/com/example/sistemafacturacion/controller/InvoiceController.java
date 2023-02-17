package com.example.sistemafacturacion.controller;


import com.example.sistemafacturacion.dto.InvoiceDto;
import com.example.sistemafacturacion.entity.InvoiceEntity;
import com.example.sistemafacturacion.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="InvoiceController", description="Enpoints para el sistema de facturacion")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Operation(summary = "Crea la factura", description = "Creación de la factura")
    @PostMapping("/factura")
    public InvoiceEntity createdInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceService.createdInovice(invoiceDto);
    }

    @Operation(summary = "Facturas", description = "Trae todas las facturas del cliente")
    @GetMapping("factura-por-cliente/{clientDni}")
    public List<InvoiceEntity> findByClientDni(@PathVariable(name = "clientDni") String clientDni){
        return invoiceService.getAllInvoice(clientDni);
    }

}
