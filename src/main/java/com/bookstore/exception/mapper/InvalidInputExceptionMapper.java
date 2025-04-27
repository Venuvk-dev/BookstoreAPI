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

@Provider  // JAX-RS will automatically detect this when the server starts
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

    // Log errors in the terminal for backend monitoring
    private static final Logger logger = LoggerFactory.getLogger(InvalidInputExceptionMapper.class);

    @Override
    public Response toResponse(InvalidInputException exception) {
        // Log the full exception with stack trace
        logger.error("Invalid input entries: ", exception);

        // Create a map to store the error message
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", exception.getMessage());

        // Return 400 with a JSON response indicating invalid input
        return Response.status(Response.Status.BAD_REQUEST)  // Use BAD_REQUEST (400) instead of NOT_FOUND
                       .entity(errorMessage)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
