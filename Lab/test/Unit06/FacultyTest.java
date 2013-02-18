/*
 * CIST 2372 Java II
 * Unit 06 Lab JUnit tester - FacultyTest
 * Spring Semester 2012
 * Version 1.0
 * 
 * This tester will test your Faculty class for the standard number of points.
 * You'll have to modify this tester to test for the extra credit, if you 
 * decide to do the "Above and Beyond" part of the lab.
 * 
 * This tester assumes you have the database connecter in your 
 * projects Libraries folder in NetBeans.
 * 
 * This tester can fail for a number of reasons if your Faculty class
 * is incomplete.  When it fails, look at the first failed test only.
 * Figure out how to change your Faculty class to pass that one test
 * then re-test.
 * 
 * Some tests in this tester are dependant on another method working in
 * your Faculty class.  Sometimes all you have to do to get the test
 * for "methodA" to work is to get "methodB" working.  This is particularly
 * true of the constructors.  Get them working first.
 * 
 */

package Unit06;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dbusse
 */
public class FacultyTest {

    public FacultyTest() {
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
        //
        // Delete test data from database.
        // Version 2.0, March 31, 2012, DBusse - added delete for test row 999999999
        Connection con;
        try {
            con = makeConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate("delete from Faculty where ssn = \'999221119\';");
            statement.executeUpdate("delete from Faculty where ssn = \'999999999\';");
            con.close();
        } catch (SQLException ex) {
            // ignore
        } catch (ClassNotFoundException ex) {
            // ignore
        }
        
    }

    /**
     * Utility Method.
     * 
     * This tester has to be able to create test data in the database.
     * Thus we need a way to connect.
     */
    	private static Connection makeConnection() throws SQLException, ClassNotFoundException{
	     // Load the JDBC driver 
        Class.forName("com.mysql.jdbc.Driver");  
      
        // Establish a connection 
        Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/test", "scott", "tiger"); 
		  return connection;
   }
    
