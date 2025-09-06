package com.alejandroct.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;


public record ProductDto(

        Long id,
        @NotBlank(message = "name cannot be null")
        String name,

        String description,

        @NotNull(message = "price cannot be empty")
        @PositiveOrZero(message = "price should be greater than 0")
        BigDecimal price
)
{
}

//public class ProductDto {
//        private Long id;
//
//        private String name;
//
//        private String description;
//
//        private BigDecimal price;
//
//
//        public ProductDto() {
//        }
//
//        public ProductDto(Long id, String name, String description, BigDecimal price) {
//                this.id = id;
//                this.name = name;
//                this.description = description;
//                this.price = price;
//        }
//
//        public Long getId() {
//                return id;
//        }
//
//        public void setId(Long id) {
//                this.id = id;
//        }
//
//        public String getName() {
//                return name;
//        }
//
//        public void setName(String name) {
//                this.name = name;
//        }
//
//        public String getDescription() {
//                return description;
//        }
//
//        public void setDescription(String description) {
//                this.description = description;
//        }
//
//        public BigDecimal getPrice() {
//                return price;
//        }
//
//        public void setPrice(BigDecimal price) {
//                this.price = price;
//        }
//}
//
