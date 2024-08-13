package com.codegym.thi_module4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loai_san_pham")
public class ProductType {

    @Id
    @Column(name = "ma_loai_sp")
    private Long id;

    @Column(name = "ten_loai_sp")
    private String name;

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
}

