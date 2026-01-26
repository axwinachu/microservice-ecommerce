package com.example.cart_service.facade;

import com.example.cart_service.client.ProductClient;
import com.example.cart_service.dto.AddToCartRequestDto;
import com.example.cart_service.dto.ProductDto;
import com.example.cart_service.model.Cart;
import com.example.cart_service.model.CartItems;
import com.example.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Transactional
public class CartFacade {

    private final CartService cartService;
    private final ProductClient productClient;

    public void addProductToCart(Long userId, AddToCartRequestDto dto) {

        // 1️⃣ Get or create cart
        Cart cart = cartService.findByUserId(userId)
                .orElseGet(() -> cartService.createCart(userId));

        // 2️⃣ Fetch product from Product Service
        ProductDto product = productClient.getProduct(dto.getProductId());

        // 3️⃣ Validate stock
        if (product.getStockQuantity() < dto.getQuantity()) {
            throw new RuntimeException("Insufficient stock for product: " + product.getProductId());
        }

        // 4️⃣ Check if item already exists in cart
        CartItems item = cart.getItems().stream()
                .filter(i -> i.getProductId().equals(product.getProductId()))
                .findFirst()
                .orElse(null);

        // 5️⃣ Add new item or update existing one
        if (item == null) {
            item = CartItems.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .productImage(product.getMainImageUrl())
                    .rating(product.getAverageRating())
                    .ratingCount(product.getReviewCount())
                    .quantity(dto.getQuantity())
                    .price(product.getPrice()) // temporary, recalculated below
                    .cart(cart)
                    .build();
            cart.getItems().add(item);
        } else {
            item.setQuantity(item.getQuantity() + dto.getQuantity());
        }

        // 6️⃣ Recalculate item total price (unitPrice × quantity)
        BigDecimal itemTotalPrice =
                product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
        item.setPrice(itemTotalPrice);

        // 7️⃣ Recalculate cart total price
        BigDecimal cartTotal = cart.getItems().stream()
                .map(CartItems::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalPrice(cartTotal);

        // 8️⃣ Persist cart (cascade saves items)
        cartService.save(cart);
    }
}
