/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit04
* Date: 03/05/12
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit04;

import java.io.*;
import java.lang.Math;
import java.util.Random;

        
public class CreateData {
    public static void main(String[] args)throws IOException {
      RandomAccessFile file = new RandomAccessFile("CreateData.dat", "rw");
      Random r1 = new Random(100);
      
      file.setLength(0);
      
      for (int i=0; i < 100; i++)
         file.write(r1.nextInt(100));
        
      
      file.close();
     
    }
}
