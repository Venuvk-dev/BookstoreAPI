/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.resources;

import com.bookstore.exception.CustomerNotFoundException;
import com.bookstore.exception.InvalidInputException;
import com.bookstore.model.Customer;
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

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static int nextId = 3;

    static {
        customers.put(1, new Customer(1, "Venukanth", "rvenukanth5@gmail.com", "pass123"));
        customers.put(2, new Customer(2, "Kithuskanth", "kithus3457@gmail.com", "pass456"));
    }

    @GET
    public Response getAllCustomers() {
        logger.info("Getting all customers");
        return Response.ok(customers.values()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") int id) {
        logger.info("Getting customer by id: " + id);
        Customer customer = customers.get(id);
        if (customer != null) {
            return Response.ok(customer).build();
        } else {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
    }

    @POST
    public Response addCustomer(Customer customer) {
        logger.info("POST request to add a new customer");
        if (customer.getName() == null || customer.getEmail() == null || customer.getPassword() == null) {
            throw new InvalidInputException("Name, Email, and Password are required");
        }

        customer.setId(nextId++);
        customers.put(customer.getId(), customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") int id, Customer updatedCustomer) {
        logger.info("PUT request to update customer with id: " + id);
        Customer existingCustomer = customers.get(id);
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found for update");
        }

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPassword(updatedCustomer.getPassword());

        customers.put(id, existingCustomer);
        return Response.ok(existingCustomer).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        logger.info("DELETE request for customer with id: " + id);
        Customer removedCustomer = customers.remove(id);
        if (removedCustomer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found for deletion");
        }
        return Response.noContent().build();
    }
}
