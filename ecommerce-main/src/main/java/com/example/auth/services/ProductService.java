package com.example.auth.services;

import com.example.auth.domain.product.*;
import com.example.auth.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;


    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public List<Product> getProductByName(ProductSearchNameRequestDTO requestBody){
        System.out.println(requestBody.name());
        return repository.findByNameContainingIgnoreCase(requestBody.name());
    }

    public void createProduct(ProductRequestDTO body) {
        Product newProduct = new Product(body);
        this.repository.save(newProduct);
    }

    public void updateProduct(String id ,ProductRequestDTO body) {

            Product existingProduct = repository.findById(id)
                    .orElseThrow(()-> new EntityNotFoundException("Product not found"));

            if(body.getName() != null){
                existingProduct.setName(body.getName());
            }
            if(body.getDescription() != null){
                existingProduct.setDescription(body.getDescription());
            }

            if(body.getPrice() > 0){
                existingProduct.setPrice(body.getPrice());
            }

            if(body.getQtd() > 0){
                existingProduct.setQtd(body.getQtd());
            }

            repository.save(existingProduct);
    }

    public void updateProductQtd(String id , ProductUpdateQtdDTO productUpdateQtdDTO) {

        Product existingProduct = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Product not found"));

        if(productUpdateQtdDTO.qtd() > 0){
            existingProduct.setQtd(productUpdateQtdDTO.qtd());
        }

        repository.save(existingProduct);
    }



    public void deleteProductById(String id){
        repository.deleteById(id);
    }

    public boolean existsById(String id) {
        return repository.existsById(id);
    }
}
