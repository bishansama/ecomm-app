package com.ecommapp.productcatalogservice.service;

import com.ecommapp.productcatalogservice.model.Product;
import com.ecommapp.productcatalogservice.model.ProductRequest;
import com.ecommapp.productcatalogservice.model.ProductResponse;

import java.util.List;

/**
 * Interface for Product Service operations.
 * Defines the contract for product catalog management functionality.
 */
public interface IProductService {
    
    /**
     * Creates a new product in the catalog.
     * 
     * @param productRequest the product details
     * @return ProductResponse containing product ID and status
     */
    ProductResponse createProduct(ProductRequest productRequest);
    
    /**
     * Retrieves all products from the catalog.
     * 
     * @return List of all products in the catalog
     */
    List<Product> viewCatalog();
}