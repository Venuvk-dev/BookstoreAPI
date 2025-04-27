/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.exception.mapper;


import com.bookstore.exception.OutOfStockException;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
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

@Provider
public class OutOfStockExceptionMapper implements ExceptionMapper<OutOfStockException>{
    private static final Logger logger =LoggerFactory.getLogger(OutOfStockExceptionMapper.class);
    
    public Response toResponse(OutOfStockException exception){
        logger.error("Out of Stock : "+exception.getMessage());
        
        Map<String , String > errorMessage=new HashMap<>();
        errorMessage.put("Error", exception.getMessage());
        
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
