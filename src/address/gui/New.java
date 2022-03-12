package address.gui;

import address.data.AddressEntry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class New {
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

    AddressEntry newEntry;

    public New(){
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEntry = new AddressEntry(firstNameTextField.getText(),lastNameTextField.getText(),streetTextField.getText(),cityTextField.getText(),stateTextField.getText(),
                        Integer.parseInt(zipCodeTextField.getText()),emailTextField.getText(),phoneNumberTextField.getText());
            }
        });
    }
}
