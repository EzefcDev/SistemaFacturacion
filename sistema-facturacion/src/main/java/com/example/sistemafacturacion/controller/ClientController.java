package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.entity.ClientEntity;
import com.example.sistemafacturacion.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name="ClienteController", description="Enpoints para el sistema de clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Operation(summary = "Clientes", description = "Trae todos los clientes de la base de datos")
    @GetMapping("/clientes")
    public List<ClientEntity> getClients(){
        return clientService.getAllClient();
    }

    @Operation(summary = "Cliente por DNI", description = "Trae los datos de un cliente buscándolo por su DNI")
    @GetMapping("/cliente/{clientDni}")
    public ClientEntity findByClientDni(@PathVariable(name = "clientDni") String clientDni){
        return clientService.getByClientDni(clientDni);
    }

    @Operation(summary = "Cliente por nombre", description = "Trae los datos de un cliente buscándolo por su nombre")
    @GetMapping("/clientes/{clientName}")
    public List<ClientEntity> findAllByClientName(@PathVariable (name = "clientName")String clientName){
        return clientService.getAllByClientName(clientName);
    }

    @Operation(summary = "Creación clientes", description = "Creación del cliente ingresando su dni, nombre, apellido y dirección ")
    @ApiResponse(responseCode = "200", description = "El cliente fue creado")
    @PostMapping("/crear-cliente")
    public String createClient(@Valid @RequestBody ClientEntity client){
        return clientService.saveClient(client);
    }

    @Operation(summary = "Actualización cliente", description = "Actualiza los datos del cliente")
    @ApiResponse(responseCode = "200", description = "El cliente a sido actualizado")
    @PutMapping("/actualizar-cliente")
    public String updateClient(@Valid @RequestBody ClientEntity client){
        return clientService.update(client);
    }

    @Operation(summary = "Eliminación cliente", description = "elimina el cliente ingresando su dni")
    @ApiResponse(responseCode = "200", description = "El cliente a sido eliminado")
    @DeleteMapping("/eliminar-cliente/{clientDni}")
    public String deleteClient(@PathVariable(name = "clientDni") String clientDni){
        return clientService.delete(clientDni);
    }
}
