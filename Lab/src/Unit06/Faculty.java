/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit 06 Lab
* Date: 4/9/12
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit06;

import java.sql.*;

public class Faculty {

    
    private String ssn;
    private String firstName;
    private char mi;
    private String lastName;
    private String phone;
    private String email;
    private String office;
    private String startTime;
    private String rank;
    private double salary;
    private String deptId;
    
public Faculty(){
}
Faculty(String ssn, String firstName, char mi, String lastName,
        String phone, String email, String office, String startTime,
        String rank, double salary, String deptId)throws SQLException, ClassNotFoundException{
this.ssn = ssn;
this.firstName = firstName;
this.mi = mi;
this.lastName = lastName;
this.phone = phone;
this.email = email;
this.office = office;
this.startTime = startTime;
this.rank = rank;
this.salary = salary;
this.deptId = deptId;

  Class.forName("com.mysql.jdbc.Driver");           
  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test","scott","tiger");    
  Statement statement = connection.createStatement(); 
  statement.executeUpdate("insert into Faculty values("
             + "'" + ssn + "', "
             + "'" + firstName + "', "
             + "'" + mi + "', "
             + "'" + lastName + "', "
             + "'" + phone + "', "
             + "'" + email + "', "
             + "'" + office + "', "
             + "'" + startTime + "', "
             + "'" + rank + "', "
             + "'" + salary + "', "
             + "'" + deptId + "')"
             );
        
    connection.close();    
}
    Faculty(String ssn)throws SQLException, ClassNotFoundException{
       
       Class.forName("com.mysql.jdbc.Driver");           
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test","scott","tiger");    
       Statement statement = connection.createStatement();      
       ResultSet resultSet = statement.executeQuery("select * from Faculty where ssn = "+ssn+";");
           while(resultSet.next()){
           this.ssn = resultSet.getString("ssn");
           this.firstName = resultSet.getString("firstName");
           this.mi = resultSet.getString("mi").charAt(0);
           this.lastName = resultSet.getString("lastName");
           this.phone = resultSet.getString("phone");
           this.email = resultSet.getString("email");
           this.office = resultSet.getString("office");
           this.startTime = resultSet.getString("startTime");
           this.rank = resultSet.getString("rank");
           this.salary = resultSet.getDouble("salary");
           this.deptId = resultSet.getString("deptId");
           }
        connection.close();  
    }

    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the mi
     */
    public char getMi() {
        return mi;
    }

    /**
     * @param mi the mi to set
     */
    public void setMi(char mi) {
        this.mi = mi;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    public void deleteDB() throws SQLException, ClassNotFoundException {
        
    }
    
     static void deleteDB(String ssn) throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test" , "scott" , "tiger");
    
    Statement statement = connection.createStatement();
    
    statement.executeUpdate("delete from Faculty where ssn = " + "'" + ssn + "';");
    
    connection.close();
     }

}


