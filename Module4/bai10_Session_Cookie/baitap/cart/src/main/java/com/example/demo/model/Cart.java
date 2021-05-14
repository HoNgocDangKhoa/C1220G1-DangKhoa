package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
private Map<Product,Integer> cart;

    public Cart() {
        this.cart=new HashMap<>();
    }

    public Cart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void saveCart(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }else {
            cart.put(product,1);
        }
    }
    public Integer getAmount(Product product){
        return cart.get(product);
    }
    public void editCart(Product product,Integer amount){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product),amount);
        }else {
            cart.put(product,amount);
        }
    }
    public Integer getTotalCost(){
        Integer totalCost = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            Integer price = product.getPrice();
            totalCost += price*entry.getValue();
        }
        return totalCost;
    }
    public void delete(Product product){
        cart.remove(product);
    }
    public void deleteAll(){
        cart.clear();
    }

}
