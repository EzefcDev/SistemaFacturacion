package com.example.sistemafacturacion.repository;

import com.example.sistemafacturacion.entity.ClientEntity;
import com.example.sistemafacturacion.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findByClient(ClientEntity client);
}
