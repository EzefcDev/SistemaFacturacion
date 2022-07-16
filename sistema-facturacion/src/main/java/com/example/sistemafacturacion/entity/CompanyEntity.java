package com.example.sistemafacturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    @NotNull
    @Size(min = 3)
    private String companyName;

    @Column(name = "company_business_name")
    @NotNull
    @Size(min = 3)
    private String companyBusinessName;

    @Column(name = "company_heading")
    @NotNull
    @Size(min = 10)
    private String companyHeading;

}
