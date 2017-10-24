package lsfire;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lsfire.BusinessProperty;
import lsfire.Inspections;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-12T12:45:10")
@StaticMetamodel(Property.class)
public class Property_ { 

    public static volatile SingularAttribute<Property, String> panelLocation;
    public static volatile ListAttribute<Property, BusinessProperty> businessPropertyList;
    public static volatile ListAttribute<Property, Inspections> inspectionsList;
    public static volatile SingularAttribute<Property, Integer> idProperty;
    public static volatile SingularAttribute<Property, String> propertyAddress;
    public static volatile SingularAttribute<Property, Integer> numberPFA;
    public static volatile SingularAttribute<Property, String> activeCheck;
    public static volatile SingularAttribute<Property, String> district;
    public static volatile SingularAttribute<Property, String> sysNormCheck;
    public static volatile SingularAttribute<Property, String> fireAlarmPanel;
    public static volatile SingularAttribute<Property, String> occupancyClass;
    public static volatile SingularAttribute<Property, String> hazardClass;

}