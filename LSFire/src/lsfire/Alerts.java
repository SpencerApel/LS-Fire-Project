package lsfire;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class Alerts
{
   // database URL, username and password
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lsfire";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "yoast";
   
   // default query retrieves all data from authors table
   private static final String DEFAULT_QUERY =  
        "SELECT BU.name, IP.inspectionDate, PR.PropertyAddress " +  
        " FROM inspections AS IP" +                                               
        " INNER JOIN property AS PR ON IP.idProperty = PR.idProperty" + 
        " INNER JOIN business_property AS BP ON PR.idProperty = BP.idProperty" +  
        " INNER JOIN business AS BU ON BP.idBusiness = BU.idBusiness" + 
        " WHERE (DATEDIFF(NOW(), IP.inspectionDate) > 365)";
   
   private static ResultSetTableModel tableModel;

   public void BaseClassFunction() 
   {   
      // create ResultSetTableModel and display database table
      try 
      {
         // create TableModel for results of query SELECT * FROM authors
         tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
         JTable resultTable = new JTable(tableModel);

         JFrame window = new JFrame("Displaying Query Results");
         //window.add(boxNorth, BorderLayout.NORTH);
         window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
         //window.add(boxSouth, BorderLayout.SOUTH);

         final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
         resultTable.setRowSorter(sorter);
         
         window.setSize(500, 250); 
         window.setVisible(true); 
         
         // ensure database is closed when user quits application
         window.addWindowListener(
            new WindowAdapter() 
            {
               @Override
               public void windowClosed(WindowEvent event)
               {
                  tableModel.disconnectFromDatabase();
               } 
            } 
         ); 
      } 
      catch (SQLException sqlException) 
      {
         JOptionPane.showMessageDialog(null, sqlException.getMessage(), 
            "Database error", JOptionPane.ERROR_MESSAGE);
         tableModel.disconnectFromDatabase();
      }     
   } 
} // end class DisplayQueryResults