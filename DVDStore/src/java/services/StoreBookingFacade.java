/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.StoreBooking;
import entities.StoreDvdCopy;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import util.StoreBookingUtil;
import util.UtilMethods;

/**
 *
 * @author Risina
 */
@Stateless
public class StoreBookingFacade implements StoreBookingFacadeLocal {
    
    private final EntityManager em = Persistence.createEntityManagerFactory("DVDStorePU").createEntityManager();
    private final UtilMethods uMethods = new UtilMethods();
    
    public List<StoreBookingUtil> getBookingsByDVDId(Long dvdId){
//        List<StoreBooking> dvds = (List<StoreBooking>)em.createNamedQuery("StoreBooking.findStoreBookingByDvdId").setParameter("storeDvdId", dvdId).getResultList();
//        return uMethods.copyBookingListToDetails(dvds);
        return new ArrayList<StoreBookingUtil>();
    }
}
