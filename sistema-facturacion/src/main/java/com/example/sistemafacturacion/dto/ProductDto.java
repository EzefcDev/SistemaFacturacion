package com.example.sistemafacturacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String productName;

    private Float productTotalPurchasePrice;

    private Long productAmount;
}
