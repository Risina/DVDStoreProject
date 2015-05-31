/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Remote;
import util.StoreBookingUtil;

/**
 *
 * @author Risina
 */
@Remote
public interface StoreBookingFacadeLocal {

    public List<StoreBookingUtil> getBookingsByDVDId(Long id);
    public void addBooking(StoreBookingUtil booking);    
}
