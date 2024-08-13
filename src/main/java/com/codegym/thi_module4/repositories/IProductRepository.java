package com.codegym.thi_module4.repositories;

import com.codegym.thi_module4.models.Product;
import com.codegym.thi_module4.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
