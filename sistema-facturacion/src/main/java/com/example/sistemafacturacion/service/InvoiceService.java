package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.dto.InvoiceDto;
import com.example.sistemafacturacion.entity.InvoiceEntity;

import java.util.List;

public interface InvoiceService {

    InvoiceEntity createdInovice(InvoiceDto invoiceDto);

    List<InvoiceEntity> getAllInvoice(String clientDni);
}
