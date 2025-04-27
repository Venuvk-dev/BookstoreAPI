/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.model.Author;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    private static final Logger logger = LoggerFactory.getLogger(AuthorResource.class);
    private static final Map<Integer, Author> authors = new ConcurrentHashMap<>();
    
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

}
