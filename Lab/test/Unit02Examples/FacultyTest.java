/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit02Examples;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author James
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
    }

    /**
     * Test of contactInfo method, of class Faculty.
     */
    @Test
    public void testContactInfo() {
        System.out.println("contactInfo");
        Faculty instance = new Faculty("Fred", "123 Maple", "770-777-5555");
        String expResult = "Fred, 123 Maple, 770-777-5555";
        String result = instance.contactInfo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class Faculty.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Faculty instance = new Faculty("Fred", "123 Maple", "770-777-5555");
        String expResult = "Fred";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setName method, of class Faculty.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Faculty instance = new Faculty();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Faculty.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Faculty instance = new Faculty();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Faculty.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Faculty instance = new Faculty();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Faculty.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Faculty instance = new Faculty();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Faculty.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Faculty instance = new Faculty();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
