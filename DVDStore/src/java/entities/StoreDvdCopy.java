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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Risina
 */
@Entity
@Table(name = "store_dvd_copy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreDvdCopy.findAll", query = "SELECT s FROM StoreDvdCopy s"),
    @NamedQuery(name = "StoreDvdCopy.findByStoreDvdCopyId", query = "SELECT s FROM StoreDvdCopy s WHERE s.storeDvdCopyId = :storeDvdCopyId"),
    @NamedQuery(name = "StoreDvdCopy.findByStoreDvdId", query = "SELECT s FROM StoreDvdCopy s WHERE s.storeDvdId.storeDvdId = :storeDvdId"),
    @NamedQuery(name = "StoreDvdCopy.findByStoreDvdCopyIsle", query = "SELECT s FROM StoreDvdCopy s WHERE s.storeDvdCopyIsle = :storeDvdCopyIsle"),
    @NamedQuery(name = "StoreDvdCopy.findByStoreDvdCopyShelf", query = "SELECT s FROM StoreDvdCopy s WHERE s.storeDvdCopyShelf = :storeDvdCopyShelf")})
public class StoreDvdCopy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_dvd_copy_id")
    private Long storeDvdCopyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_dvd_copy_isle")
    private int storeDvdCopyIsle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_dvd_copy_shelf")
    private int storeDvdCopyShelf;
    @JoinColumn(name = "store_dvd_id", referencedColumnName = "store_dvd_id")
    @ManyToOne(optional = false)
    private StoreDvd storeDvdId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeBookingCopyId")
    private List<StoreBooking> storeBookingList;

    public StoreDvdCopy() {
    }

    public StoreDvdCopy(Long storeDvdCopyId) {
        this.storeDvdCopyId = storeDvdCopyId;
    }

    public StoreDvdCopy(Long storeDvdCopyId, int storeDvdCopyIsle, int storeDvdCopyShelf) {
        this.storeDvdCopyId = storeDvdCopyId;
        this.storeDvdCopyIsle = storeDvdCopyIsle;
        this.storeDvdCopyShelf = storeDvdCopyShelf;
    }

    public Long getStoreDvdCopyId() {
        return storeDvdCopyId;
    }

    public void setStoreDvdCopyId(Long storeDvdCopyId) {
        this.storeDvdCopyId = storeDvdCopyId;
    }

    public int getStoreDvdCopyIsle() {
        return storeDvdCopyIsle;
    }

    public void setStoreDvdCopyIsle(int storeDvdCopyIsle) {
        this.storeDvdCopyIsle = storeDvdCopyIsle;
    }

    public int getStoreDvdCopyShelf() {
        return storeDvdCopyShelf;
    }

    public void setStoreDvdCopyShelf(int storeDvdCopyShelf) {
        this.storeDvdCopyShelf = storeDvdCopyShelf;
    }

    public StoreDvd getStoreDvdId() {
        return storeDvdId;
    }

    public void setStoreDvdId(StoreDvd storeDvdId) {
        this.storeDvdId = storeDvdId;
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
        hash += (storeDvdCopyId != null ? storeDvdCopyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreDvdCopy)) {
            return false;
        }
        StoreDvdCopy other = (StoreDvdCopy) object;
        if ((this.storeDvdCopyId == null && other.storeDvdCopyId != null) || (this.storeDvdCopyId != null && !this.storeDvdCopyId.equals(other.storeDvdCopyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StoreDvdCopy[ storeDvdCopyId=" + storeDvdCopyId + " ]";
    }
    
}
