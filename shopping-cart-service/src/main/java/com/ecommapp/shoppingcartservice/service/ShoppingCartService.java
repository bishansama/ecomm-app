package com.ecommapp.shoppingcartservice.service;

import com.ecommapp.shoppingcartservice.model.AddToCartRequest;
import com.ecommapp.shoppingcartservice.model.CartItem;
import com.ecommapp.shoppingcartservice.model.CartResponse;
import com.ecommapp.shoppingcartservice.model.RemoveFromCartRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShoppingCartService {

    // In-memory storage for demonstration purposes
    // In a real application, this would be replaced with a database
    private final Map<String, Map<String, CartItem>> userCarts = new ConcurrentHashMap<>();

    public CartResponse addToCart(AddToCartRequest request) {
        System.out.println("Adding item to cart for user: " + request.getUserId() + ", product: " + request.getProductId());
        
        Map<String, CartItem> userCart = userCarts.computeIfAbsent(request.getUserId(), k -> new HashMap<>());
        
        CartItem existingItem = userCart.get(request.getProductId());
        if (existingItem != null) {
            // Update quantity if item already exists
            existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());
        } else {
            // Add new item to cart
            CartItem newItem = new CartItem(
                request.getProductId(),
                request.getProductName(),
                request.getPrice(),
                request.getQuantity()
            );
            userCart.put(request.getProductId(), newItem);
        }
        
        return buildCartResponse(request.getUserId(), "Item added to cart successfully");
    }

    public CartResponse removeFromCart(RemoveFromCartRequest request) {
        System.out.println("Removing item from cart for user: " + request.getUserId() + ", product: " + request.getProductId());
        
        Map<String, CartItem> userCart = userCarts.get(request.getUserId());
        if (userCart == null || !userCart.containsKey(request.getProductId())) {
            throw new RuntimeException("Item not found in cart");
        }
        
        userCart.remove(request.getProductId());
        
        return buildCartResponse(request.getUserId(), "Item removed from cart successfully");
    }

    public CartResponse getCart(String userId) {
        System.out.println("Getting cart for user: " + userId);
        return buildCartResponse(userId, "Cart retrieved successfully");
    }

    private CartResponse buildCartResponse(String userId, String message) {
        Map<String, CartItem> userCart = userCarts.getOrDefault(userId, new HashMap<>());
        List<CartItem> items = new ArrayList<>(userCart.values());
        
        double totalAmount = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        
        return new CartResponse(userId, items, totalAmount, message);
    }
}