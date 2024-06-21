package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField pfpassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);

        // Adding KeyListener to tfusername
        tfusername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pfpassword.requestFocus(); // Move focus to password field
                }
            }
        });

        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        pfpassword = new JPasswordField();
        pfpassword.setBounds(150, 70, 150, 30);

        // Adding KeyListener to pfpassword
        pfpassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin();
                }
            }
        });

        add(pfpassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login_icon.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    private void performLogin() {
        try {
            String username = tfusername.getText();
            char[] passwordChars = pfpassword.getPassword();
            String password = new String(passwordChars);

            Connection c;
            Statement s=null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","redhat6562");
                s= c.createStatement();
                System.out.print("Connection Successful");
            } catch(Exception e) {
                e.printStackTrace();
            }

            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close any resources if necessary
        }
    }

    public void actionPerformed(ActionEvent ae) {
        performLogin();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}