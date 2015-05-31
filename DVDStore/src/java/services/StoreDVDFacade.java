/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.StoreDvd;
import entities.StoreDvdCopy;
import entities.StoreEmployee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import util.*;

/**
 *
 * @author Risina
 */
@Stateless(mappedName = "storedvdfacade")
public class StoreDVDFacade implements StoreDvdFacadeLocal{

    private final EntityManager em = Persistence.createEntityManagerFactory("DVDStorePU").createEntityManager();
    
    public void addDVD(StoreDVDUtil dvd) {
        dvd.setAddedDate(new Date());
        dvd.setModifiedDate(new Date());
        StoreDvd storeDvd = new StoreDvd(dvd.getTitle(), 
                dvd.getReleasedYear(), 
                dvd.getActors(), 
                dvd.getRating(), 
                dvd.getFormat(), 
                dvd.getAddedDate(), 
                dvd.getModifiedDate(), 
                em.find(StoreEmployee.class, dvd.getAddedEmployeeId()));
       
        
        em.getTransaction().begin();
        boolean doesExist =  em.createNamedQuery("StoreDvd.findByStoreDvdTitle").setParameter("storeDvdTitle", dvd.getTitle()).getResultList().size() > 0;
        if (!em.contains(storeDvd) && !doesExist) {
            em.persist(storeDvd);
            em.flush();
            em.refresh(storeDvd);
        }
        else {
            throw new EJBException("DVD already stored!");
        }
        em.getTransaction().commit();
    }
    
    @Override
    public StoreDVDUtil getDVDById(long id) {
        StoreDvd d = em.find(StoreDvd.class, id);
        return new UtilMethods().copyToDetails(em.find(StoreDvd.class, id));
    }
    
    @Override
    public List<StoreDVDUtil> getDVDs() {//StoreDvd.findAll
        List<StoreDvd> dvds = (List<StoreDvd>)em.createNamedQuery("StoreDvd.findAll").getResultList();
        return new UtilMethods().copyListToDetails(dvds);
    }
    
    @Override
    public List<StoreDVDUtil> getDVDsByTitle(String title) {
        List<StoreDvd> dvds = (List<StoreDvd>)em.createNamedQuery("StoreDvd.findByStoreDvdTitle").setParameter("storeDvdTitle", title).getResultList();
        return new UtilMethods().copyListToDetails(dvds);
    }
    
    @Override
    public List<StoreDVDUtil> getDVDsByRating(String rating) {
        List<StoreDvd> dvds = (List<StoreDvd>)em.createNamedQuery("StoreDvd.findByStoreDvdRating").setParameter("storeDvdRating", rating).getResultList();
        return new UtilMethods().copyListToDetails(dvds);
    }
    
    @Override
    public List<StoreDVDUtil> getDVDsByYear(String year) {
        List<StoreDvd> dvds = (List<StoreDvd>)em.createNamedQuery("StoreDvd.findByStoredvdreleasedYear").setParameter("storedvdreleasedYear", year).getResultList();
        return new UtilMethods().copyListToDetails(dvds);
    }
    
    @Override
    public List<StoreDVDUtil> getDVDsByFormat(String format) {
        List<StoreDvd> dvds = (List<StoreDvd>)em.createNamedQuery("StoreDvd.findByStoreDvdFormat").setParameter("storeDvdFormat", format).getResultList();
        return new UtilMethods().copyListToDetails(dvds);
    }
    
    @Override
    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId) {
        StoreDvd dvd = em.find(StoreDvd.class, dvdId);
        return new UtilMethods().copyDVDCopyListToDetails(dvd.getStoreDvdCopyList());
    }
    
    @Override
    public String getSomething(){
        return "Something";
    }

    /**
     * Web service operation
     */
    public String operation() {
        //TODO write your implementation code here:
        return null;
    }
}
