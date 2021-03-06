package lsfire;

import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import jdk.nashorn.internal.parser.Scanner;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//New and improved jpanel that plays nicely with scroll panes
class ContentPanel extends JPanel{
    public ContentPanel(){
        super();
    }

    //This function here is the key to having absolute layouts in a scroll pane.
    //Scroll panes query their child panel for their preferred size and then determines if it should add a scroll bar
    //or not.

    //Usually, if you have a layout manager, JPanel's just send this size request to its own layout manager, which
    //computes the best size for the panel based off of the panel's components and sends it to the scroll pane

    //Since ya'll don't have a layout manager (which is fine...but more work :/), you need to provide your own
    //getPreferredSize function since JPanel's without a layout manager just return a dimension of 0x0 when
    //asked what size they want to be (unless you have set their preferred size with setPreferredSize)

    //So whats actually going on here? Well, we don't know how large the panel is supposed to be, so we need to
    //manually iterate over the components and somehow compute the best dimensions

    //There are multiple ways you can go about this, but one of the simpler ways is by keeping track of the bounds of the
    //JPanel, and adjusting these as you find more components. Here, I am just continually extending the bounds
    //as more components are transversed, and then I return the new dimensions.
    @Override
    public Dimension getPreferredSize(){
        int maxX = 0;
        int maxY = 0;

        Component[] components = getComponents();
        for(Component i : components){
            Rectangle bounds = i.getBounds();
            maxX = Math.max(maxX, (int)bounds.getMaxX());
            maxY = Math.max(maxY, (int)bounds.getMaxY());
        }

        return new Dimension(maxX, maxY);
    }
}
public class CreateTab extends Applet{
    
    private final EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("LSFirePU");
        // create an EntityManager for interacting with the persistence unit
        private final EntityManager entityManager =
        entityManagerFactory.createEntityManager();
        //private List<Business> results;
    
     /* MOVED ALL OF THESE OUTSIDE OF METHOD ADDCOMPONENTTOPANE AND MADE STATIC*/
    private static JTextField t1 = new JTextField(50);
    private static JTextField t2 = new JTextField(50);
    private static JTextField t3 = new JTextField(50);
    private static JTextField t4 = new JTextField(50);
    private static JTextField t5 = new JTextField(50);
    private static JTextField t6 = new JTextField(50);
    private static JTextField t7 = new JTextField(50);
    private static JTextField t8 = new JTextField(50);
    private static JTextField t9 = new JTextField(50);
    private final static JTextField t10 = new JTextField(50);
    private final static JTextField t11 = new JTextField(50);
    private final static JTextField t12 = new JTextField(50);
    private final static JTextField t13 = new JTextField(50);
    private final static JTextField t14 = new JTextField(50);
    private final static JTextField t15 = new JTextField(50);
    private final static JTextField t16 = new JTextField(50);
    private final static JTextField t17 = new JTextField(50);
    private final static JTextField t18 = new JTextField(50);
    private final static JTextField t19 = new JTextField(50);
    private final static JTextField t20 = new JTextField(50);
    private final static JTextField t21 = new JTextField(50);
    private final static JTextField t22 = new JTextField(6);
    private final static JTextField t23 = new JTextField(6);
    private final static JTextField t24 = new JTextField(6);
    private final static JTextField t25 = new JTextField(6);
    private final static JTextField t26 = new JTextField(6);
    private final static JTextField t27 = new JTextField(50);
    private final static JTextField t28 = new JTextField(50);
    private final static JTextField t29 = new JTextField(50);
    private final static JTextField t30 = new JTextField(50);
    private static JCheckBox c1 = new JCheckBox();
    private static JCheckBox c2 = new JCheckBox();
    private static JCheckBox c3 = new JCheckBox();
    private static JCheckBox c4 = new JCheckBox();
    private static JCheckBox c5 = new JCheckBox();
    private static JCheckBox c6 = new JCheckBox();
    private final static JCheckBox c7 = new JCheckBox("No Violations Noted");
    private final static JCheckBox c8 = new JCheckBox("All Violations Corrected");
    private final static JCheckBox c9 = new JCheckBox();
    private final static JCheckBox c10 = new JCheckBox();
    private final static JCheckBox c11 = new JCheckBox("Obstruction");
    private final static JCheckBox c12 = new JCheckBox();
    private final static JCheckBox c13 = new JCheckBox();
    private final static JCheckBox c14 = new JCheckBox("Locks/Panic Hardware");
    private final static JCheckBox c15 = new JCheckBox();
    private final static JCheckBox c16 = new JCheckBox();
    private final static JCheckBox c17 = new JCheckBox("Exit Signs Illuminated");
    private final static JCheckBox c18 = new JCheckBox();
    private final static JCheckBox c19 = new JCheckBox();
    private final static JCheckBox c20 = new JCheckBox("Emer. Lights Working");
    private final static JCheckBox c21 = new JCheckBox();
    private final static JCheckBox c22 = new JCheckBox();
    private final static JCheckBox c23 = new JCheckBox("Maintained/Close Fully");
    private final static JCheckBox c24 = new JCheckBox();
    private final static JCheckBox c25 = new JCheckBox();
    private final static JCheckBox c26 = new JCheckBox("Unapproved Open Devices");
    private final static JCheckBox c27 = new JCheckBox();
    private final static JCheckBox c28 = new JCheckBox();
    private final static JCheckBox c29 = new JCheckBox("Clear of Obstructions");
    private final static JCheckBox c30 = new JCheckBox();
    private final static JCheckBox c31 = new JCheckBox();
    private final static JCheckBox c32 = new JCheckBox("Minimum 2A10BC");
    private final static JCheckBox c33 = new JCheckBox();
    private final static JCheckBox c34 = new JCheckBox();
    private final static JCheckBox c35 = new JCheckBox("Max of 75’ travel distance");
    private final static JCheckBox c36 = new JCheckBox();
    private final static JCheckBox c37 = new JCheckBox();
    private final static JCheckBox c38 = new JCheckBox("Annual Inspection");
    private final static JCheckBox c39 = new JCheckBox();
    private final static JCheckBox c40 = new JCheckBox();
    private final static JCheckBox c41 = new JCheckBox("Access");
    private final static JCheckBox c42 = new JCheckBox();
    private final static JCheckBox c43 = new JCheckBox();
    private final static JCheckBox c44 = new JCheckBox("Extension Cords");
    private final static JCheckBox c45 = new JCheckBox();
    private final static JCheckBox c46 = new JCheckBox();
    private final static JCheckBox c47 = new JCheckBox("Multi Plug Adapters");
    private final static JCheckBox c48 = new JCheckBox();
    private final static JCheckBox c49 = new JCheckBox();
    private final static JCheckBox c50 = new JCheckBox("Open Boxes, Switches");
    private final static JCheckBox c51 = new JCheckBox();
    private final static JCheckBox c52 = new JCheckBox();
    private final static JCheckBox c53 = new JCheckBox("Openings in Electrical Panel");
    private final static JCheckBox c54 = new JCheckBox();
    private final static JCheckBox c55 = new JCheckBox();
    private final static JCheckBox c56 = new JCheckBox("36” clearance from storage");
    private final static JCheckBox c57 = new JCheckBox();
    private final static JCheckBox c58 = new JCheckBox();
    private final static JCheckBox c59 = new JCheckBox("Housekeeping");
    private final static JCheckBox c60 = new JCheckBox();
    private final static JCheckBox c61 = new JCheckBox();
    private final static JCheckBox c62 = new JCheckBox("24” below ceiling");
    private final static JCheckBox c63 = new JCheckBox();
    private final static JCheckBox c64 = new JCheckBox();
    private final static JCheckBox c65 = new JCheckBox("18” below sprinklers");
    private final static JCheckBox c66 = new JCheckBox();
    private final static JCheckBox c67 = new JCheckBox();
    private final static JCheckBox c68 = new JCheckBox("Under stairs");
    private final static JCheckBox c69 = new JCheckBox();
    private final static JCheckBox c70 = new JCheckBox();
    private final static JCheckBox c71 = new JCheckBox("Close to ignition source");
    private final static JCheckBox c72 = new JCheckBox();
    private final static JCheckBox c73 = new JCheckBox();
    private final static JCheckBox c74 = new JCheckBox("704 Placards");
    private final static JCheckBox c75 = new JCheckBox();
    private final static JCheckBox c76 = new JCheckBox();
    private final static JCheckBox c77 = new JCheckBox("MSDS on premises");
    private final static JCheckBox c78 = new JCheckBox();
    private final static JCheckBox c79 = new JCheckBox();
    private final static JCheckBox c80 = new JCheckBox("Non-smoking signs");
    private final static JCheckBox c81 = new JCheckBox();
    private final static JCheckBox c82 = new JCheckBox();
    private final static JCheckBox c83 = new JCheckBox("Secured");
    private final static JCheckBox c84 = new JCheckBox();
    private final static JCheckBox c85 = new JCheckBox();
    private final static JCheckBox c86 = new JCheckBox("Min. 4A40BC fire extinguisher within 30’");
    private final static JCheckBox c87 = new JCheckBox();
    private final static JCheckBox c88 = new JCheckBox();
    private final static JCheckBox c89 = new JCheckBox("Approved spray");
    private final static JCheckBox c90 = new JCheckBox();
    private final static JCheckBox c91 = new JCheckBox();
    private final static JCheckBox c92 = new JCheckBox("Auto extinguishing system inspected annually");
    private final static JCheckBox c93 = new JCheckBox();
    private final static JCheckBox c94 = new JCheckBox();
    private final static JCheckBox c95 = new JCheckBox("Welding/hotwork warning signs and No Smoking signs");
    private final static JCheckBox c96 = new JCheckBox();
    private final static JCheckBox c97 = new JCheckBox();
    private final static JCheckBox c98 = new JCheckBox("Annual Service");
    private final static JCheckBox c99 = new JCheckBox();
    private final static JCheckBox c100 = new JCheckBox();
    private final static JCheckBox c101 = new JCheckBox("Access");
    private final static JCheckBox c102 = new JCheckBox();
    private final static JCheckBox c103 = new JCheckBox();
    private final static JCheckBox c104 = new JCheckBox("Standpipe sticker on door");
    private final static JCheckBox c105 = new JCheckBox();
    private final static JCheckBox c106 = new JCheckBox();
    private final static JCheckBox c107 = new JCheckBox("Sprinkler room identified");
    private final static JCheckBox c108 = new JCheckBox();
    private final static JCheckBox c109 = new JCheckBox();
    private final static JCheckBox c110 = new JCheckBox("Service within 6 months");
    private final static JCheckBox c111 = new JCheckBox();
    private final static JCheckBox c112 = new JCheckBox();
    private final static JCheckBox c113 = new JCheckBox("Access to remote pull");
    private final static JCheckBox c114 = new JCheckBox();
    private final static JCheckBox c115 = new JCheckBox();
    private final static JCheckBox c116 = new JCheckBox("Clean");
    private final static JCheckBox c117 = new JCheckBox();
    private final static JCheckBox c118 = new JCheckBox();
    private final static JCheckBox c119 = new JCheckBox("“K” Class extinguisher");
    private final static JCheckBox c120 = new JCheckBox();
    private final static JCheckBox c121 = new JCheckBox();
    private final static JCheckBox c122 = new JCheckBox("Nozzle Condition");
    private final static JCheckBox c123 = new JCheckBox();
    private final static JCheckBox c124 = new JCheckBox();
    private final static JCheckBox c125 = new JCheckBox("Filters in place");
    private final static JCheckBox c126 = new JCheckBox();
    private final static JCheckBox c127 = new JCheckBox();
    private final static JCheckBox c128 = new JCheckBox("Posted in places of assembly");
    private final static JCheckBox c129 = new JCheckBox();
    private final static JCheckBox c130 = new JCheckBox();
    private final static JCheckBox c131 = new JCheckBox("Visible & legible");
    private final static JCheckBox c132 = new JCheckBox();
    private final static JCheckBox c133 = new JCheckBox();
    private final static JCheckBox c134 = new JCheckBox("Maint/Lubrication");
    private final static JCheckBox c135 = new JCheckBox();
    private final static JCheckBox c136 = new JCheckBox();
    private final static JCheckBox c137 = new JCheckBox("Knox box keys current");
    private final static JCheckBox c138 = new JCheckBox();
    private final static JCheckBox c139 = new JCheckBox();
    private final static JCheckBox c140 = new JCheckBox("FDC caps in place");
    private final static JCheckBox c141 = new JCheckBox();
    private final static JCheckBox c142 = new JCheckBox();
    private final static JCheckBox c143 = new JCheckBox("FDC Identified");
    private final static JCheckBox c144 = new JCheckBox();
    private final static JCheckBox c145 = new JCheckBox();
    private final static JCheckBox c146 = new JCheckBox("FDC access is unobstructed");
    private final static JCheckBox c147 = new JCheckBox();
    private final static JCheckBox c148 = new JCheckBox();
    private final static JCheckBox c149 = new JCheckBox("Override Keys On-Site");
    private final static JCheckBox c150 = new JCheckBox();
    private final static JCheckBox c151 = new JCheckBox();
    private final static JCheckBox c152 = new JCheckBox("704 Placards");
    private final static JCheckBox c153 = new JCheckBox();
    private final static JCheckBox c154 = new JCheckBox();
    private final static JCheckBox c155 = new JCheckBox("Permit on site");
    private final static JCheckBox c156 = new JCheckBox();
    private final static JCheckBox c157 = new JCheckBox();
    private final static JCheckBox c158 = new JCheckBox("Impact bollards");
    private final static JCheckBox c159 = new JCheckBox();
    private final static JCheckBox c160 = new JCheckBox();
    private final static JCheckBox c161 = new JCheckBox("Other Violations Noted - Use box below to describe");
    
