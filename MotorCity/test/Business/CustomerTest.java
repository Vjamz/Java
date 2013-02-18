/*
 * Capstone Customer Class
 * JUnit Tester for Customer Class
 * Summer Semester 2012
 */
package Business;

import java.sql.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author James
 */
public class CustomerTest {
    
    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
        Connection con;
        try {
            con = makeConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate("delete from Customer where customerID = \'6\';");
            statement.executeUpdate("delete from Customer where customerID = \'7\';");
            con.close();
        }catch (SQLException ex){
            // Ignore!
        }catch (ClassNotFoundException ex){
            // Ignore!
        }
        
    }
    
    private static Connection makeConnection() throws SQLException, ClassNotFoundException{
	     // Load the JDBC driver 
        Class.forName("com.mysql.jdbc.Driver");  
      
        // Establish a connection 
        Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/motorcity", "root", "sesame"); 
		  return connection;
   }

    /**
     * Test of search method, of class Customer.
     */
   /* @Test
    public void testSearch() throws Exception {
        System.out.println("search");
        String s = "";
        ArrayList expResult = null;
        ArrayList result = Customer.search(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } 
    
 */   
    
    /**
     * Test of Customer one arg construstor
     */
    @Test
    public void testCustomer_one_arg1() {
        //This test is dependant on what is in the Motorcity database
        System.out.println("* Test of Customer(customerID)");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch(SQLException ex){
            fail("SQL Exception, " + ex.getMessage());
            return;
        }catch(ClassNotFoundException ex ){
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
    }
        String result = instance.getCustomerID();
        assertEquals("5", result);
        result = instance.getFname();
        assertEquals("Granny", result);
        result = instance.getLname();
        assertEquals("Smith", result);  
    }
    
    @Test
    public void testCustomer_one_arg2() {
        //This test is dependant on what is in the Motorcity Database
        System.out.println("* Test of Customer(customerID) with bad id");
        Customer instance = null;
        boolean badIdNotFound = false;
        try{
            instance = new Customer("x");
        }catch(SQLException ex){
            badIdNotFound = true;
        }catch(ClassNotFoundException ex){
            fail("Class not found Exception, check JBDC lib in classpath");
            return;
        }
        assertTrue(badIdNotFound);
    }
    
    //Create test for multi arg constructor 
    @Test
    public void testCustomer_many_arg() {
        //This test is dependant on what is in the Motorcity Database.
        System.out.println("* Test of Customer(customerID, fname, ...)");
        Customer instance = null;
        Customer instance2 = null;
        try{
            instance = new Customer("6", "James", "Biggleton", "123 Harbor Rd", "ViceCity", "GA",
                    "30107", "770-555-1112", "770-555-1113", "770-555-1114", "jbiggle@main.com");
        }catch (SQLException ex){
            fail("SQL Error - inserting new Customer member. " + ex.getMessage());
            return;
        }catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        try{
            instance2 = new Customer("6");
        }catch (SQLException ex){
            fail("SQL Error - could not find id that was just inserted");
            return;
        }catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDB lib in CLASSPATH");
            return;
        }
        assertEquals(instance.getFname(), instance2.getFname());
    }
    
    
    
    /**
     * Test of getFname method, of class Customer.
     */
    @Test
    public void testGetFname() {
        System.out.println("* Test getFname()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch (Exception ex){}
        String expResult = "Granny";
        String result = instance.getFname();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setFname method, of class Customer.
     */
    @Test
    public void testSetFname() {
        System.out.println("* Test setFname(String)");
        String fname = "John";
        Customer instance = new Customer();
        instance.setFname(fname);
        String returnedValue = instance.getFname();
        assertEquals("John", returnedValue);
        
    }

    /**
     * Test of getLname method, of class Customer.
     */
    @Test
    public void testGetLname() {
        System.out.println("* Test getLname()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch(Exception ex){}
        String expResult = "Smith";
        String result = instance.getLname();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setLname method, of class Customer.
     */
    @Test
    public void testSetLname() {
        System.out.println("* Test setLname()");
        String lname = "Smith";
        Customer instance = new Customer();
        instance.setLname(lname);
        String returnedValue = instance.getLname();
        assertEquals("Smith", returnedValue);
        
    }

    /**
     * Test of getStreet method, of class Customer.
     */
    @Test
    public void testGetStreet() {
        System.out.println("* Test getStreet()");
        Customer instance = null;
        try{
            instance = new Customer("1");
        }catch(Exception ex){}
        String expResult = "45 Maple";
        String result = instance.getStreet();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setStreet method, of class Customer.
     */
    @Test
    public void testSetStreet() {
        System.out.println("* Test setStreet()");
        String street = "45 Maple";
        Customer instance = new Customer();
        instance.setStreet(street);
        String returnedValue = instance.getStreet();
        assertEquals("45 Maple", returnedValue);
    }

    /**
     * Test of getCity method, of class Customer.
     */
    @Test
    public void testGetCity() {
        System.out.println("* Test getCity()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch (Exception ex){}
        String expResult = "BigCity";
        String result = instance.getCity();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setCity method, of class Customer.
     */
    @Test
    public void testSetCity() {
        System.out.println("* Test setCity(String)");
        String city = "BigCity";
        Customer instance = new Customer();
        instance.setCity(city);
        String returnedValue = instance.getCity();
        assertEquals("BigCity", returnedValue);
    }

    /**
     * Test of getState method, of class Customer.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Customer instance = null;
        try {
            instance = new Customer("5");
        }catch (Exception ex){}
        String expResult = "GA";
        String result = instance.getState();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setState method, of class Customer.
     */
    @Test
    public void testSetState() {
        System.out.println("* Test setState(String)");
        String state = "GA";
        Customer instance = new Customer();
        instance.setState(state);
        String returnedValue = instance.getState();
        assertEquals(state, returnedValue);
    }

    /**
     * Test of getZip method, of class Customer.
     */
    @Test
    public void testGetZip() {
        System.out.println("* Test getZip()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch(Exception ex){}
        String expResult = "30099";
        String result = instance.getZip();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setZip method, of class Customer.
     */
    @Test
    public void testSetZip() {
        System.out.println("* Test setZip(String)");
        String zip = "30099";
        Customer instance = new Customer();
        instance.setZip(zip);
        String returnedValue = instance.getZip();
        assertEquals(zip, returnedValue);
    }

    /**
     * Test of getDayPhone method, of class Customer.
     */
    @Test
    public void testGetDayPhone() {
        System.out.println("* Test getDayPhone()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch(Exception ex){}
        String expResult = "777-555-5666";
        String result = instance.getDayPhone();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setDayPhone method, of class Customer.
     */
    @Test
    public void testSetDayPhone() {
        System.out.println("setDayPhone");
        String dayPhone = "777-555-5666";
        Customer instance = new Customer();
        instance.setDayPhone(dayPhone);
        String returnedValue = instance.getDayPhone();
        assertEquals(dayPhone, returnedValue);
        
    }

    /**
     * Test of getNightPhone method, of class Customer.
     */
    @Test
    public void testGetNightPhone() {
        System.out.println("* Test getNightPhone()");
        Customer instance = null;
        try{
            instance = new Customer("4");
        }catch (Exception ex){}
        String expResult = "777-555-7588";
        String result = instance.getNightPhone();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNightPhone method, of class Customer.
     */
    @Test
    public void testSetNightPhone() {
        System.out.println("* Test setNightPhone(String)");
        String nightPhone = "777-555-7588";
        Customer instance = new Customer();
        instance.setNightPhone(nightPhone);
        String returnedValue = instance.getNightPhone();
        assertEquals(nightPhone, returnedValue);
    }

    /**
     * Test of getMobilePhone method, of class Customer.
     */
    @Test
    public void testGetMobilePhone() {
        System.out.println("* Test getMobilePhone()");
        Customer instance = null;
        try{
            instance = new Customer("3");
        }catch (Exception ex){}
        String expResult = "888-555-8435";
        String result = instance.getMobilePhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMobilePhone method, of class Customer.
     */
    @Test
    public void testSetMobilePhone() {
        System.out.println("setMobilePhone");
        String mobilePhone = "888-555-8435";
        Customer instance = new Customer();
        instance.setMobilePhone(mobilePhone);
        String returnedValue = instance.getMobilePhone();
        assertEquals(mobilePhone, returnedValue);
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("* Test getEmail()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch(Exception ex){}
        String expResult = null;
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("* Test setEmail(String)");
        String email = "jbiggle@main.com";
        Customer instance = new Customer();
        instance.setEmail(email);
        String returnedValue = instance.getEmail();
        assertEquals(email, returnedValue);
    }

    /**
     * Test of getCustomerID method, of class Customer.
     */
    @Test
    public void testGetCustomerID() {
        System.out.println("* Test getCustomerID()");
        Customer instance = null;
        try{
            instance = new Customer("5");
        }catch (Exception ex){}
        String expResult = "5";
        String result = instance.getCustomerID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCustomerID method, of class Customer.
     */
    @Test
    public void testSetCustomerID() {
        System.out.println("* Test setCustomerID(String)");
        String customerID = "8";
        Customer instance = new Customer();
        instance.setCustomerID(customerID);
        String returnedValue = instance.getCustomerID();
        assertEquals(customerID, returnedValue);
    }

 

    /**
     * Test of deleteDB method, of class Customer.
     */
    @Test
    public void testDeleteDB_String() throws Exception {
        System.out.println("deleteDB");
        String customerID = null;
        try{
            Customer.deleteDB(customerID);
        }catch (SQLException ex){
            fail("SQL Error - deleting Customer." + ex.getMessage());
            return;
        }catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        
    }
}
