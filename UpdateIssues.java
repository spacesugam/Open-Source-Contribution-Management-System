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

public class UpdateIssues extends JFrame implements ActionListener{
    
    //Random ran = new Random();
   // int number = ran.nextInt(999999);
    
    JTextField   tplead;
    JDateChooser dcdob;
    JComboBox tpdesc;
    JLabel prId;
    Choice tpname;
    JButton add, back;
    String Is_Id;
    
    UpdateIssues(String ID) {
        this.Is_Id=ID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Issues Details");
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
        
        
        
        
        
        
        
        JLabel labelsalary = new JLabel("Status");
        labelsalary.setBounds(50, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        
            
        String typ[] = {"Open","Close"};
        tpdesc = new JComboBox(typ);
        tpdesc.setBackground(Color.WHITE);
        tpdesc.setBounds(200, 200, 150, 30);
        add(tpdesc);
        
        JLabel labeladdress = new JLabel("Issue Info");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tplead = new JTextField();
        tplead.setBounds(200, 250, 150, 30);
        add(tplead);
        
        //JLabel labeldob = new JLabel("Date");
        //labeldob.setBounds(50, 200, 150, 30);
       // labeldob.setFont(new Font("serif", Font.PLAIN, 20));
       // add(labeldob);
        
       // dcdob = new JDateChooser();
       // dcdob.setBounds(200, 200, 150, 30);
       // add(dcdob);
 
        
        JLabel labelempId = new JLabel("Issue ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        prId = new JLabel();
        prId.setBounds(200, 400, 150, 30);
        prId.setFont(new Font("serif", Font.PLAIN, 20));
        add(prId);
        
        try{
            Conn c = new Conn();
            String query = "select * from issues where Issue_Id = '"+Is_Id+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next())
            {
                
                tpname.addItem(rs.getString("Project_Id"));
                tpdesc.addItem(rs.getString("Issue_Status"));
                tplead.setText(rs.getString("Issue_Info"));
                //dcdob.setDate(rs.getDate("Start_date"));
                prId.setText(rs.getString("Issue_Id"));
                
                
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
            String Is_status = (String) tpdesc.getSelectedItem();
            String Is_info = tplead.getText();
            
           // String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update issues set Project_Id = '"+pr_id+"', Issue_Status = '"+Is_status+"', Issue_Info = '"+Is_info+"' where Issue_Id = '"+Is_Id+"'";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                new  ViewIssues().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new  ViewIssues().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateIssues("");
    }
}


