package com.example.order_service.facade;

import com.example.order_service.client.CartClient;
import com.example.order_service.dto.CartItemsResponseDto;
import com.example.order_service.dto.CartResponseDto;
import com.example.order_service.exception.CartIsEmpty;
import com.example.order_service.model.Enum.OrderStatus;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderItem;
import com.example.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final CartClient cartClient;

    @Transactional
    public String placeOrder(Long userId) {

        CartResponseDto cart = cartClient.getCart(userId);

        if (cart.getItems().isEmpty()) {
            throw new CartIsEmpty("cart is empty");
        }

        Order order = Order.builder()
                .userId(cart.getUserId())
                .totalAmount(cart.getTotalPrice())
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .items(new ArrayList<>())
                .build();

        for (CartItemsResponseDto cartItem : cart.getItems()) {
            OrderItem item = OrderItem.builder()
                    .productId(cartItem.getProductId())
                    .productName(cartItem.getProductName())
                    .productImage(cartItem.getProductImage())
                    .quantity(cartItem.getQuantity())
                    .price(cartItem.getPrice())
                    .order(order)
                    .build();

            order.getItems().add(item);
        }

        Order savedOrder = orderRepository.save(order);

        cartClient.clearCart(userId);

        return "order place success fully";
    }

}
