package com.devoluciones.carozzidev.model.repository;

import com.devoluciones.carozzidev.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<Products, Long> {
}
