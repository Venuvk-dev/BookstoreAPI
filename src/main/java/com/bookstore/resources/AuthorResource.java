/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.exception.AuthorNotFoundException;
import com.bookstore.exception.InvalidInputException;
import com.bookstore.model.Author;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    private static final Logger logger = LoggerFactory.getLogger(AuthorResource.class);
    private static final Map<Integer, Author> authors = new ConcurrentHashMap<>();
    private static int nextId=4;
    
    static {
    authors.put(1, new Author(1, "J.K. Rowling", "British author of Harry Potter"));
    authors.put(2, new Author(2, "George Orwell", "Author of 1984 and Animal Farm"));
    authors.put(3, new Author(3, "Jane Austen", "Known for Pride and Prejudice"));
    }
    
    @GET
    public Response getAllAuthors(){
        logger.info("Getting all authors");
        return Response.ok(authors.values()).build();
    }
    
     @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        logger.info("Getting an author by id: " + id);
        Author author = authors.get(id);
        if (author != null) {
            return Response.ok(author).build();
        } else {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
    }
    
    @POST
    public Response addAuthor(Author author) {
        logger.info("POST request to add a new author");
        if (author.getName() == null || author.getBiography() == null) {
            throw new InvalidInputException("Name and Biography are required");
        }
        
        author.setId(nextId++);
        authors.put(author.getId(), author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }
    
    
}
