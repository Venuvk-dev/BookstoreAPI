/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.exception.OrderNotFoundException;
import com.bookstore.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderResource.class);
    private static Map<Integer, Order> orders = new HashMap<>();
    private static int nextId = 1;

    @GET
    public Response getAllOrders() {
        logger.info("GET request for all orders");
        return Response.ok(orders.values()).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrderById(@PathParam("id") int id) {
        logger.info("GET request for order by ID: {}", id);
        Order order = orders.get(id);
        if (order == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        return Response.ok(order).build();
    }

    @POST
    public Response createOrder(Order order) {
        logger.info("POST request to create new order");
        if (order == null) {
            throw new BadRequestException("Order details cannot be null");
        }
        order.setId(nextId++);
        orders.put(order.getId(), order);
        return Response.status(Response.Status.CREATED).entity(order).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrder(@PathParam("id") int id, Order updatedOrder) {
        logger.info("PUT request to update order with ID: {}", id);
        Order existingOrder = orders.get(id);
        if (existingOrder == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found for update");
        }
        existingOrder.setCustomerId(updatedOrder.getCustomerId());
        existingOrder.setItems(updatedOrder.getItems());
        
        
        orders.put(id, existingOrder);
        return Response.ok(existingOrder).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        logger.info("DELETE request for order with ID: {}", id);
        Order removedOrder = orders.remove(id);
        if (removedOrder == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found for deletion");
        }
        return Response.noContent().build();
    }
}
