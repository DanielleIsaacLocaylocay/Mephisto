import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSystem extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginSystem() {
    
        setTitle("LAMIKAEYO");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Left side na panel (Gray color)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.GRAY);
        add(leftPanel);
        placeComponents(leftPanel);
        leftPanel.setBounds(0, 0, 300, 500);
        
        // Right side na panel (Maroon color)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(128, 0, 0)); 
        add(rightPanel);
        placeComponents(rightPanel);
        
        /* Wala ko kabalo nganong nahimo ni siyang main panel(maroon panel)
         if ako e wagtang ning "setVisible" na function kay mawala ang maroon na panel haha*/ 
         
         // Naa ra ninyo if e re-construct ninyog balik haha  
        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
    
        panel.setLayout(null);
        
        // Username:
        // Di ko kabalo atong ang JLabel na Username kay naas sulod sa JTextField haha
        JLabel userLabel = new JLabel("Username: ");
        userLabel.setBounds(320, 170, 80, 25);
        panel.add(userLabel);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        // Username textfield
        usernameField = new JTextField(20);
        usernameField.setBounds(400, 170, 165, 25);
        panel.add(usernameField);
        
        // Password
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(320, 210, 80, 25);
        panel.add(passwordLabel);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        // Password textfield
        passwordField = new JPasswordField(20);
        passwordField.setBounds(400, 210, 165, 25);
        panel.add(passwordField);
        
        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(400, 250, 80, 25);
        panel.add(loginButton);
        
        
        // Ambot gi unsa ni gi ChatGPT raman ni nako kay wala dyud ko kasabot sa looping hahaha
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                String password = new String(enteredPassword);

                if (isValidLogin(enteredUsername, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
                if (usernameField.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "Please fill out username and password before proceeding.");
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
