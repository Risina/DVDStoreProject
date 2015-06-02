/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import services.StoreDvdFacadeLocal;
import util.*;

/**
 * REST Web Service
 *
 * @author Risina
 */
@Path("dvd")
public class StoreDvdRest {

    @Context
    private UriInfo context;
    
    private StoreDvdFacadeLocal storedvdfacade;

    /**
     * Creates a new instance of StoreDvdRest
     */
    public StoreDvdRest() {
        storedvdfacade = (StoreDvdFacadeLocal)getEJBBean("storedvdfacade");
    }

    /**
     * Retrieves representation of an instance of service.StoreDvdRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getDvds() {
        return new Gson().toJson(storedvdfacade.getDVDs());
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String postDvds(String dvd) {
        String success = "";
        try{
            storedvdfacade.addDVD(new Gson().fromJson(dvd, StoreDVDUtil.class));
            success = "Success";
        }
        catch(EJBException e){
            success = e.getMessage();
        }

        return success;
    }

    @GET
    @Path("title/{value}")
    @Produces("application/json")
    public String getDVDsByTitle(@PathParam("value") String value) {
        return new Gson().toJson(storedvdfacade.getDVDsByTitle(value));
    }
    
    @GET
    @Path("rating/{value}")
    @Produces("application/json")
    public String getDVDsByRating(@PathParam("value") String value) {
        return new Gson().toJson(storedvdfacade.getDVDsByRating(value));
    }
    
    @GET
    @Path("year/{value}")
    @Produces("application/json")
    public String getDVDsByYear(@PathParam("value") String value) {
        return new Gson().toJson(storedvdfacade.getDVDsByYear(value));
    }
    
    @GET
    @Path("format/{value}")
    @Produces("application/json")
    public String getDVDsByFormat(@PathParam("value") String value) {
        return new Gson().toJson(storedvdfacade.getDVDsByFormat(value));
    }
    
    @GET
    @Path("copy/{id}")
    @Produces("application/json")
    public String getCopiedByDVDId(@PathParam("id") Long value) {
        return new Gson().toJson(storedvdfacade.getCopiedByDVDId(value));
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
