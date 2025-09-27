package com.ecommapp.productcatalogservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Product name cannot be empty")
    private String name;
    
    @NotBlank(message = "Product description cannot be empty")
    private String description;
    
    @NotNull(message = "Product price cannot be null")
    @Positive(message = "Product price must be positive")
    private BigDecimal price;
    
    @NotBlank(message = "Product category cannot be empty")
    private String category;
    
    @NotNull(message = "Product quantity cannot be null")
    @Positive(message = "Product quantity must be positive")
    private Integer quantity;

    // Explicit getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}