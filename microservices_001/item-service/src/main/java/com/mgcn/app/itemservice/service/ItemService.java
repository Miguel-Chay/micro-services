package com.mgcn.app.itemservice.service;

import java.util.List;

import com.mgcn.app.itemservice.models.Item;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer quantity);
}
