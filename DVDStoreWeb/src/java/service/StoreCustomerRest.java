/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.naming.InitialContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import services.StoreBookingFacadeLocal;
import services.StoreCustomerFacadeLocal;
import services.StoreDVDCopyFacadeLocal;
import services.StoreDvdFacadeLocal;
import services.StoreEmployeeFacadeLocal;

/**
 * REST Web Service
 *
 * @author Risina
 */
@Path("customer")
public class StoreCustomerRest {

    @Context
    private UriInfo context;
    
    private static StoreCustomerFacadeLocal storecustomerfacade;
    
    /**
     * Creates a new instance of StoreCustomerRest
     */
    public StoreCustomerRest() {
        storecustomerfacade = (StoreCustomerFacadeLocal) getEJBBean("storecustomerfacade");
    }

    /**
     * Retrieves representation of an instance of service.StoreCustomerRest
     * @param credentials
     * @return an instance of java.lang.String
     */
    @GET
    @Path("login/{credentials}")
    @Produces("application/json")
    public String authencticate(@PathParam("credentials") String credentials) {
        return storecustomerfacade.authencticate(credentials);
    }

    /**
     * PUT method for updating or creating an instance of StoreCustomerRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    public Object getEJBBean(String beanName) {
        try {
            InitialContext ctx = new InitialContext();
            return ctx.lookup(beanName);
        } catch (Exception ex) {
            System.err.println("ERROR: while locating bean from the server " + ex.getMessage());
            return null;

        }
    }
}