    /**
     *  Utility Method
     * 
     * We need a way to create a test row in the database.
     * This will create a row for Donald Knuth, our test
     * subject.
     * @return new row ssn 
     */
     private String createTestRow(){
        String ssn = "999999999";
        try {
            Connection con = makeConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into Faculty values(\'"+ssn+"',\'Don\',\'E\',\'Knuth\',\'9995674456\',\'dknuth@gmail.com\',\'F1126\',\'1999-04-01\',\'Full Professor\', \'150000.00\',\'CS\');");
            con.close();
        } catch (SQLException ex) {
            fail("Utility method createTestRow FAILED: SQL Execption, "+ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            fail("Utility method createTestRow FAILED: ClassNotFound Execption, "+ex.getMessage());
            return null;
        }

       return ssn;
     }
    
    /**
     * Test of Faculty(id) constructor, of class Faculty.
     */
    @Test
    public void testFaculty_one_arg_1() {
        //
        // This test is dependant on the contents
        // of the test database
        System.out.println("* Test of Facult(id)");
        Faculty instance = null;
        try{
           instance = new Faculty("111221119");
        } catch(SQLException ex){
            fail("SQL Execption, " + ex.getMessage());
            return;
        } catch(ClassNotFoundException ex){
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        String result = instance.getSsn();
        assertEquals("111221119", result);
        result = instance.getFirstName();
        assertEquals("Ray", result);
        result = instance.getLastName();
        assertEquals("Smith", result);
        double resultAmt = instance.getSalary();
        assertEquals(85000.00,resultAmt,0.0);
        result = instance.getStartTime();
        assertEquals("1994-01-01", result);
    }

   /**
     * Test of Faculty(id) constructor, of class Faculty.
     */
    @Test
    public void testFaculty_one_arg_2() {
        //
        // This test is dependant on the contents
        // of the test database
        System.out.println("* Test of Faculty(id) with bad id");
        Faculty instance = null;
        boolean badIdNotFound = false;
        try{
           instance = new Faculty("11122111x");
        } catch(SQLException ex){
            badIdNotFound = true;
        } catch(ClassNotFoundException ex){
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        assertTrue(badIdNotFound);
    }


   /**
     * Test of Faculty(id, firstName, mi, ...) constructor, of class Faculty.
     * Depends on Faculty(ssn) working.
     */
    @Test
    public void testFaculty_many_arg() {
        //
        // This test is dependant on the contents
        // of the test database.
        System.out.println("* Test of Faculty(id, fistname, ...)");
        Faculty instance = null;
        Faculty instance2 = null;
        try{
           instance = new Faculty("999221119", "John", 'H', "Doe","9995551212",
                   "jdoe@main.com","F3333", "1990-01-01","Full Prof",85000.00,"CS");
        } catch (SQLException ex) {
            fail("SQL Error - inserting new Faculty member. " + ex.getMessage());
            return;
        } catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        try{
          instance2 = new Faculty("999221119");
        } catch(SQLException ex){
            fail("SQL Error - cound not find id that was just inserted");
            return;
        } catch(ClassNotFoundException ex){
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }

        assertEquals(instance.getFirstName(), instance2.getFirstName());
    }


    /**
     * Test of getSsn method, of class Faculty.
     */
    @Test
    public void testGetSsn() {
        System.out.println("* Test getSsn()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "111221119";
        String result = instance.getSsn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSsn method, of class Faculty.
     */
    @Test
    public void testSetSsn() {
        System.out.println("* Test setSsn(String)");
        String ssn = "7777777";
        Faculty instance = new Faculty();
        instance.setSsn(ssn);
        String returnedValue = instance.getSsn();
        assertEquals(ssn, returnedValue);
    }

    /**
     * Test of getFirstName method, of class Faculty.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("* Test getFirstName()");
         Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "Ray";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Faculty.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("* Test setFirstName(String)");
        String firstName = "Fred";
        Faculty instance = new Faculty();
        instance.setFirstName(firstName);
        String returnedValue = instance.getFirstName();
        assertEquals("Fred", returnedValue);
    }

    /**
     * Test of getLastName method, of class Faculty.
     */
    @Test
    public void testGetLastName() {
        System.out.println("* Test getLastName()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "Smith";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Faculty.
     */
    @Test
    public void testSetLastName() {
        System.out.println("* Test setLastName()");
        String lastName = "Smith";
        Faculty instance = new Faculty();
        instance.setLastName(lastName);
        String returnedValue = instance.getLastName();
        assertEquals("Smith", returnedValue);
    }

    /**
     * Test of getMi method, of class Faculty.
     */
    @Test
    public void testGetMi() {
        System.out.println("* Test getMi()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        char expResult = 'R';
        char result = instance.getMi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMi method, of class Faculty.
     */
    @Test
    public void testSetMi() {
        System.out.println("* Test setMi(char)");
        char mi = 'Q';
        Faculty instance = new Faculty();
        instance.setMi(mi);
        char returnedValue = instance.getMi();
        assertEquals('Q', returnedValue);
    }

    /**
     * Test of getPhone method, of class Faculty.
     */
    @Test
    public void testGetPhone() {
        System.out.println("* Test getPhone()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "9129215563";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhone method, of class Faculty.
     */
    @Test
    public void testSetPhone() {
        System.out.println("* Test setPhone(String)");
        String phone = "555-666-7777";
        Faculty instance = new Faculty();
        instance.setPhone(phone);
        String returnedValue = instance.getPhone();
        assertEquals(phone, returnedValue);
    }

    /**
     * Test of getEmail method, of class Faculty.
     */
    @Test
    public void testGetEmail() {
        System.out.println("* Test getEmail()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "ray@yahoo.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Faculty.
     */
    @Test
    public void testSetEmail() {
        System.out.println("* Test setEmail(String)");
        String email = "foobar@mail.com";
        Faculty instance = new Faculty();
        instance.setEmail(email);
        String returnedValue = instance.getEmail();
        assertEquals(email, returnedValue);
    }

    /**
     * Test of getOffice method, of class Faculty.
     */
    @Test
    public void testGetOffice() {
        System.out.println("* Test getOffice()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "SC133";
        String result = instance.getOffice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOffice method, of class Faculty.
     */
    @Test
    public void testSetOffice() {
        System.out.println("* Test setOffice(String)");
        String office = "F9999";
        Faculty instance = new Faculty();
        instance.setOffice(office);
        String returnedValue = instance.getOffice();
        assertEquals(office, returnedValue);
    }

    /**
     * Test of getStartTime method, of class Faculty.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("* Test getStartTime()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "1994-01-01";
        String result = instance.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartTime method, of class Faculty.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("* Test setStartTime(String)");
        String startTime = "2001-01-01";
        Faculty instance = new Faculty();
        instance.setStartTime(startTime);
        String returnedValue = instance.getStartTime();
        assertEquals(startTime, returnedValue);
    }

    /**
     * Test of getRank method, of class Faculty.
     */
    @Test
    public void testGetRank() {
        System.out.println("* Test getRank()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221119");
        }catch(Exception ex){}
        String expResult = "Full Professor";
        String result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRank method, of class Faculty.
     */
    @Test
    public void testSetRank() {
        System.out.println("* Test setRank()");
        String rank = "Full Professor";
        Faculty instance = null;
        try{
          instance = new Faculty("111221118");
        }catch(Exception ex){}
        instance.setRank(rank);
        String returnedValue = instance.getRank();
        assertEquals(rank, returnedValue);
    }

    /**
     * Test of getSalary method, of class Faculty.
     */
    @Test
    public void testGetSalary() {
        System.out.println("* Test getSalary()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221118");
        }catch(Exception ex){}
        double expResult = 75000.00;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSalary method, of class Faculty.
     */
    @Test
    public void testSetSalary() {
        System.out.println("* Test setSalary(double)");
        double salary = 100000.00;
        Faculty instance = new Faculty();
        instance.setSalary(salary);
        double returnedValue = instance.getSalary();
        assertEquals(salary, returnedValue, 0.0);
    }

    /**
     * Test of getDeptId method, of class Faculty.
     */
    @Test
    public void testGetDeptId() {
        System.out.println("* Test getDeptId()");
        Faculty instance = null;
        try{
          instance = new Faculty("111221115");
        }catch(Exception ex){}
        String expResult = "CS";
        String result = instance.getDeptId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeptId method, of class Faculty.
     */
    @Test
    public void testSetDeptId() {
        System.out.println("* Test setDeptId(String)");
        String deptId = "CIS";
        Faculty instance = new Faculty();
        instance.setDeptId(deptId);
        String returnedValue = instance.getDeptId();
        assertEquals(deptId, returnedValue);
    }

    /**
     * Test of deleteDB method, of class Faculty.
     */
    @Test
    public void testDeleteDB_String(){
        System.out.println("* Test static deleteDB(ssn)");

        String ssn = createTestRow();
        try {
            Faculty.deleteDB(ssn);
        } catch (SQLException ex) {
            fail("SQL Error - deleting Faculty member. " + ex.getMessage());
            return;
        } catch (ClassNotFoundException ex) {
            fail("Class Not Found Exception, check JDBC lib in CLASSPATH");
            return;
        }
        
    }

}