/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.model.Book;
//import com.sun.org.slf4j.Logger;
//import com.sun.org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USER
 */

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    
    private static final Logger logger =LoggerFactory.getLogger(BookResource.class);   //to log crud events
    private static Map<Integer, Book> books=new HashMap<>();   //A map to store books as temporary database
    
    static{
        books.put(1, new Book(1,"Java Basics", "Venukanth", 39.99,"isbn001", 2020, 10));
        books.put(2, new Book(2,"Core Java", "Kithuskanth", 59.99,"isbn002", 2024, 5));
    }
    
    @GET
    public Response getAllBooks(){
        logger.info("Getting all books");         
        return Response.ok(books.values()).build();        //response.ok means HTTP 200 ok.
    }
}
