package com.example.sistemafacturacion.repository;

import com.example.sistemafacturacion.entity.InvoiceDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetailEntity, Long> {
}
