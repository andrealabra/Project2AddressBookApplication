package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainGUI extends JFrame {
    private JPanel mainPanel;
    private JScrollPane listingJScrollPane;
    private JButton newButton;
    private JButton removeButton;
    private JButton displayButton;
    private JList <AddressEntry> addressEntryJList;
    Vector<AddressEntry> addressEntryList = new Vector<AddressEntry>();

    DefaultListModel<AddressEntry> myaddressEntryListModel = new DefaultListModel<AddressEntry>();
    

    public MainGUI(){

        add(mainPanel);
        setLayout(new GridLayout());

        //listingJScrollPane = new JScrollPane(this.addressEntryJList);
        listingJScrollPane.setViewportView(addressEntryJList);
       //getContentPane().add(this.listingJScrollPane, BorderLayout.CENTER);
        //add(listingJScrollPane);
        this.addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        this.addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        this.addressEntryJList.setVisibleRowCount(-1);
        //getContentPane().add(listingJScrollPane, BorderLayout.CENTER);
        setTitle("Address Book Application");
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
//                         write your code here
                        NewGUI newGUI = new NewGUI();
                    };
                });
            }
        });
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dummyData();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = addressEntryJList.getSelectedIndex();

                if(index != -1)//something is selected otherwise do nothing

                {   //retrieve the DeffaultListModel associated
                    // with our JList and remove from it the AddressEntry at this index

                    ((DefaultListModel<AddressEntry>) (addressEntryJList.getModel())).remove(index);

                    // NOTE in your project 2 you will also remove it from your AddressBook.addressEntryList
                    // AND ALSO remove it from the associated database table

                }
            }
        });

    }

    public void dummyData(){
        //make a dummy addressEntryList with 2 AddressEntry objects--Project 2 will read from Database instead,etc.
        addressEntryList.add(new AddressEntry("Lynne", "Grewe", "33 A street", "Hayward", "CA", 9399,"l@csueastbay.edu","555-1212"));

        addressEntryList.add(new AddressEntry("Jane", "Doe", "22 Cobble street", "Hayward", "CA", 9399,"jane@csueastbay.edu","555-9999"));

        //because we want to REMOVE or ADD to our JList we have to create it

        //from a DefaultListModel (see https://docs.oracle.com/javase/tutorial/uiswing/components/list.html)
        // to which we add the elements of our collection of AddressEntry objects

        for(int i = 0; i<addressEntryList.size(); i++)
        {  this.myaddressEntryListModel.add(i, this.addressEntryList.elementAt(i)); }
        //Now when we create our JList do it from our ListModel rather than our vector of AddressEntry

        addressEntryJList.setModel(myaddressEntryListModel);
        //this.addressEntryJList = new JList<AddressEntry>(this.myaddressEntryListModel);

        //setting up the look of the JList


    }
    public void initialize() {
        //create scrollPane associated with JList
        //JScrollPane scrollPane = new JScrollPane(this.addressEntryJList);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = addressEntryJList.getSelectedIndex();

                if(index != -1)//something is selected otherwise do nothing

                {   //retrieve the DeffaultListModel associated
                    // with our JList and remove from it the AddressEntry at this index

                    ((DefaultListModel<AddressEntry>) (addressEntryJList.getModel())).remove(index);

                    // NOTE in your project 2 you will also remove it from your AddressBook.addressEntryList
                    // AND ALSO remove it from the associated database table

                }
            }
        });
        listingJScrollPane.setColumnHeaderView(removeButton);
    }
}
