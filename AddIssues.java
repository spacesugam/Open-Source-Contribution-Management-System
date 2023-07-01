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
import java.sql.ResultSet;

public class AddIssues extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999);
    
    JTextField  tpname,is_desc ;
    JDateChooser dcdob;
    JComboBox tplead;
    JLabel prId;
    JButton add, back;
    Choice Cntr_Id,tpdesc;
    
    AddIssues() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Issue Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        //abelsalary.setBounds(400, 200, 150, 30);
        //tpdesc.setBounds(600, 200, 150, 30);
                
        JLabel labePid = new JLabel("Project Id");
        labePid.setBounds(400, 200, 150, 30);
        labePid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labePid);
        
        //tpname  = new JTextField();
       // tpname.setBounds(200, 150, 150, 30);
       // add(tpname);
        
        tpdesc = new Choice();
        tpdesc.setBounds(600, 200, 150, 30);
        
        
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
        
        
        
        JLabel labeladdress = new JLabel("Status");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        String typ[] = {"Open","Close"};
        tplead = new JComboBox(typ);
        tplead.setBackground(Color.WHITE);
        tplead.setBounds(200, 250, 150, 30);
        add(tplead);
        
       
        
        
        
        
        
        
        JLabel labelsalary = new JLabel("Description");
        labelsalary.setBounds(50, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        is_desc  = new JTextField();
        is_desc .setBounds(200, 200, 150, 30);
        add(is_desc );
        
        
     
        
        JLabel labelempId = new JLabel("Issue ID");
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
            String isid = prId.getText();

           // String cid = Cntr_Id.getSelectedItem();
            String prid = tpdesc.getSelectedItem();
            String ctype =(String) tplead.getSelectedItem();
           String isdesc =is_desc.getText();
            //String cdob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into issues values('"+isid+"', '"+prid+"', '"+ctype+"', '"+isdesc+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new  AddIssues().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
           new  ViewIssues().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddIssues();
    }
}