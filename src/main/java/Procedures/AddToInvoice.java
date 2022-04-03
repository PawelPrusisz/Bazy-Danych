package Procedures;

import javax.swing.*;

import invoice.DatabaseConnector;

import java.awt.*;
import java.awt.event.*;

	public class AddToInvoice  extends JFrame {

	  private JButton b  = new JButton("Dodaj");

	  private JTextField txtA = new JTextField();
	  private JTextField txtB = new JTextField();
	  private JTextField txtC = new JTextField();

	  private JLabel lblA = new JLabel("idFaktury :"); 
	  private JLabel lblB = new JLabel("ile :"); 
	  private JLabel lblC = new JLabel("idPorduktu :");

	  public AddToInvoice(){
		  init();
		  initComponent();    
		  initEvent(); 
	  }

	  private void init() {
		    JFrame frame = new JFrame();
			setTitle("AddToInvoice");
		    setSize(400,200);
		    setLocation(new Point(300,200));
		    setLayout(null);    
		    setResizable(false);
		    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		    //dispatchEvent(new WindowEvent(frame ,WindowEvent.WINDOW_CLOSING));

		    initComponent();    
		    initEvent(); 
	  }
	  
	  private void initComponent(){
	    b.setBounds(300,130, 80,25);

	    txtA.setBounds(100,10,100,20);
	    txtB.setBounds(100,35,100,20);
	    txtC.setBounds(100,65,100,20);

	    lblA.setBounds(20,10,100,20);
	    lblB.setBounds(20,35,100,20);
	    lblC.setBounds(20,60,100,20);

	    add(b);

	    add(lblA);
	    add(lblB);
	    add(lblC);
	    
	    add(txtA);
	    add(txtB);
	    add(txtC);

	  }

	  private void initEvent(){
	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        DodajTo(e);
	      }
	    });
	  }
	  
	  private void DodajTo(ActionEvent evt){
		  int a = 0,b = 0,c = 0;
		  String d = null;
		  try{	
		      a = Integer.parseInt(txtA.getText());
		      d = txtA.getText();
		      b = Integer.parseInt(txtB.getText());
		      c = Integer.parseInt(txtC.getText());
		      		
		  }catch(Exception e){
		      System.out.println(e);
		      JOptionPane.showMessageDialog(null, 
		          e.toString(),
		          "Error", 
		          JOptionPane.ERROR_MESSAGE);
		  }
		    if(d.contains("'") || d.contains("#") || d.contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				  }
		    else {
		    	DatabaseConnector connector = DatabaseConnector.getInstance();		 
		    	connector.dodajDoFaktury(a,b,c);	 
		    }
		  }
	
}
