/**
* Class: CIST 2373 Java III
* Quarter: Summer 2012
* Instructor: Dave Busse
* Description: 
* Date:
* @author James Vice
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
* */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import javax.swing.border.*;


public class ChattProgramServer extends JFrame {
//Properties for drawGUI()
	public static JButton exitBtn = new JButton("Exit");
	//exitBtn.addActionListener(this);
	public static JButton sendBtn = new JButton("Send");
	public static JPanel TopPanel = new JPanel();
	public static JPanel MidPanel = new JPanel(new BorderLayout());
	public static JPanel BottomPanel = new JPanel(new FlowLayout());
	public static JTextArea tArea = new JTextArea(10, 20);
	public static JTextField tField = new JTextField(10);
	public static JLabel ChattServerLabel = new JLabel("Chatt Server");
	public static JFrame ServerFrame = new JFrame("Chatt Server");	
	
	//Draw GUI()
	public void DrawGUI(){

		//Building the Frame
		ServerFrame.setTitle("ChattServer");
		ServerFrame.setSize(300, 300);
		ServerFrame.setLocation(300, 300);
		setDefaultCloseOperation(ServerFrame.EXIT_ON_CLOSE);
		ServerFrame.setLayout(new BorderLayout());
		
		//Adding the TopFrame
		ServerFrame.add(TopPanel, BorderLayout.NORTH);
		
		//Adding the ChattServerLabel
		TopPanel.add(ChattServerLabel);
		
		//Adding the Middle Frame
		ServerFrame.add(MidPanel, BorderLayout.CENTER);
		
		//Adding the Text Area and setting parameters
		MidPanel.add(tArea, BorderLayout.NORTH);
		tArea.setLineWrap(true);
		tArea.setWrapStyleWord(true);
		
		//Adding the Textfield
		MidPanel.add(tField, BorderLayout.SOUTH);
		
		//Adding the Bottom Frame
		ServerFrame.add(BottomPanel, BorderLayout.SOUTH);
		
		//Adding the Buttons
		BottomPanel.add(sendBtn);
		BottomPanel.add(exitBtn);
		
		//Adding the Action Events
		//exitBtn.addActionListener(this);
		
		//Displaying the GUI
		ServerFrame.setVisible(true);
                
                exitBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you ant to exit?", "Confirm Exit", 0, 2);
		if(result == 0)
		{
		System.exit(0);
		}
		}

	});

	}//End drawGUI()
	
	//SocketSetup()
	public void ServerSocketSetup(){
		
		try
		{
			ServerSocket ss1 = new ServerSocket(8000);
			System.out.println("Server Ready");
			
			Socket s1 = ss1.accept();
			System.out.println("Connection Established");
			
			OutputStream os = s1.getOutputStream();
			PrintStream ps = new PrintStream(os);
			
			ps.println("You have successfully connected");
			
			s1.close();
			ss1.close();
		}//End Try
		
		catch(IOException ioe)
		{
			System.out.println("There is an IO Exception in your code" + ioe);
		}//End Catch
		
	}//End ServerSocketSetup
	
	//Constructor
	public ChattProgramServer(){
		
		DrawGUI();
		ServerSocketSetup();
		
	}//End Constructor
	
	
	
	//Main For Testing
	public static void main(String args[]){
		
		ChattProgramServer cps = new ChattProgramServer();

	}//End Main
	
	
         
        
    

}