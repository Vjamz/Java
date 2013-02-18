/**
* Class: CAPSTONE
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: Customer Class
* Sprint: 3
* @author Emma Mays
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

public class Customer 
{

    /**
     * @return the searchResults
     */
    /*
    public static ArrayList<String> getSearchResults() 
    {
        return searchResults;
    }
    
   /* public static void setSearchResults(ArrayList<String> aSearchResults) 
    {
        searchResults = aSearchResults;
    }
    * 
    */
    // Declare variables.
    
    private String fname;
    private String lname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String dayPhone;
    private String nightPhone;
    private String mobilePhone;
    private String email;
    private String customerID;
    
    //private static ArrayList<String> searchResults = new ArrayList<>();
    
    // Create the no arg constructor.
    public Customer()
    {    
    }
    
    // Create a one arg constructor that can retrieve information from the Customer table.
    public Customer(String customerID) throws SQLException, ClassNotFoundException
    {
        // Create a JDBC method: A connection to the database.
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity","root","sesame");    
       Statement statement = connection.createStatement();      
       ResultSet resultSet = statement.executeQuery("select * from Customer where customerID = "+customerID+";");
        // Execute statement.
        while(resultSet.next()){ 
            this.customerID = resultSet.getString("customerID");
            this.fname = resultSet.getString("fname");
            this.lname = resultSet.getString("lname");
            this.street = resultSet.getString("street");
            this.city = resultSet.getString("city");
            this.state = resultSet.getString("state");
            this.zip = resultSet.getString("zip");
            this.dayPhone = resultSet.getString("dayPhone");
            this.nightPhone = resultSet.getString("nightPhone");
            this.mobilePhone = resultSet.getString("mobilePhone");
            this.email = resultSet.getString("email");
        }
        
        connection.close();
    }
    
    //Create a multi-arg constructor that can retrieve information from the Customer table
    Customer (String customerID, String fname, String lname, String street, String city, String state, String zip,
            String dayPhone, String nightPhone, String mobilePhone, String email)throws SQLException, ClassNotFoundException{
        
        this.customerID = customerID;
        this.fname = fname;
        this.lname = lname;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.dayPhone = dayPhone;
        this.nightPhone = nightPhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        
        
        Class.forName("com.mysql.jdbc.Driver");           
  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity","root","sesame");    
  Statement statement = connection.createStatement(); 
  statement.executeUpdate("insert into Customer values("
             + "'" + customerID + "', "
             + "'" + fname + "', "
             + "'" + lname + "', "
             + "'" + street + "', "
             + "'" + city + "', "
             + "'" + state + "', "
             + "'" + zip + "', "
             + "'" + dayPhone + "', "
             + "'" + nightPhone + "', "
             + "'" + mobilePhone + "', "
             + "'" + email + "')"
             );
        
    connection.close();
        
    }
    //Create an ArrayList method to call the information
     public static ArrayList search(String s) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");           
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity","root","sesame");    
       Statement statement = connection.createStatement();      
       ResultSet resultSet = statement.executeQuery("select customerID from Customer where customerID like '"+s+"';");
       ArrayList list = new ArrayList();
       
       while(resultSet.next()){
           list.add(resultSet.getString("customerID"));
       }
       
       return list;
        
    }

    
    public void deleteDB() throws SQLException, ClassNotFoundException {
        
    }
    
    //Create a method to delete items in the Customer table
    static void deleteDB(String customerID) throws SQLException, ClassNotFoundException {
    
    Class.forName("com.mysql.jdbc.Driver");
    
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity" , "root" , "sesame");
    
    Statement statement = connection.createStatement();
    
    statement.executeUpdate("delete from Customer where customerID = " + "'" + customerID + "';");
    
    connection.close();
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
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
     * @return the dayPhone
     */
    public String getDayPhone() {
        return dayPhone;
    }

    /**
     * @param dayPhone the dayPhone to set
     */
    public void setDayPhone(String dayPhone) {
        this.dayPhone = dayPhone;
    }

    /**
     * @return the nightPhone
     */
    public String getNightPhone() {
        return nightPhone;
    }

    /**
     * @param nightPhone the nightPhone to set
     */
    public void setNightPhone(String nightPhone) {
        this.nightPhone = nightPhone;
    }

    /**
     * @return the mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
      
}

