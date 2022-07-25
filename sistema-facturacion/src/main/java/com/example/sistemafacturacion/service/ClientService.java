package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.entity.ClientEntity;

import java.util.List;

public interface ClientService {

    String saveClient(ClientEntity client);

    ClientEntity getByClientDni(String clientDni);

    String delete(String clientDni);

    List<ClientEntity> getAllClient();

    String update(ClientEntity client);

    List<ClientEntity> getAllByClientName(String clientName);
}
