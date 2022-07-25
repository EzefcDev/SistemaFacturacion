package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.dto.InvoiceDto;
import com.example.sistemafacturacion.entity.InvoiceEntity;

public interface InvoiceService {

    InvoiceEntity createdInovice(InvoiceDto invoiceDto);
}
