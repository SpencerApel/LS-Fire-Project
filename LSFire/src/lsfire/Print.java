package lsfire;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public class Print
{   
    public void print() 
    {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/lsfire";
        final String SELECT_QUERY =             
       " select b.name, b.phone, p.PropertyAddress, e.ECI_name, e.ECI_contact, e.ECI_Number, p.occupancyClass, p.hazardClass, p.district, p.numberPFA, p.fireAlarmPanel, p.activeCheck, p.sysNormCheck, p.panelLocation, i.ED_Obst, i.EL_Ext, i.SFO_Min, i.HES_Service, i.FDC_Caps, i.ED_Lock, i.El_Multi, i.HES_LSD, i.FDC_Ident, i.El_BoxSw, i.SFO_Appr, i.HES_Access, i.FDC_Access, i.El_ElPa, i.SFO_Auto, i.HES_Clean, i.HES_KClass, i.FDC_Location, i.ED_Illum, i.El_36Clear, i.HES_Nozzle, i.ES_Work, i.SFO_Weld, i.HES_Filter, i.EL_Override, i.FD_Maint, i.St_House, i.OL_Posted, i.FD_Unapp, i.St_24BC, i.St_18BS, i.FD_Clear, i.St_Stair, i.St_Ignit, i.SS_Annual, i.AD_Visible, i.PR_704, i.SS_DoL, i.PR_Permit, i.FE_Min, i.PR_Impact, i.FE_Max, i.SS_Access, i.FE_Annual, i.FC_704, i.SS_Stand, i.FDA_Maint, i.FE_Access, i.FC_MSDS, i.FDA_Knox, i.FC_Smoke, i.SS_Sprink, i.FDA_KLoc, i.OT_Violations, i.SS_RiserL, i.CG_Secured from property p " + 
       " join business_property bp on bp.idProperty = p.idProperty " +
       " join business b on b.idBusiness = bp.idBusiness " +
       " join emergency_contact_info e on e.idEmergency_Contact_Info = b.idECI " +
       " where b.name = 'Michael Scott Paper Company' ";
          String file = "C:\\Users\\nhhopper1226\\Documents\\NetBeansProjects\\LSFire\\src\\lsfire\\Inspection Report.txt";
        try 
        {
            //FileOutputStream outStr = new FileOutputStream(file, true);
            //PrintWriter outFile = new PrintWriter(file);
        //j f = new j();
        //j.myMethod();
        try
            
           (
            Connection connection = DriverManager.getConnection 
               (DATABASE_URL, "root", "yoast");

          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
        {
            FileOutputStream outStr = new FileOutputStream(file, true);
            PrintWriter outFile = new PrintWriter(file);
              
          
              ResultSetMetaData metaData = resultSet.getMetaData();
              int numberOfColumns = metaData.getColumnCount();
              
              System.out.printf("\t\t\t\t\t\t\tLee's Summit Missouri Fire Department %n");
              System.out.printf("\t\t\t\t\t\t\t\t Inspection Report %n");
              System.out.printf("\t\t\t\t\t\t\t\tPhone (816)969-1300 %n");
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              
              outFile.printf("\t\t\t\t\t\t\tLee's Summit Missouri Fire Department %n");
              outFile.printf("\t\t\t\t\t\t\t\t Inspection Report %n");
              outFile.printf("\t\t\t\t\t\t\t\tPhone (816)969-1300 %n");
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              
              
              //Tihs is where the data gets pulled into the form
              while (resultSet.next())
              {
              System.out.printf("%nBusiness Name: %s \t\t\t\t\t\t\t\t\t\t\tPhone:%d%n",resultSet.getObject(1),resultSet.getObject(2));
              System.out.printf("Address:       %s %n",resultSet.getObject(3));
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              System.out.printf("%n\t\t\t\t\t\t\t    Emergency Contact Information%n");
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              
              outFile.printf("%nBusiness Name: %s \t\t\t\t\t\t\t\t\t\t\tPhone:%d%n",resultSet.getObject(1),resultSet.getObject(2));
              outFile.printf("Address:       %s %n",resultSet.getObject(3));
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              outFile.printf("%n\t\t\t\t\t\t\t    Emergency Contact Information%n");
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              
              //DESIGN FORM AND INSERT DATA HERE
            
              System.out.printf("\t\t\tName: %s\t\t\tContact Type: %s\t\t\tNumber: %d %n%n",resultSet.getObject(4),resultSet.getObject(5),resultSet.getObject(6));
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              System.out.printf("Occupancy Class: %s\t\t\t\t| Hazard Classificaion: %s\t| District: %s\t\t|PFA#: %d\n ",resultSet.getObject(7),
                resultSet.getObject(8),resultSet.getObject(9), resultSet.getObject(10));
              System.out.println ("                                                       |                               |                               |");
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              System.out.printf("Fire Alarm Panel: %s\t| Active: %s\t\t| Sys Normal: %s\t\t| Panel/Pad Location: %s\n",resultSet.getObject(11),
                resultSet.getObject(12),resultSet.getObject(13),resultSet.getObject(14));
              System.out.println ("                                |                       |                       |");
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              System.out.printf("%n\t\t\t\t\t\t\t\tInspection Narrative%n");
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              System.out.printf("1. EXIT DOORS/EXIT WAYS\t |5. ELECTRICAL\t\t  |9. SPRAY FINISHING OPER.\t |11. HOOD EXT. SYSTEM\t\t|15. FIRE DEPT. CONNECTION%n");
              System.out.println ("__________________________________________________________________________________________________________________________________________________________");
              System.out.printf(" %s :Obstruction\t\t | %s :Extension Cords     | %s :Minimum 4A40BC fire\t | %s :Service within 6 months   | %s :FDC caps in place\n", resultSet.getObject(15), resultSet.getObject(16), resultSet.getObject(17), resultSet.getObject(18), resultSet.getObject(19));
              System.out.printf(" %s :Locks/Panic Hardware | %s :Multi Plug Adapters |      extinguisher within 30' | %s Last service date | %s :FDC Identified\n", resultSet.getObject(20), resultSet.getObject(21), resultSet.getObject(22), resultSet.getObject(23));
              System.out.printf("_________________________| %s :Open Boxes, Switches| %s :Approved spray booth      | %s :Access to remote pull     | %s :FDC access is \n", resultSet.getObject(24), resultSet.getObject(25), resultSet.getObject(26), resultSet.getObject(27));
              System.out.printf("2. EXIT SIGNS/EMR. LIGHTS| %s :Openings in        | %s :Auto extinguishing        | %s :Clean                     |     obstructed\n", resultSet.getObject(28), resultSet.getObject(29), resultSet.getObject(30));
              System.out.printf("_________________________|      Electrical Panel  |     system Inspected         | %s: 'K' Class extinguisher    | %s FDC Location\n", resultSet.getObject(31), resultSet.getObject(32));
              System.out.printf(" %s :Exit Signs Illum.    | %s :36' clearance from  |    Annually                  | %s :Nozzle Condition         |_________________________________________\n", resultSet.getObject(33), resultSet.getObject(34), resultSet.getObject(35));
              System.out.printf(" %s :Emer. Lights Working |     storage            | %s :Welding/hotwork           | %s :Filters in place          |16. ELEVATOR\n", resultSet.getObject(36), resultSet.getObject(37), resultSet.getObject(38));
              System.out.println("_________________________|________________________|     warning signs and No     |______________________________|_________________________________________");
              System.out.printf("3. FIRE DOORS            |6. STORAGE              |     Smoking signs            |12. OCCUPANT LOAD             | %s :Override Keys\n", resultSet.getObject(39));
              System.out.println("_________________________|________________________|                              |______________________________|      On-Site");                        
              System.out.printf(" %s :Maintain/Close Fully| %s :Housekeeping        |                              | %s :Posted in places of       |                   \n",resultSet.getObject(40), resultSet.getObject(41), resultSet.getObject(42));
              System.out.printf(" %s :Unapproved Open      | %s :24 below ceiling    |                              |    assembly                  |                        \n", resultSet.getObject(43), resultSet.getObject(44));
              System.out.printf("     Devices             | %s :18 below sprinklers |______________________________|______________________________|__________________________________________\n", resultSet.getObject(45));
              System.out.printf(" %s :Clear of obstructions| %s :Under Stairs        |10. SPRINKLERS/STANDPIPE      |13. ADDRESS                   |17. PROPANE                               \n", resultSet.getObject(46), resultSet.getObject(47));
              System.out.printf("_________________________| %s :Close to            |______________________________|______________________________|__________________________________________\n", resultSet.getObject(48));
              System.out.printf("4. FIRE EXTINGUISHERS    |     ignition source    | %s :Annual Service            | %s :Visible and legible       | %s :704 Placards\n" , resultSet.getObject(49), resultSet.getObject(50), resultSet.getObject(51));
              System.out.printf("_________________________|________________________| %s :Date of last     |______________________________| %s :Permit on site\n", resultSet.getObject(52), resultSet.getObject(53));
              System.out.printf(" %s :Minimum 2A10BC       |7. FLAMMABLE/COMB.      |              service         |14. FIRE DEPT. ACCESS         | %s :Impact bollards\n", resultSet.getObject(54), resultSet.getObject(55));
              System.out.printf(" %s :Max of 75' travel dst|________________________| %s :Access                    |______________________________|___________________________________________\n", resultSet.getObject(56), resultSet.getObject(57));
              System.out.printf(" %s :Annual Inspection    | %s :704 Placards       | %s :Standpipe sticker on     | %s :Maint/Lubrication         |18. OTHER\n", resultSet.getObject(58), resultSet.getObject(59), resultSet.getObject(60), resultSet.getObject(61));
              System.out.printf(" %s :Access               | %s :MSDS on premises   |      door                    | %s :Knox box keys current    |___________________________________________\n", resultSet.getObject(62), resultSet.getObject(63), resultSet.getObject(64));
              System.out.printf("                         | %s :Non-smoking signs   | %s :Sprinkler room            | %s :Knox box location         | %s :Other Violations Noted - Use\n", resultSet.getObject(65), resultSet.getObject(66), resultSet.getObject(67), resultSet.getObject(68));
              System.out.println("                         |________________________|      identified              |                              |     box below to describe");
              System.out.printf("                         |8. COMPRESSED GASES     | %s :Riser location            |                              |\n", resultSet.getObject(69));
              System.out.println("                         |________________________|                              |                              |");
              System.out.printf("                         | %s :Secured             |                              |                              |\n", resultSet.getObject(70));
              System.out.println("_________________________|________________________|______________________________|______________________________|___________________________________________");
              System.out.println("ADDITIONAL VIOLATIONS/COMMENTS:                       P = Pass  F = Fail  NA= Not Applicable");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________\n");
              System.out.println("____________________________________________________________________________________________________________________________________________________________");
              System.out.println("Date of Report          |Inspector                                                    |Responsible Signature");
              System.out.println("________________________|_____________________________________________________________|_____________________________________________________________________");
              
              outFile.printf("\t\t\tName: %s\t\t\tContact Type: %s\t\t\tNumber: %d %n%n",resultSet.getObject(4),resultSet.getObject(5),resultSet.getObject(6));
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              outFile.printf("Occupancy Class: %s\t\t\t\t| Hazard Classificaion: %s\t| District: %s\t\t|PFA#: %d\n ",resultSet.getObject(7),
                resultSet.getObject(8),resultSet.getObject(9), resultSet.getObject(10));
              outFile.println ("                                                       |                               |                               |");
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              outFile.printf("Fire Alarm Panel: %s\t| Active: %s\t\t| Sys Normal: %s\t\t| Panel/Pad Location: %s\n",resultSet.getObject(11),
                resultSet.getObject(12),resultSet.getObject(13),resultSet.getObject(14));
              outFile.println ("                                |                       |                       |");
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              outFile.printf("%n\t\t\t\t\t\t\t\tInspection Narrative%n");
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              outFile.printf("1. EXIT DOORS/EXIT WAYS\t |5. ELECTRICAL\t\t  |9. SPRAY FINISHING OPER.\t |11. HOOD EXT. SYSTEM\t\t|15. FIRE DEPT. CONNECTION%n");
              outFile.println ("__________________________________________________________________________________________________________________________________________________________");
              outFile.printf(" %s :Obstruction\t\t | %s :Extension Cords     | %s :Minimum 4A40BC fire\t | %s :Service within 6 months   | %s :FDC caps in place\n", resultSet.getObject(15), resultSet.getObject(16), resultSet.getObject(17), resultSet.getObject(18), resultSet.getObject(19));
              outFile.printf(" %s :Locks/Panic Hardware | %s :Multi Plug Adapters |      extinguisher within 30' | %s Last service date | %s :FDC Identified\n", resultSet.getObject(20), resultSet.getObject(21), resultSet.getObject(22), resultSet.getObject(23));
              outFile.printf("_________________________| %s :Open Boxes, Switches| %s :Approved spray booth      | %s :Access to remote pull     | %s :FDC access is \n", resultSet.getObject(24), resultSet.getObject(25), resultSet.getObject(26), resultSet.getObject(27));
              outFile.printf("2. EXIT SIGNS/EMR. LIGHTS| %s :Openings in        | %s :Auto extinguishing        | %s :Clean                     |     obstructed\n", resultSet.getObject(28), resultSet.getObject(29), resultSet.getObject(30));
              outFile.printf("_________________________|      Electrical Panel  |     system Inspected         | %s: 'K' Class extinguisher    | %s FDC Location\n", resultSet.getObject(31), resultSet.getObject(32));
              outFile.printf(" %s :Exit Signs Illum.    | %s :36' clearance from  |    Annually                  | %s :Nozzle Condition         |_________________________________________\n", resultSet.getObject(33), resultSet.getObject(34), resultSet.getObject(35));
              outFile.printf(" %s :Emer. Lights Working |     storage            | %s :Welding/hotwork           | %s :Filters in place          |16. ELEVATOR\n", resultSet.getObject(36), resultSet.getObject(37), resultSet.getObject(38));
              outFile.println("_________________________|________________________|     warning signs and No     |______________________________|_________________________________________");
              outFile.printf("3. FIRE DOORS            |6. STORAGE              |     Smoking signs            |12. OCCUPANT LOAD             | %s :Override Keys\n", resultSet.getObject(39));
              outFile.println("_________________________|________________________|                              |______________________________|      On-Site");                        
              outFile.printf(" %s :Maintain/Close Fully| %s :Housekeeping        |                              | %s :Posted in places of       |                   \n",resultSet.getObject(40), resultSet.getObject(41), resultSet.getObject(42));
              outFile.printf(" %s :Unapproved Open      | %s :24 below ceiling    |                              |    assembly                  |                        \n", resultSet.getObject(43), resultSet.getObject(44));
              outFile.printf("     Devices             | %s :18 below sprinklers |______________________________|______________________________|__________________________________________\n", resultSet.getObject(45));
              outFile.printf(" %s :Clear of obstructions| %s :Under Stairs        |10. SPRINKLERS/STANDPIPE      |13. ADDRESS                   |17. PROPANE                               \n", resultSet.getObject(46), resultSet.getObject(47));
              outFile.printf("_________________________| %s :Close to            |______________________________|______________________________|__________________________________________\n", resultSet.getObject(48));
              outFile.printf("4. FIRE EXTINGUISHERS    |     ignition source    | %s :Annual Service            | %s :Visible and legible       | %s :704 Placards\n" , resultSet.getObject(49), resultSet.getObject(50), resultSet.getObject(51));
              outFile.printf("_________________________|________________________| %s :Date of last     |______________________________| %s :Permit on site\n", resultSet.getObject(52), resultSet.getObject(53));
              outFile.printf(" %s :Minimum 2A10BC       |7. FLAMMABLE/COMB.      |              service         |14. FIRE DEPT. ACCESS         | %s :Impact bollards\n", resultSet.getObject(54), resultSet.getObject(55));
              outFile.printf(" %s :Max of 75' travel dst|________________________| %s :Access                    |______________________________|___________________________________________\n", resultSet.getObject(56), resultSet.getObject(57));
              outFile.printf(" %s :Annual Inspection    | %s :704 Placards       | %s :Standpipe sticker on     | %s :Maint/Lubrication         |18. OTHER\n", resultSet.getObject(58), resultSet.getObject(59), resultSet.getObject(60), resultSet.getObject(61));
              outFile.printf(" %s :Access               | %s :MSDS on premises   |      door                    | %s :Knox box keys current    |___________________________________________\n", resultSet.getObject(62), resultSet.getObject(63), resultSet.getObject(64));
              outFile.printf("                         | %s :Non-smoking signs   | %s :Sprinkler room            | %s :Knox box location         | %s :Other Violations Noted - Use\n", resultSet.getObject(65), resultSet.getObject(66), resultSet.getObject(67), resultSet.getObject(68));
              outFile.println("                         |________________________|      identified              |                              |     box below to describe");
              outFile.printf("                         |8. COMPRESSED GASES     | %s :Riser location            |                              |\n", resultSet.getObject(69));
              outFile.println("                         |________________________|                              |                              |");
              outFile.printf("                         | %s :Secured             |                              |                              |\n", resultSet.getObject(70));
              outFile.println("_________________________|________________________|______________________________|______________________________|___________________________________________");
              outFile.println("ADDITIONAL VIOLATIONS/COMMENTS:                       P = Pass  F = Fail  NA= Not Applicable");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________\n");
              outFile.println("____________________________________________________________________________________________________________________________________________________________");
              outFile.println("Date of Report          |Inspector                                                    |Responsible Signature");
              outFile.println("________________________|_____________________________________________________________|_____________________________________________________________________");
              
              outFile.close();
              
              }
        }
        }
         catch(FileNotFoundException fnfe) { 
            System.out.println(fnfe.getMessage());
            }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        } 
    
    

    }
}