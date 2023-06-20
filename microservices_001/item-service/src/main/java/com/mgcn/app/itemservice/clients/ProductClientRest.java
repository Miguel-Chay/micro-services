package com.mgcn.app.itemservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mgcn.app.itemservice.models.Product;

@FeignClient(name = "product-service")
public interface ProductClientRest {

    @GetMapping("/list")
    public List<Product> list();
    
    @GetMapping("/list/{id}")
    public Product detail(@PathVariable Long id);
}
