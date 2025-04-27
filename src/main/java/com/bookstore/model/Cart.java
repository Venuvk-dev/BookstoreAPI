/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
public class Cart {
    private int id;                //unique id for the cart
    private int customerId;        //Linking the cart with customer
    private Map<Integer, Integer> items;          //stores a mapping between BookId and quantity

    public Cart() {
        items = new HashMap<>();
    }

    public Cart(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
        this.items=new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }
}
