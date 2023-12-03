package com.example.auth.domain.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        int price,

        @NotNull
        int qtd
) {
        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public int getPrice() {
                return price;
        }

        public int getQtd() {
                return qtd;
        }
}
