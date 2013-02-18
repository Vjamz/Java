/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit02
* Date 
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit02;


public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(){
        System.out.println("Cannot complete transaction");
    }
}
