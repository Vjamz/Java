/**
* Class: CIST 2373 Java III
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: 
* Date:
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Business;

import java.sql.*;
import java.util.ArrayList;

public class WorkOrderBus {

  
    
    //Creating variables for Work Order
    
    private String workOrderID;
    private String customerFirstName;
    private String customerLastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String make;
    private String model;
    private String year;
    private String description;

    
    static ArrayList<String> list = new ArrayList<>();
    
    //Create a no-arg constructor
    public WorkOrderBus(){
        
    }
    
    //Create a one arg constructor that can retreive information from the Work Order Table
    public WorkOrderBus(String workOrderID) throws SQLException, ClassNotFoundException{
        // Create a JDBC method: A connection to the database.
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity","root","sesame");    
       Statement statement = connection.createStatement();      
       ResultSet resultSet = statement.executeQuery("select * from WorkOrder where WorkOrderID = "+workOrderID+";");
        // Execute statement.
        while(resultSet.next()){
            this.workOrderID = resultSet.getString("WorkOrderID");
            this.customerLastName = resultSet.getString("customerLastName");
            this.customerFirstName = resultSet.getString("customerFirstName");
            this.address = resultSet.getString("Address");
            this.city = resultSet.getString("City");
            this.state = resultSet.getString("State");
            this.zip = resultSet.getString("Zip");
            this.make = resultSet.getString("Make");
            this.model = resultSet.getString("Model");
            this.year = resultSet.getString("Year");
            this.description = resultSet.getString("Description");
        }
        connection.close();
    }
    
    //Create a multi-arg contrusctor that can retreieve information from the WorkOrderBus Table
    WorkOrderBus (String workOrderID, String customerLastName, String customerFirstName, String address, String city, String state, String zip,
            String make, String model, String year, String description) throws SQLException, ClassNotFoundException {
        
        this.workOrderID = workOrderID;
        this.customerLastName = customerLastName;
        this.customerFirstName = customerFirstName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.make = make;
        this.model = model;
        this.year = year;
        this.description = description;
        
              Class.forName("com.mysql.jdbc.Driver");           
  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity","root","sesame");    
  Statement statement = connection.createStatement(); 
  statement.executeUpdate("insert into WorkOrder values("
             + "'" + workOrderID + "', "
             + "'" + customerLastName + "', "
             + "'" + customerFirstName + "', "
             + "'" + address + "', "
             + "'" + city + "', "
             + "'" + state + "', "
             + "'" + zip + "', "
             + "'" + make + "', "
             + "'" + model + "', "
             + "'" + year + "', "
             + "'" + description + "')"
             );
        
    connection.close();
        
    }
    
      //Create an ArrayList method to call the information
     public static ArrayList search(String s) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");           
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity","root","sesame");    
       Statement statement = connection.createStatement();      
       ResultSet resultSet = statement.executeQuery("select WorkOrderID from WorkOrder where WorkOrderID like '"+s+"';");
       ArrayList list = new ArrayList();
       
       while(resultSet.next()){
           list.add(resultSet.getString("WorkOrderID"));
       }
       
       return list;
        
    }
     
     //Create a method to delete items in the Customer table
    static void deleteDB(String workOrderID) throws SQLException, ClassNotFoundException {
    
    Class.forName("com.mysql.jdbc.Driver");
    
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity" , "root" , "sesame");
    
    Statement statement = connection.createStatement();
    
    statement.executeUpdate("delete from WorkOrder where WorkOrderID = " + "'" + workOrderID + "';");
    
    connection.close();
    }

    /**
     * @return the workOrderID
     */
    public String getWorkOrderID() {
        return workOrderID;
    }

    /**
     * @param workOrderID the workOrderID to set
     */
    public void setWorkOrderID(String workOrderID) {
        this.workOrderID = workOrderID;
    }

    /**
     * @return the customerFirstName
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * @param customerFirstName the customerFirstName to set
     */
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    /**
     * @return the customerLastName
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * @param customerLastName the customerLastName to set
     */
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
   
    
    
    

}
