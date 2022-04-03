package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class DelClient  extends JFrame {

	  private JButton all  = new JButton("Usun");

	  private JTextField txtA = new JTextField();

	 
	  private JLabel lblA = new JLabel("Id :"); 

	  public DelClient(){
	    setTitle("Restore");
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
	        Restore(e);
	      }
	    });


	  }
	  
	  private void Restore(ActionEvent evt){
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
		  connector.delClient(a);
		  }
}
	  
	

