package Gui;
import javax.swing.*;
import Procedures.*;
import java.awt.*;
import java.awt.event.*;
public class GuiAccountant extends JFrame { 


	  private JButton DodajF = new JButton("Dodaj Fakturê");
	  private JButton DodajTF = new JButton("Dodaj do Faktury");
	  private JButton Pay = new JButton("Wplac");
	  private JButton PayM = new JButton("Zaplac");



	  public GuiAccountant(){
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
		  Pay.setBounds(0,330, 200,100);		 		  

	    add(DodajF);
	    add(DodajTF);
	    add(Pay);
	    add(PayM);
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
	    Pay.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Pay pay = new Pay();
		    	  pay.setVisible(true);
		      }
		    });
	    PayM.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Payment payM = new Payment();
		    	  payM.setVisible(true);
		      }
		    });	 	  	  
	  }
}
