/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opensource.contribution.management;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateProjectLeader extends JFrame implements ActionListener{
    
    //Random ran = new Random();
   // int number = ran.nextInt(999999);
    
    JTextField tpdesc, tplead;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel prId;
    Choice  tpname;
    JButton add, back;
    String C_Id;
    
    UpdateProjectLeader(String ID) {
        this.C_Id=ID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Project Leader Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
       
        
        JLabel labelfname = new JLabel("Project Id");
        
        labelfname.setBounds(50, 150, 150, 30);
        
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        
           tpname = new Choice();
        tpname.setBounds(200, 150, 150, 30);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from projects");
            while(rs.next()) {
                tpname.add(rs.getString("Project_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(tpname);
        
        
        
        
        
        
        
        JLabel labelsalary = new JLabel("Project Leader Name");
        labelsalary.setBounds(50, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tpdesc = new JTextField();
        tpdesc.setBounds(200, 200, 150, 30);
        add(tpdesc);
       
 
        
        JLabel labelempId = new JLabel("Project Leader ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        prId = new JLabel();
        prId.setBounds(200, 400, 150, 30);
        prId.setFont(new Font("serif", Font.PLAIN, 20));
        add(prId);
        
        try{
            Conn c = new Conn();
            String query = "select * from project_leader where Project_Leader_Id= '"+C_Id+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next())
            {
                
                tpname.addItem(rs.getString("Project_Id"));
                tpdesc.setText(rs.getString("Project_Leader_Name"));
                //tplead.setText(rs.getString("C_rep"));
                //dcdob.setDate(rs.getDate("Start_date"));
                prId.setText(rs.getString("Project_Leader_Id"));
                
                
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            
        }
        
        
        add = new JButton("Update Details");
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
            String pr_id = tpname.getSelectedItem();
            String c_name = tpdesc.getText();
            //String c_rep = tplead.getText();
           // String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update project_leader set Project_Id = '"+pr_id+"', Project_Leader_Name = '"+c_name+"' where Project_Leader_Id = '"+C_Id+"'";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                new  ViewProjectLeader().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
           new  ViewProjectLeader().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateProjectLeader("");
    }
}


