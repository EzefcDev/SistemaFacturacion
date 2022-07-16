package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.entity.CompanyEntity;

public interface CompanyService {

    String updateCompany(CompanyEntity company);

    CompanyEntity getCompanyByName(String companyName);
}
