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

public class UpdateContributionz extends JFrame implements ActionListener{
    
    //Random ran = new Random();
   // int number = ran.nextInt(999999);
    
   
    JDateChooser dcdob;
    JComboBox tplead;
    Choice tpdesc,tpname;
    JLabel prId;
    JButton add, back;
    String Cntr_Id;
    
    UpdateContributionz(String ID) {
        this.Cntr_Id=ID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Contribution Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
       
        
        JLabel labelfname = new JLabel("Contributer Id");
        
        labelfname.setBounds(50, 150, 150, 30);
        
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        
          tpname = new Choice();
         tpname.setBounds(200, 150, 150, 30);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from  contributers");
            while(rs.next()) {
                 tpname.add(rs.getString("Contributer_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add( tpname);
        
        
        
        
        
     
        
        
        JLabel labelsalary = new JLabel("Project Id");
        labelsalary.setBounds(50, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
      
         
        tpdesc = new Choice();
        tpdesc.setBounds(200, 200, 150, 30);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from projects");
            while(rs.next()) {
                tpdesc.add(rs.getString("Project_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(tpdesc);
        
        
        
        
        JLabel labeladdress = new JLabel("Type");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
         String typ[] = {"Major","Minor","None"};
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
 
        
        JLabel labelempId = new JLabel("Contribution ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        prId = new JLabel();
        prId.setBounds(200, 400, 150, 30);
        prId.setFont(new Font("serif", Font.PLAIN, 20));
        add(prId);
        
        try{
            Conn c = new Conn();
            String query = "select * from contributions where Contribution_Id = '"+Cntr_Id+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next())
            {
                
                tpname.addItem(rs.getString("Contributer_Id"));
                tpdesc.addItem(rs.getString("Project_Id"));
                tplead.addItem(rs.getString("Contribution_Type"));
                //tplead.setText(rs.getString("Contribution_Type"));
                //dcdob.setDate(rs.getDate("Start_date"));
                prId.setText(rs.getString("Contribution_Id"));
                
                
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
            String c_name = tpdesc.getSelectedItem();
            String c_rep = (String)tplead.getSelectedItem();
           // String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update contributions set Contributer_Id = '"+pr_id+"', Project_Id = '"+c_name+"', Contribution_Type = '"+c_rep+"' where Contribution_Id = '"+Cntr_Id+"'";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
               new  ViewContributions().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new  ViewContributions().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateContributionz("");
    }
}