    public static JButton b1 = new JButton("SUBMIT");
    
    private final static JLabel l1 = new JLabel("Business Name:");
    private final static JLabel l2 = new JLabel("Phone:");
    private final static JLabel l3 = new JLabel("Address:");
    private final static JLabel l4 = new JLabel("Emergency Contact Information:");
    private final static JLabel l5 = new JLabel("Name:");
    private final static JLabel l6 = new JLabel("Contact Type:");
    private final static JLabel l7 = new JLabel("Number:");
    private final static JLabel l8 = new JLabel("Type of Phone:");
    private final static JLabel l9 = new JLabel("Occupancy Class:");
    private final static JLabel l10 = new JLabel("Hazard Classification:");
    private final static JLabel l11 = new JLabel("District:");
    private final static JLabel l12 = new JLabel("PFA#:");
    private final static JLabel l13 = new JLabel("Fire Alarm Panel:");
    private final static JLabel l14 = new JLabel("Active:");
    private final static JLabel l15 = new JLabel("P");
    private final static JLabel l16 = new JLabel("F");
    private final static JLabel l17 = new JLabel("N/A");
    private final static JLabel l18 = new JLabel("Sys Normal:");
    private final static JLabel l19 = new JLabel("P");
    private final static JLabel l20 = new JLabel("F");
    private final static JLabel l21 = new JLabel("N/A");
    private final static JLabel l22 = new JLabel("Panel/Pad Location:");
    private final static JLabel l23 = new JLabel("Inspection Narrative");
    private final static JLabel l24 = new JLabel("1st Inspection:");
    private final static JLabel l25 = new JLabel("2nd Inspection:");
    private final static JLabel l26 = new JLabel("3rd Inspection:");
    private final static JLabel l27 = new JLabel("4th Inspection:");
    private final static JLabel l28 = new JLabel("1.       EXIT DOORS/EXIT WAYS:");
    private final static JLabel l29 = new JLabel("P");
    private final static JLabel l30 = new JLabel("F");
    private final static JLabel l31 = new JLabel("N/A");
    private final static JLabel l32 = new JLabel("2.       EXIT SIGNS/EMER. LIGHTS:");
    private final static JLabel l33 = new JLabel("P");
    private final static JLabel l34 = new JLabel("F");
    private final static JLabel l35 = new JLabel("N/A");
    private final static JLabel l36 = new JLabel("3.       FIRE DOORS:");
    private final static JLabel l37 = new JLabel("P");
    private final static JLabel l38 = new JLabel("F");
    private final static JLabel l39 = new JLabel("N/A");
    private final static JLabel l40 = new JLabel("4.       FIRE EXTINGUISHERS:");
    private final static JLabel l41 = new JLabel("P");
    private final static JLabel l42 = new JLabel("F");
    private final static JLabel l43 = new JLabel("N/A");
    private final static JLabel l44 = new JLabel("5.       ELECTRICAL:");
    private final static JLabel l45 = new JLabel("P");
    private final static JLabel l46 = new JLabel("F");
    private final static JLabel l47 = new JLabel("N/A");
    private final static JLabel l48 = new JLabel("6.       STORAGE:");
    private final static JLabel l49 = new JLabel("P");
    private final static JLabel l50 = new JLabel("F");
    private final static JLabel l51 = new JLabel("N/A");
    private final static JLabel l52 = new JLabel("7.       FLAMMABLE/COMB.:");
    private final static JLabel l53 = new JLabel("P");
    private final static JLabel l54 = new JLabel("F");
    private final static JLabel l55 = new JLabel("N/A");
    private final static JLabel l56 = new JLabel("8.       COMPRESSED GASES:");
    private final static JLabel l57 = new JLabel("P");
    private final static JLabel l58 = new JLabel("F");
    private final static JLabel l59 = new JLabel("N/A");
    private final static JLabel l60 = new JLabel("9.       SPRAY FINISHING OPER.:");
    private final static JLabel l61 = new JLabel("P");
    private final static JLabel l62 = new JLabel("F");
    private final static JLabel l63 = new JLabel("N/A");
    private final static JLabel l64 = new JLabel("10.      SPRINKLER/STANDPIPE:");
    private final static JLabel l65 = new JLabel("P");
    private final static JLabel l66 = new JLabel("F");
    private final static JLabel l67 = new JLabel("N/A");
    private final static JLabel l68 = new JLabel("Date of last service");
    private final static JLabel l69 = new JLabel("Riser Location");
    private final static JLabel l70 = new JLabel("11.      HOOD EXT. SYSTEM:");
    private final static JLabel l71 = new JLabel("P");
    private final static JLabel l72 = new JLabel("F");
    private final static JLabel l73 = new JLabel("N/A");
    private final static JLabel l74 = new JLabel("Last service date");
    private final static JLabel l75 = new JLabel("12.      OCCUPANT LOAD:");
    private final static JLabel l76 = new JLabel("P");
    private final static JLabel l77 = new JLabel("F");
    private final static JLabel l78 = new JLabel("N/A");
    private final static JLabel l79 = new JLabel("13.      ADDRESS:");
    private final static JLabel l80 = new JLabel("P");
    private final static JLabel l81 = new JLabel("F");
    private final static JLabel l82 = new JLabel("N/A");
    private final static JLabel l83 = new JLabel("14.      FIRE DEPT. ACCESS:");
    private final static JLabel l84 = new JLabel("P");
    private final static JLabel l85 = new JLabel("F");
    private final static JLabel l86 = new JLabel("N/A");
    private final static JLabel l87 = new JLabel("Knox box location");
    private final static JLabel l88 = new JLabel("15.     FIRE DEPT. CONNECTION:");
    private final static JLabel l89 = new JLabel("P");
    private final static JLabel l90 = new JLabel("F");
    private final static JLabel l91 = new JLabel("N/A");
    private final static JLabel l92 = new JLabel("FDC Location");
    private final static JLabel l93 = new JLabel("16.      ELEVATOR:");
    private final static JLabel l94 = new JLabel("P");
    private final static JLabel l95 = new JLabel("F");
    private final static JLabel l96 = new JLabel("N/A");
    private final static JLabel l97 = new JLabel("17.      PROPANE:");
    private final static JLabel l98 = new JLabel("P");
    private final static JLabel l99 = new JLabel("F");
    private final static JLabel l100 = new JLabel("N/A");
    private final static JLabel l101 = new JLabel("18.      OTHER:");
    private final static JLabel l102 = new JLabel("P");
    private final static JLabel l103 = new JLabel("F");
    private final static JLabel l104 = new JLabel("N/A");
    private final static JLabel l105 = new JLabel("ADDITIONAL VIOLATIONS/COMMENTS:");
    private final static JLabel l106 = new JLabel("Date of Report:");
    private final static JLabel l107 = new JLabel("Inspector:");
    private final static JLabel l108 = new JLabel("Responsible Signature:");
    private final static JLabel l109 = new JLabel();
    private final static JLabel l110 = new JLabel("P = Pass");
    private final static JLabel l111 = new JLabel("F = Fail");
    private final static JLabel l112 = new JLabel("N/A = Not Applicable");
    
