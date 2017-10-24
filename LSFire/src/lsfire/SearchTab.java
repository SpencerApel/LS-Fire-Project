package lsfire;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import java.util.Scanner;

public class SearchTab extends JFrame 
{
   // database URL, username and password
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lsfire";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "yoast";
   
   // default query retrieves all data from authors table
   private static final String DEFAULT_QUERY =  
        "SELECT BU.name, IP.inspectionDate, PR.PropertyAddress" +  
        " FROM inspections AS IP" +                                               
        " INNER JOIN property AS PR ON IP.idProperty = PR.idProperty" + 
        " INNER JOIN business_property AS BP ON PR.idProperty = BP.idProperty" +  
        " INNER JOIN business AS BU ON BP.idBusiness = BU.idBusiness";
    
  /* private static final String DELETE_QUERY =
           "DELETE FROM Inspections" +
           "WHERE(inspectionsDate = JTable date AND"+
           "IP.idProperty = JTable IdProp)";*/
   
   private static ResultSetTableModel tableModel;

   public void Search()
   {   
      // create ResultSetTableModel and display database table
      try 
      {
         // create TableModel for results of query SELECT * FROM authors
         tableModel = new ResultSetTableModel(
            DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

         // set up JTextArea in which user types queries
         final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
         queryArea.setWrapStyleWord(true);
         queryArea.setLineWrap(true);
         
        JLabel filterLabel = new JLabel("Search for Business Name or Address:");
         final JTextField filterText = new JTextField();
         JButton submitButton = new JButton("Search");
         Box boxSouth = Box.createHorizontalBox();
         JButton printButton = new JButton("Print");
         JButton deleteButton = new JButton("Delete");
         JButton editButton = new JButton("Edit");
         JLabel notice = new JLabel("EXPAND THE WINDOW TO SEE FULL OPTIONS. Please select one of the results to either print, edit, or delete. No selecting a result and clicking the button will do nothing.     ");
         Box newBox = Box.createHorizontalBox();
         
         newBox.add(notice);
         newBox.add(printButton);
         newBox.add(deleteButton);
         newBox.add(editButton);
         
         boxSouth.add(filterLabel);
         boxSouth.add(filterText);
         boxSouth.add(submitButton);
         

         // create JTable based on the tableModel
         JTable resultTable = new JTable(tableModel);
         
         // place GUI components on JFrame's content pane
         JFrame window = new JFrame("Displaying Query Results");
         window.add(boxSouth, BorderLayout.NORTH);
         window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
         window.add(newBox, BorderLayout.SOUTH);

         
         final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
         resultTable.setRowSorter(sorter);
         
         // create listener for filterButton
         submitButton.addActionListener(           
            new ActionListener() 
            {
               // pass filter text to listener
               public void actionPerformed(ActionEvent e) 
               {
                  String text = filterText.getText();

                  if (text.length() == 0)
                     sorter.setRowFilter(null);
                  else
                  {
                     try
                     {
                        sorter.setRowFilter(
                           RowFilter.regexFilter(text));
                     } 
                     catch (PatternSyntaxException pse) 
                     {
                        JOptionPane.showMessageDialog(null,
                           "Bad regex pattern", "Bad regex pattern",
                           JOptionPane.ERROR_MESSAGE);
                     }
                  } 
               } 
            } 
         ); // end call to addActionLister

         deleteButton.addActionListener(           
            new ActionListener() 
             {
               // pass filter text to listener
               public void actionPerformed(ActionEvent e) 
               {
                   Scanner input = new Scanner(System.in);
                   int response = JOptionPane.showConfirmDialog(null, 
                           "Are you sure you want to delete this report?",
                           "Delete Fire Inspection Report?", 
                           JOptionPane.YES_NO_OPTION);
                   if ((response == 0)||(response == 0)){
                      
                   }
                   else if ((response == 1)||(response == 1)){
                       
                   }    
                }
            }
         );
         
         printButton.addActionListener(           
            new ActionListener() 
             {
                 Print obj = new Print();
                 public void actionPerformed(ActionEvent e) 
               {
                   obj.print();
               }
             }
         );
         
         //editButton.addActionListener(           
           // new ActionListener() 
             //{
               //  public void actionPerformed(ActionEvent e) 
                 //{
                   /* int selectedRow = table.SelectedRow();
                    int selectedCol = table.getSelectedColumn();
                    String s = ((ResultSetTableModel)table.getModel()).getValueAt(selectedRow, selectedCol).toString();

                    //Get the indices of the selected rows and columns
                    int[] highlightedRows = table.getSelectedRows();
                    int[] highlightedCols = table.getSelectedColumns();
                    int numRows =  ((ResultSetTableModel)table.getModel()).getColumnCount();
                    int numCols = ((ResultSetTableModel)table.getModel()).getRowCount();

                    Vector datas = new Vector<String>();

                    for(int i = 0; i < numRows; i++)
                    {
                        if(IntStream.of(highlightedRows).anyMatch(x -> x == i))
                        {
                            for(int j = 0; j < numCols; j++)
                            {
                                if(IntStream.of(highlightedCols).anyMatch(j -> j == i))
                                {
                                    datas.add(((ResultSetTableModel)table.getModel()).getValueAt(i, j).toString());
                                }
                           }
                       } 
                    }
             }
         );*/
         
         // dispose of window when user quits application (this overrides
         // the default of HIDE_ON_CLOSE)
         //window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         window.setSize(500, 250); 
         window.setVisible(true); 
         
         // ensure database is closed when user quits application
        // window.addWindowListener(
          //  new WindowAdapter() 
            //{
              // public void windowClosed(WindowEvent event)
               //{
                 // tableModel.disconnectFromDatabase();
                  //System.exit(0);
               //} 
            //} 
         //); 
      }
      catch (SQLException sqlException) 
      {
         JOptionPane.showMessageDialog(null, sqlException.getMessage(), 
            "Database error", JOptionPane.ERROR_MESSAGE);
         tableModel.disconnectFromDatabase();
         //System.exit(1); // terminate application
      }     
   } 
} // end class DisplayQueryResults