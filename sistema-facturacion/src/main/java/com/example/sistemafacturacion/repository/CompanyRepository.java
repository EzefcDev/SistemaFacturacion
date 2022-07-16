package com.example.sistemafacturacion.repository;

import com.example.sistemafacturacion.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    CompanyEntity findByCompanyName(String companyName);
}
