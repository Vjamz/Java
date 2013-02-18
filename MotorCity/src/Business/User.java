/**
* Class: CAPSTONE
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: User Class
* Sprint: 3
* @author Brittney Zeigler
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */
package Business;

import GUI.MainScreen;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import GUI.WorkOrder;

/**
 *
 * @author Brittney Zeigler
 */
public class User extends MainScreen 
{   
    private String userID;
    private String userName;
    private String password;
    
    public User()
    {
    }
    
    // Create a JDBC method: A connection to the database.
    private static java.sql.Connection makeConnection() 
            throws SQLException, ClassNotFoundException
    {
        java.sql.Connection connection = null;
        // Load the JDBC driver
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {}
        
        // Establish a conneciton.
        try 
        {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/motorcity", "root", "sesame");
        } catch (SQLException cnf) {}

        return connection;
    }
    
    public void validateUser(String userName, String pwd)throws SQLException, ClassNotFoundException
    {      
        // Call method that loads the driver and makes a connection
        java.sql.Connection connection = null;
        try 
        {
        connection = makeConnection();
        }
        catch (SQLException se) {}
        catch (ClassNotFoundException cnf) {}
        
        
        // Create a statement
        try 
        {
            java.sql.Statement statement = connection.createStatement();            
            ResultSet resultSet = statement.executeQuery("select * from user where UserName = '"+ userName +"';");
            resultSet.last();
            if (resultSet.getRow() < 1)
            {
                JOptionPane.showMessageDialog(null, "You must enter a valid User Name and Password.");
                usertf.setText("");
                passwordtf.setText(""); 
            }
            else {
                resultSet.first();
                this.userName = resultSet.getString("UserName");
                this.password = resultSet.getString("Password");
                if (pwd.equals(this.password))
                {
                    WorkOrder.displayWorkOrder();
                    usertf.setText("");
                    passwordtf.setText("");     
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You must enter a valid User Name and Password.");
                    usertf.setText("");
                    passwordtf.setText("");     
                }

            }
        }
        catch (SQLException e) {}
    }
    
    /**
     * @return the userID
     */
    public String getUserID() 
    {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) 
    {
        this.userID = userID;
    }

    /**
     * @return the userName
     */
    public String getUserName() 
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() 
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }   
}