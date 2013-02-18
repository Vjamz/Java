/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Brittney Zeigler
 */
public class MainApplication
{
    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("Motor City Repair");
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBorder(new LineBorder(Color.BLUE, 5));
        mainPanel.setBackground(Color.WHITE);
        
        mainFrame.add(mainPanel, BorderLayout.CENTER);       
        JMenuBar menuBar = new JMenuBar();
        mainFrame.add(menuBar);
        mainFrame.add(menuBar, BorderLayout.NORTH);


         JMenu fileMenu = new JMenu("File");
         JMenu editMenu = new JMenu("Edit");
         JMenuItem newWorkOrder = new JMenuItem("Create Work Order");
         JMenuItem searchWorkOrder = new JMenuItem("Search Work Order");
         JMenuItem SearhCustomer = new JMenuItem("Search For a Customer");
         JMenuItem openAction = new JMenuItem("Take Payment");
         JMenuItem printAction = new JMenuItem("Print");
         JMenuItem saveAction = new JMenuItem("Save Work Order");
         JMenuItem exitAction = new JMenuItem("Exit");
         JMenuItem cutAction = new JMenuItem("Cut");
         JMenuItem copyAction = new JMenuItem("Copy");
         JMenuItem pasteAction = new JMenuItem("Paste");

         menuBar.add(fileMenu);
         menuBar.add(editMenu);
         fileMenu.add(newWorkOrder);
         fileMenu.add(searchWorkOrder);
         fileMenu.add(SearhCustomer);
         fileMenu.add(saveAction);
         fileMenu.add(openAction);
         fileMenu.add(printAction);

         fileMenu.addSeparator();
         fileMenu.add(exitAction);
         editMenu.add(cutAction);
         editMenu.add(copyAction);
         editMenu.add(pasteAction);
         editMenu.addSeparator();
         mainFrame.setVisible(true);
    }
}