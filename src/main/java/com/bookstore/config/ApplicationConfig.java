/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.config;

/**
 *
 * @author USER
 */
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api") // base URL path for all your resources
public class ApplicationConfig extends Application {   //Tells JAX-RS that this is the startup config.
   //No need to override anything for this coursework.
}