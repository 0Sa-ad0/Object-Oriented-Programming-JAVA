package classes;

import fileio.FileReadWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileReadWriteGUI extends JFrame {
    private FileReadWrite fileReadWrite; // Instance of FileReadWrite class
    private JTextArea outputArea;
    private JTextField inputField;

    public FileReadWriteGUI() {
        fileReadWrite = new FileReadWrite(); // Initialize the FileReadWrite object

        setTitle("File Read/Write History");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Components
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel inputLabel = new JLabel("Enter Action: ");
        inputField = new JTextField();

        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton writeButton = new JButton("Write to History");
        JButton readButton = new JButton("Read History");

        buttonPanel.add(writeButton);
        buttonPanel.add(readButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Action Listeners
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if (!text.isEmpty()) {
                    fileReadWrite.writeInFile(text); // Write the text to History.txt
                    outputArea.append("Added to History: " + text + "\n");
                    inputField.setText(""); // Clear the input field
                } else {
                    outputArea.append("Please enter some text to write.\n");
                }
            }
        });

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(""); // Clear previous output
                fileReadWrite.readFromFile(); // Read the contents of the file and display
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileReadWriteGUI().setVisible(true);
            }
        });
    }
}
