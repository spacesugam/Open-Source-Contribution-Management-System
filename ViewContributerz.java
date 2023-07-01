
package opensource.contribution.management;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewContributerz extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back,Add,Remove;
    
    ViewContributerz() {
        
        getContentPane().setBackground(new Color(127,255,212));
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Contributers Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from contributers");
            while(rs.next()) {
                cemployeeId.add(rs.getString("Contributer_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
          table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setBackground(new Color(255, 255, 153));
        table.getTableHeader().setOpaque(true);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from contributers");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 900, 600);
        add(jsp);
        
         print = new JButton("Print");
        print.setBounds(800, 10, 80, 20);
        print.addActionListener(this);
        print.setSize(70, 30);
        print.setFont(new Font("Arial", Font.BOLD, 14));
        add(print);
        
        search = new JButton("Search");
        search.setBounds(350, 20, 80, 20);
        search.addActionListener(this);
        add(search);
        
        
        
        Add = new JButton("Add");
        Add.setFont(new Font("Arial", Font.BOLD, 14));
        Add.setBounds(10, 70, 80, 20);
        Add.addActionListener(this);
        Add.setSize(70, 30);
        //Add.setUI(new GradientButtonUI(Color.BLUE, Color.WHITE));
        Add.setOpaque(false);
        add(Add);
        
       update = new JButton("Update");
         update.setFont(new Font("Arial", Font.BOLD, 14));
        update.setBounds(110, 70, 80, 20);
        update.addActionListener(this);
        update.setSize(90, 30);
        add(update);
        
        Remove = new JButton("Remove");
        Remove.setFont(new Font("Arial", Font.BOLD, 14));
        Remove.setBounds(230, 70, 80, 20);
        Remove.setSize(100, 20);
        Remove.addActionListener(this);
        Remove.setSize(90, 30);
        add(Remove);
        
        
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBorderPainted(rootPaneCheckingEnabled);
        back.setBounds(690, 10, 80, 20);
        back.addActionListener(this);
        back.setSize(70, 30);
        add(back);
        
        setSize(900, 900);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from contributers where Contributer_Id = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Add) {
            try {
               setVisible(false);
                  new  AddContributers().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         else if (ae.getSource() == Remove) {
            try {
               setVisible(false);
                  new  RemoveContributers().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateContributers(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new  OpenHome().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ViewContributerz();
    }
}