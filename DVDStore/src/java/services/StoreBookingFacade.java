/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.StoreBooking;
import entities.StoreCustomer;
import entities.StoreDvdCopy;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import util.StoreBookingUtil;
import util.UtilMethods;

/**
 *
 * @author Risina
 */
@Stateless(mappedName = "storebookingfacade")
public class StoreBookingFacade implements StoreBookingFacadeLocal {
    
    private final EntityManager em = Persistence.createEntityManagerFactory("DVDStorePU").createEntityManager();
       
    @Override
    public void addBooking(StoreBookingUtil booking) {
        StoreBooking storeBooking = new StoreBooking();
        storeBooking.setStoreBookingCopyId(em.find(StoreDvdCopy.class, booking.getDvdCopyId().getId()));
        storeBooking.setStoreBookingCustomerId(em.find(StoreCustomer.class, booking.getCustomerId().getId()));
        
        boolean isBookingAvailabpe;
        isBookingAvailabpe = em.createNamedQuery("StoreBooking.findStoreBookingsByCopyId").setParameter("storeDvdCopyId", storeBooking.getStoreBookingCopyId().getStoreDvdCopyId()).getResultList().size() > 0;
        
        em.getTransaction().begin();
        if (!em.contains(storeBooking) && !isBookingAvailabpe) {
            em.persist(storeBooking);
            em.flush();
            em.refresh(storeBooking);
        }
        else {
            throw new EJBException("DVD Copy already booked!");
        }
        em.getTransaction().commit();
    }
    
    @Override
    public List<StoreBookingUtil> getBookingsByDVDId(Long dvdId){
//        List<StoreBooking> dvds = (List<StoreBooking>)em.createNamedQuery("StoreBooking.findStoreBookingByDvdId").setParameter("storeDvdId", dvdId).getResultList();
//        return uMethods.copyBookingListToDetails(dvds);
        return new ArrayList<StoreBookingUtil>();
    }
}
