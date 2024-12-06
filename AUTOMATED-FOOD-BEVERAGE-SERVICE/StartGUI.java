
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartGUI extends JFrame {

    private JButton btnTerms, btnRegister, btnService, btnShowAll, btnExit;

    public StartGUI() {
        // Set up the frame
        setTitle("AIUB Automated Food & Beverage Service");
        setSize(400, 300); // Adjust the size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create the main panel and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 rows, 1 column

        btnTerms = new JButton("Read Terms And Conditions");
        btnRegister = new JButton("Student Registration");
        btnService = new JButton("AIUB Automated Food & Beverage Service");
        btnShowAll = new JButton("Show All Registered Students");
        btnExit = new JButton("EXIT");

        // Add buttons to panel
        panel.add(btnTerms);
        panel.add(btnRegister);
        panel.add(btnService);
        panel.add(btnShowAll);
        panel.add(btnExit);

        // Add panel to the frame
        add(panel);

        // Set button actions
        btnTerms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTerms();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationForm();
            }
        });

        btnService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFoodMenu();
            }
        });

        btnShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllRegisteredStudents();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void showTerms() {
        JOptionPane.showMessageDialog(this, "Terms & Conditions:\n"
                + "1. This service is only for students who register...\n"
                + "2. Registration cost is 4500tk per semester...\n"
                + "3. Registered persons can take several meals...");
    }

    private void showRegistrationForm() {
        // Create a new JFrame or JPanel for student registration
        JPanel registerPanel = new JPanel(new GridLayout(3, 2));
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField passwordField = new JPasswordField();

        registerPanel.add(new JLabel("Name: "));
        registerPanel.add(nameField);
        registerPanel.add(new JLabel("ID: "));
        registerPanel.add(idField);
        registerPanel.add(new JLabel("Password: "));
        registerPanel.add(passwordField);

        int option = JOptionPane.showConfirmDialog(this, registerPanel, "Student Registration", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String id = idField.getText();
            String password = passwordField.getText();
            // Call your registration logic here
            JOptionPane.showMessageDialog(this, "Student registered successfully!");
        }
    }

    private void showFoodMenu() {
        // Create a food menu dialog or a new frame
        JOptionPane.showMessageDialog(this, """
                                            Food Menu:
                                            1. Breakfast Items.
                                            2. Lunch Items.
                                            3. Beverage Items.""");
    }

    private void showAllRegisteredStudents() {
        // Show the list of all registered students
        JOptionPane.showMessageDialog(this, """
                                            List of Registered Students:
                                            Student1
                                            Student2
                                            Student3""");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartGUI().setVisible(true);
            }
        });
    }
}
