package com.mgcn.app.itemservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    
    private Product product;
    private Integer quantity;

    public Double getTotal (){
        return  quantity.doubleValue() * product.getPrice();
    }
}
