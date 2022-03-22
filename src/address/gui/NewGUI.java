package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * public class NewGUI that extends JFrame
 */
public class NewGUI extends JFrame{
    /**
     * JLabel class is a component for placing text in a container which is FirstName Label
     */
    private JLabel firstNameLabel;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is firstNameTextField
     */
    private JTextField firstNameTextField;
    /**
     * JLabel class is a component for placing text in a container which is LastName Label
     */
    private JLabel lastNameLabel;
    /**
     * JLabel class is a component for placing text in a container which is City Label
     */
    private JLabel cityLabel;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is CityNameTextField
     */
    private JTextField cityTextField;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is stateNameTextField
     */
    private JTextField stateTextField;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is zipCodeTextField
     */
    private JTextField zipCodeTextField;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is lastNameTextField
     */
    private JTextField lastNameTextField;
    /**
     * JLabel class is a component for placing text in a container which is state Label
     */
    private JLabel stateLabel;
    /**
     * JLabel class is a component for placing text in a container which is zipCode Label
     */
    private JLabel zipCodeLabel;
    /**
     * JLabel class is a component for placing text in a container which is phoneNumber Label
     */
    private JLabel phoneNumberLabel;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is phonenumber TextField
     */
    private JTextField phoneNumberTextField;
    /**
     * JLabel class is a component for placing text in a container which is email Label
     */
    private JLabel emailLabel;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is emailTextField
     */
    private JTextField emailTextField;
    /**
     * JLabel class is a component for placing text in a container which is street Label
     */
    private JLabel streetLabel;
    /**
     * JTextField class is a text component that allows the editing of a single line text which is streetTextField
     */
    private JTextField streetTextField;
    /**
     * JButton newButton create a labeled button that submit
     */
    private JButton submitButton;
    /**
     * private JPanel that Creating a panel to add buttons
     */
    private JPanel newPanel;
    //public JPanel newPanel;
    /**
     * AddressEntry newEntry
     */
    private AddressEntry newEntry;

    /**
     * public NewGUI
     */
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
                newEntry = new AddressEntry(firstNameTextField.getText(),lastNameTextField.getText(),streetTextField.getText(),cityTextField.getText(),stateTextField.getText(), Integer.parseInt(zipCodeTextField.getText()),emailTextField.getText(),phoneNumberTextField.getText());
                postToDatabase(firstNameTextField.getText(),lastNameTextField.getText(),streetTextField.getText(),cityTextField.getText(),stateTextField.getText(),Integer.parseInt(zipCodeTextField.getText()),emailTextField.getText(),phoneNumberTextField.getText());


            }
        });
    }

    /**
     *
     * @param firstName string
     * @param lastName string
     * @param street    string
     * @param city sting
     * @param state string
     * @param zip int
     * @param email string
     * @param phone string
     */

    public void postToDatabase(String firstName, String lastName, String street,
                               String city, String state, int zip, String email, String phone) {

        try {
            // Load the Oracle JDBC driver
            //Class.forName("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

            //check Oracle documentation online
            // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());


            // Connect to the database
            // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
            // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
            //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:mcs1004/wXTOOCL4@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

            // Create a Statement


            //Constructing The SQL Query

            String sql = "INSERT INTO ADDRESSENTRYTABLE (firstname, lastname, street, city, state, zip, phone, email) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2,lastName);
            stmt.setString(3,street);
            stmt.setString(4,city);
            stmt.setString(5,state);
            stmt.setInt(6,zip);
            stmt.setString(7,phone);
            stmt.setString(8,email);
            //stmt.setInt(9,5);


            int row = stmt.executeUpdate();

            if (row > 0) {
                System.out.println("A new record has been added");
            }else{
                System.out.println("Not inserted");
            }

            stmt.close();
            conn.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }



    }

    /**
     *
     * @return newEntry
     */
    public AddressEntry getNewEntry() {
        return newEntry;
    }
}
