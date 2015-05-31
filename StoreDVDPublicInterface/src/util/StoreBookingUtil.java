/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Risina
 */
public class StoreBookingUtil implements Serializable{
    private Long id;
    private StoreCustomerUtil customerId;
    private StoreDVDCopyUtil dvdCopyId;

    public StoreBookingUtil(Long id, StoreCustomerUtil customerId, StoreDVDCopyUtil dvdCopyId) {
        this.id = id;
        this.customerId = customerId;
        this.dvdCopyId = dvdCopyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreCustomerUtil getCustomerId() {
        return customerId;
    }

    public void setCustomerId(StoreCustomerUtil customerId) {
        this.customerId = customerId;
    }

    public StoreDVDCopyUtil getDvdCopyId() {
        return dvdCopyId;
    }

    public void setDvdCopyId(StoreDVDCopyUtil dvdCopyId) {
        this.dvdCopyId = dvdCopyId;
    }
}
