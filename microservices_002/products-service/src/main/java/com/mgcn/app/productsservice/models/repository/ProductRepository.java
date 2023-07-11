package com.mgcn.app.productsservice.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgcn.app.productsservice.models.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
