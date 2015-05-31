/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.StoreDvd;
import entities.StoreDvdCopy;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import util.StoreDVDCopyUtil;
import util.StoreDVDUtil;
import util.UtilMethods;

/**
 *
 * @author Risina
 */
@Stateless(mappedName = "storedvdcopyfacade")
public class StoreDVDCopyFacade implements StoreDVDCopyFacadeLocal {
    
    private final EntityManager em = Persistence.createEntityManagerFactory("DVDStorePU").createEntityManager();
        
    @Override
    public void addCopy(StoreDVDCopyUtil dvdCopy) {
        StoreDvdCopy storeDvdCopy = new StoreDvdCopy();
        storeDvdCopy.setStoreDvdCopyIsle(dvdCopy.getIsle());
        storeDvdCopy.setStoreDvdCopyShelf(dvdCopy.getShelf());
        storeDvdCopy.setStoreDvdId(em.find(StoreDvd.class, dvdCopy.getDvdId().getId()));
              
        em.getTransaction().begin();
        if (!em.contains(storeDvdCopy)) {
            em.persist(storeDvdCopy);
            em.flush();
            em.refresh(storeDvdCopy);
        }
        else {
            throw new EJBException("DVD Copy already stored!");
        }
        em.getTransaction().commit();
        
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId) {
        List<StoreDvdCopy> dvds = (List<StoreDvdCopy>)em.createNamedQuery("StoreDvdCopy.findByStoreDvdId").setParameter("storeDvdId", dvdId).getResultList();
        return new UtilMethods().copyDVDCopyListToDetails(dvds);
    }
}
