package com.example.sistemafacturacion.controller;

import com.example.sistemafacturacion.dto.ProductDto;
import com.example.sistemafacturacion.entity.ProductEntity;
import com.example.sistemafacturacion.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name="ProductController", description="Enpoints para el sistema de productos")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Productos", description = "Trae todos los productos de la base de datos")
    @GetMapping("/productos")
    public List<ProductEntity> findAllProducts(){
        return productService.getAllProducts();
    }

    @Operation(summary = "Producto por nombre", description = "Trae el producto ingresando su nombre")
    @GetMapping("/producto/{productName}")
    public ProductEntity findProductByProductName(@PathVariable String productName){
        return productService.getByProductName(productName);
    }

    @Operation(summary = "Ingreso de producto", description = "Crea el ingreso de un nuevo producto")
    @ApiResponse(responseCode = "200", description = "El producto fue creado")
    @PostMapping("/crear-producto")
    public String createProduct(@Valid @RequestBody ProductEntity product){
        return productService.saveProduct(product);
    }

    @Operation(summary = "Actualiza el producto", description = "Actualiza los datos del producto")
    @ApiResponse(responseCode = "200", description = "El producto se actualizo correctamente")
    @PutMapping("/actualizar-producto")
    public String updateProduct(@Valid @RequestBody ProductEntity product){
        return productService.updateProduct(product);
    }

    @Operation(summary = "ELimina producto", description = "Elimina el producto ingresando su nombre")
    @ApiResponse(responseCode = "200", description = "El producto fue eliminado")
    @DeleteMapping("/eliminar-producto/{productName}")
    public String deleteteProduct(@PathVariable String productName){
        return productService.deleteteProduct(productName);
    }

    @Operation(summary = "Resta producto", description = "Resta la cantidad de producto elegida de su total")
    @PutMapping(value = "/restar-producto", params = {"productName","amount"})
    public ProductEntity subtractProduct(@RequestParam String productName, @RequestParam Long amount){
        return productService.subtractProduct(productName,amount);
    }

    @Operation(summary = "Compra de producto", description = "Realiza la compra de varios productos")
    @PostMapping("/comprar-productos")
    public List<ProductDto> buyProducts(@RequestBody List<ProductEntity> products){
        return productService.buyProducts(products);
    }

}
