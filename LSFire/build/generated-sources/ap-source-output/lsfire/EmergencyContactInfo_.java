package lsfire;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lsfire.Business;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-12T12:45:10")
@StaticMetamodel(EmergencyContactInfo.class)
public class EmergencyContactInfo_ { 

    public static volatile SingularAttribute<EmergencyContactInfo, Integer> idEmergencyContactInfo;
    public static volatile SingularAttribute<EmergencyContactInfo, String> eCIname;
    public static volatile SingularAttribute<EmergencyContactInfo, Long> eCINumber;
    public static volatile SingularAttribute<EmergencyContactInfo, String> eCIcontact;
    public static volatile ListAttribute<EmergencyContactInfo, Business> businessList;

}