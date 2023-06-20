package com.mgcn.app.productsservice.models.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.mgcn.app.productsservice.models.entity.Product;

@Controller
public interface IProductService {
    
    public List<Product> findALL();
    public Product findById(Long id);

}