    public static void addComponentsToPane(JPanel pane) {
    
    pane.setLayout(null);
   
    pane.add(l1);
    pane.add(l2);
    pane.add(l3);
    pane.add(l4);
    pane.add(l5);
    pane.add(l6);
    pane.add(l7);
    pane.add(l8);
    pane.add(l9);
    pane.add(l10);
    pane.add(l11);
    pane.add(l12);
    pane.add(l13);
    pane.add(l14);
    pane.add(l15);
    pane.add(l16);
    pane.add(l17);
    pane.add(l18);
    pane.add(l19);
    pane.add(l20);
    pane.add(l21);
    pane.add(l22);
    pane.add(l23);
    pane.add(l24);
    pane.add(l25);
    pane.add(l26);
    pane.add(l27);
    pane.add(l28);
    pane.add(l29);
    pane.add(l30);
    pane.add(l31);
    pane.add(l32);
    pane.add(l33);
    pane.add(l34);
    pane.add(l35);
    pane.add(l36);
    pane.add(l37);
    pane.add(l38);
    pane.add(l39);
    pane.add(l40);
    pane.add(l41);
    pane.add(l42);
    pane.add(l43);
    pane.add(l44);
    pane.add(l45);
    pane.add(l46);
    pane.add(l47);
    pane.add(l48);
    pane.add(l49);
    pane.add(l50);
    pane.add(l51);
    pane.add(l52);
    pane.add(l53);
    pane.add(l54);
    pane.add(l55);
    pane.add(l56);
    pane.add(l57);
    pane.add(l58);
    pane.add(l59);
    pane.add(l60);
    pane.add(l61);
    pane.add(l62);
    pane.add(l63);
    pane.add(l64);
    pane.add(l65);
    pane.add(l66);
    pane.add(l67);
    pane.add(l68);
    pane.add(l69);
    pane.add(l70);
    pane.add(l71);
    pane.add(l72);
    pane.add(l73);
    pane.add(l74);
    pane.add(l75);
    pane.add(l76);
    pane.add(l77);
    pane.add(l78);
    pane.add(l79);
    pane.add(l80);
    pane.add(l81);
    pane.add(l82);
    pane.add(l83);
    pane.add(l84);
    pane.add(l85);
    pane.add(l86);
    pane.add(l87);
    pane.add(l88);
    pane.add(l89);
    pane.add(l90);
    pane.add(l91);
    pane.add(l92);
    pane.add(l93);
    pane.add(l94);
    pane.add(l95);
    pane.add(l96);
    pane.add(l97);
    pane.add(l98);
    pane.add(l99);
    pane.add(l100);
    pane.add(l101);
    pane.add(l102);
    pane.add(l103);
    pane.add(l104);
    pane.add(l105);
    pane.add(l106);
    pane.add(l107);
    pane.add(l108);
    pane.add(l109);
    pane.add(l110);
    pane.add(l111);
    pane.add(l112);
    
    pane.add(t1);
    pane.add(t2);
    pane.add(t3);
    pane.add(t4);
    pane.add(t5);
    pane.add(t6);
    pane.add(t7);
    pane.add(t8);
    pane.add(t9);
    pane.add(t10);
    pane.add(t11);
    pane.add(t12);
    pane.add(t13);
    pane.add(t14);
    pane.add(t15);
    pane.add(t16);
    pane.add(t17);
    pane.add(t18);
    pane.add(t19);
    pane.add(t20);
    pane.add(t21);
    pane.add(t22);
    pane.add(t23);
    pane.add(t24);
    pane.add(t25);
    pane.add(t26);
    pane.add(t27);
    pane.add(t28);
    pane.add(t29);
    pane.add(t30);
    
    pane.add(c1);
    pane.add(c2);
    pane.add(c3);
    pane.add(c4);
    pane.add(c5);
    pane.add(c6);
    pane.add(c7);
    pane.add(c8);
    pane.add(c9);
    pane.add(c10);
    pane.add(c11);
    pane.add(c12);
    pane.add(c13);
    pane.add(c14);
    pane.add(c15);
    pane.add(c16);
    pane.add(c17);
    pane.add(c18);
    pane.add(c19);
    pane.add(c20);
    pane.add(c21);
    pane.add(c22);
    pane.add(c23);
    pane.add(c24);
    pane.add(c25);
    pane.add(c26);
    pane.add(c27);
    pane.add(c28);
    pane.add(c29);
    pane.add(c30);
    pane.add(c31);
    pane.add(c32);
    pane.add(c33);
    pane.add(c34);
    pane.add(c35);
    pane.add(c36);
    pane.add(c37);
    pane.add(c38);
    pane.add(c39);
    pane.add(c40);
    pane.add(c41);
    pane.add(c42);
    pane.add(c43);
    pane.add(c44);
    pane.add(c45);
    pane.add(c46);
    pane.add(c47);
    pane.add(c48);
    pane.add(c49);
    pane.add(c50);
    pane.add(c51);
    pane.add(c52);
    pane.add(c53);
    pane.add(c54);
    pane.add(c55);
    pane.add(c56);
    pane.add(c57);
    pane.add(c58);
    pane.add(c59);
    pane.add(c60);
    pane.add(c61);
    pane.add(c62);
    pane.add(c63);
    pane.add(c64);
    pane.add(c65);
    pane.add(c66);
    pane.add(c67);
    pane.add(c68);
    pane.add(c69);
    pane.add(c70);
    pane.add(c71);
    pane.add(c72);
    pane.add(c73);
    pane.add(c74);
    pane.add(c75);
    pane.add(c76);
    pane.add(c77);
    pane.add(c78);
    pane.add(c79);
    pane.add(c80);
    pane.add(c81);
    pane.add(c82);
    pane.add(c83);
    pane.add(c84);
    pane.add(c85);
    pane.add(c86);
    pane.add(c87);
    pane.add(c88);
    pane.add(c89);
    pane.add(c90);
    pane.add(c91);
    pane.add(c92);
    pane.add(c93);
    pane.add(c94);
    pane.add(c95);
    pane.add(c96);
    pane.add(c97);
    pane.add(c98);
    pane.add(c99);
    pane.add(c100);
    pane.add(c101);
    pane.add(c102);
    pane.add(c103);
    pane.add(c104);
    pane.add(c105);
    pane.add(c106);
    pane.add(c107);
    pane.add(c108);
    pane.add(c109);
    pane.add(c110);
    pane.add(c111);
    pane.add(c112);
    pane.add(c113);
    pane.add(c114);
    pane.add(c115);
    pane.add(c116);
    pane.add(c117);
    pane.add(c118);
    pane.add(c119);
    pane.add(c120);
    pane.add(c121);
    pane.add(c122);
    pane.add(c123);
    pane.add(c124);
    pane.add(c125);
    pane.add(c126);
    pane.add(c127);
    pane.add(c128);
    pane.add(c129);
    pane.add(c130);
    pane.add(c131);
    pane.add(c132);
    pane.add(c133);
    pane.add(c134);
    pane.add(c135);
    pane.add(c136);
    pane.add(c137);
    pane.add(c138);
    pane.add(c139);
    pane.add(c140);
    pane.add(c141);
    pane.add(c142);
    pane.add(c143);
    pane.add(c144);
    pane.add(c145);
    pane.add(c146);
    pane.add(c147);
    pane.add(c148);
    pane.add(c149);
    pane.add(c150);
    pane.add(c151);
    pane.add(c152);
    pane.add(c153);
    pane.add(c154);
    pane.add(c155);
    pane.add(c156);
    pane.add(c157);
    pane.add(c158);
    pane.add(c159);
    pane.add(c160);
    pane.add(c161);
    
    pane.add(b1);

    Insets insets = pane.getInsets();
    Font font = new Font( "SansSerif", Font.BOLD, 20 );
    Dimension size = t2.getPreferredSize();
    t2.setBounds(175 + insets.left, 150 + insets.top, size.width + 100, size.height + 20);
    
    size = l2.getPreferredSize();
    l2
        .setBounds(175 + insets.left, 115 + insets.top, size.width + 100,
            size.height + 20);
    
    size = l3.getPreferredSize();
    l3.setBounds(175 + insets.left, 215 + insets.top, size.width + 150,
        size.height + 20);
    
    size = l1.getPreferredSize();
    l1.setBounds(175 + insets.left, 15 + insets.top, size.width + 50,
        size.height + 20);
    
    size = t1.getPreferredSize();
    t1.setBounds(175 + insets.left, 50 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t3.getPreferredSize();
    t3.setBounds(175 + insets.left, 250 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l4.getPreferredSize();
    l4
        .setBounds(175 + insets.left, 315 + insets.top, size.width + 300,
            size.height + 20);
    l4.setFont(font);
    
    size = l5.getPreferredSize();
    l5
        .setBounds(175 + insets.left, 360 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t4.getPreferredSize();
    t4.setBounds(175 + insets.left, 390 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l6.getPreferredSize();
    l6
        .setBounds(175 + insets.left, 450 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t5.getPreferredSize();
    t5.setBounds(175 + insets.left, 480 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l7.getPreferredSize();
    l7
        .setBounds(175 + insets.left, 540 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t6.getPreferredSize();
    t6.setBounds(175 + insets.left, 570 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l8.getPreferredSize();
    l8
        .setBounds(175 + insets.left, 630 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t7.getPreferredSize();
    t7.setBounds(175 + insets.left, 660 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l9.getPreferredSize();
    l9
        .setBounds(175 + insets.left, 720 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t8.getPreferredSize();
    t8.setBounds(175 + insets.left, 750 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l10.getPreferredSize();
    l10
        .setBounds(175 + insets.left, 810 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t9.getPreferredSize();
    t9.setBounds(175 + insets.left, 840 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l11.getPreferredSize();
    l11
        .setBounds(175 + insets.left, 900 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t10.getPreferredSize();
    t10.setBounds(175 + insets.left, 930 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l12.getPreferredSize();
    l12
        .setBounds(175 + insets.left, 990 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t11.getPreferredSize();
    t11.setBounds(175 + insets.left, 1020 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l13.getPreferredSize();
    l13.setBounds(175 + insets.left, 1080 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t12.getPreferredSize();
    t12.setBounds(175 + insets.left, 1110 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l14.getPreferredSize();
    l14.setBounds(175 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    Font cBFont = new Font( "SansSerif", Font.BOLD, 16 );
    l14.setFont(cBFont);
    
    size = l15.getPreferredSize();
    l15.setBounds(270 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l15.setFont(cBFont);
    
    size = l16.getPreferredSize();
    l16.setBounds(320 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l16.setFont(cBFont);
    
    size = l17.getPreferredSize();
    l17.setBounds(360 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l17.setFont(cBFont);
    
    size = l18.getPreferredSize();
    l18.setBounds(475 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l18.setFont(cBFont);
    
    size = l19.getPreferredSize();
    l19.setBounds(600 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l19.setFont(cBFont);
    
    size = l20.getPreferredSize();
    l20.setBounds(640 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l20.setFont(cBFont);
    
    size = l21.getPreferredSize();
    l21.setBounds(680 + insets.left, 1170 + insets.top, size.width + 100,
        size.height + 20);
    l21.setFont(cBFont);
    
    size = c1.getPreferredSize();
    c1.setBounds(270 + insets.left, 1200 + insets.top, size.width + 20,
        size.height + 20);
    c1.setFont(cBFont);
    
    size = c2.getPreferredSize();
    c2.setBounds(320 + insets.left, 1200 + insets.top, size.width + 20,
        size.height + 20);
    c2.setFont(cBFont);
    
    size = c3.getPreferredSize();
    c3.setBounds(360 + insets.left, 1200 + insets.top, size.width + 20,
        size.height + 20);
    c3.setFont(cBFont);
    
    size = c4.getPreferredSize();
    c4.setBounds(600 + insets.left, 1200 + insets.top, size.width + 20,
        size.height + 20);
    c4.setFont(cBFont);
    
    size = c5.getPreferredSize();
    c5.setBounds(640 + insets.left, 1200 + insets.top, size.width + 20,
        size.height + 20);
    c5.setFont(cBFont);
    
    size = c6.getPreferredSize();
    c6.setBounds(680 + insets.left, 1200 + insets.top, size.width + 20,
        size.height + 20);
    c6.setFont(cBFont);
    
    size = l22.getPreferredSize();
    l22.setBounds(175 + insets.left, 1240 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t13.getPreferredSize();
    t13.setBounds(175 + insets.left, 1270 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l23.getPreferredSize();
    l23.setBounds(175 + insets.left, 1330 + insets.top, size.width + 100,
        size.height + 20);
    l23.setFont(font);
    
    size = c7.getPreferredSize();
    c7.setBounds(175 + insets.left, 1360 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c8.getPreferredSize();
    c8.setBounds(175 + insets.left, 1390 + insets.top, size.width + 20,
        size.height + 20);
    
    size = l24.getPreferredSize();
    l24.setBounds(175 + insets.left, 1450 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t14.getPreferredSize();
    t14.setBounds(175 + insets.left, 1480 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l25.getPreferredSize();
    l25.setBounds(175 + insets.left, 1540 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t15.getPreferredSize();
    t15.setBounds(175 + insets.left, 1570 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l26.getPreferredSize();
    l26.setBounds(175 + insets.left, 1630 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t16.getPreferredSize();
    t16.setBounds(175 + insets.left, 1660 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l27.getPreferredSize();
    l27.setBounds(175 + insets.left, 1720 + insets.top, size.width + 100,
        size.height + 20);
    
    size = t17.getPreferredSize();
    t17.setBounds(175 + insets.left, 1750 + insets.top, size.width + 100,
        size.height + 20);
    ////
    size = l110.getPreferredSize();
    l110.setBounds(600 + insets.left, 1810 + insets.top, size.width + 100,
        size.height + 20);
    l110.setFont(cBFont);
    size = l111.getPreferredSize();
    l111.setBounds(600 + insets.left, 1830 + insets.top, size.width + 100,
        size.height + 20);
    l111.setFont(cBFont);
    size = l112.getPreferredSize();
    l112.setBounds(600 + insets.left, 1850 + insets.top, size.width + 100,
        size.height + 20);
    l112.setFont(cBFont);
    ////////////////////////////////////////////////////////////////////////////
    size = l28.getPreferredSize();
    l28.setBounds(175 + insets.left, 1810 + insets.top, size.width + 100,
        size.height + 20);
    l28.setFont(cBFont);
    
    size = l29.getPreferredSize();
    l29.setBounds(270 + insets.left, 1840 + insets.top, size.width + 100,
        size.height + 20);
    l29.setFont(cBFont);
    
    size = l30.getPreferredSize();
    l30.setBounds(320 + insets.left, 1840 + insets.top, size.width + 100,
        size.height + 20);
    l30.setFont(cBFont);
    
    size = l31.getPreferredSize();
    l31.setBounds(360 + insets.left, 1840 + insets.top, size.width + 100,
        size.height + 20);
    l31.setFont(cBFont);
    
    size = c9.getPreferredSize();
    c9.setBounds(270 + insets.left, 1870 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c10.getPreferredSize();
    c10.setBounds(320 + insets.left, 1870 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c11.getPreferredSize();
    c11.setBounds(360 + insets.left, 1870 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c12.getPreferredSize();
    c12.setBounds(270 + insets.left, 1900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c13.getPreferredSize();
    c13.setBounds(320 + insets.left, 1900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c14.getPreferredSize();
    c14.setBounds(360 + insets.left, 1900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = l32.getPreferredSize();
    l32.setBounds(175 + insets.left, 1960 + insets.top, size.width + 100,
        size.height + 20);
    l32.setFont(cBFont);
    
    size = l33.getPreferredSize();
    l33.setBounds(270 + insets.left, 1990 + insets.top, size.width + 100,
        size.height + 20);
    l33.setFont(cBFont);
    
    size = l34.getPreferredSize();
    l34.setBounds(320 + insets.left, 1990 + insets.top, size.width + 100,
        size.height + 20);
    l34.setFont(cBFont);
    
    size = l35.getPreferredSize();
    l35.setBounds(360 + insets.left, 1990 + insets.top, size.width + 100,
        size.height + 20);
    l35.setFont(cBFont);
    
    size = c15.getPreferredSize();
    c15.setBounds(270 + insets.left, 2020 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c16.getPreferredSize();
    c16.setBounds(320 + insets.left, 2020 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c17.getPreferredSize();
    c17.setBounds(360 + insets.left, 2020 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c18.getPreferredSize();
    c18.setBounds(270 + insets.left, 2050 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c19.getPreferredSize();
    c19.setBounds(320 + insets.left, 2050 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c20.getPreferredSize();
    c20.setBounds(360 + insets.left, 2050 + insets.top, size.width + 20,
        size.height + 20);
    
    size = l36.getPreferredSize();
    l36.setBounds(175 + insets.left, 2110 + insets.top, size.width + 100,
        size.height + 20);
    l36.setFont(cBFont);
    
    size = l37.getPreferredSize();
    l37.setBounds(270 + insets.left, 2140 + insets.top, size.width + 100,
        size.height + 20);
    l37.setFont(cBFont);
    
    size = l38.getPreferredSize();
    l38.setBounds(320 + insets.left, 2140 + insets.top, size.width + 100,
        size.height + 20);
    l38.setFont(cBFont);
    
    size = l39.getPreferredSize();
    l39.setBounds(360 + insets.left, 2140 + insets.top, size.width + 100,
        size.height + 20);
    l39.setFont(cBFont);
    
    size = c21.getPreferredSize();
    c21.setBounds(270 + insets.left, 2170 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c22.getPreferredSize();
    c22.setBounds(320 + insets.left, 2170 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c23.getPreferredSize();
    c23.setBounds(360 + insets.left, 2170 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c24.getPreferredSize();
    c24.setBounds(270 + insets.left, 2200 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c25.getPreferredSize();
    c25.setBounds(320 + insets.left, 2200 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c26.getPreferredSize();
    c26.setBounds(360 + insets.left, 2200 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c27.getPreferredSize();
    c27.setBounds(270 + insets.left, 2230 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c28.getPreferredSize();
    c28.setBounds(320 + insets.left, 2230 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c29.getPreferredSize();
    c29.setBounds(360 + insets.left, 2230 + insets.top, size.width + 20,
        size.height + 20);
    
    size = l40.getPreferredSize();
    l40.setBounds(175 + insets.left, 2290 + insets.top, size.width + 100,
        size.height + 20);
    l40.setFont(cBFont);
    
    size = l41.getPreferredSize();
    l41.setBounds(270 + insets.left, 2320 + insets.top, size.width + 100,
        size.height + 20);
    l41.setFont(cBFont);
    
    size = l42.getPreferredSize();
    l42.setBounds(320 + insets.left, 2320 + insets.top, size.width + 100,
        size.height + 20);
    l42.setFont(cBFont);
    
    size = l43.getPreferredSize();
    l43.setBounds(360 + insets.left, 2320 + insets.top, size.width + 100,
        size.height + 20);
    l43.setFont(cBFont);
    
    size = c30.getPreferredSize();
    c30.setBounds(270 + insets.left, 2350 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c31.getPreferredSize();
    c31.setBounds(320 + insets.left, 2350 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c32.getPreferredSize();
    c32.setBounds(360 + insets.left, 2350 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c33.getPreferredSize();
    c33.setBounds(270 + insets.left, 2380 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c34.getPreferredSize();
    c34.setBounds(320 + insets.left, 2380 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c35.getPreferredSize();
    c35.setBounds(360 + insets.left, 2380 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c36.getPreferredSize();
    c36.setBounds(270 + insets.left, 2410 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c37.getPreferredSize();
    c37.setBounds(320 + insets.left, 2410 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c38.getPreferredSize();
    c38.setBounds(360 + insets.left, 2410 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c39.getPreferredSize();
    c39.setBounds(270 + insets.left, 2440 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c40.getPreferredSize();
    c40.setBounds(320 + insets.left, 2440 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c41.getPreferredSize();
    c41.setBounds(360 + insets.left, 2440 + insets.top, size.width + 20,
        size.height + 20);
    ///
    size = l44.getPreferredSize();
    l44.setBounds(175 + insets.left, 2500 + insets.top, size.width + 100,
        size.height + 20);
    l44.setFont(cBFont);
    
    size = l45.getPreferredSize();
    l45.setBounds(270 + insets.left, 2530 + insets.top, size.width + 100,
        size.height + 20);
    l45.setFont(cBFont);
    
    size = l46.getPreferredSize();
    l46.setBounds(320 + insets.left, 2530 + insets.top, size.width + 100,
        size.height + 20);
    l46.setFont(cBFont);
    
    size = l47.getPreferredSize();
    l47.setBounds(360 + insets.left, 2530 + insets.top, size.width + 100,
        size.height + 20);
    l47.setFont(cBFont);
    
    size = c42.getPreferredSize();
    c42.setBounds(270 + insets.left, 2560 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c43.getPreferredSize();
    c43.setBounds(320 + insets.left, 2560 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c44.getPreferredSize();
    c44.setBounds(360 + insets.left, 2560 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c45.getPreferredSize();
    c45.setBounds(270 + insets.left, 2590 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c46.getPreferredSize();
    c46.setBounds(320 + insets.left, 2590 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c47.getPreferredSize();
    c47.setBounds(360 + insets.left, 2590 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c48.getPreferredSize();
    c48.setBounds(270 + insets.left, 2620 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c49.getPreferredSize();
    c49.setBounds(320 + insets.left, 2620 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c50.getPreferredSize();
    c50.setBounds(360 + insets.left, 2620 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c51.getPreferredSize();
    c51.setBounds(270 + insets.left, 2650 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c52.getPreferredSize();
    c52.setBounds(320 + insets.left, 2650 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c53.getPreferredSize();
    c53.setBounds(360 + insets.left, 2650 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c54.getPreferredSize();
    c54.setBounds(270 + insets.left, 2680 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c55.getPreferredSize();
    c55.setBounds(320 + insets.left, 2680 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c56.getPreferredSize();
    c56.setBounds(360 + insets.left, 2680 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////////
    size = l48.getPreferredSize();
    l48.setBounds(175 + insets.left, 2740 + insets.top, size.width + 100,
        size.height + 20);
    l48.setFont(cBFont);
    
    size = l49.getPreferredSize();
    l49.setBounds(270 + insets.left, 2770 + insets.top, size.width + 100,
        size.height + 20);
    l49.setFont(cBFont);
    
    size = l50.getPreferredSize();
    l50.setBounds(320 + insets.left, 2770 + insets.top, size.width + 100,
        size.height + 20);
    l50.setFont(cBFont);
    
    size = l51.getPreferredSize();
    l51.setBounds(360 + insets.left, 2770 + insets.top, size.width + 100,
        size.height + 20);
    l51.setFont(cBFont);
    
    size = c57.getPreferredSize();
    c57.setBounds(270 + insets.left, 2800 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c58.getPreferredSize();
    c58.setBounds(320 + insets.left, 2800 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c59.getPreferredSize();
    c59.setBounds(360 + insets.left, 2800 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c60.getPreferredSize();
    c60.setBounds(270 + insets.left, 2830 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c61.getPreferredSize();
    c61.setBounds(320 + insets.left, 2830 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c62.getPreferredSize();
    c62.setBounds(360 + insets.left, 2830 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c63.getPreferredSize();
    c63.setBounds(270 + insets.left, 2860 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c64.getPreferredSize();
    c64.setBounds(320 + insets.left, 2860 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c65.getPreferredSize();
    c65.setBounds(360 + insets.left, 2860 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c66.getPreferredSize();
    c66.setBounds(270 + insets.left, 2890 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c67.getPreferredSize();
    c67.setBounds(320 + insets.left, 2890 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c68.getPreferredSize();
    c68.setBounds(360 + insets.left, 2890 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c69.getPreferredSize();
    c69.setBounds(270 + insets.left, 2920 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c70.getPreferredSize();
    c70.setBounds(320 + insets.left, 2920 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c71.getPreferredSize();
    c71.setBounds(360 + insets.left, 2920 + insets.top, size.width + 20,
        size.height + 20);
    /////////////////////////////////////////////////////////////////////////////
    size = l52.getPreferredSize();
    l52.setBounds(175 + insets.left, 2980 + insets.top, size.width + 100,
        size.height + 20);
    l52.setFont(cBFont);
    
    size = l53.getPreferredSize();
    l53.setBounds(270 + insets.left, 3010 + insets.top, size.width + 100,
        size.height + 20);
    l53.setFont(cBFont);
    
    size = l54.getPreferredSize();
    l54.setBounds(320 + insets.left, 3010 + insets.top, size.width + 100,
        size.height + 20);
    l54.setFont(cBFont);
    
    size = l55.getPreferredSize();
    l55.setBounds(360 + insets.left, 3010 + insets.top, size.width + 100,
        size.height + 20);
    l55.setFont(cBFont);
    
    size = c72.getPreferredSize();
    c72.setBounds(270 + insets.left, 3040 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c73.getPreferredSize();
    c73.setBounds(320 + insets.left, 3040 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c74.getPreferredSize();
    c74.setBounds(360 + insets.left, 3040 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c75.getPreferredSize();
    c75.setBounds(270 + insets.left, 3070 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c76.getPreferredSize();
    c76.setBounds(320 + insets.left, 3070 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c77.getPreferredSize();
    c77.setBounds(360 + insets.left, 3070 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c78.getPreferredSize();
    c78.setBounds(270 + insets.left, 3100 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c79.getPreferredSize();
    c79.setBounds(320 + insets.left, 3100 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c80.getPreferredSize();
    c80.setBounds(360 + insets.left, 3100 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l56.getPreferredSize();
    l56.setBounds(175 + insets.left, 3160 + insets.top, size.width + 100,
        size.height + 20);
    l56.setFont(cBFont);
    
    size = l57.getPreferredSize();
    l57.setBounds(270 + insets.left, 3190 + insets.top, size.width + 100,
        size.height + 20);
    l57.setFont(cBFont);
    
    size = l58.getPreferredSize();
    l58.setBounds(320 + insets.left, 3190 + insets.top, size.width + 100,
        size.height + 20);
    l58.setFont(cBFont);
    
    size = l59.getPreferredSize();
    l59.setBounds(360 + insets.left, 3190 + insets.top, size.width + 100,
        size.height + 20);
    l59.setFont(cBFont);
    
    size = c81.getPreferredSize();
    c81.setBounds(270 + insets.left, 3220 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c82.getPreferredSize();
    c82.setBounds(320 + insets.left, 3220 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c83.getPreferredSize();
    c83.setBounds(360 + insets.left, 3220 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l60.getPreferredSize();
    l60.setBounds(175 + insets.left, 3280 + insets.top, size.width + 100,
        size.height + 20);
    l60.setFont(cBFont);
    
    size = l61.getPreferredSize();
    l61.setBounds(270 + insets.left, 3310 + insets.top, size.width + 100,
        size.height + 20);
    l61.setFont(cBFont);
    
    size = l62.getPreferredSize();
    l62.setBounds(320 + insets.left, 3310 + insets.top, size.width + 100,
        size.height + 20);
    l62.setFont(cBFont);
    
    size = l63.getPreferredSize();
    l63.setBounds(360 + insets.left, 3310 + insets.top, size.width + 100,
        size.height + 20);
    l63.setFont(cBFont);
    
    size = c84.getPreferredSize();
    c84.setBounds(270 + insets.left, 3340 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c85.getPreferredSize();
    c85.setBounds(320 + insets.left, 3340 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c86.getPreferredSize();
    c86.setBounds(360 + insets.left, 3340 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c87.getPreferredSize();
    c87.setBounds(270 + insets.left, 3370 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c88.getPreferredSize();
    c88.setBounds(320 + insets.left, 3370 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c89.getPreferredSize();
    c89.setBounds(360 + insets.left, 3370 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c90.getPreferredSize();
    c90.setBounds(270 + insets.left, 3400 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c91.getPreferredSize();
    c91.setBounds(320 + insets.left, 3400 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c92.getPreferredSize();
    c92.setBounds(360 + insets.left, 3400 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c93.getPreferredSize();
    c93.setBounds(270 + insets.left, 3430 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c94.getPreferredSize();
    c94.setBounds(320 + insets.left, 3430 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c95.getPreferredSize();
    c95.setBounds(360 + insets.left, 3430 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l64.getPreferredSize();
    l64.setBounds(175 + insets.left, 3490 + insets.top, size.width + 100,
        size.height + 20);
    l64.setFont(cBFont);
    
    size = l65.getPreferredSize();
    l65.setBounds(270 + insets.left, 3520 + insets.top, size.width + 100,
        size.height + 20);
    l65.setFont(cBFont);
    
    size = l66.getPreferredSize();
    l66.setBounds(320 + insets.left, 3520 + insets.top, size.width + 100,
        size.height + 20);
    l66.setFont(cBFont);
    
    size = l67.getPreferredSize();
    l67.setBounds(360 + insets.left, 3520 + insets.top, size.width + 100,
        size.height + 20);
    l67.setFont(cBFont);
    
    size = c96.getPreferredSize();
    c96.setBounds(270 + insets.left, 3550 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c97.getPreferredSize();
    c97.setBounds(320 + insets.left, 3550 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c98.getPreferredSize();
    c98.setBounds(360 + insets.left, 3550 + insets.top, size.width + 20,
        size.height + 20);
    
    size = t22.getPreferredSize();
    t22.setBounds(270 + insets.left, 3590 + insets.top, size.width + 40,
        size.height + 5);
    
    size = l68.getPreferredSize();
    l68
        .setBounds(380 + insets.left, 3585 + insets.top, size.width + 300,
            size.height + 20);
    
    size = c99.getPreferredSize();
    c99.setBounds(270 + insets.left, 3610 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c100.getPreferredSize();
    c100.setBounds(320 + insets.left, 3610 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c101.getPreferredSize();
    c101.setBounds(360 + insets.left, 3610 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c102.getPreferredSize();
    c102.setBounds(270 + insets.left, 3640 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c103.getPreferredSize();
    c103.setBounds(320 + insets.left, 3640 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c104.getPreferredSize();
    c104.setBounds(360 + insets.left, 3640 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c105.getPreferredSize();
    c105.setBounds(270 + insets.left, 3670 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c106.getPreferredSize();
    c106.setBounds(320 + insets.left, 3670 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c107.getPreferredSize();
    c107.setBounds(360 + insets.left, 3670 + insets.top, size.width + 20,
        size.height + 20);
    
    size = t23.getPreferredSize();
    t23.setBounds(270 + insets.left, 3710 + insets.top, size.width + 40,
        size.height + 5);
    
    size = l69.getPreferredSize();
    l69
        .setBounds(380 + insets.left, 3705 + insets.top, size.width + 300,
            size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l70.getPreferredSize();
    l70.setBounds(175 + insets.left, 3770 + insets.top, size.width + 100,
        size.height + 20);
    l70.setFont(cBFont);
    
    size = l71.getPreferredSize();
    l71.setBounds(270 + insets.left, 3800 + insets.top, size.width + 100,
        size.height + 20);
    l71.setFont(cBFont);
    
    size = l72.getPreferredSize();
    l72.setBounds(320 + insets.left, 3800 + insets.top, size.width + 100,
        size.height + 20);
    l72.setFont(cBFont);
    
    size = l73.getPreferredSize();
    l73.setBounds(360 + insets.left, 3800 + insets.top, size.width + 100,
        size.height + 20);
    l73.setFont(cBFont);
    
    size = c108.getPreferredSize();
    c108.setBounds(270 + insets.left, 3830 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c109.getPreferredSize();
    c109.setBounds(320 + insets.left, 3830 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c110.getPreferredSize();
    c110.setBounds(360 + insets.left, 3830 + insets.top, size.width + 20,
        size.height + 20);
    
    size = t24.getPreferredSize();
    t24.setBounds(270 + insets.left, 3870 + insets.top, size.width + 40,
        size.height + 5);
    
    size = l74.getPreferredSize();
    l74
        .setBounds(380 + insets.left, 3865 + insets.top, size.width + 300,
            size.height + 20);
    
    size = c111.getPreferredSize();
    c111.setBounds(270 + insets.left, 3900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c112.getPreferredSize();
    c112.setBounds(320 + insets.left, 3900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c113.getPreferredSize();
    c113.setBounds(360 + insets.left, 3900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c114.getPreferredSize();
    c114.setBounds(270 + insets.left, 3930 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c115.getPreferredSize();
    c115.setBounds(320 + insets.left, 3930 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c116.getPreferredSize();
    c116.setBounds(360 + insets.left, 3930 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c117.getPreferredSize();
    c117.setBounds(270 + insets.left, 3960 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c118.getPreferredSize();
    c118.setBounds(320 + insets.left, 3960 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c119.getPreferredSize();
    c119.setBounds(360 + insets.left, 3960 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c120.getPreferredSize();
    c120.setBounds(270 + insets.left, 3990 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c121.getPreferredSize();
    c121.setBounds(320 + insets.left, 3990 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c122.getPreferredSize();
    c122.setBounds(360 + insets.left, 3990 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c123.getPreferredSize();
    c123.setBounds(270 + insets.left, 4020 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c124.getPreferredSize();
    c124.setBounds(320 + insets.left, 4020 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c125.getPreferredSize();
    c125.setBounds(360 + insets.left, 4020 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l75.getPreferredSize();
    l75.setBounds(175 + insets.left, 4080 + insets.top, size.width + 100,
        size.height + 20);
    l75.setFont(cBFont);
    
    size = l76.getPreferredSize();
    l76.setBounds(270 + insets.left, 4110 + insets.top, size.width + 100,
        size.height + 20);
    l76.setFont(cBFont);
    
    size = l77.getPreferredSize();
    l77.setBounds(320 + insets.left, 4110 + insets.top, size.width + 100,
        size.height + 20);
    l77.setFont(cBFont);
    
    size = l78.getPreferredSize();
    l78.setBounds(360 + insets.left, 4110 + insets.top, size.width + 100,
        size.height + 20);
    l78.setFont(cBFont);
    
    size = c126.getPreferredSize();
    c126.setBounds(270 + insets.left, 4140 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c127.getPreferredSize();
    c127.setBounds(320 + insets.left, 4140 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c128.getPreferredSize();
    c128.setBounds(360 + insets.left, 4140 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l79.getPreferredSize();
    l79.setBounds(175 + insets.left, 4200 + insets.top, size.width + 100,
        size.height + 20);
    l79.setFont(cBFont);
    
    size = l80.getPreferredSize();
    l80.setBounds(270 + insets.left, 4230 + insets.top, size.width + 100,
        size.height + 20);
    l80.setFont(cBFont);
    
    size = l81.getPreferredSize();
    l81.setBounds(320 + insets.left, 4230 + insets.top, size.width + 100,
        size.height + 20);
    l81.setFont(cBFont);
    
    size = l82.getPreferredSize();
    l82.setBounds(360 + insets.left, 4230 + insets.top, size.width + 100,
        size.height + 20);
    l82.setFont(cBFont);
    
    size = c129.getPreferredSize();
    c129.setBounds(270 + insets.left, 4260 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c130.getPreferredSize();
    c130.setBounds(320 + insets.left, 4260 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c131.getPreferredSize();
    c131.setBounds(360 + insets.left, 4260 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l83.getPreferredSize();
    l83.setBounds(175 + insets.left, 4320 + insets.top, size.width + 100,
        size.height + 20);
    l83.setFont(cBFont);
    
    size = l84.getPreferredSize();
    l84.setBounds(270 + insets.left, 4350 + insets.top, size.width + 100,
        size.height + 20);
    l84.setFont(cBFont);
    
    size = l85.getPreferredSize();
    l85.setBounds(320 + insets.left, 4350 + insets.top, size.width + 100,
        size.height + 20);
    l85.setFont(cBFont);
    
    size = l86.getPreferredSize();
    l86.setBounds(360 + insets.left, 4350 + insets.top, size.width + 100,
        size.height + 20);
    l86.setFont(cBFont);
    
    size = c132.getPreferredSize();
    c132.setBounds(270 + insets.left, 4380 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c133.getPreferredSize();
    c133.setBounds(320 + insets.left, 4380 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c134.getPreferredSize();
    c134.setBounds(360 + insets.left, 4380 + insets.top, size.width + 20,
        size.height + 20);
    size = c135.getPreferredSize();
    c135.setBounds(270 + insets.left, 4410 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c136.getPreferredSize();
    c136.setBounds(320 + insets.left, 4410 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c137.getPreferredSize();
    c137.setBounds(360 + insets.left, 4410 + insets.top, size.width + 20,
        size.height + 20);
    
    size = t25.getPreferredSize();
    t25.setBounds(270 + insets.left, 4450 + insets.top, size.width + 40,
        size.height + 5);
    
    size = l87.getPreferredSize();
    l87
        .setBounds(380 + insets.left, 4445 + insets.top, size.width + 300,
            size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l88.getPreferredSize();
    l88.setBounds(175 + insets.left, 4510 + insets.top, size.width + 100,
        size.height + 20);
    l88.setFont(cBFont);
    
    size = l89.getPreferredSize();
    l89.setBounds(270 + insets.left, 4540 + insets.top, size.width + 100,
        size.height + 20);
    l89.setFont(cBFont);
    
    size = l90.getPreferredSize();
    l90.setBounds(320 + insets.left, 4540 + insets.top, size.width + 100,
        size.height + 20);
    l90.setFont(cBFont);
    
    size = l91.getPreferredSize();
    l91.setBounds(360 + insets.left, 4540 + insets.top, size.width + 100,
        size.height + 20);
    l91.setFont(cBFont);
    
    size = c138.getPreferredSize();
    c138.setBounds(270 + insets.left, 4570 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c139.getPreferredSize();
    c139.setBounds(320 + insets.left, 4570 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c140.getPreferredSize();
    c140.setBounds(360 + insets.left, 4570 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c141.getPreferredSize();
    c141.setBounds(270 + insets.left, 4600 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c142.getPreferredSize();
    c142.setBounds(320 + insets.left, 4600 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c143.getPreferredSize();
    c143.setBounds(360 + insets.left, 4600 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c144.getPreferredSize();
    c144.setBounds(270 + insets.left, 4630 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c145.getPreferredSize();
    c145.setBounds(320 + insets.left, 4630 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c146.getPreferredSize();
    c146.setBounds(360 + insets.left, 4630 + insets.top, size.width + 20,
        size.height + 20);
    
    size = t26.getPreferredSize();
    t26.setBounds(270 + insets.left, 4670 + insets.top, size.width + 40,
        size.height + 5);
    
    size = l92.getPreferredSize();
    l92
        .setBounds(380 + insets.left, 4665 + insets.top, size.width + 300,
            size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l93.getPreferredSize();
    l93.setBounds(175 + insets.left, 4730 + insets.top, size.width + 100,
        size.height + 20);
    l93.setFont(cBFont);
    
    size = l94.getPreferredSize();
    l94.setBounds(270 + insets.left, 4760 + insets.top, size.width + 100,
        size.height + 20);
    l94.setFont(cBFont);
    
    size = l95.getPreferredSize();
    l95.setBounds(320 + insets.left, 4760 + insets.top, size.width + 100,
        size.height + 20);
    l95.setFont(cBFont);
    
    size = l96.getPreferredSize();
    l96.setBounds(360 + insets.left, 4760 + insets.top, size.width + 100,
        size.height + 20);
    l96.setFont(cBFont);
    
    size = c147.getPreferredSize();
    c147.setBounds(270 + insets.left, 4790 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c148.getPreferredSize();
    c148.setBounds(320 + insets.left, 4790 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c149.getPreferredSize();
    c149.setBounds(360 + insets.left, 4790 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l97.getPreferredSize();
    l97.setBounds(175 + insets.left, 4840 + insets.top, size.width + 100,
        size.height + 20);
    l97.setFont(cBFont);
    
    size = l98.getPreferredSize();
    l98.setBounds(270 + insets.left, 4870 + insets.top, size.width + 100,
        size.height + 20);
    l98.setFont(cBFont);
    
    size = l99.getPreferredSize();
    l99.setBounds(320 + insets.left, 4870 + insets.top, size.width + 100,
        size.height + 20);
    l99.setFont(cBFont);
    
    size = l100.getPreferredSize();
    l100.setBounds(360 + insets.left, 4870 + insets.top, size.width + 100,
        size.height + 20);
    l100.setFont(cBFont);
    
    size = c150.getPreferredSize();
    c150.setBounds(270 + insets.left, 4900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c151.getPreferredSize();
    c151.setBounds(320 + insets.left, 4900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c152.getPreferredSize();
    c152.setBounds(360 + insets.left, 4900 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c153.getPreferredSize();
    c153.setBounds(270 + insets.left, 4930 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c154.getPreferredSize();
    c154.setBounds(320 + insets.left, 4930 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c155.getPreferredSize();
    c155.setBounds(360 + insets.left, 4930 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c156.getPreferredSize();
    c156.setBounds(270 + insets.left, 4960 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c157.getPreferredSize();
    c157.setBounds(320 + insets.left, 4960 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c158.getPreferredSize();
    c158.setBounds(360 + insets.left, 4960 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l101.getPreferredSize();
    l101.setBounds(175 + insets.left, 5020 + insets.top, size.width + 100,
        size.height + 20);
    l101.setFont(cBFont);
    
    size = l102.getPreferredSize();
    l102.setBounds(270 + insets.left, 5050 + insets.top, size.width + 100,
        size.height + 20);
    l102.setFont(cBFont);
    
    size = l103.getPreferredSize();
    l103.setBounds(320 + insets.left, 5050 + insets.top, size.width + 100,
        size.height + 20);
    l103.setFont(cBFont);
    
    size = l104.getPreferredSize();
    l104.setBounds(360 + insets.left, 5050 + insets.top, size.width + 100,
        size.height + 20);
    l104.setFont(cBFont);
    
    size = c159.getPreferredSize();
    c159.setBounds(270 + insets.left, 5080 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c160.getPreferredSize();
    c160.setBounds(320 + insets.left, 5080 + insets.top, size.width + 20,
        size.height + 20);
    
    size = c161.getPreferredSize();
    c161.setBounds(360 + insets.left, 5080 + insets.top, size.width + 20,
        size.height + 20);
    ////////////////////////////////////////////////////////////////////////////
    size = l105.getPreferredSize();
    l105
        .setBounds(175 + insets.left, 5140 + insets.top, size.width + 300,
            size.height + 20);
    l105.setFont(font);
    
    size = t27.getPreferredSize();
    t27.setBounds(175 + insets.left, 5170 + insets.top, size.width + 100,
        size.height + 150);
    
    size = l106.getPreferredSize();
    l106
        .setBounds(175 + insets.left, 5350 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t28.getPreferredSize();
    t28.setBounds(175 + insets.left, 5380 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l107.getPreferredSize();
    l107
        .setBounds(175 + insets.left, 5410 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t29.getPreferredSize();
    t29.setBounds(175 + insets.left, 5440 + insets.top, size.width + 100,
        size.height + 20);
    
    size = l108.getPreferredSize();
    l108
        .setBounds(175 + insets.left, 5470 + insets.top, size.width + 300,
            size.height + 20);
    
    size = t30.getPreferredSize();
    t30.setBounds(175 + insets.left, 5500 + insets.top, size.width + 100,
        size.height + 20);
    
    size = b1.getPreferredSize();
    b1.setBounds(450 + insets.left, 5580 + insets.top, size.width + 60,
        size.height + 20);
    
    size = l109.getPreferredSize();
    l109
        .setBounds(175 + insets.left, 5660 + insets.top, size.width + 300,
            size.height + 20);
    
    
  }


  /**
   * Create the GUI and show it. For thread safety, this method should be
   * invoked from the event-dispatching thread.
   */
     public static void createAndShowGUI() {
    //Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);
    //Create and set up the window.
    JFrame frame = new JFrame("CREATE A FORM");
    //Use our modified content panel
    ContentPanel contentPanel = new ContentPanel();
    //Add the modified panel to the scroll pane
    JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //Setup our panel
    addComponentsToPane(contentPanel);
    //Change the frame's content panel to our own
    frame.setContentPane(scrollPane);
    

    //I changed the JFrame.EXIT_ON_CLOSE constant to a WindowConstant. They are equal in function
      //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Insets insets = frame.getInsets();

    frame.setSize(1000 + insets.left + insets.right, 900 + insets.top + insets.bottom);
    frame.setVisible(true);
  }
    public static void create() {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
   
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}