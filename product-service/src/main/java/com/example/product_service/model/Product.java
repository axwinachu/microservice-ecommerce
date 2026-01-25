package com.example.product_service.model;

import com.example.product_service.model.enums.Availability;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    private String productName;
    @Column(length = 500)
    private String category;
    private String shortDescription;
    @Column(length=5000)
    private String description;
    private String brand;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Double taxPercentage;
    private Integer stockQuantity;
    @Enumerated(EnumType.STRING)
    private Availability availability;
    private String mainImageUrl;
    @ElementCollection
    private List<String> imageUrl;
    private Double averageRating=0.0;
    private Integer reviewCount=0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}
