package com.codegym.thi_module4.repositories;

import com.codegym.thi_module4.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IProductTypeRepository extends JpaRepository<Product, Long> {

}