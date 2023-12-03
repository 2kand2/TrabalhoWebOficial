package com.example.auth.domain.product;

public record ProductResponseDTO(String id, String name, String description, int price, int qtd) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getDescription(),product.getPrice(), product.getQtd());
    }
}
