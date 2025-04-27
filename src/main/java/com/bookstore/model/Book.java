/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.model;

/**
 *
 * @author USER
 */
public class Book {
    private int id;                    //unique id for storing books
    private String title;              //title name of the book
    private String author;             //author's name
    private double price;
    private int publicationYear;       //storing the year for the book 
    private int stockQuantity;         //available stock of the book      
    
    public Book(){};      //required for the api creating frameworks(jersey+jackson)

    public Book(int id, String title, String author, double price ,int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear=publicationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" +
                author + ", price=" + price + ", publicationYear=" + publicationYear +
                ", stockQuantity=" + stockQuantity + '}';
        //toString method may help in future to display the details of the instances
    }
}
