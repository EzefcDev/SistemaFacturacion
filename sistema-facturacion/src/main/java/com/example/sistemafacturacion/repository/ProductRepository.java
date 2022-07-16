package com.example.sistemafacturacion.repository;

import com.example.sistemafacturacion.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByProductName(String productName);
}
