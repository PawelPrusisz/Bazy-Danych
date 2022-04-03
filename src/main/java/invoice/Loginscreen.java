package invoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Procedures.*;
import Procedures.Error;
import Gui.GuiAccountant;
import Gui.GuiAdmin;
import Gui.GuiClient;
import Gui.GuiPresident;
import Gui.GuiWorker;


public class Loginscreen extends javax.swing.JFrame {
	public String login;


    public Loginscreen() {
        initComponents();
        initComponents2();
     
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Loginscreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Loginscreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Loginscreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Loginscreen.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        setTitle("Login Form");
        setVisible(false);
        btnLogin.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	
    			DatabaseConnector connector = DatabaseConnector.getInstance();
    			
            	int log = connector.logowanie(txtUsername.getText(), txtPwd.getText());
    		    
            	if(txtUsername.getText().contains("'") || txtUsername.getText().contains("#") || txtUsername.getText().contains("\"")) {
    					Error error = new Error(); 
    					error.setAlwaysOnTop(true);
    					error.setVisible(true);
    		    }
    		    
    		    if(txtPwd.getText().contains("'") || txtPwd.getText().contains("#") || txtPwd.getText().contains("\"")) {
					Error error = new Error(); 
					error.setAlwaysOnTop(true);
					error.setVisible(true);
				}
    		    
               if(log != -1) {
            	Danedologowania user = connector.getDaneDoLogowania2(txtUsername.getText());
            	
            	//System.out.println(siema2.haslo);
                if (log  == user.id) {
                    JOptionPane.showMessageDialog(Loginscreen.this, "pomyœlnie zalogowano");

                    	if(user.typKonta.equals("klient")) {
                    		System.out.print("to klient :) " + user.id);
                		    GuiClient  c = new GuiClient(user.id);
                		    c.setVisible(true);
                		    setVisible(false);
                    	}
                    	else if(user.typKonta.equals("pracownik")) {
                    		System.out.print("to pracownik :)");
                		    GuiWorker w = new GuiWorker();
                		    w.setVisible(true);
                		    setVisible(false);

                    	}
                    	else if(user.typKonta.equals("ksiegowy")) {
                    		System.out.print("to ksiegowy :)");
                		    GuiAccountant k = new GuiAccountant();
                		    k.setVisible(true);
                		    setVisible(false);

                    	}
                    	else if(user.typKonta.equals("prezes")) {
                    		System.out.print("to prezes :)");
                		    GuiPresident p = new GuiPresident();
                		    p.setVisible(true);
                		    setVisible(false);

                    	}
                    	else if(user.typKonta.equals("Admin")) {
                    		System.out.print("to Admin :)");
                		    GuiAdmin a = new GuiAdmin();
                		    a.setVisible(true);
                		    setVisible(false);
                    	}                          
                }                    	
               }
              else
               {
                   JOptionPane.showMessageDialog(Loginscreen.this, "niepoprawne dane");
               }                
            }
        });
        rej.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
		    	  AddUser addu = new AddUser();
		    	   addu.setVisible(true);
			}
        	
        });

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
     
        btnLogin = new javax.swing.JButton();
        rej = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(180, 180, 180))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        btnLogin.setText("login");
        rej.setText("rejestracja");
    
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername)
                            .addComponent(txtPwd)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE,50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    
                )
                
                
                
                
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
               // .addComponent(rej)
                .addContainerGap(66, Short.MAX_VALUE))

            
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initComponents2() {
    	rej.setBounds(110, 193, 90, 28);
    	add(rej);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton rej;  
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}