
/**
* Class: Capstone
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: Motor City Repair main application screen.
* Sprint 1
* @author Emma Mays
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */

package GUI;

import Business.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;

public class MainScreen 
{
    private static User userInstance; 
    public static JTextField usertf = new JTextField(25);
    public static JPasswordField passwordtf = new JPasswordField(25);
    public static JFrame frame = new JFrame("Motor City Repair");
            
        
    //Frame for the main application screen
    public static void main(String[] args)
    {
        userInstance = new User();
        frame.setSize(300, 215);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
  

        //Main panel for the buttons that link to location specific applications.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBorder(new LineBorder(Color.BLUE, 5));
        mainPanel.setBackground(Color.WHITE);
        
        //Add main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);
      
        //Add panel for button that accesses Company wide applications. HR, accounts payable, sales receipts etc.
        JPanel company = new JPanel();
        JButton motorCity = new JButton("Motor City Repair");
        company.add(motorCity); 
        company.setBackground(Color.WHITE);
        company.setBorder(new LineBorder(Color.orange, 5));
        
        //Create panel container for each repair location
        JPanel locations = new JPanel();
        JButton mary = new JButton("Mary's Garage");
        JButton north = new JButton("North Garage");
        JButton south = new JButton("South Garage");
        JButton fifth = new JButton("Fifth Street Garage");
        
        locations.setLayout(new GridLayout(4,1));
        locations.add(mary);
        locations.add(north);
        locations.add(south);      
        locations.add(fifth);  
        
        
        //Add location panels to main panel
        frame.add(company, BorderLayout.NORTH);
        mainPanel.add(locations);       
        
        
        //Register the button action listeners 
        mary.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                //link to login window
                // Code for login labels, text fields and buttons
                JLabel userlbl = new JLabel("User Name:");
                userlbl.setBounds(40,30,200,25);
                //JTextField usertf = new JTextField(25);
                usertf.setBounds(140,30,100,25);        
                JLabel passwordlbl = new JLabel("Password:");
                passwordlbl.setBounds(40,60,100,25);
                passwordtf.setBounds(140,60,100,25);       
                JButton submitbtn = new JButton("Login");
                submitbtn.setBounds(100,110,100,25);   
                frame.setVisible(false);  

             
                //Code for login panel to place labels, textfields & buttons.
                JPanel logpanel = new JPanel();
                logpanel.setLayout(null);
                logpanel.setSize(300, 200);
                logpanel.setBackground(Color.WHITE);
                logpanel.setBorder(new LineBorder(Color.BLUE, 5));
                logpanel.add(userlbl);
                logpanel.add(usertf);
                logpanel.add(passwordlbl);
                logpanel.add(passwordtf);
                logpanel.add(submitbtn);
             
                // Code for login frame
                JFrame loginFrame = new JFrame("Log In");
                loginFrame.getContentPane().setLayout(null);
                loginFrame.setSize(305, 228);
                loginFrame.setVisible(true);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.setResizable(false);
                loginFrame.add(logpanel);     
                
             
                //Register the button action listeners 
                submitbtn.addActionListener(new ActionListener() 
                {  
                    public void actionPerformed(ActionEvent e)
                    {
                        //link to login window
                        String username = usertf.getText();
                        char[] password = passwordtf.getPassword();                       
                        try 
                        {
                            userInstance.validateUser(username, String.valueOf(password));
                        }
                        catch (SQLException se) {}
                        catch (ClassNotFoundException cnf) {}
                    }
                });
            }
        });
                
        north.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                //link to login window
             JOptionPane.showMessageDialog(null, "North Garage was clicked.");   
            }
        });
        south.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e){
                
                //link to login window
             JOptionPane.showMessageDialog(null, "South Garage was clicked.");   
            }
        });
        fifth.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                //link to login window
             JOptionPane.showMessageDialog(null, "Fifth Street Garage was clicked.");   
            }
        });
        motorCity.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                //link to login window
             JOptionPane.showMessageDialog(null, "Motor City Repair was clicked.");   
            }
        });   
    }
}