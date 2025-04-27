/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.exception.BookNotFoundException;
import com.bookstore.exception.InvalidInputException;
import com.bookstore.model.Book;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;
//import com.sun.org.slf4j.Logger;
//import com.sun.org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    private static int nextId=3;
    
    static{
        books.put(1, new Book(1,"Java Basics", "Venukanth", 39.99,"isbn001", 2020, 10));
        books.put(2, new Book(2,"Core Java", "Kithuskanth", 59.99,"isbn002", 2024, 5));
    }
    
    @GET
    public Response getAllBooks(){
        logger.info("Getting all books");         
        return Response.ok(books.values()).build();        //response.ok means HTTP 200 ok.
    }
    
    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") int id){
        logger.info("Getting a book by an id : "+id);
        Book book=books.get(id);           //getting a book of the particular from the book map
        if (book != null) {                //if there is a book in the id will return the particular book
            return Response.ok(book).build();
        }
        else{
            throw new BookNotFoundException("Book with the id "+id+" not found");
        }
    }
    
    @POST                                                 //a HTTP method for creating 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book){
        logger.info("POST request for add a new book");
        if(book.getAuthor()==null || book.getIsbn()==null || book.getTitle()==null ){  //validating to avoid storing incomplete data 
            throw new InvalidInputException("Title, Author, ISBN required");
        }
        
        book.setId(nextId++);
        books.put(book.getId(), book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") int id, Book updatedBook){
        logger.info("PUT request for updating the book of id : "+id);
        Book existingBook=books.get(id);
        if (existingBook == null) {
            throw new BookNotFoundException("Book with the id "+id+" not found to update");
        }
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setStockQuantity(updatedBook.getStockQuantity());
        
        books.put(id, existingBook);
        return Response.ok(existingBook).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id")int id){
        logger.info("Delete request for the book with id : "+id );
        Book removeBook=books.remove(id);
        if (removeBook == null) {
        throw new BookNotFoundException("Book with ID " + id + " not found for deletion");
        }
        return Response.noContent().build();
    }

    
    
    
    
    
    
}
