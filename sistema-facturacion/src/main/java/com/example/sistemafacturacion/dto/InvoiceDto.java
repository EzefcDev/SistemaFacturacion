package com.example.sistemafacturacion.dto;

import com.example.sistemafacturacion.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private String clientDni;

    private List<ProductEntity> products;
}
