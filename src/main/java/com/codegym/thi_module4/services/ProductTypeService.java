package com.codegym.thi_module4.services;

import com.codegym.thi_module4.models.ProductType;

import com.codegym.thi_module4.repositories.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements  IProductTypeService{

    @Autowired
    private IProductTypeRepository productTypeRepository;
    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
