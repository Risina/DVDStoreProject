/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.naming.InitialContext;
import services.StoreBookingFacadeLocal;
import services.StoreCustomerFacadeLocal;
import services.StoreDVDCopyFacadeLocal;
import services.StoreDvdFacadeLocal;
import services.StoreEmployeeFacadeLocal;
import util.StoreBookingUtil;
import util.StoreDVDCopyUtil;
import util.StoreDVDUtil;

/**
 *
 * @author Risina
 */
public class ServiceMethods {
    
    private static StoreDvdFacadeLocal storedvdfacade;
    private static StoreEmployeeFacadeLocal storeemployeefacade;
    private static StoreDVDCopyFacadeLocal storedvdcopyfacade;
    private static StoreCustomerFacadeLocal storecustomerfacade;
    private static StoreBookingFacadeLocal storebookingfacade;
    
    boolean isWeb = false;
    
    public ServiceMethods(boolean isWeb) {
        if(isWeb) {
            
        }
        else {
            storedvdfacade = (StoreDvdFacadeLocal) getEJBBean("storedvdfacade");
            storeemployeefacade = (StoreEmployeeFacadeLocal) getEJBBean("storeemployeefacade");
            storedvdcopyfacade = (StoreDVDCopyFacadeLocal) getEJBBean("storedvdcopyfacade");
            storecustomerfacade = (StoreCustomerFacadeLocal) getEJBBean("storecustomerfacade");
            storebookingfacade = (StoreBookingFacadeLocal) getEJBBean("storebookingfacade");
        }
        
        this.isWeb = isWeb;
    }
    
    public String authenticate(String credectials, String userType) {
        
        String output;
        
        if(isWeb) {
            output = "";
        }
        else {
            if(userType == "Customer") {
                output = storecustomerfacade.authencticate(credectials);
            }
            else {
                output = storeemployeefacade.authencticate(credectials);
            }
        }
        return output;
    }
    
    public List<StoreDVDUtil> getDVDs() {
      return  storedvdfacade.getDVDs();
    }
    public String addDVD(StoreDVDUtil util) {
        
        try{
            storedvdfacade.addDVD(util);
        }
        catch(EJBException ex) {
            return ex.getMessage();
        }
        
        return "Success";
    }
    public List<StoreDVDUtil> getDVDsByTitle(String title) {
        return storedvdfacade.getDVDsByTitle(title);
    }
    public List<StoreDVDUtil> getDVDsByRating(String rating) {
        return storedvdfacade.getDVDsByRating(rating);
    }
    public List<StoreDVDUtil> getDVDsByFormat(String format) {
        return storedvdfacade.getDVDsByFormat(format);
    }
    public List<StoreDVDUtil> getDVDsByYear(String year) {
        return storedvdfacade.getDVDsByYear(year);
    }
    
    
    
    public void addCopy(StoreDVDCopyUtil dvdCopy){
        storedvdcopyfacade.addCopy(dvdCopy);
    }
    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId) {
        return storedvdfacade.getCopiedByDVDId(dvdId);
    }
    
    public String addBooking(StoreBookingUtil booking) {
        
        try{
            storebookingfacade.addBooking(booking);
        }
        catch(EJBException ex) {
            return ex.getMessage();
        }
        return "Success!";
    }
    
    
    
    
    private Object getEJBBean(String beanName) {
        try {
            InitialContext ctx = new InitialContext();
            return ctx.lookup(beanName);
        } catch (Exception ex) {
            System.err.println("ERROR: while locating bean from the server " + ex.getMessage());
            return null;

        }
    }
}
