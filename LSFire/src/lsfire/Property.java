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
@Table(name = "property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "Property.findByIdProperty", query = "SELECT p FROM Property p WHERE p.idProperty = :idProperty"),
    @NamedQuery(name = "Property.findByOccupancyClass", query = "SELECT p FROM Property p WHERE p.occupancyClass = :occupancyClass"),
    @NamedQuery(name = "Property.findByHazardClass", query = "SELECT p FROM Property p WHERE p.hazardClass = :hazardClass"),
    @NamedQuery(name = "Property.findByDistrict", query = "SELECT p FROM Property p WHERE p.district = :district"),
    @NamedQuery(name = "Property.findByNumberPFA", query = "SELECT p FROM Property p WHERE p.numberPFA = :numberPFA"),
    @NamedQuery(name = "Property.findByFireAlarmPanel", query = "SELECT p FROM Property p WHERE p.fireAlarmPanel = :fireAlarmPanel"),
    @NamedQuery(name = "Property.findByActiveCheck", query = "SELECT p FROM Property p WHERE p.activeCheck = :activeCheck"),
    @NamedQuery(name = "Property.findBySysNormCheck", query = "SELECT p FROM Property p WHERE p.sysNormCheck = :sysNormCheck"),
    @NamedQuery(name = "Property.findByPanelLocation", query = "SELECT p FROM Property p WHERE p.panelLocation = :panelLocation"),
    @NamedQuery(name = "Property.findByPropertyAddress", query = "SELECT p FROM Property p WHERE p.propertyAddress = :propertyAddress")})
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProperty")
    private Integer idProperty;
    @Basic(optional = false)
    @Column(name = "occupancyClass")
    private String occupancyClass;
    @Basic(optional = false)
    @Column(name = "hazardClass")
    private String hazardClass;
    @Basic(optional = false)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @Column(name = "numberPFA")
    private int numberPFA;
    @Basic(optional = false)
    @Column(name = "fireAlarmPanel")
    private String fireAlarmPanel;
    @Basic(optional = false)
    @Column(name = "activeCheck")
    private String activeCheck;
    @Basic(optional = false)
    @Column(name = "sysNormCheck")
    private String sysNormCheck;
    @Basic(optional = false)
    @Column(name = "panelLocation")
    private String panelLocation;
    @Basic(optional = false)
    @Column(name = "PropertyAddress")
    private String propertyAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProperty")
    private List<Inspections> inspectionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProperty")
    private List<BusinessProperty> businessPropertyList;

    public Property() {
    }

    public Property(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public Property(Integer idProperty, String occupancyClass, String hazardClass, String district, int numberPFA, String fireAlarmPanel, String activeCheck, String sysNormCheck, String panelLocation, String propertyAddress) {
        this.idProperty = idProperty;
        this.occupancyClass = occupancyClass;
        this.hazardClass = hazardClass;
        this.district = district;
        this.numberPFA = numberPFA;
        this.fireAlarmPanel = fireAlarmPanel;
        this.activeCheck = activeCheck;
        this.sysNormCheck = sysNormCheck;
        this.panelLocation = panelLocation;
        this.propertyAddress = propertyAddress;
    }

    public Integer getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public String getOccupancyClass() {
        return occupancyClass;
    }

    public void setOccupancyClass(String occupancyClass) {
        this.occupancyClass = occupancyClass;
    }

    public String getHazardClass() {
        return hazardClass;
    }

    public void setHazardClass(String hazardClass) {
        this.hazardClass = hazardClass;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getNumberPFA() {
        return numberPFA;
    }

    public void setNumberPFA(int numberPFA) {
        this.numberPFA = numberPFA;
    }

    public String getFireAlarmPanel() {
        return fireAlarmPanel;
    }

    public void setFireAlarmPanel(String fireAlarmPanel) {
        this.fireAlarmPanel = fireAlarmPanel;
    }

    public String getActiveCheck() {
        return activeCheck;
    }

    public void setActiveCheck(String activeCheck) {
        this.activeCheck = activeCheck;
    }

    public String getSysNormCheck() {
        return sysNormCheck;
    }

    public void setSysNormCheck(String sysNormCheck) {
        this.sysNormCheck = sysNormCheck;
    }

    public String getPanelLocation() {
        return panelLocation;
    }

    public void setPanelLocation(String panelLocation) {
        this.panelLocation = panelLocation;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    @XmlTransient
    public List<Inspections> getInspectionsList() {
        return inspectionsList;
    }

    public void setInspectionsList(List<Inspections> inspectionsList) {
        this.inspectionsList = inspectionsList;
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
        hash += (idProperty != null ? idProperty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.idProperty == null && other.idProperty != null) || (this.idProperty != null && !this.idProperty.equals(other.idProperty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lsfire.Property[ idProperty=" + idProperty + " ]";
    }
    
}
