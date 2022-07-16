package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity getByProductName(String productName);

    String saveProduct(ProductEntity product);

    List<ProductEntity> getAllProducts();

    String updateProduct(ProductEntity product);

    String deleteteProduct(String productName);
}
