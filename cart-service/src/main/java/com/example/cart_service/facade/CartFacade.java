package com.example.cart_service.facade;

import com.example.cart_service.client.ProductClient;
import com.example.cart_service.dto.*;
import com.example.cart_service.mapper.Mapper;
import com.example.cart_service.model.Cart;
import com.example.cart_service.model.CartItems;
import com.example.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class CartFacade {

    private final CartService cartService;
    private final ProductClient productClient;
    private final Mapper mapper;

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
    public CartResponseDto viewCart(Long userId) {
        Cart cart=cartService.findByUserId(userId).orElseGet(()->cartService.createCart(userId));
        List<CartItemsResponseDto> cartResponseDto=cart.getItems()
                .stream().map(mapper::cartItemTOCartItemsResponseDto).toList();
        return CartResponseDto.builder()
                .id(cart.getId())
                .userId(cart.getUserId())
                .items(cartResponseDto)
                .totalPrice(cart.getTotalPrice()).build();
    }
    public void updateCartItems(Long userId, Long productId, UpdateCartItemRequestDto updateCartItemRequestDto) {
        Cart cart=cartService.findByUserId(userId)
                .orElseThrow(()->new RuntimeException("Cart Not Found"));
        CartItems cartItems=cart.getItems().stream().filter(i->i.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Product Id not found in the cart"));
        if(updateCartItemRequestDto.getQuantity()<=0){
            throw new RuntimeException("quantity not be negative");
        }
        cartItems.setQuantity(updateCartItemRequestDto.getQuantity());
        BigDecimal unitPrice =
                cartItems.getPrice().divide(
                        BigDecimal.valueOf(cartItems.getQuantity()),
                        RoundingMode.HALF_UP
                );
        cartItems.setPrice(unitPrice.multiply(BigDecimal.valueOf(updateCartItemRequestDto.getQuantity())));

        BigDecimal cartTotal = cart.getItems().stream()
                .map(CartItems::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalPrice(cartTotal);
        cartService.save(cart);
    }
    public void removeFromCart(Long userId, Long productId) {
        Cart cart=cartService.findByUserId(userId)
                .orElseThrow(()->new RuntimeException("cart not found exception"));
        CartItems product=cart.getItems().stream().filter(i->i.getProductId().equals(productId))
                .findFirst().orElseThrow(()->new RuntimeException("product id not found"));
        cart.getItems().remove(product);
        BigDecimal cartTotal = cart.getItems().stream()
                .map(CartItems::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalPrice(cartTotal);
        cartService.save(cart);
    }
}
