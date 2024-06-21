package employee.management.system;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.sql.*;

import java.awt.event.*;
public class ViewEmployee extends JFrame implements ActionListener{


	DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable table = new JTable(model);
    Choice cemployeeId;
    JButton search,update, back;            
   
	 ViewEmployee(){
		 getContentPane().setBackground(Color.WHITE);
	     setLayout(null);
	     
	     	JLabel searchlbl = new JLabel("Search by Student Id");
	        searchlbl.setBounds(0, 0, 200, 20);
	        add(searchlbl);
	        

	        cemployeeId = new Choice();
	        cemployeeId.setBounds(180, 20, 150, 20);
	        add(cemployeeId);
	        
	        try {
	        	Connection c;
         		Statement s=null;
         		try {
         			
         			Class.forName("com.mysql.cj.jdbc.Driver");
         			c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","redhat6562");
         			s= c.createStatement();
         			System.out.print("Connection Successful");
         		}catch(Exception e) {
         			e.printStackTrace();
         		}
	            ResultSet rs = s.executeQuery("select * from employee");
	            while(rs.next()) {
	                cemployeeId.add(rs.getString("empId"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
	        setSize(600, 400);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));

	        model.addColumn("NAME");
	        model.addColumn("FATHER NAME");
	        model.addColumn("DOB");
	        model.addColumn("AGE");
	        model.addColumn("ADDRESS");
	        model.addColumn("PHONE");
	        model.addColumn("EMAIL");
	        model.addColumn("EDUCATION");
	        model.addColumn("STATE");
	        model.addColumn("ADDHAR");
	        model.addColumn("EMPLOYEE");
	        
	     
	     try {
         	Connection c;
     		Statement s=null;
     		try {
     			
     			Class.forName("com.mysql.cj.jdbc.Driver");
     			c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","redhat6562");
     			s= c.createStatement();
     			System.out.print("Connection Successful");
     		}catch(Exception e) {
     			e.printStackTrace();
     		}
     		
     		String query="select * from employee";
     		ResultSet rs = s.executeQuery(query);
  
     		 while(rs.next()){
                 model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                		 rs.getString(5), String.valueOf(rs.getInt("salary")),
                		 rs.getString("address"),String.valueOf(rs.getDouble("phone")),rs.getString("email"),
                		 rs.getString("education"),	rs.getString("designation"),String.valueOf(rs.getDouble("aadhar")),
                		 String.valueOf(rs.getInt("empId"))});
             }
     		 
     		while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
     		
//     		while(rs.next()) {
//     			String name= rs.getString("name");
//         		String fname= rs.getString("fname");
//         		String dob= String.valueOf(rs.getString("dob"));
//         		String salary=String.valueOf(rs.getInt("salary"));
//         		String address= rs.getString("address");
//         		String phone= String.valueOf(rs.getDouble("phone"));
//         		String email= rs.getString("email");
//         		String education= rs.getString("education");
//         		String designation= rs.getString("designation");
//         		String addhar= String.valueOf(rs.getDouble("aadhar"));
//         		String empId= String.valueOf(rs.getInt("empId"));
//         		
//         		String tableData[]= {name,fname,dob,salary,address,phone,email,education,designation,addhar,empId};
//         		DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
//         		
//         		tbmodel.addRow(tableData);
//     		}

     		
            
     		
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
     		
	        
	        search = new JButton("Search");
	        search.setBounds(0, 0, 80, 20);
	        search.addActionListener(this);
	        add(search);
	        
	        update = new JButton("Update");
	        update.setBounds(0, 0, 80, 20);
	        update.addActionListener(this);
	        add(update);
	        
	        back = new JButton("Back");
	        back.setBounds(0, 0, 80, 20);
	        back.addActionListener(this);
	        add(back);
     		
	        JScrollPane pg = new JScrollPane(table);
	        cnt.add(pg);
	        
	        cnt.setPreferredSize(new Dimension(10000, 50000));
//	        pg.setSize(200, 500);
	        this.pack();
	        
	        TableColumnModel columnModel = table.getColumnModel();
	        columnModel.getColumn(0).setPreferredWidth(400);
	        columnModel.getColumn(1).setPreferredWidth(400);
	        columnModel.getColumn(2).setPreferredWidth(400);
	        columnModel.getColumn(3).setPreferredWidth(400);
	        columnModel.getColumn(4).setPreferredWidth(400);
	        columnModel.getColumn(5).setPreferredWidth(400);
	        columnModel.getColumn(6).setPreferredWidth(400);
	        columnModel.getColumn(7).setPreferredWidth(400);
	        columnModel.getColumn(8).setPreferredWidth(400);
	        columnModel.getColumn(9).setPreferredWidth(400);
	        columnModel.getColumn(10).setPreferredWidth(400);
	     
	        
	        
	     setSize(900, 700);
	     setLocation(300, 100);
	     setVisible(true);
	 }
	 
	 public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == search) {
	            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
	            try {
	            	Connection c;
	         		Statement s=null;
	         		try {
	         			
	         			Class.forName("com.mysql.cj.jdbc.Driver");
	         			c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","redhat6562");
	         			s= c.createStatement();
	         			System.out.print("Connection Successful");
	         		}catch(Exception e) {
	         			e.printStackTrace();
	         		}
	         		
	                ResultSet rs = s.executeQuery(query);
	                
	                
	             
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }else if (ae.getSource() == update) {
	            setVisible(false);
	            new UpdateEmployee(cemployeeId.getSelectedItem());
	        } else {
	            setVisible(false);
	            new Home();
	        }
	    }

	public static void main(String[] args) {
		new ViewEmployee();

	}

}