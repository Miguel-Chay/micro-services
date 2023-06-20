package com.mgcn.app.productsservice.models.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mgcn.app.productsservice.models.entity.Product;
import com.mgcn.app.productsservice.models.service.ProductsServiceImpl;

@RestController
public class ProductController {
    
    @Autowired
    private ProductsServiceImpl productsService;

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    // private String port = env.getProperty("local.server.port");

    @GetMapping("/list")
    public List<Product> listar(){
        return productsService.findALL().stream().map(p ->{
            p.setPort(port); 
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/list/{id}")
    public Product details(@PathVariable Long id){
        Product producto = productsService.findById(id);
        producto.setPort(port);
        return producto;
    }

}
