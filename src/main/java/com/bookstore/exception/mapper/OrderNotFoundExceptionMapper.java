package com.bookstore.exception.mapper;

import com.bookstore.exception.OrderNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@Provider
public class OrderNotFoundExceptionMapper implements ExceptionMapper<OrderNotFoundException> {

    private static final Logger logger = LoggerFactory.getLogger(OrderNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(OrderNotFoundException exception) {
        // Log the error along with the stack trace for better debugging
        logger.error("Order not found: ", exception);

        // Create a map for the error response
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", exception.getMessage());

        // Return a JSON response with status 404 (Not Found)
        return Response.status(Response.Status.NOT_FOUND)
                       .entity(errorMessage)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
