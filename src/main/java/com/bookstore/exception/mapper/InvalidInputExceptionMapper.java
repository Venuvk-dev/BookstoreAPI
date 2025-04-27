/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.exception.mapper;

import com.bookstore.exception.InvalidInputException;
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

@Provider
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException>{
    private static final Logger logger =LoggerFactory.getLogger(InvalidInputExceptionMapper.class);
    
    public Response toResponse(InvalidInputException exception){
        logger.error("Invalid input entries : "+exception.getMessage());
        
        Map<String , String > errorMessage=new HashMap<>();
        errorMessage.put("Error", exception.getMessage());
        
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
