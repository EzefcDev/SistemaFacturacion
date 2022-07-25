package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.entity.ClientEntity;
import com.example.sistemafacturacion.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clientes")
    public List<ClientEntity> getClients(){
        return clientService.getAllClient();
    }

    @GetMapping("/cliente/{clientDni}")
    public ClientEntity findByClientDni(@PathVariable(name = "clientDni") String clientDni){
        return clientService.getByClientDni(clientDni);
    }

    @GetMapping("/clientes/{clientName}")
    public List<ClientEntity> findAllByClientName(@PathVariable (name = "clientName")String clientName){
        return clientService.getAllByClientName(clientName);
    }

    @PostMapping("/crear-cliente")
    public String createClient(@Valid @RequestBody ClientEntity client){
        return clientService.saveClient(client);
    }

    @PutMapping("/actualizar-cliente")
    public String updateClient(@Valid @RequestBody ClientEntity client){
        return clientService.update(client);
    }

    @DeleteMapping("/eliminar-cliente/{clientDni}")
    public String deleteClient(@PathVariable(name = "clientDni") String clientDni){
        return clientService.delete(clientDni);
    }
}
