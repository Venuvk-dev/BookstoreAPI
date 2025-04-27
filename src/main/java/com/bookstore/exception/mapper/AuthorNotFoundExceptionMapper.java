package com.bookstore.exception.mapper;

import com.bookstore.exception.AuthorNotFoundException;
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
public class AuthorNotFoundExceptionMapper implements ExceptionMapper<AuthorNotFoundException> {

    // Log errors in the terminal for backend monitoring
    private static final Logger logger = LoggerFactory.getLogger(AuthorNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(AuthorNotFoundException exception) {
        // Log the full exception with the stack trace
        logger.error("The particular Author not found: ", exception);

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
