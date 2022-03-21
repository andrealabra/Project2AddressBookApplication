package address;
import address.data.AddressBook;
import address.data.AddressEntry;
import address.gui.MainGUI;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author Arshdeep Singh, Andrea Labra
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to add data to and delete data from and query an address book
 */
public class AddressBookApplication {


    /**
     * creates an AddressBook initializes the AddressBook with some AddressEntry's and
     * then prompts the user to add, delete, list, and search for entries.
     * @param args command line arguments passed to main
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


//        //create instance of AddressBook for application
//        AddressBook ab = new AddressBook();
//        initAddressBook(ab);
//
//        //Code to Loop until user chooses to Quit
//        //Display Menu of options, based on user's choice
//        //invoke apprpriate code.
//        Scanner keyboard = new Scanner(System.in);
//        String answer;
//
//        //Loop
//        boolean continueLoop = true;
//        while(continueLoop) {
//            //display menu
//            Menu.display_Menu();
//            //grab users choice and based on this invoke code
//            answer = keyboard.nextLine();
//            //print a few line returns before processing
//            System.out.println("\n\n");
//            switch (answer) {
//                case "a" -> { //case of read from file
//                    System.out.println("Enter in FileName:");
//                    ab.readFromFile(keyboard.nextLine());
//                }
//                case "b" -> ab.add(Menu.promptForNewAddressEntry());  //case add new address object using Menu class prompts to User
//                case "c" -> { //remove an address entry
//                    System.out.println("Enter in Last Name of contact to remove:");
//                    ab.remove(keyboard.nextLine());
//                }
//                case "d" -> { //find AddressEntry based on last name or start of it
//                    System.out.println("Enter in all or beginning of last name you wish to find:");
//                    ab.find(keyboard.nextLine());
//                }
//                case "e" -> ab.list();  //list alphanumerically based on last name all the users
//                case "f" -> {
//                    System.out.println("Quitting.");
//                    continueLoop = false;
//                }
//                default -> System.out.println("Error: " + answer + " is not a valid selection.");
//            }
//        }

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

        // Select the all (*) from the table JAVATEST

        ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        System.out.println(rset);

        // Iterate through the result and print the employee names

        while (rset.next ()) //get next row of table returned

        {         for(int i=1; i<=rset.getMetaData().getColumnCount(); i++) //visit each column

            System.out.print(rset.getString(i) + " | ");

            System.out.println(" ");

            System.out.println("========================================");

        }

        //Close access to everything...will otherwise happen when disconnect

        // from database.

        rset.close();

        stmt.close();

        conn.close();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // write your code here
                MainGUI mainGUI = new MainGUI();
            }
        });
}

    /**
     * initializes 2 AddressEntry instances with hard-coded data. Then adds entries to AddressBook class passed to function.
     * @param ab is an instance of AddressBook class
     */
    public static void initAddressBook(AddressBook ab) {
        AddressEntry entry1 = new AddressEntry("Sterling", "Jeppson",
                                                "2759 Vine Dr.","Livermore",
                                                "CA", 94550, "sterlingijeppson@gmail.com", "925-289-6963");
        AddressEntry entry2 = new AddressEntry("D.S", "Malik",
                "2759 Vine Dr.","Livermore",
                "CA", 94550, "sterlingijeppson@gmail.com","925-289-6963");
        ab.add(entry1);
        ab.add(entry2);
    }




}
