package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.entity.CompanyEntity;
import com.example.sistemafacturacion.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Tag(name="CompanyController", description="Endpoints para el sistema de empresa")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Operation(summary = "Empresa", description = "Trae los datos de la empresa pasandole el nombre")
    @GetMapping("/empresa/{companyName}")
    public CompanyEntity findCompanyByName(@PathVariable String companyName){
        return companyService.getCompanyByName(companyName);
    }

    @Operation(summary = "Actualizar empresa", description = "Actualiza los datos de la empresa")
    @ApiResponse(responseCode = "200", description = "La empresa se actualizo correctamente")
    @PutMapping("/actualizar-empresa")
    public String updatedCompany(@Valid @RequestBody CompanyEntity company){
        return companyService.updateCompany(company);
    }
}
