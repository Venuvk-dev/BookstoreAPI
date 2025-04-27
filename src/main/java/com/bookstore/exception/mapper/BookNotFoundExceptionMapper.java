/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.exception.mapper;

import com.bookstore.exception.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author USER
 */

@Provider                                 //jax-rs will automatically detect this when server will started
public class BookNotFoundExceptionMapper implements ExceptionMapper<BookNotFoundException>{
    //log errors in the terminal for backend monitoring
    private static final Logger logger=LoggerFactory.getLogger(BookNotFoundExceptionMapper.class);
    
    public Response toResponse(BookNotFoundException exception){
        logger.error("The particular Book not found : ", exception.getMessage());
        
        Map<String, String> errorMessage=new HashMap<>();       //a map to store 2 string values error and the particular error message
        errorMessage.put("error", exception.getMessage());      
        
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    
}
