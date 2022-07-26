package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.entity.ClientEntity;
import com.example.sistemafacturacion.error.NotFoundException;
import com.example.sistemafacturacion.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    //Metodo que devuelve todos los clientes
    @Override
    public List<ClientEntity> getAllClient() {
        return clientRepository.findAll();
    }

    //Metodo para devolver un cliente segun su DNI
    @Override
    public ClientEntity getByClientDni(String clientDni){
        Optional<ClientEntity> client = Optional.ofNullable(clientRepository.findByClientDni(clientDni));
        return client.orElseThrow(() -> new NotFoundException("El cliente no existe"));
    }

    //Metodo para buscar todos los clientes por un nombre
    @Override
    public List<ClientEntity> getAllByClientName(String clientName) {
        if(clientName.matches("^([A-Z]{1}[a-zñáéíóú]+[\\s]*)+$")){
            return clientRepository.findByClientName(clientName);
        }else{
            throw new NotFoundException("El nombre ingresado debe contener solo letras");
        }
    }

    //Metodo que almacena un nuevo cliente
    @Override
    public String saveClient(ClientEntity client) {
        Optional<ClientEntity>clientExist = Optional.ofNullable(clientRepository.findByClientDni(client.getClientDni()));
        if (clientExist.isPresent() ){
            throw new NotFoundException("El cliente ya existe");
        }else {
            ClientEntity clientValidated = validator(client);
            clientRepository.save(clientValidated);
            return "El cliente fue creado";
        }
    }

    //Metodo para actualizar al cliente
    @Override
    public String update(ClientEntity client) {
        if (client.getClientId() == null){
            client.setClientId(clientRepository.findByClientDni(client.getClientDni()).getClientId());
        }
        Optional<ClientEntity>clientExist = Optional.ofNullable(clientRepository.findByClientDni(client.getClientDni()));
        if (clientExist.isPresent()){
            ClientEntity clientValidated = validator(client);
            clientRepository.save(clientValidated);
            return "El cliente a sido actualizado";
        }else {
            throw new NotFoundException("El cliente no existe");
        }
    }

    //Metodo para eliminar al cliente mediante el envio del DNI
    @Override
    public String delete(String clientDni) {
        Optional<ClientEntity> clientExist = Optional.ofNullable(clientRepository.findByClientDni(clientDni));
        if (clientExist.isPresent()){
            ClientEntity client = clientRepository.findByClientDni(clientDni);
            clientRepository.delete(client);
            return "El cliente a sido eliminado";
        }else {
            throw new NotFoundException("El cliente no existe");
        }
    }

    //Metodo para validar datos del cliente
    public ClientEntity validator(ClientEntity client){
        if (client.getClientDni().matches("[0-9]*") && client.getClientDni().length() > 7){
            if (client.getClientName().matches("^([A-Z]{1}[a-zñáéíóú]+[\\s]*)+$")){
                if (client.getClientLastName().matches("^([A-Z]{1}[a-zñáéíóú]+[\\s]*)+$")){
                    return client;
                }else {
                    throw new NotFoundException("El apellido contiene caracteres no validos");
                }
            }else {
                throw new NotFoundException("El nombre contiene caracteres no validos");
            }
        }else {
            throw new NotFoundException("El dni contiene valores no numericos o contiene menos de 8 digitos");
        }
    }

}
