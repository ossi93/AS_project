import sun.util.resources.TimeZoneNames_zh_CN;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * Created by rostwald on 01.12.2014.
 */

public class userGUI extends JFrame {
    private JButton bt_searchInvID;
    private JButton bt_searchEmpID;
    private JLabel lb_EmpID;
    private JLabel lb_InvID;
    private JTextField tf_EmpID;
    private JTextField tf_InvID;

    // Creating Object of DBConnector-class, providing connectionString and SQL user credentials
    DBConnector obj_db = new DBConnector("jdbc:sqlserver://DEFR2APP31\\BO_TEST;databaseName=Test", "asproject", "Blumen99");
    // Save connection as an object to "conn"
    Connection conn = obj_db.connectToMSSQL();

    public userGUI() {

        // Name of Window (top left)
        super("InventO - Alpha");

        // Close on [X} Press
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Denying Layout Manager
        this.getContentPane().setLayout(null);

        // Creating Elements
        lb_EmpID = new JLabel("Employee ID");
        lb_InvID = new JLabel("Inventory ID");
        bt_searchInvID = new JButton("Search for Inventory ID");
        bt_searchEmpID = new JButton ("Search for Employee ID");
        tf_EmpID = new JTextField("");
        tf_InvID = new JTextField("");

        // Setting Bounds for Inventory ID
        bt_searchInvID.setBounds(220,40,180,25);
        lb_InvID.setBounds(10,10,100,25);
        tf_InvID.setBounds(10,40,200,25);

        // Setting Bounds for Emp ID
        bt_searchEmpID.setBounds(220,120,180,25);
        lb_EmpID.setBounds(10,90,100,25);
        tf_EmpID.setBounds(10,120,200,25);


        // Adding Elements to Window
        this.getContentPane().add(lb_EmpID);
        this.getContentPane().add(lb_InvID);
        this.getContentPane().add(bt_searchInvID);
        this.getContentPane().add(bt_searchEmpID);
        this.getContentPane().add(tf_InvID);
        this.getContentPane().add(tf_EmpID);
        this.pack();

        // Moving GUI to Center
        this.setLocationRelativeTo(null);

        // ActionListener to bt_searchEmpID
        bt_searchEmpID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmpID_clicked();
            }
        });

        // ActionListener to bt_searchInvID
        bt_searchInvID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInvID_clicked();
            }
        });
    }  // End of UserGUI Constructor

/// Action performed, when bt_searchEmpID is clicked
    public void searchEmpID_clicked() {
        double empID;
        try {
            empID = Double.parseDouble(tf_EmpID.getText());
        } catch (NumberFormatException e) {
            empID = 0;
        }
        if (empID == 0) {
            System.out.println("Please enter a valid Employee ID");
        }
        else {
            obj_db.getEmpByID(conn, empID);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/// Action performed, when bt_searchInvID is clicked
    public void searchInvID_clicked() {
        double invID;
        try {
            invID = Double.parseDouble(tf_InvID.getText());
        } catch (NumberFormatException e) {
            invID = 0;
        }
        if (invID == 0) {
            System.out.println("Please enter a valid Inventory ID");
        } else {
            obj_db.getItemByID(conn, invID);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        userGUI mainGUI = new userGUI();
        mainGUI.setBounds(100,100,520,400);
        mainGUI.show();

    }


}
