package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class AddInvoice  extends JFrame {

	  private JButton b  = new JButton("Dodaj");

	  private JTextField txtA = new JTextField();
	  private JTextField txtB = new JTextField();

	  private JLabel lblA = new JLabel("idKlienta :"); 
	  private JLabel lblB = new JLabel("idKonta :"); 

	  public AddInvoice(){
	    setTitle("AddInvoice");
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
	        Dodaj(e);
	      }
	    });


	  }
	  
	  private void Dodaj(ActionEvent evt){
		  int a = 0,b = 0;
		    try{	
		      a = Integer.parseInt(txtA.getText());
		      b = Integer.parseInt(txtB.getText());
		    }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		    }
		  DatabaseConnector connector = DatabaseConnector.getInstance();		 
		  connector.dodajFakture(a,b);
		  System.exit(0);
	  }
	
}
