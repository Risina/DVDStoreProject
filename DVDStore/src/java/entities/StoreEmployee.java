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
@Table(name = "store_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreEmployee.findAll", query = "SELECT s FROM StoreEmployee s"),
    @NamedQuery(name = "StoreEmployee.findByStoreEmployeeId", query = "SELECT s FROM StoreEmployee s WHERE s.storeEmployeeId = :storeEmployeeId"),
    @NamedQuery(name = "StoreEmployee.findByStoreEmployeeName", query = "SELECT s FROM StoreEmployee s WHERE s.storeEmployeeName = :storeEmployeeName"),
    @NamedQuery(name = "StoreEmployee.findByStoreEmployeeEmail", query = "SELECT s FROM StoreEmployee s WHERE s.storeEmployeeEmail = :storeEmployeeEmail"),
    @NamedQuery(name = "StoreEmployee.findByStoreEmployeePassword", query = "SELECT s FROM StoreEmployee s WHERE s.storeEmployeePassword = :storeEmployeePassword")})
public class StoreEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_employee_id")
    private Long storeEmployeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "store_employee_name")
    private String storeEmployeeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "store_employee_email")
    private String storeEmployeeEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "store_employee_password")
    private String storeEmployeePassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeDvdAddedEmployeeId")
    private List<StoreDvd> storeDvdList;

    public StoreEmployee() {
    }

    public StoreEmployee(Long storeEmployeeId) {
        this.storeEmployeeId = storeEmployeeId;
    }

    public StoreEmployee(Long storeEmployeeId, String storeEmployeeName, String storeEmployeeEmail, String storeEmployeePassword) {
        this.storeEmployeeId = storeEmployeeId;
        this.storeEmployeeName = storeEmployeeName;
        this.storeEmployeeEmail = storeEmployeeEmail;
        this.storeEmployeePassword = storeEmployeePassword;
    }

    public Long getStoreEmployeeId() {
        return storeEmployeeId;
    }

    public void setStoreEmployeeId(Long storeEmployeeId) {
        this.storeEmployeeId = storeEmployeeId;
    }

    public String getStoreEmployeeName() {
        return storeEmployeeName;
    }

    public void setStoreEmployeeName(String storeEmployeeName) {
        this.storeEmployeeName = storeEmployeeName;
    }

    public String getStoreEmployeeEmail() {
        return storeEmployeeEmail;
    }

    public void setStoreEmployeeEmail(String storeEmployeeEmail) {
        this.storeEmployeeEmail = storeEmployeeEmail;
    }

    public String getStoreEmployeePassword() {
        return storeEmployeePassword;
    }

    public void setStoreEmployeePassword(String storeEmployeePassword) {
        this.storeEmployeePassword = storeEmployeePassword;
    }

    @XmlTransient
    public List<StoreDvd> getStoreDvdList() {
        return storeDvdList;
    }

    public void setStoreDvdList(List<StoreDvd> storeDvdList) {
        this.storeDvdList = storeDvdList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeEmployeeId != null ? storeEmployeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreEmployee)) {
            return false;
        }
        StoreEmployee other = (StoreEmployee) object;
        if ((this.storeEmployeeId == null && other.storeEmployeeId != null) || (this.storeEmployeeId != null && !this.storeEmployeeId.equals(other.storeEmployeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StoreEmployee[ storeEmployeeId=" + storeEmployeeId + " ]";
    }
    
}
