import javax.swing.*;
import java.awt.*;

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

    public userGUI() {

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


        // Adding Elements to JPanel
        this.getContentPane().add(lb_EmpID);
        this.getContentPane().add(lb_InvID);
        this.getContentPane().add(bt_searchInvID);
        this.getContentPane().add(bt_searchEmpID);
        this.getContentPane().add(tf_InvID);
        this.getContentPane().add(tf_EmpID);

        this.pack();

        // Moving GUI to Center
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        userGUI mainGUI = new userGUI();
        mainGUI.setBounds(100,100,520,400);
        mainGUI.show();

    }
}
