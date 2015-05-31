/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Risina
 */
@Entity
@Table(name = "store_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreCustomer.findAll", query = "SELECT s FROM StoreCustomer s"),
    @NamedQuery(name = "StoreCustomer.findByStoreCustomerId", query = "SELECT s FROM StoreCustomer s WHERE s.storeCustomerId = :storeCustomerId"),
    @NamedQuery(name = "StoreCustomer.findByStoreCustomerName", query = "SELECT s FROM StoreCustomer s WHERE s.storeCustomerName = :storeCustomerName"),
    @NamedQuery(name = "StoreCustomer.findByStoreCustomerEmail", query = "SELECT s FROM StoreCustomer s WHERE s.storeCustomerEmail = :storeCustomerEmail"),
    @NamedQuery(name = "StoreCustomer.findByStoreCustomerPassword", query = "SELECT s FROM StoreCustomer s WHERE s.storeCustomerPassword = :storeCustomerPassword")})
public class StoreCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_customer_id")
    private Long storeCustomerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "store_customer_name")
    private String storeCustomerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "store_customer_email")
    private String storeCustomerEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "store_customer_password")
    private String storeCustomerPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeBookingCustomerId")
    private List<StoreBooking> storeBookingList;

    public StoreCustomer() {
    }

    public StoreCustomer(Long storeCustomerId) {
        this.storeCustomerId = storeCustomerId;
    }

    public StoreCustomer(Long storeCustomerId, String storeCustomerName, String storeCustomerEmail, String storeCustomerPassword) {
        this.storeCustomerId = storeCustomerId;
        this.storeCustomerName = storeCustomerName;
        this.storeCustomerEmail = storeCustomerEmail;
        this.storeCustomerPassword = storeCustomerPassword;
    }

    public Long getStoreCustomerId() {
        return storeCustomerId;
    }

    public void setStoreCustomerId(Long storeCustomerId) {
        this.storeCustomerId = storeCustomerId;
    }

    public String getStoreCustomerName() {
        return storeCustomerName;
    }

    public void setStoreCustomerName(String storeCustomerName) {
        this.storeCustomerName = storeCustomerName;
    }

    public String getStoreCustomerEmail() {
        return storeCustomerEmail;
    }

    public void setStoreCustomerEmail(String storeCustomerEmail) {
        this.storeCustomerEmail = storeCustomerEmail;
    }

    public String getStoreCustomerPassword() {
        return storeCustomerPassword;
    }

    public void setStoreCustomerPassword(String storeCustomerPassword) {
        this.storeCustomerPassword = storeCustomerPassword;
    }

    @XmlTransient
    public List<StoreBooking> getStoreBookingList() {
        return storeBookingList;
    }

    public void setStoreBookingList(List<StoreBooking> storeBookingList) {
        this.storeBookingList = storeBookingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeCustomerId != null ? storeCustomerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreCustomer)) {
            return false;
        }
        StoreCustomer other = (StoreCustomer) object;
        if ((this.storeCustomerId == null && other.storeCustomerId != null) || (this.storeCustomerId != null && !this.storeCustomerId.equals(other.storeCustomerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StoreCustomer[ storeCustomerId=" + storeCustomerId + " ]";
    }
    
}
