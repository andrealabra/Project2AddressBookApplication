package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    protected AddressEntry newEntry;

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

    public AddressEntry getNewEntry() {
        return newEntry;
    }
}
