package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class AddEmployee extends JFrame implements ActionListener{
	
	

	Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfage, tfstate;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add, back;
	
	AddEmployee() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Add Student Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        heading.setForeground(Color.red);
        add(heading);
        
        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        
        tfname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	dcdob.requestFocus(); // Move focus to DOB field
                }
            }
        });
        
        add(tfname);
        
        JLabel labelfname = new JLabel("Mother's Name:");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        
        tffname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tfage.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        dcdob.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tfaddress.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Age:");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfage = new JTextField();
        tfage.setBounds(600, 200, 150, 30);
        tfage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tfphone.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(tfage);
        
        JLabel labeladdress = new JLabel("Address:");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        
        tfaddress.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tfemail.requestFocus(); // Move focus to DOB field
                }
            }
        });
        
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone:");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        tfphone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	cbeducation.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email:");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        tfemail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tfstate.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education:");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tfaadhar.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("State:");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfstate = new JTextField();
        tfstate.setBounds(200, 350, 150, 30);
        tfstate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	lblempId.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(tfstate);
        
        JLabel labelaadhar = new JLabel("Aadhar Number:");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        tfaadhar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	add.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(tfaadhar);
        
        JLabel labelempId = new JLabel("Student ID:");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        lblempId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	tffname.requestFocus(); // Move focus to DOB field
                }
            }
        });
        add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
	
	
	
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String age = tfage.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String state = tfstate.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();
            
            try {
            	Connection c;
        		Statement s=null;
        		try {
        			
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","redhat6562");
        			s= c.createStatement();
        			System.out.println("Connection Successful");
        		}catch(Exception e) {
        			e.printStackTrace();
        		}
        		
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+age+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+state+"', '"+aadhar+"', '"+empId+"')";
                s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
	
	
	
	public static void main(String[] args) {
		
		
		new AddEmployee();

	}

}
