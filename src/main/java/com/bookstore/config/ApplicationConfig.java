/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.config;

import com.bookstore.exception.mapper.AuthorNotFoundExceptionMapper;
import com.bookstore.exception.mapper.BookNotFoundExceptionMapper;
import com.bookstore.exception.mapper.CartNotFoundExceptionMapper;
import com.bookstore.exception.mapper.CustomerNotFoundExceptionMapper;
import com.bookstore.exception.mapper.InvalidInputExceptionMapper;
import com.bookstore.exception.mapper.OrderNotFoundExceptionMapper;
import com.bookstore.exception.mapper.OutOfStockExceptionMapper;
import com.bookstore.resources.AuthorResource;
import com.bookstore.resources.BookResource;
import com.bookstore.resources.CartResource;
import com.bookstore.resources.CustomerResource;
import com.bookstore.resources.OrderResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(BookResource.class);
        register(AuthorResource.class);
        register(CustomerResource.class);
        register(CartResource.class);
        register(OrderResource.class);
        
        // If you want, you can also register exception mappers here (optional)
        register(BookNotFoundExceptionMapper.class);
        register(AuthorNotFoundExceptionMapper.class);
        register(CartNotFoundExceptionMapper.class);
        register(CustomerNotFoundExceptionMapper.class);
        register(OrderNotFoundExceptionMapper.class);
        register(InvalidInputExceptionMapper.class);
        register(OutOfStockExceptionMapper.class);
        
        
        
    }
}
