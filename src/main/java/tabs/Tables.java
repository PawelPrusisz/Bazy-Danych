package tabs;
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

public class Tables  extends JPanel{
    private boolean DEBUG = false;

    public Tables(int klientid) {
        super(new GridLayout(1,0));
        DataMaker maker = new DataMaker();
        String[] columnNames = {"Nazwa Produktu",
                "Cena",
                "Ilosc"
                };
        ArrayList<ArrayList<ArrayList<Object>>> wholeData = maker.printData(klientid);
        for(ArrayList<ArrayList<Object>> faktura : wholeData)
        {
        	Object[][] tab = new Object[1000][3];
    		int it = 0;
	    	for(ArrayList<Object> zawartosc : faktura)
	    	{
	    		it ++;
	    		Object[] tmp = new Object[3];
	    		for(int i = 0; i < 3; i++)
	    		{
	    			tmp[i] = zawartosc.get(i);
	    			//System.out.print(zawartosc.toString());
	    		}
	    		tab[it] = tmp;
	    		//System.out.println();
	    	}
	    	Object[][] data = tab;
	    	final JTable table = new JTable(data, columnNames);
	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        table.setFillsViewportHeight(true);

	        if (DEBUG) {
	            table.addMouseListener(new MouseAdapter() {
	                public void mouseClicked(MouseEvent e) {
	                    printDebugData(table);
	                }
	            });
	        }

	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);

	        //Add the scroll pane to this panel.
	        add(scrollPane);
	        /*
	        try
	        {
				Thread.sleep(1000000000);
			} 
	        catch (InterruptedException e)
	        {
				e.printStackTrace();
			}
			*/
        }
        /*
        Object[][] data = {
	    {"", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)},
	    {"John", "Doe",
	     "Rowing", new Integer(3), new Boolean(true)},
	    {"Sue", "Black",
	     "Knitting", new Integer(2), new Boolean(false)},
	    {"Jane", "White",
	     "Speed reading", new Integer(20), new Boolean(true)},
	    {"Joe", "Brown",
	     "Pool", new Integer(10), new Boolean(false)}
        };
		*/
        /*
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        */
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void createAndShowGUI(int klientid) {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Tables newContentPane = new Tables(klientid);
        System.out.print(klientid);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}
