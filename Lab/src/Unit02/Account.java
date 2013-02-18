/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit02 Lab
* Due Date: 2/8/12
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */
package Unit02;

/**
 *
 * @author James
 */

public class Account extends InsufficientFundsException {
   private int acctNo;
   private String owner;
   private int balance;
   


public Account() {
    
}

public Account(int acctNo, String owner, int balance) {
    this.acctNo = acctNo;
    this.owner = owner;
    this.balance = balance;
}

public void withdraw(int amt)throws InsufficientFundsException {
        //setBalance(getBalance() - amt);
        if (balance < 0) 
            throw new InsufficientFundsException();
        else
            balance = balance - amt;
        
          
        }
        

public void deposit(int amt){
        setBalance(getBalance() + amt);
}

    /**
     * @return the acctNo
     */
    public int getAcctNo() {
        return acctNo;
    }

    /**
     * @param acctNo the acctNo to set
     */
    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance)  {
        this.balance = balance;
     
}
        
    }

