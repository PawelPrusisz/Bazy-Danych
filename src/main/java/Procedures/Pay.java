package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class Pay extends JFrame {

	  private JButton b  = new JButton("Dodaj");

	  private JTextField txtA = new JTextField();
	  private JTextField txtB = new JTextField();

	  private JLabel lblA = new JLabel("idFaktury :"); 
	  private JLabel lblB = new JLabel("kwota :"); 

	  public Pay(){
	    setTitle("Pay");
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

	    lblA.setBounds(20,10,100,20);

	    add(b);

	    
	    add(lblA);    
	    add(txtA);

	  }

	  private void initEvent(){
	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  OplataFaktury(e);
	      }
	    });


	  }
	  
	  private void OplataFaktury(ActionEvent evt){
		  int a = 0;
		    try{	
		      a = Integer.parseInt(txtA.getText());
		    }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		    }
		  DatabaseConnector connector = DatabaseConnector.getInstance();		 
		  connector.OplataFaktury(a);
	  }
	
}
