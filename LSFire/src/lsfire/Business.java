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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "business")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b"),
    @NamedQuery(name = "Business.findByIdBusiness", query = "SELECT b FROM Business b WHERE b.idBusiness = :idBusiness"),
    @NamedQuery(name = "Business.findByName", query = "SELECT b FROM Business b WHERE b.name = :name"),
    @NamedQuery(name = "Business.findByPhone", query = "SELECT b FROM Business b WHERE b.phone = :phone")})
public class Business implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBusiness")
    private Integer idBusiness;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "phone")
    private int phone;
    @JoinColumn(name = "idECI", referencedColumnName = "idEmergency_Contact_Info")
    @ManyToOne(optional = false)
    private EmergencyContactInfo idECI;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBusiness")
    private List<BusinessProperty> businessPropertyList;

    public Business() {
    }

    public Business(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public Business(Integer idBusiness, String name, int phone) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.phone = phone;
    }

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public EmergencyContactInfo getIdECI() {
        return idECI;
    }

    public void setIdECI(EmergencyContactInfo idECI) {
        this.idECI = idECI;
    }

    @XmlTransient
    public List<BusinessProperty> getBusinessPropertyList() {
        return businessPropertyList;
    }

    public void setBusinessPropertyList(List<BusinessProperty> businessPropertyList) {
        this.businessPropertyList = businessPropertyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBusiness != null ? idBusiness.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.idBusiness == null && other.idBusiness != null) || (this.idBusiness != null && !this.idBusiness.equals(other.idBusiness))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lsfire.Business[ idBusiness=" + idBusiness + " ]";
    }
    
}
