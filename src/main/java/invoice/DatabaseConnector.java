package invoice;
import java.util.List;
import java.util.Spliterator;

import javax.persistence.Parameter;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.jdbc.PreparedStatement;
public class DatabaseConnector{
	
	private static SessionFactory factory;
	
    private static DatabaseConnector instance = null;

    private DatabaseConnector() {
    	try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}

    }

    public static DatabaseConnector getInstance() {
        if(instance == null) {
            synchronized (DatabaseConnector.class) {
                if(instance == null) {
                    instance = new DatabaseConnector();
                }
            }
        }

        return instance;
    }

    public Klient getKlient(int logowanieId) {
    	Session session = factory.openSession();
    	
    	String SQL = "from Klient";
    	Query query  = session.createQuery(SQL);
    	List<Klient> result = query.getResultList();
        session.close();
        return result.get(logowanieId);
    }

    public Zawartoscfaktury getZawartosc(int id) {
    	Session session = factory.openSession();
    	String SQL = "from Zawartoscfaktury";
    	Query query  = session.createQuery(SQL);
    	List<Zawartoscfaktury> result = query.getResultList();
        session.close();
        return result.get(id);
    }
    
    public List<Zawartoscfaktury> getZawartosc2(int fakturaid ) {
    	Session session = factory.openSession();
    	String sql = "from Zawartoscfaktury where fakturaId=:siema";
    	Query query  = session.createQuery(sql);
    	query.setParameter("siema", fakturaid);
    	 List<Zawartoscfaktury> result = ( List<Zawartoscfaktury>) query.getResultList();
    	     
        return result;
    }
    public ArrayList<Faktury> getFaktury2(int Id) {
    	Session session = factory.openSession();
    	String SQL = "from Faktury";
    	Query query  = session.createQuery(SQL);
    	ArrayList<Faktury> result = (ArrayList<Faktury>) query.getResultList();
        session.close();
        return result;
    } 
    public Faktury getFaktury(int Id) {
    	Session session = factory.openSession();
    	String SQL = "from Faktury";
    	Query query  = session.createQuery(SQL);
    	List<Faktury> result = query.getResultList();
        session.close();
        return result.get(Id);
    }
    public List<Kontafirmowe> getKontaFirmowe () {
    	Session session = factory.openSession();
    	String SQL = "from Kontafirmowe";
    	Query query  = session.createQuery(SQL);
    	List<Kontafirmowe> result = query.getResultList();
        session.close();
        return result;
    }
    
    public Produkty getProdukty(int id) {
    	Session session = factory.openSession();
    	String SQL = "from Produkty";
    	Query query  = session.createQuery(SQL);
    	List<Produkty> result = query.getResultList();
        session.close();
        return result.get(id - 1);
    }
    
    
    public Danedologowania getDaneDoLogowania(int id) {
    	Session session = factory.openSession();
    	String SQL = "from Danedologowania";
    	Query query  = session.createQuery(SQL);
    	List<Danedologowania> result = query.getResultList();
        session.close();
        return result.get(id);
    }
  
         
    public void delInvoice(int a) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();  

    	Query spSQLQuery = session.createSQLQuery("DELETE FROM zawartoscfaktury WHERE zawartoscfaktury.fakturaId = " + a);
    	spSQLQuery.executeUpdate();
    	spSQLQuery = session.createSQLQuery("DELETE FROM faktury WHERE faktury.id = " + a);
    	spSQLQuery.executeUpdate();
    	tx.commit();  
    	session.close();
    }
    
    public void delClient(int a) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();  

    	Query spSQLQuery = session.createSQLQuery("DELETE FROM klient WHERE klient.logowanieId = " + a);
    	spSQLQuery.executeUpdate();
    	spSQLQuery = session.createSQLQuery("DELETE FROM danedologowania WHERE danedologowania.id = " + a);
    	spSQLQuery.executeUpdate();
    	tx.commit();  
    	session.close();
    }

    
    public Danedologowania getDaneDoLogowania2(String login ) {
    	Session session = factory.openSession();
    	String sql = "from Danedologowania where login=:siema";
    	Query query  = session.createQuery(sql);
    	query.setParameter("siema", login);
    	Danedologowania result = (Danedologowania) query.getSingleResult();
        session.close();
        return result;
    }
     
    public List<Produkty> pokazFaktury(int a) {
    	Session session = factory.openSession();   
    	StoredProcedureQuery query = session.createStoredProcedureQuery("PokazFaktury");	
    	query.registerStoredProcedureParameter("id",int.class,ParameterMode.IN);    	
    	query.setParameter("id", a); 	
    	query.execute();
    	List<Produkty> result = (List<Produkty>) query.getResultList();

       return result;
    }
                      
    public void addNewUser(String a, String b, String c, String d, String e) {
    	Session session = factory.openSession();
    	
    	StoredProcedureQuery query = session.createStoredProcedureQuery("AddNewUser");
    	
    	query.registerStoredProcedureParameter("newemail",String.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("newlogin",String.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("newhaslo",String.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("newimie",String.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("newnazwisko",String.class,ParameterMode.IN);

    	query.setParameter("newemail", a);
    	query.setParameter("newlogin", b);
    	query.setParameter("newhaslo", c);
    	query.setParameter("newimie", d);
    	query.setParameter("newnazwisko", e);
    	
    	query.execute();

        session.close();
    }

    public void dodajFakture(int a, int b) {
    	Session session = factory.openSession();
    	
    	StoredProcedureQuery query = session.createStoredProcedureQuery("DodajFakture");
    	
    	query.registerStoredProcedureParameter("idKlienta",int.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("idKonta",int.class,ParameterMode.IN);
    	
    	query.setParameter("idKlienta", a);
    	query.setParameter("idKonta", b);
    	
    	query.execute();

        session.close();
    	
    }
    public void dodajDoFaktury(int a, int b, int c) {
    	Session session = factory.openSession();
    	
    	StoredProcedureQuery query = session.createStoredProcedureQuery("DodajDoFaktury");
    	
    	query.registerStoredProcedureParameter("idFaktury",int.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("ile",int.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("idProduktu",int.class,ParameterMode.IN);

    	query.setParameter("idFaktury", a);
    	query.setParameter("ile", b);
    	query.setParameter("idProduktu", c);
    	
    	query.execute();

        session.close();
    	
    }

    public  void OplataFaktury(int a) {
    	Session session = factory.openSession();
    	
    	StoredProcedureQuery query = session.createStoredProcedureQuery("OplataFaktury");
    	query.registerStoredProcedureParameter("idFaktury",int.class,ParameterMode.IN);    	
    	query.setParameter("idFaktury", a);   	
    	query.execute();

        session.close();   	
    }
    
    
    public void wplataKlienta(int a, double b) {
    	Session session = factory.openSession();
    	
    	StoredProcedureQuery query = session.createStoredProcedureQuery("WplataKlienta");
    	query.registerStoredProcedureParameter("idFaktury",int.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("kwota",double.class,ParameterMode.IN);
    	
    	query.setParameter("idFaktury", a);
    	query.setParameter("kwota", b);
    	query.execute();

        session.close();   	
    }

    public void UstawDostep(int a, String b) {
    	Session session = factory.openSession();
    	
    	StoredProcedureQuery query = session.createStoredProcedureQuery("UstawDostep");
    	query.registerStoredProcedureParameter("IdLogowanie",int.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("stanowisko",String.class,ParameterMode.IN);
    	
    	query.setParameter("IdLogowanie", a);
    	query.setParameter("stanowisko", b);
    	query.execute();

        session.close();   	
    }
    
    
    
    public int logowanie(String a, String b) {
    	Session session = factory.openSession();
    	StoredProcedureQuery query = session.createStoredProcedureQuery("Logowanie");
    	query.registerStoredProcedureParameter("curLogin",String.class,ParameterMode.IN);
    	query.registerStoredProcedureParameter("curHaslo",String.class,ParameterMode.IN);

    	query.setParameter("curLogin", a);
    	query.setParameter("curHaslo", b);
       
        int result = (Integer) query.getSingleResult();
        session.close();   
        return result;
 
    }

    public int logowanie2(String a, String b ) {
    	Session session = factory.openSession();
    	StoredProcedureQuery query = session.createStoredProcedureQuery("Logowanie");
    	query.setParameter("curLogin", a);
    	query.setParameter("curHaslo", b);
    	int result = (Integer) query.getSingleResult();
        session.close();
        return result;
    }



	public static void Backupdbtosql() {
	    try {
	        /*NOTE: Getting path to the Jar file being executed*/
	        /*NOTE: YourImplementingClass-> replace with the class executing the code*/
	        CodeSource codeSource = DatabaseConnector.class.getProtectionDomain().getCodeSource();
	        File jarFile = new File(codeSource.getLocation().toURI().getPath());
	        String jarDir = jarFile.getParentFile().getPath();


	        /*NOTE: Creating Database Constraints*/
	        String dbName = "fakturyjanuszexpol";
	        String dbUser = "root";
	        String dbPass = "Pawcio010";

	        /*NOTE: Creating Path Constraints for folder saving*/
	        /*NOTE: Here the backup folder is created for saving inside it*/
	        String folderPath = jarDir + "\\backup";
	        System.out.println(folderPath);

	        /*NOTE: Creating Folder if it does not exist*/
	        File f1 = new File(folderPath);
	        f1.mkdir();

	        /*NOTE: Creating Path Constraints for backup saving*/
	        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
	         String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
	        /*NOTE: Used to create a cmd command*/
	        String executeCmd2 = "mysqldump -u" + dbUser + " -p" + dbPass + " --database " + dbName + " -r " + savePath;
	        String executeCmd = "C:\\Program Files\\MariaDB 10.5\\bin\\mysqldump -u" 
	        + dbUser + " -p" + dbPass + " --database " + dbName + " -r " + savePath;
	        /*NOTE: Executing the command here*/
	        System.out.println(executeCmd);

	        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
	        int processComplete = runtimeProcess.waitFor();

	        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
	        if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Successfull");
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

	    } catch (URISyntaxException | IOException | InterruptedException ex) {
	        JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
	    }
	}
	public static void Restoredbfromsql(String s) {
        try {
            /*NOTE: String s is the mysql file name including the .sql in its name*/
            /*NOTE: Getting path to the Jar file being executed*/
            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = DatabaseConnector.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();

            /*NOTE: Creating Database Constraints*/
	        String dbName = "fakturyjanuszexpol";
	        String dbUser = "root";
	        String dbPass = "Pawcio010";

            /*NOTE: Creating Path Constraints for restoring*/
            String restorePath = jarDir + "\\backup" + "\\" + s;
            restorePath = "C:/Users/pprui/git/Invoice-App/target/backup/" + s + ".sql";
            System.out.println(restorePath + "\n");

            /*NOTE: Used to create a cmd command*/
            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
            String executeCmd2 = "C:\\Program Files\\MariaDB 10.5\\bin\\mysql -u" + dbUser + " -p" + dbPass + " -e \"source " + restorePath + "\" "+ dbName;
        	       // + dbUser + " -p" + dbPass + " --database " + dbName + " -e " + restorePath;
            String[] executeCmd = new String[]{"C:\\Program Files\\MariaDB 10.5\\bin\\mysql ", " -u" + dbUser, " -p" + dbPass, " -e", " \"source " + restorePath + "\"",dbName};
            System.out.println(executeCmd2 + "\n");
           
            
            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd2);
            System.out.println("xD");

            int processComplete = runtimeProcess.waitFor();
            System.out.println("xD");

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Successfully restored from SQL : " + s);
            } else {
                JOptionPane.showMessageDialog(null, "Error at restoring");
            }


        } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
        }

    }
}

