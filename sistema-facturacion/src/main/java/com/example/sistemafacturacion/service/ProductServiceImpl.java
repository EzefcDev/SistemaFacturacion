package com.example.sistemafacturacion.service;

import com.example.sistemafacturacion.entity.ProductEntity;
import com.example.sistemafacturacion.error.NotFoundException;
import com.example.sistemafacturacion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    //Metodo para buscar todos los productos
    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    //Metodo para buscar un producto por su nombre
    @Override
    public ProductEntity getByProductName(String productName) {
        Optional<ProductEntity> product = Optional.ofNullable(productRepository.findByProductName(productName));
        return product.orElseThrow(() -> new NotFoundException("El producto no existe"));
    }

    //Metodo para almacenar un producto
    @Override
    public String saveProduct(ProductEntity product) {
        Optional<ProductEntity> productExiste = Optional.ofNullable(productRepository.findByProductName(product.getProductName()));
        if (productExiste.isPresent()) {
            throw new NotFoundException("El producto ya esxite");
        }else {
            ProductEntity productValidated = validator(product);
            productRepository.save(productValidated);
            return "El producto fue creado";
        }
    }

    //Metodo para actualizar un producto
    @Override
    public String updateProduct(ProductEntity product) {
        if (product.getProductId() == null){
            product.setProductId(productRepository.findByProductName(product.getProductName()).getProductId());
        }
        Optional<ProductEntity> productExiste = Optional.ofNullable(productRepository.findByProductName(product.getProductName()));
        if (productExiste.isPresent()) {
            ProductEntity productValidated = validator(product);
            productRepository.save(productValidated);
            return "El producto se actualizo correctamente";
        }else {
            throw new NotFoundException("El producto ya esxite");
        }
    }

    //Metodo para elimnar el producto
    @Override
    public String deleteteProduct(String productName) {
        Optional<ProductEntity> productExiste = Optional.ofNullable(productRepository.findByProductName(productName));
        if (productExiste.isPresent()) {
            ProductEntity product = productRepository.findByProductName(productName);
            productRepository.delete(product);
            return "El producto fue eliminado";
        }else {
            throw new NotFoundException("El producto no esxite");
        }
    }

    //Metodo para validar datos del producto
    public ProductEntity validator(ProductEntity product) {
        if(product.getProductPrice() >= 0){
            if(product.getProductAmount() >= 0){
                return  product;
            }else {
                throw new NotFoundException("La cantidad del producto no puede ser negativa");
            }
        }else {
            throw new NotFoundException("El precio del producto no puede ser negativo");
        }
    }
}
