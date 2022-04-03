package Gui;
import javax.swing.*;

import Procedures.*;
import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;
public class GuiClient extends JFrame { 


	  private JButton PayM = new JButton("Zaplac");
	  private JButton ShowClient = new JButton("Poka¿ faktury");
	  private int klientid;


	  public GuiClient(int id){
	    this.klientid = id;
		setTitle("App");
	    setSize(500,700);
	    setLocation(new Point(300,200));
	    setLayout(null);    
	    setResizable(false);
	    setAlwaysOnTop(true);

	    initComponent();    
	    initEvent();    
	  }

	  private void initComponent(){	  		  
		  PayM.setBounds(0,440, 200,100);
		  ShowClient.setBounds(0, 550, 200, 100);
	   
		  add(PayM);
	      add(ShowClient);

	  }

	  private void initEvent(){

	    this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e){
	       System.exit(1);
	      }
	    });


	    PayM.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Payment payM = new Payment();
		    	  payM.setVisible(true);
		      }
		    });	 	  	  
	    ShowClient.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {

		    	  ShowClient ShowClient = new ShowClient(klientid);

		      }
		    });	
	  }
}
