package com.example.order_service.controller;

import com.example.order_service.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderFacade orderFacade;
    @PostMapping
    public Long placeOrder(@RequestHeader("X-USER-ID") Long userId){
        return orderFacade.placeOrder(userId);
    }
}
