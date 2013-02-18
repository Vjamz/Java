/**
* Class: Capstone
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: Parts Class 
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

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Parts {

    //Declare variables
    private String Name;
    private String Description;
    private String Manufacture;
    private String Cost;
    private String Price;
    
    //Create no arg Constructor
    Parts (){    
    }
    //Create multi-arg constructor
    Parts (String Name, String Description, String Manufacture, String Cost, String Price){
        }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Manufacture
     */
    public String getManufacture() {
        return Manufacture;
    }

    /**
     * @param Manufacture the Manufacture to set
     */
    public void setManufacture(String Manufacture) {
        this.Manufacture = Manufacture;
    }

    /**
     * @return the Cost
     */
    public String getCost() {
        return Cost;
    }

    /**
     * @param Cost the Cost to set
     */
    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    /**
     * @return the Price
     */
    public String getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }
    
}
