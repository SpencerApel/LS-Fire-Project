/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsfire;

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
 * @author nhhopper1226
 */
@Entity
@Table(name = "business_property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessProperty.findAll", query = "SELECT b FROM BusinessProperty b"),
    @NamedQuery(name = "BusinessProperty.findByIdBusinessProperty", query = "SELECT b FROM BusinessProperty b WHERE b.idBusinessProperty = :idBusinessProperty")})
public class BusinessProperty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBusiness_Property")
    private Integer idBusinessProperty;
    @JoinColumn(name = "idBusiness", referencedColumnName = "idBusiness")
    @ManyToOne(optional = false)
    private Business idBusiness;
    @JoinColumn(name = "idProperty", referencedColumnName = "idProperty")
    @ManyToOne(optional = false)
    private Property idProperty;

    public BusinessProperty() {
    }

    public BusinessProperty(Integer idBusinessProperty) {
        this.idBusinessProperty = idBusinessProperty;
    }

    public Integer getIdBusinessProperty() {
        return idBusinessProperty;
    }

    public void setIdBusinessProperty(Integer idBusinessProperty) {
        this.idBusinessProperty = idBusinessProperty;
    }

    public Business getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Business idBusiness) {
        this.idBusiness = idBusiness;
    }

    public Property getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Property idProperty) {
        this.idProperty = idProperty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBusinessProperty != null ? idBusinessProperty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessProperty)) {
            return false;
        }
        BusinessProperty other = (BusinessProperty) object;
        if ((this.idBusinessProperty == null && other.idBusinessProperty != null) || (this.idBusinessProperty != null && !this.idBusinessProperty.equals(other.idBusinessProperty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lsfire.BusinessProperty[ idBusinessProperty=" + idBusinessProperty + " ]";
    }
    
}
