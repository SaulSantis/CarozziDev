package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.entity.Products;
import com.devoluciones.carozzidev.model.repository.IProductsRepository;
import com.devoluciones.carozzidev.service.impl.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    public ProductImpl productImpl;

    @Autowired
    public IProductsRepository iProductsRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productImpl.productList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Products>> saveProductList(@RequestBody List<Products> products) {
        List<Products> savedProducts = productImpl.saveAll(products);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    @PostMapping("/product")
    public Products save(@RequestBody Products products) {
        return productImpl.save(products);
    }

}
