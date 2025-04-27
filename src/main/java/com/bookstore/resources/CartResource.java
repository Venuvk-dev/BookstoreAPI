/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.exception.CartNotFoundException;
import com.bookstore.model.Cart;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author USER
 */
@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
    
    private static final Logger logger = LoggerFactory.getLogger(CartResource.class);
    private static Map<Integer, Cart> carts = new HashMap<>();
    private static int nextId = 1;
    
    @GET
    public Response getAllCarts() {
        logger.info("GET request for all carts");
        return Response.ok(carts.values()).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getCartById(@PathParam("id") int id) {
        logger.info("GET request for cart with id: {}", id);
        Cart cart = carts.get(id);
        if (cart != null) {
            return Response.ok(cart).build();
        } else {
            throw new CartNotFoundException("Cart with ID " + id + " not found");
        }
    }
    
    @POST
    public Response createCart(Cart cart) {
        logger.info("POST request to create a new cart");
        cart.setId(nextId++);
        carts.put(cart.getId(), cart);
        return Response.status(Response.Status.CREATED).entity(cart).build();
    }
    
    @PUT
    @Path("/{cartId}/add/{bookId}/{quantity}")
    public Response addBookToCart(@PathParam("cartId") int cartId,
                                  @PathParam("bookId") int bookId,
                                  @PathParam("quantity") int quantity) {
        logger.info("PUT request to add book {} with quantity {} to cart {}", bookId, quantity, cartId);
        Cart cart = carts.get(cartId);
        if (cart == null) {
            throw new CartNotFoundException("Cart with ID " + cartId + " not found");
        }
        
        Map<Integer, Integer> items = cart.getItems();
        items.put(bookId, items.getOrDefault(bookId, 0) + quantity);
        cart.setItems(items);
        return Response.ok(cart).build();
    }
    
    @DELETE
    @Path("/{cartId}/remove/{bookId}")
    public Response removeBookFromCart(@PathParam("cartId") int cartId,
                                       @PathParam("bookId") int bookId) {
        logger.info("DELETE request to remove book {} from cart {}", bookId, cartId);
        Cart cart = carts.get(cartId);
        if (cart == null) {
            throw new CartNotFoundException("Cart with ID " + cartId + " not found");
        }
        
        cart.getItems().remove(bookId);
        return Response.ok(cart).build();
    }
    
    @DELETE
    @Path("/{cartId}")
    public Response deleteCart(@PathParam("cartId") int cartId) {
        logger.info("DELETE request to delete cart with id: {}", cartId);
        Cart removedCart = carts.remove(cartId);
        if (removedCart == null) {
            throw new CartNotFoundException("Cart with ID " + cartId + " not found for deletion");
        }
        return Response.noContent().build();
    }
}
