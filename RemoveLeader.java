/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opensource.contribution.management;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveLeader extends JFrame implements ActionListener {
    
    Choice CId;
    JButton delete, back;
    
    RemoveLeader() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Project Leader Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        CId = new Choice();
        CId.setBounds(200, 50, 150, 30);
        add(CId);
        
        try {
            Conn c = new Conn();
            String query = "select * from project_leader";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                CId.add(rs.getString("Project_Leader_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Project Id");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Project Leader Name");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
       
        
        try {
            Conn c = new Conn();
            String query = "select * from project_leader where Project_Leader_Id = '"+CId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("Project_Id"));
                lblphone.setText(rs.getString("Project_Leader_name"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from project_leader where Project_Leader_Id = '"+CId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                 lblname.setText(rs.getString("Project_Id"));
                 lblphone.setText(rs.getString("Project_Leader_name"));
                       
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nasa.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from project_leader where Project_Leader_Id = '"+CId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Project Leader Information Deleted Sucessfully");
                setVisible(false);
                new  RemoveLeader().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
           new  ViewProjectLeader().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new RemoveLeader();
    }
}