/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.EJB;
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
import util.StoreDVDUtil;

/**
 * REST Web Service
 *
 * @author Risina
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    
//    @EJB(mappedName = "storedvdfacade")
    private StoreDvdFacadeLocal storedvdfacade;
    

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        storedvdfacade = (StoreDvdFacadeLocal)getEJBBean("storedvdfacade");
    }

    /**
     * Retrieves representation of an instance of ser.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public String getXml(@PathParam("id") long id) {
        //TODO return proper representation object
        
        return storedvdfacade.getDVDById(id).getActors();
        
//        try{
//            return storedvdfacade.getSomething();
//        }
//        catch(Exception e){
//            return e.getStackTrace().toString();
////            return "Wada kale na";
//            
//        }
        
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
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
