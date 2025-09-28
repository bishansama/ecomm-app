package com.ecommapp.shoppingcartservice.controller;

import com.ecommapp.shoppingcartservice.model.AddToCartRequest;
import com.ecommapp.shoppingcartservice.model.CartResponse;
import com.ecommapp.shoppingcartservice.model.RemoveFromCartRequest;
import com.ecommapp.shoppingcartservice.service.IShoppingCartService;
import com.ecommapp.shoppingcartservice.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Shopping Cart API", description = "API for managing shopping cart")
public class ShoppingCartController {

    private final IShoppingCartService shoppingCartService;
    
    public ShoppingCartController(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add")
    @Operation(summary = "Add item to cart", description = "Adds an item to the user's shopping cart")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item added to cart successfully",
                content = @Content(schema = @Schema(implementation = CartResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CartResponse> addToCart(@Valid @RequestBody AddToCartRequest request) {
        CartResponse response = shoppingCartService.addToCart(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove")
    @Operation(summary = "Remove item from cart", description = "Removes an item from the user's shopping cart")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item removed from cart successfully",
                content = @Content(schema = @Schema(implementation = CartResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Item not found in cart",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CartResponse> removeFromCart(@Valid @RequestBody RemoveFromCartRequest request) {
        CartResponse response = shoppingCartService.removeFromCart(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get user's cart", description = "Retrieves all items in the user's shopping cart")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cart retrieved successfully",
                content = @Content(schema = @Schema(implementation = CartResponse.class)))
    })
    public ResponseEntity<CartResponse> getCart(@PathVariable("userId") String userId) {
        CartResponse response = shoppingCartService.getCart(userId);
        return ResponseEntity.ok(response);
    }
}