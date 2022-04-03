package Procedures;

import javax.swing.*;
import tabs.*;
import invoice.DatabaseConnector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import invoice.DatabaseConnector;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

	public class ShowClient{


	  private int klientid;
	  
	  public ShowClient(int a){
	   this.klientid = a;
	   System.out.println("ShowClient" + this.klientid);
	   Tables tab = new Tables(this.klientid);
	   tab.createAndShowGUI(this.klientid);
	  }

}
