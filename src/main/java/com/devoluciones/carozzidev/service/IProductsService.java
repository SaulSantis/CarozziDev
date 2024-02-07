package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.entity.Products;

import java.util.List;

public interface IProductsService {

    List<Products> productList();

    List<Products> saveAll(List<Products> products);

    Products save(Products products);

}
