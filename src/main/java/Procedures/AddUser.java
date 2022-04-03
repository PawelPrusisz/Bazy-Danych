package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class AddUser  extends JFrame {

	  private JButton all  = new JButton("Dodaj");

	  private JTextField txtA = new JTextField();
	  private JTextField txtB = new JTextField();
	  private JTextField txtC = new JTextField();
	  private JTextField txtD = new JTextField();
	  private JTextField txtE = new JTextField();
	 
	  private JLabel lblA = new JLabel("imie :"); 
	  private JLabel lblB = new JLabel("nazwisko :"); 
	  private JLabel lblC = new JLabel("Login :");
	  private JLabel lblD = new JLabel("Email :");
	  private JLabel lblE = new JLabel("Haslo :");
	  public AddUser(){
	    setTitle("AddUser");
	    setSize(400,200);
	    setLocation(new Point(300,200));
	    setLayout(null);    
	    setResizable(false);
	    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	    
	    initComponent();    
	    initEvent();    
	  }

	  private void initComponent(){
	    all.setBounds(300,130, 80,25);

	    txtA.setBounds(100,10,100,20);
	    txtB.setBounds(100,35,100,20);
	    txtC.setBounds(100,65,100,20);
	    txtD.setBounds(100,85,100,20);
	    txtE.setBounds(100,110,100,20);

	    lblA.setBounds(20,10,100,20);
	    lblB.setBounds(20,35,100,20);
	    lblC.setBounds(20,60,100,20);
	    lblD.setBounds(20,85,100,20);
	    lblE.setBounds(20,110,100,20);

	    add(all);

	    add(lblA);
	    add(lblB);
	    add(lblC);
	    add(lblD);
	    add(lblE);
	    
	    add(txtA);
	    add(txtB);
	    add(txtC);
	    add(txtD);
	    add(txtE);
	  }

	  private void initEvent(){
	    all.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        Dodaj(e);
	      }
	    });


	  }
	  
	  private void Dodaj(ActionEvent evt){
		  String a = null,b = null,c = null,d = null ,f = null;
		    try{	
		      a = txtA.getText();
		      b = txtB.getText();
		      c = txtC.getText();
		      d = txtD.getText();
		      f = txtE.getText();
		    }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		    }
		    if(a.contains("'") || a.contains("#") || a.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else {  		  
		    	DatabaseConnector connector = DatabaseConnector.getInstance();		 
		    	connector.addNewUser(a,b,c,d,f);
		    	System.exit(0);
		    }	
		    if(a.contains("'") || a.contains("#") || a.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else if(b.contains("'") || b.contains("#") || b.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else if(c.contains("'") || c.contains("#") || c.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else if(d.contains("'") || d.contains("#") || d.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else if(f.contains("'") || f.contains("#") || f.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else {  		  
		    	DatabaseConnector connector = DatabaseConnector.getInstance();		 
		    	connector.addNewUser(a,b,c,d,f);
		    	System.exit(0);
		    }	
	  }

	
}
