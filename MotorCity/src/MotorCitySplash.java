


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MotorCitySplash extends JApplet {

    public static void main(String[] args) {
        
              
//Create a menu bar
        JMenuBar frameMenuBar = new JMenuBar();

//Create first menu in menubar
        JMenu menu1 = new JMenu("File");

//Create second menu in menubar
        JMenu menu2 = new JMenu("WorkOrder");

//Create third menu in menubar
        JMenu menu3 = new JMenu("Employees");

//Create fourth menu in menubar
        JMenu menu4 = new JMenu("Parts");

//Create menu that will be add into third menu
/*
         * JMenu menu3_internalMenu1=new JMenu("Search");
         */

//Create first menu item for first menu
        JMenuItem menuItemS = new JMenuItem("Save");

//Create Second menu item for first menu File
        JMenuItem menuItemE = new JMenuItem("Exit");

//Create first menu item for second menu Work Order
        JMenuItem menuItem2 = new JMenuItem("New");

//Create second menu item for Work Order
        JMenuItem menuItem3 = new JMenuItem("Search");

//Create a third menu item for Work Order
        JMenuItem menuItemP = new JMenuItem("Payment");

//Create first menu item for third menu - Customer
        JMenuItem menuItem4 = new JMenuItem("Search");

//Create second menu item for third menu - Customer
        JMenuItem menuItem5 = new JMenuItem("Update");

//Create second menu item for fourth menu - Parts
        JMenuItem menuItem6 = new JMenuItem("Search");

//Create menu item that will be add into internal menu in third menu
//JMenuItem menuItem5=new JMenuItem("Update");//

//add first menu item into first menu
        menu1.add(menuItemS);


//add second menu item into first menu - File
        menu1.add(menuItemE);

//add first menu item into second menu - Work Order
        menu2.add(menuItem2);

//add second menu item into second menu - Work Order
        menu2.add(menuItem3);

//add third menu item into second menu - Work Order
        menu2.add(menuItemP);


//add first menu item into third menu - Customers
        menu3.add(menuItem4);

//add second menu item into third menu - Customers
        menu3.add(menuItem5);

//add first menu item into fourth menu - Parts
        menu4.add(menuItem6);

//add internal menu into third menu
/*
         * menu3.add(menu3_internalMenu1);
         */

//add menu item into internal menu
//menu3_internalMenu1.add(menuItem5);//

//add first menu into menu bar
        frameMenuBar.add(menu1);

//add second menu into menu bar
        frameMenuBar.add(menu2);

//add third menu into menu bar
        frameMenuBar.add(menu3);

//add third menu into menu bar
        frameMenuBar.add(menu4);


//Create a JFrame with title ( JFrame with menu bar )
        JFrame frame = new JFrame("MotorCity Repairs");

//Set menu bar for JFrame
        frame.setJMenuBar(frameMenuBar);

//Set default close operation for JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Set JFrame size
        frame.setSize(400, 300);

//Make JFrame visible. So we can see it.
        frame.setVisible(true);

      
        
       

        
        
      

    }
}