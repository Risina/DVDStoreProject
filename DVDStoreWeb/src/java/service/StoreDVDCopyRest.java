/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
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
import util.StoreDVDCopyUtil;

/**
 * REST Web Service
 *
 * @author Risina
 */
@Path("copy")
public class StoreDVDCopyRest {

    @Context
    private UriInfo context;
    
    private static StoreDVDCopyFacadeLocal storedvdcopyfacade;
    
    /**
     * Creates a new instance of StoreDVDCopyRest
     */
    public StoreDVDCopyRest() {
        storedvdcopyfacade = (StoreDVDCopyFacadeLocal) getEJBBean("storedvdcopyfacade");
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public void addCopy(String copy) {
        storedvdcopyfacade.addCopy(new Gson().fromJson(copy, StoreDVDCopyUtil.class));
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getCopiedByDVDId(@PathParam("id") Long value) {
        return new Gson().toJson(storedvdcopyfacade.getCopiedByDVDId(value));
    }

    /**
     * Retrieves representation of an instance of service.StoreDVDCopyRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    

    /**
     * PUT method for updating or creating an instance of StoreDVDCopyRest
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
