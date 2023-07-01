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

public class AddContributions extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999);
    
    JTextField  tpname ;
    JDateChooser dcdob;
    JComboBox tplead;
    JLabel prId;
    JButton add, back;
    Choice Cntr_Id,tpdesc;
    
    AddContributions() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Contributions Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
       
        
        JLabel labelfname = new JLabel("Contributer Id");
        labelfname.setBounds(50, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        //tpname  = new JTextField();
       // tpname.setBounds(200, 150, 150, 30);
       // add(tpname);
        
        Cntr_Id = new Choice();
         Cntr_Id.setBounds(200, 150, 150, 30);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from  contributers");
            while(rs.next()) {
                 Cntr_Id.add(rs.getString("Contributer_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add( Cntr_Id);
        
        
       
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
        
        
        
        JLabel labeladdress = new JLabel("Type");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        String typ[] = {"Major","Minor","None"};
        tplead = new JComboBox(typ);
        tplead.setBackground(Color.WHITE);
        tplead.setBounds(200, 250, 150, 30);
        add(tplead);
        
     
        
        JLabel labelempId = new JLabel("Contribution ID");
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
            String cntrid = prId.getText();
            String cid = Cntr_Id.getSelectedItem();
            String prid = tpdesc.getSelectedItem();
            String ctype =(String) tplead.getSelectedItem();
            //String cdob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
           // String phone = tfphone.getText();
           // String email = tfemail.getText();
           // String education = (String) cbeducation.getSelectedItem();
           // String designation = tfdesignation.getText();
           // String aadhar = tfaadhar.getText();
           // String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into contributions values('"+cntrid+"', '"+cid+"', '"+prid+"', '"+ctype+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new  AddContributions().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
                   new  ViewContributions().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddContributions();
    }
}