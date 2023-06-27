package com.mgcn.app.productsservice.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgcn.app.productsservice.models.entity.Product;
import com.mgcn.app.productsservice.models.repository.ProductRepository;

@Service
public class ProductsServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findALL() {
    	
    	List<Product> list = productRepository.findAll();
    	return list;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
 
    
}
