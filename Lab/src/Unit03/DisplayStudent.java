/**
* Class: CIS 2421 Java II
* Quarter: Spring 2012
* Instructor: Dave Busse
* Description: 
* Date 
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package Unit03;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class DisplayStudent extends JFrame {
    
    String database_name;
    String search_ssn;
    int StudentCount = 0;
   
    
    
    public DisplayStudent() {
        
        final JPanel p1 = new JPanel(new BorderLayout());
        final JTextArea jta1 = new JTextArea();
        add(jta1, BorderLayout.CENTER);
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        add(jmb, BorderLayout.NORTH);
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem connect = new JMenuItem("Connect");
        JMenuItem close = new JMenuItem("Close");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem search = new JMenuItem("Search");
        JMenuItem clear = new JMenuItem("Clear");
        jmb.add(file);
        jmb.add(edit);
        file.add(connect);
        file.add(close);
        file.add(exit);
        edit.add(search);
        edit.add(clear);
        file.setMnemonic('F');
        edit.setMnemonic('E');
        connect.setMnemonic('C');
        close.setMnemonic(KeyEvent.VK_L);
        exit.setMnemonic(KeyEvent.VK_X);
        search.setMnemonic('S');
        clear.setMnemonic('A');
        
        JPanel p2 = new JPanel(new BorderLayout());
        final JLabel l1 = new JLabel("No Connection");
        final JLabel l2 = new JLabel("Number of Students = 0");
        p2.add(l1, BorderLayout.WEST);
        p2.add(l2, BorderLayout.EAST);
        add(p2, BorderLayout.SOUTH);
        p2.setBorder(new javax.swing.border.LineBorder(Color.BLACK));
        
        connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String database_name = JOptionPane.showInputDialog(null, "Supply Database Name?");
               if(database_name != null)
                   l1.setText("Connected to " + database_name);
            }
        });
        close.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Attention Required!", 0,2);
               if (result == 0){
                   l1.setText("Not Connected");
                   l2.setText("Number of Student = 0");
               }
           } 
        });
        search.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(!l1.getText().equals("Not Connected")){
                   String search_ssn = JOptionPane.showInputDialog(null, "Enter Social Security Number", "Search Students", 3);
                   jta1.setText(jta1.getText() + "Test Student [" + search_ssn + "]\012");
                   StudentCount++;
                   l2.setText("Number of Students = " + StudentCount);
               } else {
                   JOptionPane.showMessageDialog(null, "You must be connected to a database before searching","Application Error", 0);
               }
           } 
        });
        clear.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               StudentCount = 0;
               l2.setText("Number of Students = " + StudentCount);
               jta1.setText("");
               p1.updateUI();
           } 
        });
        
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
    }
    
    
    public static void main(String[] args){
       DisplayStudent frame = new DisplayStudent();
       frame.setSize(400,300);
       frame.setTitle("Display Student");
       frame.setLocationRelativeTo(null); // Center the frame
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}
