/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.StoreBooking;
import entities.StoreCustomer;
import entities.StoreDvd;
import entities.StoreDvdCopy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Risina
 */
public class UtilMethods {
    
    public StoreCustomerUtil copyCustomerToDetails(StoreCustomer customer) {
        StoreCustomerUtil util = new StoreCustomerUtil(
                customer.getStoreCustomerId(), 
                customer.getStoreCustomerName(), 
                customer.getStoreCustomerEmail());
        
        return util;
    }
    
    public StoreCustomerUtil copyEmployeeToDetails(StoreEmployee emp) {
        StoreCustomerUtil util = new StoreCustomerUtil(
                emp.getId(), 
                emp.getName(), 
                emp.getEmail());
        
        return util;
    }
    
    public StoreBookingUtil copyBookingToDetails(StoreBooking booking) {
        StoreBookingUtil util = new StoreBookingUtil(
                booking.getStoreBookingId(), 
                copyCustomerToDetails(booking.getStoreBookingCustomerId()),
                copyToCopyDetails(booking.getStoreBookingCopyId()));
        
        return util;
    }
    
    public StoreDVDCopyUtil copyToCopyDetails(StoreDvdCopy dvdCopy) {
        StoreDVDCopyUtil util = new StoreDVDCopyUtil(dvdCopy.getStoreDvdCopyId(), copyToDetails(dvdCopy.getStoreDvdId()), dvdCopy.getStoreDvdCopyShelf(), dvdCopy.getStoreDvdCopyIsle());
        return util;
    }
    
    public List<StoreDVDCopyUtil> copyDVDCopyListToDetails(List <StoreDvdCopy> dvdList) {
        
        List<StoreDVDCopyUtil> list = new ArrayList<>();
        for(StoreDvdCopy dvd: dvdList) {
            StoreDVDCopyUtil util = copyToCopyDetails(dvd);
            list.add(util);
        }
        
        return list;
    }
    
    public List<StoreBookingUtil> copyBookingListToDetails(List <StoreBooking> dvdList) {
        
        List<StoreBookingUtil> list = new ArrayList<>();
        for(StoreBooking dvd: dvdList) {
            StoreBookingUtil util = copyBookingToDetails(dvd);
            list.add(util);
        }
        
        return list;
    }
   
    public StoreDVDUtil copyToDetails(StoreDvd dvd) {
        StoreDVDUtil util = new StoreDVDUtil(dvd.getStoreDvdId(), dvd.getStoreDvdTitle(), dvd.getStoredvdreleasedYear(), dvd.getStoreDvdActors(), dvd.getStoreDvdRating(), dvd.getStoreDvdFormat());
        return util;
    }
    
    public List<StoreDVDUtil> copyListToDetails(List <StoreDvd> dvdList) {
        
        List<StoreDVDUtil> list = new ArrayList<>();
        for(StoreDvd dvd: dvdList) {
            StoreDVDUtil util = copyToDetails(dvd);
            list.add(util);
        }
        
        return list;
    }
}
