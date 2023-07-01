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

public class AddProjects extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField  tpname,tpdesc, tplead;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel prId;
    JButton add, back;
    
    AddProjects() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Project Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
       
        
        JLabel labelfname = new JLabel("Project Name");
        labelfname.setBounds(50, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tpname  = new JTextField();
        tpname.setBounds(200, 150, 150, 30);
        add(tpname);
        
        
        JLabel labelsalary = new JLabel("Description");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tpdesc = new JTextField();
        
        tpdesc.setBounds(600, 200, 150, 30);
        add(tpdesc);
        
       // JLabel labeladdress = new JLabel("Project Leader");
      //  labeladdress.setBounds(50, 250, 150, 30);
     //   labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
      // add(labeladdress);
        
       // tplead = new JTextField();
       // tplead.setBounds(200, 250, 150, 30);
       // add(tplead);
        
        JLabel labeldob = new JLabel("Date");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
 
        
        JLabel labelempId = new JLabel("Project ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        prId = new JLabel("" + number);
        prId.setBounds(200, 400, 150, 30);
        prId.setFont(new Font("serif", Font.PLAIN, 20));
        add(prId);
        
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
            String pid = prId.getText();
            String pname = tpname.getText();
            String pdesc = tpdesc.getText();
            //String plname = tplead.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into projects values('"+pid+"', '"+pname+"', '"+pdesc+"', '"+dob+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                 new  AddProjects().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else {
            setVisible(false);
           new  ViewProjects().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddProjects();
    }
}