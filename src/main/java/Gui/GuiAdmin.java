package Gui;
import javax.swing.*;

import Procedures.*;

import java.awt.*;
import java.awt.event.*;
public class GuiAdmin extends JFrame { 


	  private JButton DodajU  = new JButton("Dodaj U¿ytkownika");
	  private JButton DodajF = new JButton("Dodaj Fakturê");
	  private JButton DodajTF = new JButton("Dodaj do Faktury");
	  private JButton SetPerm = new JButton("Ustaw Dostêp");
	  private JButton Backup = new JButton("Backup");
	  private JButton Restore = new JButton("Restore");
	  private JButton DelInvoice = new JButton("Delete Invoice");
	  private JButton DelClient = new JButton("Delete Client");

	  



	  public GuiAdmin(){
	    setTitle("App");
	    setSize(500,700);
	    setLocation(new Point(300,200));
	    setLayout(null);    
	    setResizable(false);
	    setAlwaysOnTop(true);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	    
	    initComponent();    
	    initEvent();    
	  }

	  private void initComponent(){
		  DodajU.setBounds(0,0, 200,100);		  		  
		  DodajF.setBounds(0,110, 200,100);		  		  
		  DodajTF.setBounds(0,220, 200,100);		  		  
		  SetPerm.setBounds(0,550, 200,100);
		  Backup.setBounds(300,90,200,100);
		  Restore.setBounds(300,210,200,100);
		  DelInvoice.setBounds(300,330,200,100);
		  DelClient.setBounds(300,450,200,100);


		  
	    add(DodajU);
	    add(DodajF);
	    add(DodajTF);
	    add(SetPerm);
	    add(Backup);
	    add(Restore);
	    add(DelInvoice);
	    add(DelClient);

	  }

	  private void initEvent(){

	    this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e){
	       System.exit(1);
	      }
	    });

	    DodajU.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  AddUser addu = new AddUser();
	    	   addu.setVisible(true);
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
	    SetPerm.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  SetPerm setPerm = new SetPerm();
		    	  setPerm.setVisible(true);
		      }
		    });
	    Backup.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Backup backup = new Backup();
		    	  backup.setVisible(true);
		      }
		    });

	    Restore.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Restore Restore = new Restore();
		    	  Restore.setVisible(true);
		      }
		    });
	    DelClient.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DelClient dC = new DelClient();
		    	  dC.setVisible(true);
		      }
		    });
	    DelInvoice.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DelInvoice dI = new DelInvoice();
		    	  dI.setVisible(true);
		      }
		    });

	  }
}
