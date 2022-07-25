package com.example.sistemafacturacion.service;


import com.example.sistemafacturacion.dto.InvoiceDto;
import com.example.sistemafacturacion.entity.ClientEntity;
import com.example.sistemafacturacion.entity.InvoiceDetailEntity;
import com.example.sistemafacturacion.entity.InvoiceEntity;
import com.example.sistemafacturacion.entity.ProductEntity;
import com.example.sistemafacturacion.repository.InvoiceDetailRepository;
import com.example.sistemafacturacion.repository.InvoiceRepository;

import com.example.sistemafacturacion.util.WorldClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    CompanyService companyService;
    @Autowired
    ClientService clientService;
    @Autowired
    WorldClockService worldClockService;
    @Autowired
    ProductService productService;
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceEntity createdInovice(InvoiceDto invoiceDto){
        ClientEntity client = clientService.getByClientDni(invoiceDto.getClientDni());
        InvoiceEntity invoice = new InvoiceEntity();

        List<InvoiceDetailEntity> invoiceDetails = new ArrayList<>();
        float priceTotalByProduct;
        for(ProductEntity product : invoiceDto.getProducts()){
            ProductEntity productFind = productService.subtractProduct(product.getProductName(), product.getProductAmount());
            priceTotalByProduct = productFind.getProductPrice() * product.getProductAmount();
            InvoiceDetailEntity invoiceDetail = new InvoiceDetailEntity();

            invoiceDetail.setProductName(productFind.getProductName());
            invoiceDetail.setAmount(product.getProductAmount());
            invoiceDetail.setPrice(priceTotalByProduct);

            invoiceDetails.add(invoiceDetail);
            invoiceDetailRepository.save(invoiceDetail);
        }

        float priceTotal = 0;
        for(InvoiceDetailEntity price : invoiceDetails){
             priceTotal += price.getPrice();
        }

        invoice.setCompany(companyService.getCompanyByName("Almacen 3D"));
        invoice.setClient(client);
        invoice.setInvoiceDate(worldClockService.getcurrentDateTime());
        invoice.setPriceTotal(priceTotal);
        invoice.setInvoiceDetail(invoiceDetails);
        invoiceRepository.save(invoice);
        return invoice;
    }



}