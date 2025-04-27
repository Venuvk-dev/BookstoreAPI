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
public class Order {
    private int id;                          //unique id is for each order
    private int customerId;                 //the coustomer id who makes the order
    private Map<Integer, Integer> items;     //mapping for between BookId and Purchased quantity
    private double totalAmount;

    public Order() {
        this.items=new HashMap<>();
    }

    public Order(int id, int customerId, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.items = new HashMap<>();
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}


