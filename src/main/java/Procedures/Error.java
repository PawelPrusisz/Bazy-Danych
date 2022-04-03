package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class Error  extends JFrame {

	  private JButton all  = new JButton("OK");

	  public Error(){
	    setTitle("ERROR");
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

	    
	    add(all);

	  }

	  private void initEvent(){


	    all.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        Error(e);
	      }
	    });


	  }
	  
	  private void Error(ActionEvent evt){
		    setVisible(false);
	  }
	  

	
}
