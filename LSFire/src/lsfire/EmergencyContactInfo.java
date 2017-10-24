/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsfire;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhhopper1226
 */
@Entity
@Table(name = "emergency_contact_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmergencyContactInfo.findAll", query = "SELECT e FROM EmergencyContactInfo e"),
    @NamedQuery(name = "EmergencyContactInfo.findByIdEmergencyContactInfo", query = "SELECT e FROM EmergencyContactInfo e WHERE e.idEmergencyContactInfo = :idEmergencyContactInfo"),
    @NamedQuery(name = "EmergencyContactInfo.findByECIname", query = "SELECT e FROM EmergencyContactInfo e WHERE e.eCIname = :eCIname"),
    @NamedQuery(name = "EmergencyContactInfo.findByECIcontact", query = "SELECT e FROM EmergencyContactInfo e WHERE e.eCIcontact = :eCIcontact"),
    @NamedQuery(name = "EmergencyContactInfo.findByECINumber", query = "SELECT e FROM EmergencyContactInfo e WHERE e.eCINumber = :eCINumber")})
public class EmergencyContactInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmergency_Contact_Info")
    private Integer idEmergencyContactInfo;
    @Basic(optional = false)
    @Column(name = "ECI_name")
    private String eCIname;
    @Basic(optional = false)
    @Column(name = "ECI_contact")
    private String eCIcontact;
    @Basic(optional = false)
    @Column(name = "ECI_Number")
    private long eCINumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idECI")
    private List<Business> businessList;

    public EmergencyContactInfo() {
    }

    public EmergencyContactInfo(Integer idEmergencyContactInfo) {
        this.idEmergencyContactInfo = idEmergencyContactInfo;
    }

    public EmergencyContactInfo(Integer idEmergencyContactInfo, String eCIname, String eCIcontact, long eCINumber) {
        this.idEmergencyContactInfo = idEmergencyContactInfo;
        this.eCIname = eCIname;
        this.eCIcontact = eCIcontact;
        this.eCINumber = eCINumber;
    }

    public Integer getIdEmergencyContactInfo() {
        return idEmergencyContactInfo;
    }

    public void setIdEmergencyContactInfo(Integer idEmergencyContactInfo) {
        this.idEmergencyContactInfo = idEmergencyContactInfo;
    }

    public String getECIname() {
        return eCIname;
    }

    public void setECIname(String eCIname) {
        this.eCIname = eCIname;
    }

    public String getECIcontact() {
        return eCIcontact;
    }

    public void setECIcontact(String eCIcontact) {
        this.eCIcontact = eCIcontact;
    }

    public long getECINumber() {
        return eCINumber;
    }

    public void setECINumber(long eCINumber) {
        this.eCINumber = eCINumber;
    }

    @XmlTransient
    public List<Business> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<Business> businessList) {
        this.businessList = businessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmergencyContactInfo != null ? idEmergencyContactInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmergencyContactInfo)) {
            return false;
        }
        EmergencyContactInfo other = (EmergencyContactInfo) object;
        if ((this.idEmergencyContactInfo == null && other.idEmergencyContactInfo != null) || (this.idEmergencyContactInfo != null && !this.idEmergencyContactInfo.equals(other.idEmergencyContactInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lsfire.EmergencyContactInfo[ idEmergencyContactInfo=" + idEmergencyContactInfo + " ]";
    }
    
}
