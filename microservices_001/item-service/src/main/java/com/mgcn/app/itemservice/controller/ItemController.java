package com.mgcn.app.itemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mgcn.app.itemservice.models.Item;
import com.mgcn.app.itemservice.service.ItemService;

@RestController
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item> list(){
        return itemService.findAll();
    }


    @GetMapping("/list/{id}/quantity/{quantity}")
    public Item detail(@PathVariable long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }
}
