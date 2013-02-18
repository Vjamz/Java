/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit07  
* Date : April 16th, 2012
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit07;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class NameLookupServer extends JFrame {
     
    private JTextArea jta = new JTextArea();
    
    public static void main(String[] args) {
        new NameLookupServer();
    }
    

    
public NameLookupServer() {
    
    setLayout(new BorderLayout());
    add(new JScrollPane(jta), BorderLayout.CENTER);
    
    setTitle("NameLookupServer");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    try {
        ServerSocket serverSocket = new ServerSocket(88);
        jta.append("Server started at " + new Date() + '\n');
        
        Socket socket = serverSocket.accept();
        
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
        
        String s1 = "";
        
        while (true) {
            int ssn = inputFromClient.readInt();
        switch (ssn) {
            case 7000123: s1 = "John Doe";
                break;
            case 7000453: s1 = "Mary Smith";
                break;
            case 7000677: s1 = "G. Washington";
                break;
            case 7000799: s1 = "B. Franklin";
                break;
            case 7000388: s1 = "B. Ford";
                break;
            default: s1 = "No matching data";
        }
            outputToClient.writeUTF(s1);
            
            jta.append("Student recieved from client: " + ssn + '\n');
           
        }
    }
    catch(IOException ex) {
        System.err.println(ex);
    }
    
}
}
