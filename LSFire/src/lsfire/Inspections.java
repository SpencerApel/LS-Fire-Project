/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsfire;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhhopper1226
 */
@Entity
@Table(name = "inspections")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspections.findAll", query = "SELECT i FROM Inspections i"),
    @NamedQuery(name = "Inspections.findByIdInspections", query = "SELECT i FROM Inspections i WHERE i.idInspections = :idInspections"),
    @NamedQuery(name = "Inspections.findByInspectionDate", query = "SELECT i FROM Inspections i WHERE i.inspectionDate = :inspectionDate"),
    @NamedQuery(name = "Inspections.findByEDObst", query = "SELECT i FROM Inspections i WHERE i.eDObst = :eDObst"),
    @NamedQuery(name = "Inspections.findByEDLock", query = "SELECT i FROM Inspections i WHERE i.eDLock = :eDLock"),
    @NamedQuery(name = "Inspections.findByEDIllum", query = "SELECT i FROM Inspections i WHERE i.eDIllum = :eDIllum"),
    @NamedQuery(name = "Inspections.findByESWork", query = "SELECT i FROM Inspections i WHERE i.eSWork = :eSWork"),
    @NamedQuery(name = "Inspections.findByFDUnapp", query = "SELECT i FROM Inspections i WHERE i.fDUnapp = :fDUnapp"),
    @NamedQuery(name = "Inspections.findByFDClear", query = "SELECT i FROM Inspections i WHERE i.fDClear = :fDClear"),
    @NamedQuery(name = "Inspections.findByFEMin", query = "SELECT i FROM Inspections i WHERE i.fEMin = :fEMin"),
    @NamedQuery(name = "Inspections.findByFEMax", query = "SELECT i FROM Inspections i WHERE i.fEMax = :fEMax"),
    @NamedQuery(name = "Inspections.findByFEAnnual", query = "SELECT i FROM Inspections i WHERE i.fEAnnual = :fEAnnual"),
    @NamedQuery(name = "Inspections.findByFEAccess", query = "SELECT i FROM Inspections i WHERE i.fEAccess = :fEAccess"),
    @NamedQuery(name = "Inspections.findByElExt", query = "SELECT i FROM Inspections i WHERE i.elExt = :elExt"),
    @NamedQuery(name = "Inspections.findByElMulti", query = "SELECT i FROM Inspections i WHERE i.elMulti = :elMulti"),
    @NamedQuery(name = "Inspections.findByElBoxSw", query = "SELECT i FROM Inspections i WHERE i.elBoxSw = :elBoxSw"),
    @NamedQuery(name = "Inspections.findByElElPa", query = "SELECT i FROM Inspections i WHERE i.elElPa = :elElPa"),
    @NamedQuery(name = "Inspections.findByEl36Clear", query = "SELECT i FROM Inspections i WHERE i.el36Clear = :el36Clear"),
    @NamedQuery(name = "Inspections.findByStHouse", query = "SELECT i FROM Inspections i WHERE i.stHouse = :stHouse"),
    @NamedQuery(name = "Inspections.findBySt24BC", query = "SELECT i FROM Inspections i WHERE i.st24BC = :st24BC"),
    @NamedQuery(name = "Inspections.findBySt18BS", query = "SELECT i FROM Inspections i WHERE i.st18BS = :st18BS"),
    @NamedQuery(name = "Inspections.findByStStair", query = "SELECT i FROM Inspections i WHERE i.stStair = :stStair"),
    @NamedQuery(name = "Inspections.findByStIgnit", query = "SELECT i FROM Inspections i WHERE i.stIgnit = :stIgnit"),
    @NamedQuery(name = "Inspections.findByFc704", query = "SELECT i FROM Inspections i WHERE i.fc704 = :fc704"),
    @NamedQuery(name = "Inspections.findByFcMsds", query = "SELECT i FROM Inspections i WHERE i.fcMsds = :fcMsds"),
    @NamedQuery(name = "Inspections.findByFCSmoke", query = "SELECT i FROM Inspections i WHERE i.fCSmoke = :fCSmoke"),
    @NamedQuery(name = "Inspections.findByCGSecured", query = "SELECT i FROM Inspections i WHERE i.cGSecured = :cGSecured"),
    @NamedQuery(name = "Inspections.findBySFOMin", query = "SELECT i FROM Inspections i WHERE i.sFOMin = :sFOMin"),
    @NamedQuery(name = "Inspections.findBySFOAppr", query = "SELECT i FROM Inspections i WHERE i.sFOAppr = :sFOAppr"),
    @NamedQuery(name = "Inspections.findBySFOAuto", query = "SELECT i FROM Inspections i WHERE i.sFOAuto = :sFOAuto"),
    @NamedQuery(name = "Inspections.findBySFOWeld", query = "SELECT i FROM Inspections i WHERE i.sFOWeld = :sFOWeld"),
    @NamedQuery(name = "Inspections.findBySSAnnual", query = "SELECT i FROM Inspections i WHERE i.sSAnnual = :sSAnnual"),
    @NamedQuery(name = "Inspections.findBySSDoL", query = "SELECT i FROM Inspections i WHERE i.sSDoL = :sSDoL"),
    @NamedQuery(name = "Inspections.findBySSAccess", query = "SELECT i FROM Inspections i WHERE i.sSAccess = :sSAccess"),
    @NamedQuery(name = "Inspections.findBySSStand", query = "SELECT i FROM Inspections i WHERE i.sSStand = :sSStand"),
    @NamedQuery(name = "Inspections.findBySSSprink", query = "SELECT i FROM Inspections i WHERE i.sSSprink = :sSSprink"),
    @NamedQuery(name = "Inspections.findBySSRiserL", query = "SELECT i FROM Inspections i WHERE i.sSRiserL = :sSRiserL"),
    @NamedQuery(name = "Inspections.findByHESService", query = "SELECT i FROM Inspections i WHERE i.hESService = :hESService"),
    @NamedQuery(name = "Inspections.findByHesLsd", query = "SELECT i FROM Inspections i WHERE i.hesLsd = :hesLsd"),
    @NamedQuery(name = "Inspections.findByHESAccess", query = "SELECT i FROM Inspections i WHERE i.hESAccess = :hESAccess"),
    @NamedQuery(name = "Inspections.findByHESClean", query = "SELECT i FROM Inspections i WHERE i.hESClean = :hESClean"),
    @NamedQuery(name = "Inspections.findByHESKClass", query = "SELECT i FROM Inspections i WHERE i.hESKClass = :hESKClass"),
    @NamedQuery(name = "Inspections.findByHESFilter", query = "SELECT i FROM Inspections i WHERE i.hESFilter = :hESFilter"),
    @NamedQuery(name = "Inspections.findByFDMaint", query = "SELECT i FROM Inspections i WHERE i.fDMaint = :fDMaint"),
    @NamedQuery(name = "Inspections.findByHESNozzle", query = "SELECT i FROM Inspections i WHERE i.hESNozzle = :hESNozzle"),
    @NamedQuery(name = "Inspections.findByOLPosted", query = "SELECT i FROM Inspections i WHERE i.oLPosted = :oLPosted"),
    @NamedQuery(name = "Inspections.findByADVisible", query = "SELECT i FROM Inspections i WHERE i.aDVisible = :aDVisible"),
    @NamedQuery(name = "Inspections.findByFDAMaint", query = "SELECT i FROM Inspections i WHERE i.fDAMaint = :fDAMaint"),
    @NamedQuery(name = "Inspections.findByFDAKnox", query = "SELECT i FROM Inspections i WHERE i.fDAKnox = :fDAKnox"),
    @NamedQuery(name = "Inspections.findByFDAKLoc", query = "SELECT i FROM Inspections i WHERE i.fDAKLoc = :fDAKLoc"),
    @NamedQuery(name = "Inspections.findByFDCCaps", query = "SELECT i FROM Inspections i WHERE i.fDCCaps = :fDCCaps"),
    @NamedQuery(name = "Inspections.findByFDCIdent", query = "SELECT i FROM Inspections i WHERE i.fDCIdent = :fDCIdent"),
    @NamedQuery(name = "Inspections.findByFDCAccess", query = "SELECT i FROM Inspections i WHERE i.fDCAccess = :fDCAccess"),
    @NamedQuery(name = "Inspections.findByFDCLocation", query = "SELECT i FROM Inspections i WHERE i.fDCLocation = :fDCLocation"),
    @NamedQuery(name = "Inspections.findByELOverride", query = "SELECT i FROM Inspections i WHERE i.eLOverride = :eLOverride"),
    @NamedQuery(name = "Inspections.findByPr704", query = "SELECT i FROM Inspections i WHERE i.pr704 = :pr704"),
    @NamedQuery(name = "Inspections.findByPRPermit", query = "SELECT i FROM Inspections i WHERE i.pRPermit = :pRPermit"),
    @NamedQuery(name = "Inspections.findByPRImpact", query = "SELECT i FROM Inspections i WHERE i.pRImpact = :pRImpact"),
    @NamedQuery(name = "Inspections.findByOTViolations", query = "SELECT i FROM Inspections i WHERE i.oTViolations = :oTViolations"),
    @NamedQuery(name = "Inspections.findByInspectionscol", query = "SELECT i FROM Inspections i WHERE i.inspectionscol = :inspectionscol")})
