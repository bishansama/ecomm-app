package com.ecommapp.productcatalogservice.service;

import com.ecommapp.productcatalogservice.model.Product;
import com.ecommapp.productcatalogservice.model.ProductRequest;
import com.ecommapp.productcatalogservice.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    
    // In-memory storage for demonstration (in real application, this would be a database)
    private final List<Product> productCatalog = new ArrayList<>();

    public ProductResponse createProduct(ProductRequest productRequest) {
        // Generate a random product ID
        String productId = UUID.randomUUID().toString();
        
        // Create new product
        Product product = new Product();
        product.setProductId(productId);
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setQuantity(productRequest.getQuantity());
        
        // Add to catalog
        productCatalog.add(product);
        
        // Return response
        ProductResponse response = new ProductResponse();
        response.setProductId(productId);
        response.setMessage("Product created successfully");
        return response;
    }

    public List<Product> viewCatalog() {
        return new ArrayList<>(productCatalog);
    }
}