/**
* Class: CAPSTONE
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: Vechicle
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
public class Vehicle 
{
    // Declare variables.
    private String vin;
    private String make; 
    private String modle;
    private String year;
    private String interior;
    private String exterior; 
    
    // Create the no arg constructor.
    Vehicle()
    {
    }
    
    // Create the multi arg constructor.
    Vehicle(String vin, String make, String modle, String year, String interior, String exterior)
    {       
    }

    /**
     * @return the vin
     */
    public String getVin() 
    {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(String vin) 
    {
        this.vin = vin;
    }

    /**
     * @return the make
     */
    public String getMake() 
    {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) 
    {
        this.make = make;
    }

    /**
     * @return the modle
     */
    public String getModle() 
    {
        return modle;
    }

    /**
     * @param modle the modle to set
     */
    public void setModle(String modle) 
    {
        this.modle = modle;
    }

    /**
     * @return the year
     */
    public String getYear() 
    {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) 
    {
        this.year = year;
    }

    /**
     * @return the interior
     */
    public String getInterior() 
    {
        return interior;
    }

    /**
     * @param interior the interior to set
     */
    public void setInterior(String interior) 
    {
        this.interior = interior;
    }

    /**
     * @return the exterior
     */
    public String getExterior() 
    {
        return exterior;
    }

    /**
     * @param exterior the exterior to set
     */
    public void setExterior(String exterior) 
    {
        this.exterior = exterior;
    }
}