public class Inspections implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInspections")
    private Integer idInspections;
    @Basic(optional = false)
    @Column(name = "InspectionDate")
    @Temporal(TemporalType.DATE)
    private Date inspectionDate;
    @Basic(optional = false)
    @Column(name = "ED_Obst")
    private String eDObst;
    @Basic(optional = false)
    @Column(name = "ED_Lock")
    private String eDLock;
    @Basic(optional = false)
    @Column(name = "ED_Illum")
    private String eDIllum;
    @Basic(optional = false)
    @Column(name = "ES_Work")
    private String eSWork;
    @Basic(optional = false)
    @Column(name = "FD_Unapp")
    private String fDUnapp;
    @Basic(optional = false)
    @Column(name = "FD_Clear")
    private String fDClear;
    @Basic(optional = false)
    @Column(name = "FE_Min")
    private String fEMin;
    @Basic(optional = false)
    @Column(name = "FE_Max")
    private String fEMax;
    @Basic(optional = false)
    @Column(name = "FE_Annual")
    private String fEAnnual;
    @Basic(optional = false)
    @Column(name = "FE_Access")
    private String fEAccess;
    @Basic(optional = false)
    @Column(name = "El_Ext")
    private String elExt;
    @Basic(optional = false)
    @Column(name = "El_Multi")
    private String elMulti;
    @Basic(optional = false)
    @Column(name = "El_BoxSw")
    private String elBoxSw;
    @Basic(optional = false)
    @Column(name = "El_ElPa")
    private String elElPa;
    @Basic(optional = false)
    @Column(name = "El_36Clear")
    private String el36Clear;
    @Basic(optional = false)
    @Column(name = "St_House")
    private String stHouse;
    @Basic(optional = false)
    @Column(name = "St_24BC")
    private String st24BC;
    @Basic(optional = false)
    @Column(name = "St_18BS")
    private String st18BS;
    @Basic(optional = false)
    @Column(name = "St_Stair")
    private String stStair;
    @Basic(optional = false)
    @Column(name = "St_Ignit")
    private String stIgnit;
    @Basic(optional = false)
    @Column(name = "FC_704")
    private String fc704;
    @Basic(optional = false)
    @Column(name = "FC_MSDS")
    private String fcMsds;
    @Basic(optional = false)
    @Column(name = "FC_Smoke")
    private String fCSmoke;
    @Basic(optional = false)
    @Column(name = "CG_Secured")
    private String cGSecured;
    @Basic(optional = false)
    @Column(name = "SFO_Min")
    private String sFOMin;
    @Basic(optional = false)
    @Column(name = "SFO_Appr")
    private String sFOAppr;
    @Basic(optional = false)
    @Column(name = "SFO_Auto")
    private String sFOAuto;
    @Basic(optional = false)
    @Column(name = "SFO_Weld")
    private String sFOWeld;
    @Basic(optional = false)
    @Column(name = "SS_Annual")
    private String sSAnnual;
    @Basic(optional = false)
    @Column(name = "SS_DoL")
    @Temporal(TemporalType.DATE)
    private Date sSDoL;
    @Basic(optional = false)
    @Column(name = "SS_Access")
    private String sSAccess;
    @Basic(optional = false)
    @Column(name = "SS_Stand")
    private String sSStand;
    @Basic(optional = false)
    @Column(name = "SS_Sprink")
    private String sSSprink;
    @Basic(optional = false)
    @Column(name = "SS_RiserL")
    private String sSRiserL;
    @Basic(optional = false)
    @Column(name = "HES_Service")
    private String hESService;
    @Basic(optional = false)
    @Column(name = "HES_LSD")
    @Temporal(TemporalType.DATE)
    private Date hesLsd;
    @Basic(optional = false)
    @Column(name = "HES_Access")
    private String hESAccess;
    @Basic(optional = false)
    @Column(name = "HES_Clean")
    private String hESClean;
    @Basic(optional = false)
    @Column(name = "HES_KClass")
    private String hESKClass;
    @Basic(optional = false)
    @Column(name = "HES_Filter")
    private String hESFilter;
    @Basic(optional = false)
    @Column(name = "FD_Maint")
    private String fDMaint;
    @Basic(optional = false)
    @Column(name = "HES_Nozzle")
    private String hESNozzle;
    @Basic(optional = false)
    @Column(name = "OL_Posted")
    private String oLPosted;
    @Basic(optional = false)
    @Column(name = "AD_Visible")
    private String aDVisible;
    @Basic(optional = false)
    @Column(name = "FDA_Maint")
    private String fDAMaint;
    @Basic(optional = false)
    @Column(name = "FDA_Knox")
    private String fDAKnox;
    @Basic(optional = false)
    @Column(name = "FDA_KLoc")
    private String fDAKLoc;
    @Basic(optional = false)
    @Column(name = "FDC_Caps")
    private String fDCCaps;
    @Basic(optional = false)
    @Column(name = "FDC_Ident")
    private String fDCIdent;
    @Basic(optional = false)
    @Column(name = "FDC_Access")
    private String fDCAccess;
    @Basic(optional = false)
    @Column(name = "FDC_Location")
    private String fDCLocation;
    @Basic(optional = false)
    @Column(name = "EL_Override")
    private String eLOverride;
    @Basic(optional = false)
    @Column(name = "PR_704")
    private String pr704;
    @Basic(optional = false)
    @Column(name = "PR_Permit")
    private String pRPermit;
    @Basic(optional = false)
    @Column(name = "PR_Impact")
    private String pRImpact;
    @Basic(optional = false)
    @Column(name = "OT_Violations")
    private String oTViolations;
    @Basic(optional = false)
    @Column(name = "Inspectionscol")
    private String inspectionscol;
    @JoinColumn(name = "idProperty", referencedColumnName = "idProperty")
    @ManyToOne(optional = false)
    private Property idProperty;

    public Inspections() {
    }

    public Inspections(Integer idInspections) {
        this.idInspections = idInspections;
    }

    public Inspections(Integer idInspections, Date inspectionDate, String eDObst, String eDLock, String eDIllum, String eSWork, String fDUnapp, String fDClear, String fEMin, String fEMax, String fEAnnual, String fEAccess, String elExt, String elMulti, String elBoxSw, String elElPa, String el36Clear, String stHouse, String st24BC, String st18BS, String stStair, String stIgnit, String fc704, String fcMsds, String fCSmoke, String cGSecured, String sFOMin, String sFOAppr, String sFOAuto, String sFOWeld, String sSAnnual, Date sSDoL, String sSAccess, String sSStand, String sSSprink, String sSRiserL, String hESService, Date hesLsd, String hESAccess, String hESClean, String hESKClass, String hESFilter, String fDMaint, String hESNozzle, String oLPosted, String aDVisible, String fDAMaint, String fDAKnox, String fDAKLoc, String fDCCaps, String fDCIdent, String fDCAccess, String fDCLocation, String eLOverride, String pr704, String pRPermit, String pRImpact, String oTViolations, String inspectionscol) {
        this.idInspections = idInspections;
        this.inspectionDate = inspectionDate;
        this.eDObst = eDObst;
        this.eDLock = eDLock;
        this.eDIllum = eDIllum;
        this.eSWork = eSWork;
        this.fDUnapp = fDUnapp;
        this.fDClear = fDClear;
        this.fEMin = fEMin;
        this.fEMax = fEMax;
        this.fEAnnual = fEAnnual;
        this.fEAccess = fEAccess;
        this.elExt = elExt;
        this.elMulti = elMulti;
        this.elBoxSw = elBoxSw;
        this.elElPa = elElPa;
        this.el36Clear = el36Clear;
        this.stHouse = stHouse;
        this.st24BC = st24BC;
        this.st18BS = st18BS;
        this.stStair = stStair;
        this.stIgnit = stIgnit;
        this.fc704 = fc704;
        this.fcMsds = fcMsds;
        this.fCSmoke = fCSmoke;
        this.cGSecured = cGSecured;
        this.sFOMin = sFOMin;
        this.sFOAppr = sFOAppr;
        this.sFOAuto = sFOAuto;
        this.sFOWeld = sFOWeld;
        this.sSAnnual = sSAnnual;
        this.sSDoL = sSDoL;
        this.sSAccess = sSAccess;
        this.sSStand = sSStand;
        this.sSSprink = sSSprink;
        this.sSRiserL = sSRiserL;
        this.hESService = hESService;
        this.hesLsd = hesLsd;
        this.hESAccess = hESAccess;
        this.hESClean = hESClean;
        this.hESKClass = hESKClass;
        this.hESFilter = hESFilter;
        this.fDMaint = fDMaint;
        this.hESNozzle = hESNozzle;
        this.oLPosted = oLPosted;
        this.aDVisible = aDVisible;
        this.fDAMaint = fDAMaint;
        this.fDAKnox = fDAKnox;
        this.fDAKLoc = fDAKLoc;
        this.fDCCaps = fDCCaps;
        this.fDCIdent = fDCIdent;
        this.fDCAccess = fDCAccess;
        this.fDCLocation = fDCLocation;
        this.eLOverride = eLOverride;
        this.pr704 = pr704;
        this.pRPermit = pRPermit;
        this.pRImpact = pRImpact;
        this.oTViolations = oTViolations;
        this.inspectionscol = inspectionscol;
    }

    public Integer getIdInspections() {
        return idInspections;
    }

    public void setIdInspections(Integer idInspections) {
        this.idInspections = idInspections;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getEDObst() {
        return eDObst;
    }

    public void setEDObst(String eDObst) {
        this.eDObst = eDObst;
    }

    public String getEDLock() {
        return eDLock;
    }

    public void setEDLock(String eDLock) {
        this.eDLock = eDLock;
    }

    public String getEDIllum() {
        return eDIllum;
    }

    public void setEDIllum(String eDIllum) {
        this.eDIllum = eDIllum;
    }

    public String getESWork() {
        return eSWork;
    }

    public void setESWork(String eSWork) {
        this.eSWork = eSWork;
    }

    public String getFDUnapp() {
        return fDUnapp;
    }

    public void setFDUnapp(String fDUnapp) {
        this.fDUnapp = fDUnapp;
    }

    public String getFDClear() {
        return fDClear;
    }

    public void setFDClear(String fDClear) {
        this.fDClear = fDClear;
    }

    public String getFEMin() {
        return fEMin;
    }

    public void setFEMin(String fEMin) {
        this.fEMin = fEMin;
    }

    public String getFEMax() {
        return fEMax;
    }

    public void setFEMax(String fEMax) {
        this.fEMax = fEMax;
    }

    public String getFEAnnual() {
        return fEAnnual;
    }

    public void setFEAnnual(String fEAnnual) {
        this.fEAnnual = fEAnnual;
    }

    public String getFEAccess() {
        return fEAccess;
    }

    public void setFEAccess(String fEAccess) {
        this.fEAccess = fEAccess;
    }

    public String getElExt() {
        return elExt;
    }

    public void setElExt(String elExt) {
        this.elExt = elExt;
    }

    public String getElMulti() {
        return elMulti;
    }

    public void setElMulti(String elMulti) {
        this.elMulti = elMulti;
    }

    public String getElBoxSw() {
        return elBoxSw;
    }

    public void setElBoxSw(String elBoxSw) {
        this.elBoxSw = elBoxSw;
    }

    public String getElElPa() {
        return elElPa;
    }

    public void setElElPa(String elElPa) {
        this.elElPa = elElPa;
    }

    public String getEl36Clear() {
        return el36Clear;
    }

    public void setEl36Clear(String el36Clear) {
        this.el36Clear = el36Clear;
    }

    public String getStHouse() {
        return stHouse;
    }

    public void setStHouse(String stHouse) {
        this.stHouse = stHouse;
    }

    public String getSt24BC() {
        return st24BC;
    }

    public void setSt24BC(String st24BC) {
        this.st24BC = st24BC;
    }

    public String getSt18BS() {
        return st18BS;
    }

    public void setSt18BS(String st18BS) {
        this.st18BS = st18BS;
    }

    public String getStStair() {
        return stStair;
    }

    public void setStStair(String stStair) {
        this.stStair = stStair;
    }

    public String getStIgnit() {
        return stIgnit;
    }

    public void setStIgnit(String stIgnit) {
        this.stIgnit = stIgnit;
    }

    public String getFc704() {
        return fc704;
    }

    public void setFc704(String fc704) {
        this.fc704 = fc704;
    }

    public String getFcMsds() {
        return fcMsds;
    }

    public void setFcMsds(String fcMsds) {
        this.fcMsds = fcMsds;
    }

    public String getFCSmoke() {
        return fCSmoke;
    }

    public void setFCSmoke(String fCSmoke) {
        this.fCSmoke = fCSmoke;
    }

    public String getCGSecured() {
        return cGSecured;
    }

    public void setCGSecured(String cGSecured) {
        this.cGSecured = cGSecured;
    }

    public String getSFOMin() {
        return sFOMin;
    }

    public void setSFOMin(String sFOMin) {
        this.sFOMin = sFOMin;
    }

    public String getSFOAppr() {
        return sFOAppr;
    }

    public void setSFOAppr(String sFOAppr) {
        this.sFOAppr = sFOAppr;
    }

    public String getSFOAuto() {
        return sFOAuto;
    }

    public void setSFOAuto(String sFOAuto) {
        this.sFOAuto = sFOAuto;
    }

    public String getSFOWeld() {
        return sFOWeld;
    }

    public void setSFOWeld(String sFOWeld) {
        this.sFOWeld = sFOWeld;
    }

    public String getSSAnnual() {
        return sSAnnual;
    }

    public void setSSAnnual(String sSAnnual) {
        this.sSAnnual = sSAnnual;
    }

    public Date getSSDoL() {
        return sSDoL;
    }

    public void setSSDoL(Date sSDoL) {
        this.sSDoL = sSDoL;
    }

    public String getSSAccess() {
        return sSAccess;
    }

    public void setSSAccess(String sSAccess) {
        this.sSAccess = sSAccess;
    }

    public String getSSStand() {
        return sSStand;
    }

    public void setSSStand(String sSStand) {
        this.sSStand = sSStand;
    }

    public String getSSSprink() {
        return sSSprink;
    }

    public void setSSSprink(String sSSprink) {
        this.sSSprink = sSSprink;
    }

    public String getSSRiserL() {
        return sSRiserL;
    }

    public void setSSRiserL(String sSRiserL) {
        this.sSRiserL = sSRiserL;
    }

    public String getHESService() {
        return hESService;
    }

    public void setHESService(String hESService) {
        this.hESService = hESService;
    }

    public Date getHesLsd() {
        return hesLsd;
    }

    public void setHesLsd(Date hesLsd) {
        this.hesLsd = hesLsd;
    }

    public String getHESAccess() {
        return hESAccess;
    }

    public void setHESAccess(String hESAccess) {
        this.hESAccess = hESAccess;
    }

    public String getHESClean() {
        return hESClean;
    }

    public void setHESClean(String hESClean) {
        this.hESClean = hESClean;
    }

    public String getHESKClass() {
        return hESKClass;
    }

    public void setHESKClass(String hESKClass) {
        this.hESKClass = hESKClass;
    }

    public String getHESFilter() {
        return hESFilter;
    }

    public void setHESFilter(String hESFilter) {
        this.hESFilter = hESFilter;
    }

    public String getFDMaint() {
        return fDMaint;
    }

    public void setFDMaint(String fDMaint) {
        this.fDMaint = fDMaint;
    }

    public String getHESNozzle() {
        return hESNozzle;
    }

    public void setHESNozzle(String hESNozzle) {
        this.hESNozzle = hESNozzle;
    }

    public String getOLPosted() {
        return oLPosted;
    }

    public void setOLPosted(String oLPosted) {
        this.oLPosted = oLPosted;
    }

    public String getADVisible() {
        return aDVisible;
    }

    public void setADVisible(String aDVisible) {
        this.aDVisible = aDVisible;
    }

    public String getFDAMaint() {
        return fDAMaint;
    }

    public void setFDAMaint(String fDAMaint) {
        this.fDAMaint = fDAMaint;
    }

    public String getFDAKnox() {
        return fDAKnox;
    }

    public void setFDAKnox(String fDAKnox) {
        this.fDAKnox = fDAKnox;
    }

    public String getFDAKLoc() {
        return fDAKLoc;
    }

    public void setFDAKLoc(String fDAKLoc) {
        this.fDAKLoc = fDAKLoc;
    }

    public String getFDCCaps() {
        return fDCCaps;
    }

    public void setFDCCaps(String fDCCaps) {
        this.fDCCaps = fDCCaps;
    }

    public String getFDCIdent() {
        return fDCIdent;
    }

    public void setFDCIdent(String fDCIdent) {
        this.fDCIdent = fDCIdent;
    }

    public String getFDCAccess() {
        return fDCAccess;
    }

    public void setFDCAccess(String fDCAccess) {
        this.fDCAccess = fDCAccess;
    }

    public String getFDCLocation() {
        return fDCLocation;
    }

    public void setFDCLocation(String fDCLocation) {
        this.fDCLocation = fDCLocation;
    }

    public String getELOverride() {
        return eLOverride;
    }

    public void setELOverride(String eLOverride) {
        this.eLOverride = eLOverride;
    }

    public String getPr704() {
        return pr704;
    }

    public void setPr704(String pr704) {
        this.pr704 = pr704;
    }

    public String getPRPermit() {
        return pRPermit;
    }

    public void setPRPermit(String pRPermit) {
        this.pRPermit = pRPermit;
    }

    public String getPRImpact() {
        return pRImpact;
    }

    public void setPRImpact(String pRImpact) {
        this.pRImpact = pRImpact;
    }

    public String getOTViolations() {
        return oTViolations;
    }

    public void setOTViolations(String oTViolations) {
        this.oTViolations = oTViolations;
    }

    public String getInspectionscol() {
        return inspectionscol;
    }

    public void setInspectionscol(String inspectionscol) {
        this.inspectionscol = inspectionscol;
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
        hash += (idInspections != null ? idInspections.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspections)) {
            return false;
        }
        Inspections other = (Inspections) object;
        if ((this.idInspections == null && other.idInspections != null) || (this.idInspections != null && !this.idInspections.equals(other.idInspections))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lsfire.Inspections[ idInspections=" + idInspections + " ]";
    }
    
}
