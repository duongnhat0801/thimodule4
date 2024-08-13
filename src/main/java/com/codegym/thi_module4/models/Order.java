package com.codegym.thi_module4.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "don_hang")
public class Order {

    @Id
    @Column(name = "ma_don_hang")
    private Long id;

    @Column(name = "ngay_mua")
    private LocalDate purchaseDate;

    @Column(name = "so_luong")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ma_sp")
    private Product product;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

