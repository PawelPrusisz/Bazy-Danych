package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class Payment  extends JFrame {

	  private JButton b  = new JButton("Dodaj");

	  private JTextField txtA = new JTextField();
	  private JTextField txtB = new JTextField();

	  private JLabel lblA = new JLabel("idFaktury :"); 
	  private JLabel lblB = new JLabel("kwota :"); 

	  public Payment(){
	    setTitle("Payment");
	    setSize(400,200);
	    setLocation(new Point(300,200));
	    setLayout(null);    
	    setResizable(false);
	    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	    
	    initComponent();    
	    initEvent();    
	  }

	  private void initComponent(){
	    b.setBounds(300,130, 80,25);

	    txtA.setBounds(100,10,100,20);
	    txtB.setBounds(100,35,100,20);

	    lblA.setBounds(20,10,100,20);
	    lblB.setBounds(20,35,100,20);

	    add(b);

	    add(lblA);
	    add(lblB);
	    
	    add(txtA);
	    add(txtB);
	  }

	  private void initEvent(){

	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  wplataKlienta(e);
	      }
	    });


	  }
	  
	  private void wplataKlienta(ActionEvent evt){
		  int a = 0;
		  double b = 0;
		    try{	
		      a = Integer.parseInt(txtA.getText());
		      b = Double.parseDouble(txtB.getText());
		    }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		    }
		    if(txtA.getText().contains("siema")) {
		    
		    }
		    else {
		    	DatabaseConnector connector = DatabaseConnector.getInstance();		 
		    	connector.wplataKlienta(a,b);
		    }
		   }
	
}
