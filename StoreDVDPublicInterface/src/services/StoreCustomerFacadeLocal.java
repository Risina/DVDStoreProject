/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Remote;

/**
 *
 * @author Risina
 */
@Remote
public interface StoreCustomerFacadeLocal {
    public String authencticate(String credentials);
}
