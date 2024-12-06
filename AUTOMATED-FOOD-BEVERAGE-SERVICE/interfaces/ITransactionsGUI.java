package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ITransactionsGUI extends JFrame {
    private Student student; // The student object, which implements ITransactions
    private JTextArea outputArea;
    private JTextField amountField;

    public ITransactionsGUI(Student student) {
        this.student = student; // Pass the specific student for transaction operations

        setTitle("Transaction Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Components
        outputArea = new JTextArea(6, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel amountLabel = new JLabel("Amount: ");
        amountField = new JTextField();

        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel();
        JButton buyButton = new JButton("Buy Item");
        JButton addButton = new JButton("Add Money");

        buttonPanel.add(buyButton);
        buttonPanel.add(addButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(amountField.getText());
                    if (amount > 0) {
                        student.buyAnItem(amount); // Call buyAnItem method
                        outputArea.append("Purchased item for: " + amount + "TK\n");
                        outputArea.append("New balance: " + student.getBalance() + "TK\n");
                    } else {
                        outputArea.append("Amount must be positive.\n");
                    }
                    amountField.setText("");
                } catch (NumberFormatException ex) {
                    outputArea.append("Please enter a valid amount.\n");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(amountField.getText());
                    if (amount > 0) {
                        student.addMoney(amount); // Call addMoney method
                        outputArea.append("Added money: " + amount + "TK\n");
                        outputArea.append("New balance: " + student.getBalance() + "TK\n");
                    } else {
                        outputArea.append("Amount must be positive.\n");
                    }
                    amountField.setText("");
                } catch (NumberFormatException ex) {
                    outputArea.append("Please enter a valid amount.\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        // For testing, create a student with initial balance
        Student student = new Student("password123", 100, "John Doe", "S12345");
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ITransactionsGUI(student).setVisible(true); // Pass student object to the GUI
            }
        });
    }
}
