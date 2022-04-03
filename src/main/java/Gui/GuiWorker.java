package Gui;
import javax.swing.*;

import Procedures.AddInvoice;
import Procedures.AddToInvoice;

import java.awt.*;
import java.awt.event.*;
public class GuiWorker extends JFrame { 



	  private JButton DodajF = new JButton("Dodaj Fakturê");
	  private JButton DodajTF = new JButton("Dodaj do Faktury");




	  public GuiWorker(){
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
		  DodajF.setBounds(0,110, 200,100);		  		  
		  DodajTF.setBounds(0,220, 200,100);		  		  		
	    add(DodajF);
	    add(DodajTF);
	  }

	  private void initEvent(){

	    this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e){
	       System.exit(1);
	      }
	    });


	    DodajF.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  AddInvoice addI = new AddInvoice();
	    	   addI.setVisible(true);
	      }
	    });
	    DodajTF.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  AddToInvoice addTI = new AddToInvoice();
		    	   addTI.setVisible(true);
		      }
		    });
 	  	  
	  }
}
