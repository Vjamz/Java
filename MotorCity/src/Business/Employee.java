/**
* Class: CAPSTONE
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: Customer Class
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

/**
 *
 * @author Brittney Zeigler
 */
public class Employee 
{
    // Declare variables.
    private String location;
    private String firstName; 
    private String lastName;
    private String rate;
    private String hireDate;           
    
    // Create the no arg constructor.
    Employee()
    {
    }
    
    // Create the multi arg constructor.
    Employee(String location, String firstName, String lastName, String rate, String hireDate)
    {
    }

    /**
     * @return the location
     */
    public String getLocation() 
    {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) 
    {
        this.location = location;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() 
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() 
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    /**
     * @return the rate
     */
    public String getRate() 
    {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(String rate) 
    {
        this.rate = rate;
    }

    /**
     * @return the hireDate
     */
    public String getHireDate() 
    {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(String hireDate) 
    {
        this.hireDate = hireDate;
    }
}
