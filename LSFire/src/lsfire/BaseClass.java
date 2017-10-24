package lsfire;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.persistence.*;

public class BaseClass extends JFrame{
    private final EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("LSFirePU");
    private final EntityManager eM = eMFactory.createEntityManager();
    private final JButton button;
    private final JButton SubB;
    private final JButton CButton;
    
   public BaseClass()
   {
        super("Fire Inspection Report System");
        JTabbedPane tabbedPane = new JTabbedPane();
        SearchHandler handler = new SearchHandler();
        JPanel panel1 = new JPanel();
          
        JLabel label141 = new JLabel ("<html><center><font size = +4>LSFD Inspection Report System</center></font><br></html>");
        JLabel label142 = new JLabel ("<html>This program is for the Lee’s Summit Fire Department when wanting to edit, create, delete, or renew reports.<br>" +
            "The Search tab is used to search through existing reports, where you can view, edit or delete them.<br>" +
            "The Create tab is used to create new reports.<br>" +
            "The Alerts tab is used to make you aware of reports that are overdue for updating, with the number indicating how many reports are overdue.</html>");
        tabbedPane.addTab("Home", null, panel1, "Panel one");
        panel1.add(label141);
        panel1.add(label142);
            
        JPanel panel2 = new JPanel();
        SubB = new JButton("SEARCH");
        SubB.addActionListener(handler);   
        panel2.add(SubB);
        tabbedPane.addTab("Search", null, panel2);
        
        JPanel panel3 = new JPanel();
        CreateTabHandler handler3 = new CreateTabHandler();
        CButton = new JButton("CREATE A NEW FORM");
        CButton.addActionListener(handler3);   
         panel3.add(CButton);
        tabbedPane.addTab("Create", null, panel3, "Panel three");
              
        JPanel panel4 = new JPanel();
        button = new JButton("CLICK TO SEE WHAT IS OVERDUE");
 
        ButtonHandler handler2 = new ButtonHandler();
        button.addActionListener(handler2);
        panel4.add(button);

        tabbedPane.addTab("Alerts", null , panel4, "Panel four");
 
        add(tabbedPane);                        
   }
   
   private class ButtonHandler implements ActionListener{
       
       Alerts obj = new Alerts();
       @Override
       public void actionPerformed(ActionEvent event)
       {
           obj.BaseClassFunction();
       }
   }
   
   private class SearchHandler implements ActionListener{
           
       SearchTab obj = new SearchTab();
       @Override
       public void actionPerformed(ActionEvent event){
           obj.Search();
       }
   }
   
      private class CreateTabHandler implements ActionListener{
           
       CreateTab obj = new CreateTab();
       @Override
       public void actionPerformed(ActionEvent event){
           obj.create();
       }
   }
}