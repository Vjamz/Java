/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: Unit07
* Date: April 16th, 2012
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NameLookupClient extends JFrame {
    
    private JTextField jtf = new JTextField();
    private JTextArea jta = new JTextArea();
    
    private DataOutputStream toServer;
    private DataInputStream fromServer;
    
    public static void main(String[] args) {
        new NameLookupClient();
    }

    public NameLookupClient() {
        
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel("Enter SSN"), BorderLayout.WEST);
        p.add(jtf, BorderLayout.CENTER);
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
        add(new JScrollPane(jta), BorderLayout.CENTER);
        
        jtf.addActionListener(new ButtonListener());
        
        setTitle("NameLookupClient");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        try {
            Socket socket = new Socket("localhost", 88);
            
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            }
        catch (IOException ex) {
            jta.append(ex.toString() + '\n');
        }
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int ssn = Integer.parseInt(jtf.getText().trim());
                
                toServer.writeInt(ssn);
                toServer.flush();
                
                String s = fromServer.readUTF();
                jta.append(s + '\n');
            }
            catch (IOException ex){
                System.err.println(ex);
            }
        }

       
    }
    
}
