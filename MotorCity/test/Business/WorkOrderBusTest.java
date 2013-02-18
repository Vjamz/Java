/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author James
 */
public class WorkOrderBusTest {
    
    public WorkOrderBusTest() {
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
            statement.executeUpdate("delete from WorkOrder where WorkOrderID = \'4\';");
            statement.executeUpdate("delete from WorkOrder where WorkOrderID = \'5\';");
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
     * Test of search method, of class WorkOrder.
     */
   /* @Test
    public void testSearch() throws Exception {
        System.out.println("search");
        int s = 0;
        ArrayList expResult = null;
        ArrayList result = WorkOrder.search(s);
        assertEquals(expResult, result);
      
    }
    */
    @Test
    public void testWorkOrder_one_arg1() {
        //This test is dependant on what is in the Motorcity database
        System.out.println("* Test of workOrder(workOrderID)");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch(SQLException ex){
            fail("SQL Exception, " + ex.getMessage());
            return;
        }catch(ClassNotFoundException ex ){
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
    }
        String result = instance.getWorkOrderID();
        assertEquals("3", result);
        result = instance.getCustomerFirstName();
        assertEquals("Zebra", result);
        result = instance.getCustomerLastName();
        assertEquals("Phil", result);  
    }
    
    @Test
    public void testWorkOrder_one_arg2() {
        //This test is dependant on what is in the Motorcity Database
        System.out.println("* Test of WorkOrder(workOrderID) with bad id");
        WorkOrderBus instance = null;
        boolean badIdNotFound = false;
        try{
            instance = new WorkOrderBus("x");
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
    public void testWorkOrder_many_arg() {
        //This test is dependant on what is in the Motorcity Database.
        System.out.println("* Test of WorkOrder(workOrderID, customerLastName, ...)");
        WorkOrderBus instance = null;
        WorkOrderBus instance2 = null;
        try{
            instance = new WorkOrderBus("4", null, "James", "123 Harbor Rd", "ViceCity", "GA",
                    "30107", "Dodge", "Charger", "2003", "Tire Change");
        }catch (SQLException ex){
            fail("SQL Error - inserting new Work Order " + ex.getMessage());
            return;
        }catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        try{
            instance2 = new WorkOrderBus("5");
        }catch (SQLException ex){
            fail("SQL Error - could not find id that was just inserted");
            return;
        }catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDB lib in CLASSPATH");
            return;
        }
        assertEquals(instance.getCustomerLastName(), instance2.getCustomerLastName());
    }
    
    
   


  
    /**
     * Test of getWorkOrderID method, of class WorkOrder.
     */
    @Test
    public void testGetWorkOrderID() {
        System.out.println("getWorkOrderID");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "3";
        String result = instance.getWorkOrderID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setWorkOrderID method, of class WorkOrder.
     */
    @Test
    public void testSetWorkOrderID() {
        System.out.println("setWorkOrderID");
        String workOrderID = "1";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setWorkOrderID(workOrderID);
        String returnedValue = instance.getWorkOrderID();
        assertEquals(workOrderID, returnedValue);
    }

    /**
     * Test of getCustomerFirstName method, of class WorkOrder.
     */
    @Test
    public void testGetCustomerFirstName() {
        System.out.println("getCustomerFirstName");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("2");
        }catch (Exception ex){}
        String expResult = "Barns";
        String result = instance.getCustomerFirstName();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCustomerFirstName method, of class WorkOrder.
     */
    @Test
    public void testSetCustomerFirstName() {
        System.out.println("setCustomerFirstName");
        String customerFirstName = "John";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setCustomerFirstName(customerFirstName);
        String returnedValue = instance.getCustomerFirstName();
        assertEquals(customerFirstName, returnedValue);
        
    }

    /**
     * Test of getCustomerLastName method, of class WorkOrder.
     */
    @Test
    public void testGetCustomerLastName() {
        System.out.println("getCustomerLastName");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("2");
        }catch (Exception ex){}
        
        String expResult = "Sue";
        String result = instance.getCustomerLastName();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCustomerLastName method, of class WorkOrder.
     */
    @Test
    public void testSetCustomerLastName() {
        System.out.println("setCustomerLastName");
        String customerLastName = "Sue";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setCustomerLastName(customerLastName);
        String returnedValue = instance.getCustomerLastName();
        assertEquals(customerLastName, returnedValue);
        
    }

    /**
     * Test of getAddress method, of class WorkOrder.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("1");
        }catch (Exception ex){}
        String expResult = "45 Maple";
        String result = instance.getAddress();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setAddress method, of class WorkOrder.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "45 Maple";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setAddress(address);
        String returnedValue = instance.getAddress();
        assertEquals(address, returnedValue);
    }

    /**
     * Test of getCity method, of class WorkOrder.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "BigCity";
        String result = instance.getCity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCity method, of class WorkOrder.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "BigCity";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setCity(city);
        String returnedValue = instance.getCity();
        assertEquals(city, returnedValue);
        
    }

    /**
     * Test of getState method, of class WorkOrder.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "GA";
        String result = instance.getState();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setState method, of class WorkOrder.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state = "GA";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setState(state);
        String returnedValue = instance.getState();
        assertEquals(state, returnedValue);
        
    }

    /**
     * Test of getZip method, of class WorkOrder.
     */
    @Test
    public void testGetZip() {
        System.out.println("getZip");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "30099";
        String result = instance.getZip();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setZip method, of class WorkOrder.
     */
    @Test
    public void testSetZip() {
        System.out.println("setZip");
        String zip = "30099";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setZip(zip);
        String returnedValue = instance.getZip();
        assertEquals(zip, returnedValue);
        
    }

    /**
     * Test of getMake method, of class WorkOrder.
     */
    @Test
    public void testGetMake() {
        System.out.println("getMake");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "Honda";
        String result = instance.getMake();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMake method, of class WorkOrder.
     */
    @Test
    public void testSetMake() {
        System.out.println("setMake");
        String make = "Honda";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setMake(make);
        String returnedValue = instance.getMake();
        assertEquals(make, returnedValue);
        
    }

    /**
     * Test of getModel method, of class WorkOrder.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "Civic";
        String result = instance.getModel();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setModel method, of class WorkOrder.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        String model = "Civic";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setModel(model);
        String returnedValue = instance.getModel();
        assertEquals(model, returnedValue);
    }

    /**
     * Test of getYear method, of class WorkOrder.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "2001";
        String result = instance.getYear();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setYear method, of class WorkOrder.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        String year = "2001";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setYear(year);
        String returnedValue = instance.getYear();
        assertEquals(year, returnedValue);
       
    }

    /**
     * Test of getDescription method, of class WorkOrder.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        WorkOrderBus instance = null;
        try{
            instance = new WorkOrderBus("3");
        }catch (Exception ex){}
        String expResult = "Car Wax";
        String result = instance.getDescription();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setDescription method, of class WorkOrder.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Car Wax";
        WorkOrderBus instance = new WorkOrderBus();
        instance.setDescription(description);
        String returnedValue = instance.getDescription();
        assertEquals(description, returnedValue);
    }
    
    
      /**
     * Test of deleteDB method, of class WorkOrder .
     */
    @Test
    public void testDeleteDB_String() throws Exception {
        System.out.println("deleteDB");
        String workOrderID = null;
        try{
            WorkOrderBus.deleteDB(workOrderID);
        }catch (SQLException ex){
            fail("SQL Error - deleting Customer." + ex.getMessage());
            return;
        }catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        
}
}