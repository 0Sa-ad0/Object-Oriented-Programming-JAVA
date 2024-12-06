package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterGUI extends JFrame {
    private Student student; // Instance of Student class
    private JTextArea outputArea;
    private JTextField nameField, idField, passwordField, amountField;

    public RegisterGUI() {
        setTitle("Student Register Service");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Components
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JLabel nameLabel = new JLabel("Student Name: ");
        JLabel idLabel = new JLabel("Student ID: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel amountLabel = new JLabel("Amount: ");
        nameField = new JTextField();
        idField = new JTextField();
        passwordField = new JTextField();
        amountField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel();
        JButton registerButton = new JButton("Register Student");
        JButton showInfoButton = new JButton("Show Info");
        JButton addMoneyButton = new JButton("Add Money");
        JButton buyItemButton = new JButton("Buy Item");

        buttonPanel.add(registerButton);
        buttonPanel.add(showInfoButton);
        buttonPanel.add(addMoneyButton);
        buttonPanel.add(buyItemButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Action Listeners
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = idField.getText();
                String password = passwordField.getText();
                try {
                    int initialBalance = 100; // Default balance
                    if (!name.isEmpty() && !id.isEmpty() && !password.isEmpty()) {
                        student = new Student(password, initialBalance, name, id);
                        outputArea.append("Student registered: " + name + "\n");
                    } else {
                        outputArea.append("Please enter valid student details.\n");
                    }
                } catch (Exception ex) {
                    outputArea.append("Error registering student: " + ex.getMessage() + "\n");
                }
            }
        });

        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (student != null) {
                    student.showAllRegisters();
                    outputArea.append("Student Info displayed in console.\n");
                } else {
                    outputArea.append("Please register a student first.\n");
                }
            }
        });

        addMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (student != null) {
                    try {
                        int amount = Integer.parseInt(amountField.getText());
                        student.addMoney(amount);
                        outputArea.append("Money Added. New Balance: " + student.getBalance() + " TK\n");
                    } catch (NumberFormatException ex) {
                        outputArea.append("Please enter a valid amount.\n");
                    }
                } else {
                    outputArea.append("No student registered. Please register first.\n");
                }
            }
        });

        buyItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (student != null) {
                    try {
                        int amount = Integer.parseInt(amountField.getText());
                        student.buyAnItem(amount);
                        outputArea.append("Item purchased. New Balance: " + student.getBalance() + " TK\n");
                    } catch (NumberFormatException ex) {
                        outputArea.append("Please enter a valid amount.\n");
                    }
                } else {
                    outputArea.append("No student registered. Please register first.\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterGUI().setVisible(true);
            }
        });
    }
}
