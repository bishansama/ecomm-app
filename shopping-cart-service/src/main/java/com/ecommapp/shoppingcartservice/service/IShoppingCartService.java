package com.ecommapp.shoppingcartservice.service;

import com.ecommapp.shoppingcartservice.model.AddToCartRequest;
import com.ecommapp.shoppingcartservice.model.CartResponse;
import com.ecommapp.shoppingcartservice.model.RemoveFromCartRequest;

/**
 * Interface for Shopping Cart Service operations.
 * Defines the contract for shopping cart management functionality.
 */
public interface IShoppingCartService {
    
    /**
     * Adds an item to the user's shopping cart.
     * 
     * @param request the item details to add to cart
     * @return CartResponse containing updated cart information
     */
    CartResponse addToCart(AddToCartRequest request);
    
    /**
     * Removes an item from the user's shopping cart.
     * 
     * @param request the item details to remove from cart
     * @return CartResponse containing updated cart information
     */
    CartResponse removeFromCart(RemoveFromCartRequest request);
    
    /**
     * Retrieves the current cart contents for a user.
     * 
     * @param userId the unique identifier of the user
     * @return CartResponse containing current cart information
     */
    CartResponse getCart(String userId);
}