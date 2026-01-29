package com.example.cart_service.repository;

import com.example.cart_service.model.CartItems;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM CartItems ci WHERE ci.cart.id = :cartId")
    void deleteByCartId(@Param("cartId") Long cartId);
}
