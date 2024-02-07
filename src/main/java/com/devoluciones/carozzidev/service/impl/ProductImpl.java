package com.devoluciones.carozzidev.service.impl;

import com.devoluciones.carozzidev.model.entity.Products;
import com.devoluciones.carozzidev.model.repository.IProductsRepository;
import com.devoluciones.carozzidev.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements IProductsService {

    @Autowired
    private IProductsRepository iProductsRepository;

    @Override
    public List<Products> productList() {
        return iProductsRepository.findAll();
    }

    @Override
    public List<Products> saveAll(List<Products> products) {
        return iProductsRepository.saveAll(products);
    }

    @Override
    public Products save(Products products) {
        return iProductsRepository.save(products);
    }
}
