/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.StoreEmployee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Risina
 */
@Stateless(mappedName = "storeemployeefacade")
public class StoreEmployeeFacade implements StoreEmployeeFacadeLocal {

    private final EntityManager em = Persistence.createEntityManagerFactory("DVDStorePU").createEntityManager();
    private static final String STATUS_Error = "error";
    
    @Override
    public String authencticate(String credentials) {
        String userId = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        
        StoreEmployee emp = (StoreEmployee)em.createNamedQuery("StoreEmployee.findByStoreEmployeeId").setParameter("storeEmployeeId", Long.parseLong(userId)).getSingleResult();
        if(emp.getStoreEmployeePassword().equals(password)) {
            return userId;
        }
        else {
            return STATUS_Error;
        }
    }
}
