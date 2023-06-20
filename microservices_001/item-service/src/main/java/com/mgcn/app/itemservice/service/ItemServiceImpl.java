package com.mgcn.app.itemservice.service;
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mgcn.app.itemservice.models.Item;
import com.mgcn.app.itemservice.models.Product;

@Service
// @Primary
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        System.out.println("Rest Template");
        List<Product> products = Arrays.asList( clientRest.getForObject("http://product-service/list", Product[].class) );
        return products.stream().map(p -> new Item(p,1) ).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String,String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Product product = clientRest.getForObject("http://product-service/list/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
    
}
