package com.example.sistemafacturacion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice")
public class InvoiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(mappedBy ="invoice", cascade = CascadeType.ALL)
    private Set<InvoiceDetailEntity> invoiceDetail;

    @Column(name = "price_total")
    private Float priceTotal;

//    public InvoiceDetailEntity agregarDetalle(InvoiceDetailEntity invoiceDetail){
//        getInvoiceDetail().add(invoiceDetail);
//        invoiceDetail.setInvoice(this);
//        return invoiceDetail;
//    }
}
