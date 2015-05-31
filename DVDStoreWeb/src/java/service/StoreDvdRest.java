/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import util.StoreDVDUtil;
import java.util.List;
import javax.naming.InitialContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import services.StoreDvdFacadeLocal;

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

    /**
     * PUT method for updating or creating an instance of StoreDvdRest
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
