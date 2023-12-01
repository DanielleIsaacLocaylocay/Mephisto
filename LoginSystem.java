import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSystem extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginSystem() {
    
        setTitle("Login System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    
        setVisible(true);
    }
    private void placeComponents(JPanel panel) {
    
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setBounds(105, 170, 80, 25);
        panel.add(userLabel);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        usernameField = new JTextField(20);
        usernameField.setBounds(185, 170, 165, 25);
        panel.add(usernameField);
        usernameField.setBorder(BorderFactory.createLineBorder(Color.white));

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(105, 210, 80, 25);
        panel.add(passwordLabel);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        passwordField = new JPasswordField(20);
        passwordField.setBounds(185, 210, 165, 25);
        panel.add(passwordField);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.white));
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(105, 250, 80, 25);
        panel.add(loginButton);
        loginButton.setBorder(null);
        
        JButton registerButton = new JButton("Create an account: ");
        registerButton.setBounds(200, 250, 150, 25);
        panel.add(registerButton);
        registerButton.setBorder(null);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                String password = new String(enteredPassword);

                if (isValidLogin(enteredUsername, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }
    private boolean isValidLogin(String username, String password) {
        return "John".equals(username) && "HelloWorld123".equals(password);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginSystem();
            }
        });
    }
}
