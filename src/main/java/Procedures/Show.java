package Procedures;

import javax.swing.*;
import tabs.*;
import invoice.DatabaseConnector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import invoice.DatabaseConnector;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

	public class Show  extends JFrame {

	  private JButton all  = new JButton("Poka¿");

	  private JTextField txtA = new JTextField();

	 
	  private JLabel lblA = new JLabel("KlientId :"); 

	  public Show(){
	    setTitle("Show");
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
	    lblA.setBounds(20,10,100,20);
	    
	    add(all);

	    add(lblA);

	    add(txtA);
	  }

	  private void initEvent(){

	    all.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        Show(e);
	      }
	    });


	  }
	  
	  private void Show(ActionEvent evt){
		  int a = Integer.parseInt(txtA.getText());;
		    try{   
		    	a = Integer.parseInt(txtA.getText());;

		    }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		    }		       
			  	Tables tab = new Tables(a);
		                tab.createAndShowGUI(a);
		 }
	  
	
}
