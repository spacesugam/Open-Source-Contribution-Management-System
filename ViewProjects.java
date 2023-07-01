/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opensource.contribution.management;
import javax.swing.table.TableColumn;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.net.URL;
import javax.swing.plaf.basic.BasicButtonUI;

public class ViewProjects extends JFrame implements ActionListener{

    JTable table;
    Choice P_Id;
    JButton search, print, update, back,Add,Remove;
    
    
    
  
    
    
    
    
    
    ViewProjects() {
          JPanel panel = new JPanel() {
    public void paintComponent(Graphics g) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("icons/nasa.jpg");
        Image img = new ImageIcon(resource).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
};

        
        
        
        getContentPane().setBackground(new Color(204, 255, 229));
      //  getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Project Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        P_Id = new Choice();
       P_Id.setBounds(180, 20, 150, 20);
        add(P_Id);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from projects");
            while(rs.next()) {
                P_Id.add(rs.getString("Project_Id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setBackground(new Color(255, 255, 153));
        table.getTableHeader().setOpaque(true);
        

        
        
        
        
         for (int i = 0; i < table.getColumnCount(); i++) {
          TableColumn column = table.getColumnModel().getColumn(i);
          column.setPreferredWidth(100);
         table.repaint();
}
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from projects");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 900, 600);
        add(jsp);
        
        Add = new JButton("Add");
        Add.setFont(new Font("Arial", Font.BOLD, 14));
        Add.setBounds(10, 70, 80, 20);
        Add.addActionListener(this);
        Add.setSize(70, 30);
        //Add.setUI(new GradientButtonUI(Color.BLUE, Color.WHITE));
        Add.setOpaque(false);
        
        Add.setForeground(Color.black);
Add.setRolloverEnabled(true);
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
        
        
        
        search = new JButton("Search");
        search.setBounds(350, 20, 80, 20);
        search.addActionListener(this);
        
        add(search);
        
       print = new JButton("Print");
        print.setBounds(800, 10, 80, 20);
        print.addActionListener(this);
        print.setSize(70, 30);
        print.setFont(new Font("Arial", Font.BOLD, 14));
        add(print);
        
        
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
            String query = "select * from projects where Project_Id = '"+P_Id.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
        
        
        else if (ae.getSource() == Add) {
            try {
                setVisible(false);
                new AddProjects();
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
        }
        else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateProjects(P_Id.getSelectedItem());
        } 
        
        else if (ae.getSource() == Remove) {
            setVisible(false);
                   new  RemoveProject().setVisible(true);
        } 
        
        else if (ae.getSource() == back) {
            setVisible(false);
           new  OpenHome().setVisible(true);
        }
        else {
            setVisible(false);
            OpenHome openHome = new OpenHome();
        }
    }

    public static void main(String[] args) {
        new ViewProjects();
    }
    
    
    
    
    class GradientButtonUI extends BasicButtonUI {
    private final Color startColor;
    private final Color endColor;
    public GradientButtonUI(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }
    @Override
    public void paint(Graphics g, JComponent c) {
        if (!(g instanceof Graphics2D)) {
            return;
        }
        int width = c.getWidth();
        int height = c.getHeight();
        GradientPaint paint = new GradientPaint(0, 0, startColor, width, height, endColor);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(paint);
        g2d.fillRect(0, 0, width, height);
    }
}
}