/**
* Class: Capstone Course
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: Work Order GUI
* Date:
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package GUI;

import Business.WorkOrderBus;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class WorkOrder  {
    private static Component jlbl;
    
    public static void  displayWorkOrder(){
              
        
        //Frame for the Work Order 
        final JFrame frame = new JFrame("Work Order");
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
       
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBorder(new LineBorder(Color.BLUE, 5));
        mainPanel.setBackground(Color.WHITE);
        
        frame.add(mainPanel, BorderLayout.CENTER);       
        JMenuBar menuBar = new JMenuBar();
        frame.add(menuBar);
        frame.add(menuBar, BorderLayout.NORTH);


         JMenu fileMenu = new JMenu("File");
         JMenu editMenu = new JMenu("Edit");
         JMenuItem newWorkOrder = new JMenuItem("Create Work Order");
         JMenuItem searchWorkOrder = new JMenuItem("Search Work Order");
         JMenuItem SearhCustomer = new JMenuItem("Search For a Customer");
         JMenuItem openAction = new JMenuItem("Take Payment");
         JMenuItem printAction = new JMenuItem("Print");
         JMenuItem saveAction = new JMenuItem("Save Work Order");
         JMenuItem exitAction = new JMenuItem("Exit");
         JMenuItem cutAction = new JMenuItem("Cut");
         JMenuItem copyAction = new JMenuItem("Copy");
         JMenuItem pasteAction = new JMenuItem("Paste");

         menuBar.add(fileMenu);
         menuBar.add(editMenu);
         fileMenu.add(newWorkOrder);
         fileMenu.add(searchWorkOrder);
         fileMenu.add(SearhCustomer);
         fileMenu.add(saveAction);
         fileMenu.add(openAction);
         fileMenu.add(printAction);

         fileMenu.addSeparator();
         fileMenu.add(exitAction);
         editMenu.add(cutAction);
         editMenu.add(copyAction);
         editMenu.add(pasteAction);
         editMenu.addSeparator();
         

         
        
         
         
        //////////Creating Panel for Information for Customer/Vehicle//////
        
        
        //Create Labels for Panel 1
        JLabel jlID = new JLabel("Work Order ID");
        JLabel jlCustomerFirstName = new JLabel("Customer First Name");
        JLabel jlCustomerLastName = new JLabel("Customer Last Name");
        JLabel jlAddress = new JLabel("Address");
        JLabel jlCity = new JLabel("City");
        JLabel jlState = new JLabel("State");
        JLabel jlZip = new JLabel("ZIP");
        JLabel jlMake = new JLabel("Make");
        JLabel jlModel = new JLabel("Model");
        JLabel jlYear = new JLabel("Year");
        JLabel jlProbDesc = new JLabel("Problem Description");
        
                
        
        //Create Textfields for Work Order Panel 2
        final JFormattedTextField jtfID = new JFormattedTextField();
        final JFormattedTextField jtfFirstName = new JFormattedTextField();
        final JFormattedTextField jtfLastName = new JFormattedTextField();
        final JFormattedTextField jtfAddress = new JFormattedTextField();
        final JFormattedTextField jtfCity = new JFormattedTextField();
        final JFormattedTextField jtfState = new JFormattedTextField();
        final JFormattedTextField jtfZip = new JFormattedTextField();
        final JFormattedTextField jtfMake = new JFormattedTextField();
        final JFormattedTextField jtfModel = new JFormattedTextField();
        final JFormattedTextField jtfYear = new JFormattedTextField();
        final JTextField jtfDescription = new JTextField();
        jtfID.setColumns(15);
       
        
        
        //Set alignments for Label/TextField pairs
        jlID.setLabelFor(jtfID);
        jlCustomerFirstName.setLabelFor(jtfFirstName);
        jlCustomerLastName.setLabelFor(jtfLastName);
        jlAddress.setLabelFor(jtfAddress);
        jlCity.setLabelFor(jtfCity);
        jlState.setLabelFor(jtfState);
        jlZip.setLabelFor(jtfZip);
        jlMake.setLabelFor(jtfMake);
        jlModel.setLabelFor(jlModel);
        jlYear.setLabelFor(jtfYear);
        jlProbDesc.setLabelFor(jtfDescription);
        
        //Lay out labels in a panel 1
        JPanel labelPanel1 = new JPanel(new GridLayout(0,1));
        labelPanel1.add(jlID);
        labelPanel1.add(jlCustomerFirstName);
        labelPanel1.add(jlCustomerLastName);
        labelPanel1.add(jlAddress);
        labelPanel1.add(jlCity);
        labelPanel1.add(jlState);
        labelPanel1.add(jlZip);
        labelPanel1.add(jlMake);
        labelPanel1.add(jlModel);
        labelPanel1.add(jlYear);
        labelPanel1.add(jlProbDesc);
        
        //Lay out Fields in a panel 2
        JPanel fieldPanel = new JPanel(new GridLayout(11,1,10,25));
        fieldPanel.add(jtfID);
        fieldPanel.add(jtfFirstName);
        fieldPanel.add(jtfLastName);
        fieldPanel.add(jtfAddress);
        fieldPanel.add(jtfCity);
        fieldPanel.add(jtfState);
        fieldPanel.add(jtfZip);
        fieldPanel.add(jtfMake);
        fieldPanel.add(jtfModel);
        fieldPanel.add(jtfYear);
        fieldPanel.add(jtfDescription);
        
        //Create Labels for Order Summary Panel
        JLabel jlTotalParts = new JLabel("Total Parts: ");
        JLabel jlTotalLabor = new JLabel("Total Labor: ");
        JLabel jlTaxRate = new JLabel("Tax Rate: ");
        JLabel jlTaxAmount = new JLabel("Tax Amount: ");
        JLabel jlOrderTotal = new JLabel("Order Total: ");
        
        //Create Fields for Order Summary Panel
        JTextField jtfTotalParts = new JTextField();
        JTextField jtfTotalLabor = new JTextField();
        JTextField jtfTaxRate = new JTextField();
        
        
        
        
        //Adding the panels to the frame
        frame.add(labelPanel1, BorderLayout.WEST);
        frame.add(fieldPanel, BorderLayout.EAST);
        
        
        frame.setVisible(true);
        frame.setResizable(true);
        
        //*****************Submit WorkOrder***********************************//
        
        //Create Buttons for Work Order
        JButton jbSubmit = new JButton("Submit");
        JButton jbCancel = new JButton("Cancel");
        
        
        //Create Panel to place buttons
        JPanel btPanel = new JPanel();
        btPanel.add(jbSubmit);
        btPanel.add(jbCancel);
        frame.add(btPanel, BorderLayout.SOUTH);
        
        
        
        jbSubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try{
                ArrayList submitData = new ArrayList();
             String submitButton = jtfID.getText().trim() +
                "\n" + jtfFirstName.getText().trim() +
                "\n" + jtfLastName.getText().trim() +
                "\n" + jtfAddress.getText().trim() +
                "\n" + jtfCity.getText().trim() +
                "\n" + jtfState.getText().trim() +
                "\n" + jtfZip.getText().trim() +
                "\n" + jtfMake.getText().trim() +
                "\n" + jtfModel.getText().trim() +
                "\n" + jtfYear.getText().trim() +
                "\n" + jtfDescription.getText().trim();
                
                System.out.println("The data submitted while pressing the submit button: " + submitButton);
                
                
                
            }catch (Exception ex){}
        
        }});
        
