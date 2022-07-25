package com.example.sistemafacturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    @NotNull
    @Size(min=4)
    private String productName;

    @Column(name = "product_description")
    @NotNull
    @Size(min=10)
    private String productDescription;

    @Column(name = "product_price")
    @NotNull
    private Float productPrice;

    @Column(name = "product_amount")
    @NotNull
    private Long productAmount;

}
