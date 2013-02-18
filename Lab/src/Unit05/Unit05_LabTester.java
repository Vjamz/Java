/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit05 Lab
* Date: 3/19/12
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit05;


public class Unit05_LabTester {
    public static void main(String[] args){
        LoopRunner printA = new LoopRunner('a', 50);
        LoopRunner printB = new LoopRunner('b', 50);
        LoopRunner printC = new LoopRunner('c', 50);
        LoopRunner printD = new LoopRunner('d', 50);
       
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(printC);
        Thread thread4 = new Thread(printD);
        
        //start threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        System.out.println("Main thread here");
       
    }
}
