package Gui;
import javax.swing.*;

import Procedures.*;
import java.awt.*;
import java.awt.event.*;
public class GuiPresident extends JFrame { 


	  private JButton DodajU  = new JButton("Dodaj U?ytkownika");
	  private JButton DodajF = new JButton("Dodaj Faktur?");
	  private JButton DodajTF = new JButton("Dodaj do Faktury");
	  private JButton Pay = new JButton("Wplac");
	  private JButton PayM = new JButton("Zap?ac");
	  private JButton SetPerm = new JButton("Ustaw Dost?p");
	  private JButton Backup = new JButton("Backup");
	  private JButton Restore = new JButton("Restore");
	  private JButton Show = new JButton("Poka? faktury");
	  private JButton ShowA = new JButton("Poka? konta bankowe");
	  private JButton DelInvoice = new JButton("Delete Invoice");
	  private JButton DelClient = new JButton("Delete Client");

	 
	  public GuiPresident(){
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
		  DodajU.setBounds(0,0, 200,100);		  		  
		  DodajF.setBounds(0,110, 200,100);		  		  
		  DodajTF.setBounds(0,220, 200,100);		  		  
		  Pay.setBounds(0,330, 200,100);		 		  
		  PayM.setBounds(0,440, 200,100);
		  Backup.setBounds(300,0,200,100);
		  Restore.setBounds(300,110,200,100);
		  Show.setBounds(300,220,200,100);
		  ShowA.setBounds(300, 330, 200, 100);
		  DelInvoice.setBounds(300,440,200,100);
		  DelClient.setBounds(300,550,200,100);
	    
		add(DodajU);
	    add(DodajF);
	    add(DodajTF);
	    add(Pay);
	    add(PayM);
	    add(SetPerm);
	    add(Backup);
	    add(Restore);
	    add(Show);
	    add(ShowA);
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
	    SetPerm.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  SetPerm SetPerm = new SetPerm();
		    	  SetPerm.setVisible(true);
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
	    Show.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Show show = new Show();
		    	  show.setVisible(true);
		      }
		    });	 
	    ShowA.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  ShowAccounts siema = new ShowAccounts();
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
