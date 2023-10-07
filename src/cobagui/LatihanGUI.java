/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobagui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Properties;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author hanschristian
 */
public class LatihanGUI implements ActionListener {

    JButton buttonSubmit;
    JFrame frame;
            
    /**
     * 
     */
    public LatihanGUI() {
        // Test Comments
        frame = new JFrame();
        frame.setSize(500, 700);
        frame.getContentPane().setBackground(Color.yellow);
        frame.setBackground(Color.red);
        frame.setLocationRelativeTo(null);
        frame.setTitle("PROGRAM KASIR");

        // Component: Button
        // JButton button, button1, button2, button3, button4;
        // button = new JButton("left");
        // button1 = new JButton("right");
        // button2 = new JButton("top");
        // button3 = new JButton("bottom");
        // button4 = new JButton("center");
        // JButton button5 = new JButton("blabla");

        // Border Layout
    //    frame.add(button, BorderLayout.WEST);
    //    frame.add(button1, BorderLayout.EAST);
    //    frame.add(button2, BorderLayout.NORTH);
    //    frame.add(button3, BorderLayout.SOUTH);
    //    frame.add(button4, BorderLayout.CENTER);

        // Flow Layout
    //    frame.add(button);
    //    frame.add(button1);
    //    frame.add(button2);
    //    frame.add(button3);
    //    frame.add(button4);
    //    frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Grid Layout
    //    frame.add(button);
    //    frame.add(button1);
    //    frame.add(button2);
    //    frame.add(button3);
    //    frame.add(button4);
    //    frame.setLayout(new GridLayout(2, 3));

        // Component: TextField
    //    JTextField textfield1, textfield2, textfield3;
    //    textfield1 = new JTextField("Text field 1", 10);
    //    textfield2 = new JTextField("Text field 2", 10);
    //    textfield3 = new JTextField("Text field 3", 10);
    //    frame.add(textfield1);
    //    frame.add(textfield2);
    //    frame.add(textfield3);

        // Absolute Position
        JButton buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setBounds(100, 150, 100, 40);
        JButton buttonCancel = new JButton("CANCEL");
        buttonCancel.setBounds(210, 100, 100, 40);
        buttonSubmit = new JButton("SUBMIT");
        buttonSubmit.setBounds(10, 100, 200, 40);
        buttonSubmit.setEnabled(true);
        buttonUpdate.setVisible(true);

        // //enter name label
        JLabel label = new JLabel("tes");
        label.setText("Enter Name :");
        label.setBounds(10, 10, 100, 30);
        Color c = new Color(120, 100, 50, 10);
        label.setBackground(Color.RED);
        label.setOpaque(true);

        JLabel labelInfo = new JLabel("default");
        labelInfo.setBounds(10, 150, 200, 100);
        
        JTextField textfieldName = new JTextField();
        textfieldName.setBounds(10, 50, 200, 30);
        textfieldName.setBackground(Color.GREEN);

        // Action Listener
        buttonUpdate.addActionListener(this);
        buttonSubmit.addActionListener(this);
    //    buttonSubmit.addActionListener(new ActionListener() {
    //        @Override
    //        public void actionPerformed(ActionEvent e) {
    //            String name = textfieldName.getText();
    //            labelInfo.setText(name);
    //            textfieldName.setVisible(false);
    //            buttonSubmit.setEnabled(false);
    //        }
    //    });

    //    buttonUpdate.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {

    //         }
    //    });

        textfieldName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Insert: " + e.toString());
                String name = textfieldName.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Remove: " + e.toString());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Change: " + e.toString());
            }
        });
        
        // GUI Library : Date
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        // p.put("text.today", "Today");
        // p.put("text.month", "Month");
        // p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(200, 200, 200, 50);
        
        frame.add(datePicker);
        frame.add(label);
        frame.add(labelInfo);
        frame.add(textfieldName);
        frame.add(buttonUpdate);
        frame.add(buttonCancel);
        frame.add(buttonSubmit);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void onSubmit() {
        new LoginScreen();
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "SUBMIT": 
                onSubmit();
                // new LoginScreen();
                // frame.dispose();
                break;
            case "UPDATE":
                break;
            default: 
                break;
        }
        System.out.println(command);
    }

    public static void main(String[] args) {
        new LatihanGUI();
    }
}
