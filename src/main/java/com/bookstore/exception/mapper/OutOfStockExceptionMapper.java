package com.bookstore.exception.mapper;

import com.bookstore.exception.OutOfStockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Mapper for handling OutOfStockException.
 * Returns a 404 response with a structured JSON message.
 */
@Provider
public class OutOfStockExceptionMapper implements ExceptionMapper<OutOfStockException> {
    private static final Logger logger = LoggerFactory.getLogger(OutOfStockExceptionMapper.class);

    @Override
    public Response toResponse(OutOfStockException exception) {
        // Log the full exception (including the stack trace) for better debugging
        logger.error("Out of Stock: ", exception);

        // Create a map to store the error message
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", exception.getMessage());

        // Return a 404 Not Found response with the error message as JSON
        return Response.status(Response.Status.NOT_FOUND)
                       .entity(errorMessage)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
