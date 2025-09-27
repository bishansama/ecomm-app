package com.ecommapp.productcatalogservice.controller;

import com.ecommapp.productcatalogservice.model.Product;
import com.ecommapp.productcatalogservice.model.ProductRequest;
import com.ecommapp.productcatalogservice.model.ProductResponse;
import com.ecommapp.productcatalogservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Catalog API", description = "API for managing product catalog")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/catalog")
    @Operation(summary = "View product catalog", description = "Retrieves all products in the catalog")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Catalog retrieved successfully",
                content = @Content(schema = @Schema(implementation = Product.class)))
    })
    public ResponseEntity<List<Product>> viewCatalog() {
        List<Product> catalog = productService.viewCatalog();
        return ResponseEntity.ok(catalog);
    }

    @PostMapping("/catalog")
    @Operation(summary = "Create a new product", description = "Adds a new product to the catalog")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Product created successfully",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<ProductResponse> createCatalog(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}