import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAccount extends JFrame implements ActionListener {

    private JTextField firstNameTextField, lastNameTextField, usernameTextField, emailTextField, contactNumberTextField;
    private JPasswordField passwordField;
    private JTextArea addressTextArea;
    private JButton registerButton;

    public RegisterAccount() {
        SwingUtilities.invokeLater(() -> {
            setTitle("Create an Account");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 400);
            setLocationRelativeTo(null);

            // Adding a title at the top
            JLabel titleLabel = new JLabel("Create an Account");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            add(titleLabel, BorderLayout.NORTH);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            // Labels
            JLabel firstNameLabel = new JLabel("FIRST NAME");
            JLabel lastNameLabel = new JLabel("LAST NAME");
            JLabel usernameLabel = new JLabel("USERNAME");
            JLabel passwordLabel = new JLabel("PASSWORD");
            JLabel addressLabel = new JLabel("ADDRESS");
            JLabel emailLabel = new JLabel("EMAIL");
            JLabel contactNumberLabel = new JLabel("CONTACT NUMBER");

            // TextFields
            firstNameTextField = new JTextField(20);
            lastNameTextField = new JTextField(20);
            usernameTextField = new JTextField(20);
            passwordField = new JPasswordField(20);
            addressTextArea = new JTextArea(4, 20);
            JScrollPane addressScrollPane = new JScrollPane(addressTextArea);
            emailTextField = new JTextField(20);
            contactNumberTextField = new JTextField(20);

            // Register Button
            registerButton = new JButton("REGISTER");
            registerButton.addActionListener(this);

            // Add components to the contentPane using GridBagConstraints
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            contentPane.add(firstNameLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            contentPane.add(firstNameTextField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            contentPane.add(lastNameLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            contentPane.add(lastNameTextField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            contentPane.add(usernameLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            contentPane.add(usernameTextField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            contentPane.add(passwordLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            contentPane.add(passwordField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            contentPane.add(addressLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 4;
            contentPane.add(addressScrollPane, gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            contentPane.add(emailLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 5;
            contentPane.add(emailTextField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            contentPane.add(contactNumberLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 6;
            contentPane.add(contactNumberTextField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 2;
            contentPane.add(registerButton, gbc);

            // Add contentPane to the center of the frame
            add(contentPane, BorderLayout.CENTER);

            setVisible(true);
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String username = usernameTextField.getText();
            String password = new String(passwordField.getPassword());
            String address = addressTextArea.getText();
            String email = emailTextField.getText();
            String contactNumber = contactNumberTextField.getText();

            // Perform validation
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidContactNumber(contactNumber)) {
                JOptionPane.showMessageDialog(this, "Invalid contact number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Perform registration logic here

            // Print the registration details
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Username: " + username);
            System.out.println("Address: " + address);
            System.out.println("Email: " + email);
            System.out.println("Contact Number: " + contactNumber);
        }
    }

    private boolean isValidEmail(String email) {
        // Implement email validation logic
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    private boolean isValidContactNumber(String contactNumber) {
        // Implement contact number validation logic
        return contactNumber.matches("\\d{10}");
    }

    public static void main(String[] args) {
        new RegisterAccount();
    }
}
