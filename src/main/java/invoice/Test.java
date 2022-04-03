package invoice;

import java.util.List;

import javax.persistence.Parameter;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main (String[] args)
	{
		DatabaseConnector connector = DatabaseConnector.getInstance();
		
//xD
	   // connector.Backupdbtosql();
		//connector.delInvoice(6);
	  //  connector.Restoredbfromsql("backup.sql");
	   // System.out.print("dom");
		//connector.delInvoice(4);

		///*	
		//Connector with database
	

			//Login screen	   
			try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(Loginscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(Loginscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(Loginscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(Loginscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
	
		        java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new Loginscreen().setVisible(true);
		                
		            }
		        });
		  //	*/
		    }
			

}
