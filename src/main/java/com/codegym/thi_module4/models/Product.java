package com.codegym.thi_module4.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "san_pham")
public class Product {

    @Id
    @Column(name = "ma_sp")
    private Long id;

    @Column(name = "ten_sp")
    private String name;

    @Column(name = "gia_sp")
    private BigDecimal price;

    @Column(name = "tinh_trang_sp")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ma_loai_sp")
    private ProductType productType;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
