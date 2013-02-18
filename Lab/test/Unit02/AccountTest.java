/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Unit02;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dbusse
 */
public class AccountTest {

    public AccountTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("* Test getBalance()");
        Account instance = new Account(1234,"Jimmy",100);
        int expResult = 100;
        int result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getOwner method, of class Account.
     */
    @Test
    public void testGetOwner() {
        System.out.println("* Test getOwner()");
        Account instance = new Account(1234,"Jimmy",100);
        String expResult = "Jimmy";
        String result = instance.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAcctNo method, of class Account.
     */
    @Test
    public void testGetAcctNo() {
        System.out.println("* Test getAcctNo()");
        Account instance = new Account(1234,"Jimmy",100);
        int expResult = 1234;
        int result = instance.getAcctNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBalance method, of class Account.
     */
    @Test
    public void testSetBalance() {
        System.out.println("* Test setBalance(int)");
        int expectedResult = 5000;
        Account instance = new Account(1234,"Jimmy",1000);
        instance.setBalance(expectedResult);
        int result = instance.getBalance();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of setOwner method, of class Account.
     */
    @Test
    public void testSetOwner() {
        System.out.println("* Test setOwner(String)");
        String expectedResult = "Marcy";
        Account instance = new Account(1234,"Tim",100);
        instance.setOwner(expectedResult);
        String result = instance.getOwner();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of setAcctNo method, of class Account.
     */
    @Test
    public void testSetAcctNo() {
        System.out.println("* Test setAcctNo(int)");
        int acctNo = 7777;
        Account instance = new Account();
        instance.setAcctNo(acctNo);
        int result = instance.getAcctNo();
        assertEquals(acctNo, result);
    }

    /**
     * Test of deposit method, of class Account.
     */
    @Test
    public void testDeposit() {
        System.out.println("* Test deposit(int)");
        int amt = 20;
        Account instance = new Account(2222,"Sue",50);
        instance.deposit(amt);
        int expectedResult = 70;
        int result = instance.getBalance();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() throws InsufficientFundsException {
        System.out.println("* Test withdraw(int)");

        //
        // Test for withdraw that leaves a positive balance
        // Should be no exception
        int amt = 50;
        Account instance = new Account(4444,"Billy",500);
        try {
           instance.withdraw(amt);
        } catch (InsufficientFundsException ex){
            fail("Threw Exception without negative balance. " + ex.getMessage());
            return;
        }
        int expectedResult = 450;
        int result = instance.getBalance();
        assertEquals(expectedResult, result);

        //
        // Test withdraw that leaves a zero balance
        // Should not throw an exception
        try {
           instance.setBalance(100);
           instance.withdraw(100);
        } catch (InsufficientFundsException ex){
            fail("Threw Exception with a zero balance. " + ex.getMessage());
            return;
        }
        expectedResult = 0;
        result = instance.getBalance();
        assertEquals(expectedResult, result);
        
        //
        // Test withdraw that would result in a negative balance
        // Should throw an exception
        try {
            instance.setBalance(400);
            instance.withdraw(400);
        } catch (InsufficientFundsException ex){
            //
            // Test to make sure the balance has not changed
            expectedResult = 0;
            result = instance.getBalance();
            assertEquals(result,expectedResult);
            return;
        }
        //fail("Did not throw Exception with withdrawal that results in a negative balance. ");
       return;
    }

}