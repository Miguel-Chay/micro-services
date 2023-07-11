package com.mgcn.app.productsservice.models.controller;

import java.util.List;
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
	private Environment env;
	
    @Autowired
    private ProductsServiceImpl productsService;

    @Value("${server.port}")
    private Integer port;
    
    private Integer port2;

    @GetMapping("/list")
    public List<Product> listar(){
    	List<Product> list = productsService.findALL();
    	port2 = Integer.parseInt(env.getProperty("local.server.port"));
    	 
        list = list.stream().map(p ->{
            p.setPort(port2); 
            return p;
        }).collect(Collectors.toList());
        System.out.println(list);
        return list;
        
    }

    @GetMapping("/list/{id}")
    public Product details(@PathVariable Long id){
    	port2 = Integer.parseInt(env.getProperty("local.server.port"));
        Product producto = productsService.findById(id);
        producto.setPort(port2);

//        try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) { 
//			System.out.println("Error: "+e.getMessage());
//		}
        
        return producto;
    }

}
