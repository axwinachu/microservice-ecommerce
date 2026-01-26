package com.example.cart_service.repository;

import com.example.cart_service.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
}
