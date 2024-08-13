package com.codegym.thi_module4.services;

import com.codegym.thi_module4.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Iterable<Product> findAll();
}
