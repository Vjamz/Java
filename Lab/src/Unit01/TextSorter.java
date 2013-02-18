/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: TextSorter
* Date Jan 19, 2012
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit01;
import java.util.Scanner;
public class TextSorter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = null;
        java.util.TreeSet wordList = new java.util.TreeSet();
        while(!"end".equals(word)){
            System.out.println("Enter a word or 'end' to quit:");
            word = input.nextLine();
            wordList.add(word);
            wordList.remove("end");
           
}
       System.out.println(wordList);
       System.exit(0);
}
    
    }

