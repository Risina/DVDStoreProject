/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Risina
 */
@Entity
@Table(name = "store_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreBooking.findAll", query = "SELECT s FROM StoreBooking s"),
    @NamedQuery(name = "StoreBooking.findByStoreBookingId", query = "SELECT s FROM StoreBooking s WHERE s.storeBookingId = :storeBookingId"),
//    @NamedQuery(name = "StoreBooking.findStoreBookingByDvdId", query = "SELECT s FROM StoreBooking s WHERE s.storeBookingCopyId.storeDvdId = :storeDvdId"),
//    @NamedQuery(name = "StoreBooking.findStoreBookingsByCopyId", query = "SELECT s FROM StoreBooking s WHERE s.storeBookingCopyId.storeBookingCopyId = :storeBookingCopyId")
})
public class StoreBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_booking_id")
    private Long storeBookingId;
    @JoinColumn(name = "store_booking_customer_id", referencedColumnName = "store_customer_id")
    @ManyToOne(optional = false)
    private StoreCustomer storeBookingCustomerId;
    @JoinColumn(name = "store_booking_copy_id", referencedColumnName = "store_dvd_copy_id")
    @ManyToOne(optional = false)
    private StoreDvdCopy storeBookingCopyId;

    public StoreBooking() {
    }

    public StoreBooking(Long storeBookingId) {
        this.storeBookingId = storeBookingId;
    }

    public Long getStoreBookingId() {
        return storeBookingId;
    }

    public void setStoreBookingId(Long storeBookingId) {
        this.storeBookingId = storeBookingId;
    }

    public StoreCustomer getStoreBookingCustomerId() {
        return storeBookingCustomerId;
    }

    public void setStoreBookingCustomerId(StoreCustomer storeBookingCustomerId) {
        this.storeBookingCustomerId = storeBookingCustomerId;
    }

    public StoreDvdCopy getStoreBookingCopyId() {
        return storeBookingCopyId;
    }

    public void setStoreBookingCopyId(StoreDvdCopy storeBookingCopyId) {
        this.storeBookingCopyId = storeBookingCopyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeBookingId != null ? storeBookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreBooking)) {
            return false;
        }
        StoreBooking other = (StoreBooking) object;
        if ((this.storeBookingId == null && other.storeBookingId != null) || (this.storeBookingId != null && !this.storeBookingId.equals(other.storeBookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StoreBooking[ storeBookingId=" + storeBookingId + " ]";
    }
    
}
