/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.StoreCustomer;
import entities.StoreEmployee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Risina
 */
@Stateless(mappedName = "storecustomerfacade")
public class StoreCustomerFacade implements StoreCustomerFacadeLocal {
    
    private final EntityManager em = Persistence.createEntityManagerFactory("DVDStorePU").createEntityManager();
    
    private static final String STATUS_Error = "error";
    
    @Override
    public String authencticate(String credentials) {
        String userId = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        
        StoreCustomer emp = (StoreCustomer)em.createNamedQuery("StoreCustomer.findByStoreCustomerId").setParameter("storeCustomerId", Long.parseLong(userId)).getSingleResult();
        if(emp.getStoreCustomerPassword().equals(password)) {
            return userId;
        }
        else {
            return STATUS_Error;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