//********************Search WorkOrder Function*******************************/
        
      // Create jtable column names
    String[] columnNames = {"WorkOrderID", "Last Name", "First Name", "Address",
    "City", "State", "Zip Code", "Make", "Model", "Year", "Description"};
    
    // Get table data
     Object[][] data = {};

    // Create table models
    final DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    
    // Create jtable and add to scroll pane
    final JTable jtbl = new JTable(tableModel);
    
   // Create scroll pane 
    JScrollPane jsp = new JScrollPane(jtbl); 
    final JPanel searchPanel = new JPanel(); 
    searchPanel.add(jsp);
    searchPanel.setVisible(false);
    
    
    
        // Search WorkOrder dialog box
        final JDialog srcDialog = new JDialog();
        srcDialog.setModal(true);           
        srcDialog.setTitle("Search Work Order");
        srcDialog.setSize(300,100);
        srcDialog.setLocationRelativeTo( null);
        
        // Variables for the search button within the search dialog window
        JButton jbtSearch = new JButton("Search");
        final JTextField txtBox = new JTextField(12);    
        final JLabel jlbl = new JLabel("Search by Work Order number");
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(txtBox);
        p1.add(jbtSearch);
        jbtSearch.setMnemonic(KeyEvent.VK_A);

        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout(5,5));
        p2.add(jlbl,BorderLayout.NORTH);
        p2.add(p1,BorderLayout.CENTER);
        srcDialog.add(p2); 
        
        
        
        final JFrame searchFrame = new JFrame("Work Order Search Results");
        searchFrame.setSize(1000, 300);
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchFrame.setVisible(false);
        JMenuBar woSearchBar = new JMenuBar();
        JMenu srchFile = new JMenu("File");
        JMenu srchExit = new JMenu("Exit");
        woSearchBar.add(srchFile);
        woSearchBar.add(srchExit);
        searchFrame.add(woSearchBar, BorderLayout.NORTH);
        searchFrame.add(jsp, BorderLayout.CENTER);
        
         // Creates the SearchWorkOrder function
         searchWorkOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //dialog box goes here
                srcDialog.setVisible(true);
            }});
         
         // Code for search button should connect to database
         jbtSearch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try{
               srcDialog.setVisible(false);                  
               ArrayList searchData = new ArrayList();
                                                    
              // Get text from user input.
              String searchInput = txtBox.getText().trim();  
              
              System.out.println("The data entered in the dialog is: " + searchInput);
               
              // do validation here                   
              //searchData = WorkOrder.searchSSN(searchInput);
               searchData = WorkOrderBus.search(searchInput);
               Object[] elements = searchData.toArray();
               
               for (int i = 0; i <elements.length; i++){
                   System.out.println("The data entered in the array is:" + elements[i]);
               }
               
               
              for (int i = 0; i < searchInput.length(); i++){
                  
                  
                  // Checks for alphabet 
                  if ((!Character.isDigit(searchInput.charAt(i)) && (!searchInput.contains("%")))){
                         JOptionPane.showMessageDialog(null, "You must enter a Work Order # to search for an existing Work Order "
                           + "Return to Search Menu.", "",JOptionPane.ERROR_MESSAGE);
                         break;
                  }
              } 
            
              if(searchData.isEmpty()){
                 JOptionPane.showMessageDialog(null, "You must enter a Work Order # to search for an existing Work Order. "
                           + "Return to Search Menu.", "",JOptionPane.ERROR_MESSAGE);
                    
              }else{
               Iterator iterator = searchData.iterator();              
             
               while(iterator.hasNext()){
                   // Student student1 = new Student(iterator.next().toString());
                   WorkOrderBus wo1 = new WorkOrderBus(iterator.next().toString()); 
                    
                   
                   tableModel.addRow(new Object[] {wo1.getWorkOrderID(),wo1.getCustomerLastName(),
                       wo1.getCustomerFirstName(), wo1.getAddress(), wo1.getCity(), wo1.getState(), wo1.getZip(), wo1.getMake(), 
                       wo1.getModel(), wo1.getYear(), wo1.getDescription()});
                              
               srcDialog.dispose();
               
               searchFrame.setVisible(true);
               frame.setVisible(false);
               }
               

               }
                              
                }catch(Exception ex){
                    
                }
               
                }
        });
    }
    
}
