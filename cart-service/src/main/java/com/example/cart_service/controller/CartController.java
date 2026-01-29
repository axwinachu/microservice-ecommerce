package com.example.cart_service.controller;

import com.example.cart_service.dto.AddToCartRequestDto;
import com.example.cart_service.dto.CartResponseDto;
import com.example.cart_service.dto.ProductDto;
import com.example.cart_service.dto.UpdateCartItemRequestDto;
import com.example.cart_service.facade.CartFacade;
import com.example.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartFacade cartFacade;
    @PostMapping("/items")
    public void addCartItems(@RequestHeader("X-USER-ID") Long userId, @RequestBody AddToCartRequestDto addToCartRequestDto){
        cartFacade.addProductToCart(userId,addToCartRequestDto);
    }
    @GetMapping
    public CartResponseDto viewCartItems(@RequestHeader("X-USER-ID") Long userId){
        return cartFacade.viewCart(userId);
    }
    @PutMapping("/{productId}")
    public void updateCarItems(@RequestHeader("X-USER-ID") Long userId
            , @PathVariable Long productId, @RequestBody UpdateCartItemRequestDto updateCartItemRequestDto){
        cartFacade.updateCartItems(userId,productId,updateCartItemRequestDto);
    }
    @DeleteMapping("/{productId}")
    public void removeItemFromCart(@RequestHeader("X-USER-ID") Long userId,@PathVariable Long productId ){
        cartFacade.removeFromCart(userId,productId);
    }
    @DeleteMapping
    public void clearCart(@RequestHeader("X-USER-ID") Long userId) {
        cartFacade.clearCart(userId);
    }

}
