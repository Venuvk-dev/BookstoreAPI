package com.bookstore.exception.mapper;

import com.bookstore.exception.CustomerNotFoundException;
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

@Provider  // JAX-RS will automatically detect this when the server starts
public class CustomerNotFoundExceptionMapper implements ExceptionMapper<CustomerNotFoundException> {

    // Log errors in the terminal for backend monitoring
    private static final Logger logger = LoggerFactory.getLogger(CustomerNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(CustomerNotFoundException exception) {
        // Log the full exception with stack trace
        logger.error("The particular Customer not found: ", exception);

        // Create a map to store the error message
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", exception.getMessage());

        // Return 404 with a JSON response
        return Response.status(Response.Status.NOT_FOUND)
                       .entity(errorMessage)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
