package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

	public class Backup  extends JFrame {

	  private JButton b  = new JButton("Wykonaj");


	  public Backup(){
	    setTitle("Backup");
	    setSize(400,200);
	    setLocation(new Point(300,200));
	    setLayout(null);    
	    setResizable(false);
	    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	    
	    initComponent();    
	    initEvent();    
	  }

	  private void initComponent(){
	 
		b.setBounds(150,50, 100,25);

	    add(b);

	  }

	  private void initEvent(){


	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        Backup(e);
	      }
	    });
	  }
	  
	  private void Backup(ActionEvent evt){
	
		    try{	
		     // a = Integer.parseInt();

		    }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		    }
		  DatabaseConnector connector = DatabaseConnector.getInstance();		 
		  connector.Backupdbtosql();
	
	  }
	
}
