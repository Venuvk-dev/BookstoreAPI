/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.exception.mapper;

import com.bookstore.exception.OrderNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class OrderNotFoundExceptionMapper implements ExceptionMapper<OrderNotFoundException> {

    private static final Logger logger = LoggerFactory.getLogger(OrderNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(OrderNotFoundException exception) {
        logger.error("Order not found: {}", exception.getMessage(), exception);
        return Response.status(Response.Status.NOT_FOUND)
                       .entity(exception.getMessage())
                       .type(MediaType.TEXT_PLAIN)
                       .build();
    }
}

