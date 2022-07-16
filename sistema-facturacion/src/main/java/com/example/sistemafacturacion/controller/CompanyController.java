package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.entity.CompanyEntity;
import com.example.sistemafacturacion.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/empresa/{companyName}")
    public CompanyEntity findCompanyByName(@PathVariable String companyName){
        return companyService.getCompanyByName(companyName);
    }

    @PutMapping("/actualizar-empresa")
    public String updatedCompany(@Valid @RequestBody CompanyEntity company){
        return companyService.updateCompany(company);
    }
}
