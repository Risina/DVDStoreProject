/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import services.StoreBookingFacadeLocal;
import services.StoreCustomerFacadeLocal;
import services.StoreDVDCopyFacadeLocal;
import services.StoreDvdFacadeLocal;
import services.StoreEmployeeFacadeLocal;
import util.StoreBookingUtil;

/**
 * REST Web Service
 *
 * @author Risina
 */
@Path("booking")
public class StoreBookingRest {

    @Context
    private UriInfo context;
    
    private static StoreBookingFacadeLocal storebookingfacade;
    /**
     * Creates a new instance of StoreBookingRest
     */
    public StoreBookingRest() {
        storebookingfacade = (StoreBookingFacadeLocal) getEJBBean("storebookingfacade");
    }
    
    @GET
    @Path("{dvdId}")
    @Produces("application/json")
    public String getBookingsByDVDId(@PathParam("dvdId")Long id) {
        return new Gson().toJson(storebookingfacade.getBookingsByDVDId(id));
    }
    
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String addBooking(String dvd) {
        String success = "";
        try{
            storebookingfacade.addBooking(new Gson().fromJson(dvd, StoreBookingUtil.class));
            success = "Success";
        }
        catch(EJBException e){
            success = e.getMessage();
        }

        return success;
    }

    /**
     * Retrieves representation of an instance of service.StoreBookingRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of StoreBookingRest
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
