/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opensource.contribution.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveContributions extends JFrame implements ActionListener {
    
    Choice CntrId;
    JButton delete, back;
    
    RemoveContributions() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Contribution Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        CntrId = new Choice();
        CntrId.setBounds(200, 50, 150, 30);
        add(CntrId);
        
        try {
            Conn c = new Conn();
            String query = "select * from contributions";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                CntrId.add(rs.getString("Contribution_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Contributer Id");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Project Id");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Type");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        try {
            Conn c = new Conn();
            String query = "select * from contributions where Contribution_Id = '"+CntrId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("Contributer_Id"));
                lblphone.setText(rs.getString("Project_Id"));
                lblemail.setText(rs.getString("Contribution_Type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CntrId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from contributions where Contribution_Id = '"+CntrId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                               lblname.setText(rs.getString("Contributer_Id"));
                lblphone.setText(rs.getString("Project_Id"));
                lblemail.setText(rs.getString("Contribution_Type"));
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
                String query = "delete from Contributions where Contribution_Id = '"+CntrId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Contribution Information Deleted Sucessfully");
                setVisible(false);
                new  RemoveContributions().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new  ViewContributions().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new RemoveContributions();
    }
}