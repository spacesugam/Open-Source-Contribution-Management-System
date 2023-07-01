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

public class UpdateContributers extends JFrame implements ActionListener{
    
    //Random ran = new Random();
   // int number = ran.nextInt(999999);
    
    JTextField tprojectid;
    JDateChooser dcdob;
    JComboBox   tplead;
    JLabel prId;
    Choice tp;
    JButton add, back;
    String C_Id;
    
    UpdateContributers(String ID) {
        this.C_Id=ID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Contributer Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
       
        
        JLabel labelfname = new JLabel("Project Id");
        
        labelfname.setBounds(50, 150, 150, 30);
        
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
      
        
         
      
         
        tp = new Choice();
        tp.setBounds(200, 150, 150, 30);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from projects");
            while(rs.next()) {
                tp.add(rs.getString("Project_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(tp);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JLabel labelsalary = new JLabel("Contributor Name");
        labelsalary.setBounds(50, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tprojectid = new JTextField();
        tprojectid.setBounds(200, 200, 150, 30);
        add(tprojectid);
        
        JLabel labeladdress = new JLabel("Reputaion");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
      
        String typ[] = {"1","2","3","4","5","6","7","8","9","10"};
        tplead = new JComboBox(typ);
        tplead.setBackground(Color.WHITE);
        tplead.setBounds(200, 250, 150, 30);
        add(tplead);
        
        
        //JLabel labeldob = new JLabel("Date");
        //labeldob.setBounds(50, 200, 150, 30);
       // labeldob.setFont(new Font("serif", Font.PLAIN, 20));
       // add(labeldob);
        
       // dcdob = new JDateChooser();
       // dcdob.setBounds(200, 200, 150, 30);
       // add(dcdob);
 
        
        JLabel labelempId = new JLabel("Contributer ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        prId = new JLabel();
        prId.setBounds(200, 400, 150, 30);
        prId.setFont(new Font("serif", Font.PLAIN, 20));
        add(prId);
        
        try{
            Conn c = new Conn();
            String query = "select * from contributers where Contributer_Id = '"+C_Id+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next())
            {
                
                tp.addItem(rs.getString("Project_Id"));
                tprojectid.setText(rs.getString("Contributer_Name"));
                tplead.addItem(rs.getString("Contributer_Reputation"));
                //dcdob.setDate(rs.getDate("Start_date"));
                prId.setText(rs.getString("Contributer_Id"));
                
                
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
            String pr_id = tp.getSelectedItem();
            String c_name = tprojectid.getText();
            String c_rep = (String) tplead.getSelectedItem();
           // String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update contributers set Project_Id = '"+pr_id+"', Contributer_name = '"+c_name+"', Contributer_Reputation = '"+c_rep+"' where Contributer_Id = '"+C_Id+"'";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                   new  ViewContributerz().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new  ViewContributerz().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateContributers("");
    }
}


