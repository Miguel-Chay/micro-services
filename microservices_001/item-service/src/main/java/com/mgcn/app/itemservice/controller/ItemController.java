package com.mgcn.app.itemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mgcn.app.itemservice.models.Item;
import com.mgcn.app.itemservice.models.Product;
import com.mgcn.app.itemservice.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item> list(){
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "detailAlternativeMethod")
    @GetMapping("/list/{id}/quantity/{quantity}")
    public Item detail(@PathVariable long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }
    
    public Item detailAlternativeMethod(long id, Integer quantity){
    	Item item = new Item();
    	Product product = new Product();
    	item.setQuantity(quantity);
    	
    	product.setId(id);
    	product.setName("celular");
    	product.setPrice(5000.00);
    	item.setProduct(product);
    	
    	
        return item;
    }
    
}
