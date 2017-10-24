package lsfire;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lsfire.BusinessProperty;
import lsfire.EmergencyContactInfo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-12T12:45:10")
@StaticMetamodel(Business.class)
public class Business_ { 

    public static volatile ListAttribute<Business, BusinessProperty> businessPropertyList;
    public static volatile SingularAttribute<Business, Integer> idBusiness;
    public static volatile SingularAttribute<Business, Integer> phone;
    public static volatile SingularAttribute<Business, EmergencyContactInfo> idECI;
    public static volatile SingularAttribute<Business, String> name;

}