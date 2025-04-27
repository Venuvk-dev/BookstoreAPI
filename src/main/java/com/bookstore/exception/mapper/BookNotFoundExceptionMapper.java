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
@Provider
public class BookNotFoundExceptionMapper implements ExceptionMapper<BookNotFoundException> {
    // Log errors in the terminal for backend monitoring
    private static final Logger logger = LoggerFactory.getLogger(BookNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(BookNotFoundException exception) {
        // Log the full exception with stack trace
        logger.error("The particular Book not found: ", exception);

        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", exception.getMessage());

        // Return 404 with a JSON response
        return Response.status(Response.Status.NOT_FOUND)
                       .entity(errorMessage)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
