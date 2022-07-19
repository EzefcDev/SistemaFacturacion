package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.entity.ProductEntity;
import com.example.sistemafacturacion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/productos")
    public List<ProductEntity> findAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/producto/{productName}")
    public ProductEntity findProductByProductName(@PathVariable String productName){
        return productService.getByProductName(productName);
    }

    @PostMapping("/crear-producto")
    public String createProduct(@Valid @RequestBody ProductEntity product){
        return productService.saveProduct(product);
    }

    @PutMapping("/actualizar-producto")
    public String updateProduct(@Valid @RequestBody ProductEntity product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/eliminar-producto/{productName}")
    public String deleteteProduct(@PathVariable String productName){
        return productService.deleteteProduct(productName);
    }

    @PutMapping(value = "/restar-producto", params = {"productName","amount"})
    public String subtractProduct(@RequestParam String productName, @RequestParam Long amount){
        return productService.subtractProduct(productName,amount);
    }

}
