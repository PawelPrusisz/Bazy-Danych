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

	public class ShowAccounts{


	  private int klientid;
	  
	  public ShowAccounts(){
	   TablesAccounts tem = new TablesAccounts ();
	   tem.createAndShowGUI();
	  }

}
