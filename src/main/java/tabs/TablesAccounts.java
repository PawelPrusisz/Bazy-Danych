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

public class TablesAccounts  extends JPanel{
    private boolean DEBUG = false;

    public TablesAccounts() {
        super(new GridLayout(1,0));
		DatabaseConnector connector = DatabaseConnector.getInstance();

        String[] columnNames = {"Nazwa Banku",
                "Numer konta",
                "Balans"
                };       
        
        Object[][] data = {
        		{
           			connector.getKontaFirmowe().get(0).getNazwa(),connector.getKontaFirmowe().get(0).getNrKonta(),connector.getKontaFirmowe().get(0).getBalans()
            	},
        		{
        			connector.getKontaFirmowe().get(1).getNazwa(),connector.getKontaFirmowe().get(1).getNrKonta(),connector.getKontaFirmowe().get(1).getBalans()
        		},        		{
        			connector.getKontaFirmowe().get(2).getNazwa(),connector.getKontaFirmowe().get(2).getNrKonta(),connector.getKontaFirmowe().get(2).getBalans()
        		}
        };
	
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
    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TablesAccounts newContentPane = new TablesAccounts();

        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}
