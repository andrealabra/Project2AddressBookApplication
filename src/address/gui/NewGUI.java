package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewGUI extends JFrame{
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JLabel cityLabel;
    private JTextField cityTextField;
    private JTextField stateTextField;
    private JTextField zipCodeTextField;
    private JTextField lastNameTextField;
    private JLabel stateLabel;
    private JLabel zipCodeLabel;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel streetLabel;
    private JTextField streetTextField;
    private JButton submitButton;
    private JPanel newPanel;
    //public JPanel newPanel;

    private AddressEntry newEntry;

    public NewGUI(){
        add(newPanel);
        setLayout(new GridLayout());
        setTitle("New Entry Form");
        setSize(600,600);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEntry = new AddressEntry(firstNameTextField.getText(),lastNameTextField.getText(),streetTextField.getText(),cityTextField.getText(),stateTextField.getText(),
                        Integer.parseInt(zipCodeTextField.getText()),emailTextField.getText(),phoneNumberTextField.getText());
            }
        });
    }

    public void postToDatabase(String firstName, String lastName, String street,
                               String city, String state, int zip, String email, String phone) throws SQLException, ClassNotFoundException{
        // Load the Oracle JDBC driver
        Class.forName ("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

        //check Oracle documentation online
        // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());



        // Connect to the database
        // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
        // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
        //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:mcs1004/wXTOOCL4@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

        // Create a Statement
        Statement stmt = conn.createStatement ();

        //Constructing The SQL Query

        String sql = "INSERT INTO EMPLOYEE VALUES" +
                "(111, 'Navin', 'Sharma', 'CEO')";



    }
    public AddressEntry getNewEntry() {
        return newEntry;
    }
}
