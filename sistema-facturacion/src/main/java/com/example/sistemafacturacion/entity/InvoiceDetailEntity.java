package com.example.sistemafacturacion.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice_detail")
public class InvoiceDetailEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Long invoiceDetailId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;


}
