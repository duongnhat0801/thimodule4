package com.codegym.thi_module4.services;

import com.codegym.thi_module4.models.ProductType;
import org.springframework.stereotype.Service;

@Service
public interface IProductTypeService {
    Iterable<ProductType> findAll();
}
