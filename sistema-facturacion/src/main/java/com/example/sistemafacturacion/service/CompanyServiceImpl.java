package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.entity.CompanyEntity;
import com.example.sistemafacturacion.error.NotFoundException;
import com.example.sistemafacturacion.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    //Metodo para actualizar la empresa
    @Override
    public String updateCompany(CompanyEntity company) {
        if (company.getCompanyId() == null){
            company.setCompanyId(companyRepository.findByCompanyName(company.getCompanyName()).getCompanyId());
        }
        Optional<CompanyEntity> companyExist = Optional.ofNullable(companyRepository.findByCompanyName(company.getCompanyName()));
        if (companyExist.isPresent()){
            companyRepository.save(company);
            return "La empresa se actualizo correctamente";
        }else {
            throw new NotFoundException("Empresa no existente");
        }
    }

    //Metodo para mostrar los datos de la empresa
    @Override
    public CompanyEntity getCompanyByName(String companyName) {
        Optional<CompanyEntity> company = Optional.ofNullable(companyRepository.findByCompanyName(companyName));
        return company.orElseThrow(() -> new NotFoundException("La empresa no existe"));
    }


}
