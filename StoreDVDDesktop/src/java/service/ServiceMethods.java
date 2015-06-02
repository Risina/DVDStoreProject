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

    private boolean isWeb = false;

    public boolean isIsWeb() {
        return isWeb;
    }

    public void setIsWeb(boolean isWeb) {
        this.isWeb = isWeb;
    }

    public ServiceMethods(boolean isWeb) {
        if (isWeb) {

        } else {
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

            if (userType == "Customer") {
                
                if(isWeb) {
                    output =new RestClient().authenticateCustomer(credectials);
                }
                else {
                    output = storecustomerfacade.authencticate(credectials);
                }
                
            } else {
                if(isWeb) {
                    output =new RestClient().authenticateEmployee(credectials);
                }else {
                    output = storeemployeefacade.authencticate(credectials);
                }
               
            }
        
        return output;
    }

    public List<StoreDVDUtil> getDVDs() {
        if (isWeb) {
            return new RestClient().getDVDs();
        } else {
            return storedvdfacade.getDVDs();
        }

    }

    public String addDVD(StoreDVDUtil util) {
        
        String message = "";
        try {
            if (isWeb) {
                message = new RestClient().addDVD(util);
            } else {
                storedvdfacade.addDVD(util);
            }
            
        } catch (EJBException ex) {
            return ex.getMessage();
        } 

        return message;
    }

    public List<StoreDVDUtil> getDVDsByTitle(String title) {
        
        if(isWeb) {
            return new RestClient().getDVDsByTitle(title);
        }
        else {
            return storedvdfacade.getDVDsByTitle(title);
        }
        
    }

    public List<StoreDVDUtil> getDVDsByRating(String rating) {
        
        if(isWeb) {
            return new RestClient().getDVDsByRating(rating);
        }
        else {
            return storedvdfacade.getDVDsByRating(rating);
        }
        
    }

    public List<StoreDVDUtil> getDVDsByFormat(String format) {
        
        if(isWeb) {
            return new RestClient().getDVDsByFormat(format);
        }
        else {
            return storedvdfacade.getDVDsByFormat(format);
        }
        
    }

    public List<StoreDVDUtil> getDVDsByYear(String year) {
        
        if(isWeb) {
            return new RestClient().getDVDsByYear(year);
        }
        else {
            return storedvdfacade.getDVDsByYear(year);
        }
    
    }

    public void addCopy(StoreDVDCopyUtil dvdCopy) {
        
        if(isWeb) {
            new RestClient().addCopy(dvdCopy);
        }
        else {
            storedvdcopyfacade.addCopy(dvdCopy);
        }
    }

    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId) {
        
        if(isWeb) {
            return new RestClient().getCopiedByDVDId(dvdId);
        }
        else {
            return storedvdfacade.getCopiedByDVDId(dvdId);
        }
        
    }

    public String addBooking(StoreBookingUtil booking) {

        try {
            if(isWeb) {
                return new RestClient().addBooking(booking);
            }
            else {
                storebookingfacade.addBooking(booking);
            } 
        } catch (EJBException ex) {
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
