package com.example.sistemafacturacion.repository;

import com.example.sistemafacturacion.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByClientDni(String clientDni);

    List<ClientEntity> findByClientName(String name);

}
