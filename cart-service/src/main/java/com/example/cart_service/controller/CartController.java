package com.example.cart_service.controller;

import com.example.cart_service.dto.AddToCartRequestDto;
import com.example.cart_service.facade.CartFacade;
import com.example.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartFacade cartFacade;
    @PostMapping("/items")
    public void addProductToCart(@RequestHeader("X-USER-ID") Long userId, @RequestBody AddToCartRequestDto addToCartRequestDto){
        cartFacade.addProductToCart(userId,addToCartRequestDto);
    }
}
