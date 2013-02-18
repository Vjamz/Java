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

import java.util.*;
import java.lang.Runnable;

public class LoopRunner implements Runnable {
    private char charToPrint;
    private int times;
    
    LoopRunner(char c, int i) { 
        charToPrint = c;
        times = i;
     
    }
    public void run(){
        for(int i = 1; i<=times; i++){
            System.out.print(" " + charToPrint);
        }
    }
        
}
