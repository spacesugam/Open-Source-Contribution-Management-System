/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opensource.contribution.management;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class OpenHome extends JFrame  implements ActionListener {
    
        // Variables for side panel
    JPanel sidePanel;
    JButton projectsButton;
    JButton contributorsButton;
    JButton contributionButton;
    JButton issuesButton;
    JButton leaderButton;
    JButton logoutButton;
    // Variables for title and about section
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel aboutPanel;
    JLabel aboutLabel;
    
     OpenHome() {
        setLayout(null);
        setTitle("Open Source Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/coolback.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120, 100, 1050, 500);
        add(image);
        
        
            sidePanel = new JPanel();
    sidePanel.setPreferredSize(new Dimension(200, 600));
    sidePanel.setBackground(new Color(200, 200, 200));
    sidePanel.setLayout(new GridLayout(6, 1));
    add(sidePanel, BorderLayout.WEST);
    
    // Initialize and set up side panel
    sidePanel = new JPanel();
    sidePanel.setBackground(new Color(200, 200, 200));
    sidePanel.setLayout(new GridLayout(6, 1));

    // Add buttons and icons to side panel
    // Project button
    Icon projectIcon = new ImageIcon(ClassLoader.getSystemResource("icons/proj.png "));
    projectsButton = new JButton("Projects", projectIcon);
    projectsButton.setPreferredSize(new Dimension(180, 50));
    projectsButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    projectsButton.setIconTextGap(10);
    projectsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    projectsButton.addActionListener(this);
    sidePanel.add(projectsButton);
    
    // Contributors button
    Icon contributorsIcon = new ImageIcon(ClassLoader.getSystemResource("icons/dev.png "));
    contributorsButton = new JButton("Contributers", contributorsIcon);
    contributorsButton.setPreferredSize(new Dimension(180, 50));
    contributorsButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    contributorsButton.setIconTextGap(10);
    contributorsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    contributorsButton.addActionListener(this);
    sidePanel.add(contributorsButton);

    // Contribution button
    Icon contributionIcon = new ImageIcon(ClassLoader.getSystemResource("icons/contribution.png "));
    contributionButton = new JButton("Contributions", contributionIcon);
    contributionButton.setPreferredSize(new Dimension(180, 50));
    contributionButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    contributionButton.setIconTextGap(10);
    contributionButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    contributionButton.addActionListener(this);
    sidePanel.add(contributionButton);

    // Issues button
    Icon issuesIcon = new ImageIcon(ClassLoader.getSystemResource("icons/bugs.png "));
    issuesButton = new JButton("Issues", issuesIcon);
    issuesButton.setPreferredSize(new Dimension(180, 50));
    issuesButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    issuesButton.setIconTextGap(10);
    issuesButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    issuesButton.addActionListener(this);
    sidePanel.add(issuesButton);

    // Leader button
    Icon leaderIcon = new ImageIcon(ClassLoader.getSystemResource("icons/leader1.png "));
    leaderButton = new JButton("Project Leader",leaderIcon );
    leaderButton.setPreferredSize(new Dimension(180, 50));
    leaderButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    leaderButton.setIconTextGap(10);
    leaderButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    leaderButton.addActionListener(this);
    sidePanel.add(leaderButton);

    // Logout button
    Icon logoutIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logout.png "));
    logoutButton = new JButton("Logout", logoutIcon);
    logoutButton.setPreferredSize(new Dimension(180, 50));
    logoutButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    logoutButton.setIconTextGap(10);
    logoutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    logoutButton.addActionListener(this);
    sidePanel.add(logoutButton);
    
    
    // Add JScrollPane to side panel
     JScrollPane scrollPane = new JScrollPane(sidePanel);
    scrollPane.setPreferredSize(new Dimension(200, 600));
    //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
    add(scrollPane, BorderLayout.WEST);
  
       // frame.getContentPane().add(scrollPane);  
    


        // Initialize and set up title panel
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(120, 90, 100));
        add(titlePanel, BorderLayout.NORTH);
        // Add title label to title panel
        titleLabel = new JLabel("Open Source Management");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 44));
        titlePanel.add(titleLabel);
        // Initialize and set up about panel
        aboutPanel = new JPanel();
        aboutPanel.setBackground(new Color(150, 10, 150));
        add(aboutPanel, BorderLayout.SOUTH);
        
        
        
        // Add about label to about panel
        aboutLabel = new JLabel("About: Open source management is the process of managing and organizing contributions to open source projects.");
        aboutPanel.add(aboutLabel);

        
    }
     
     
       public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == projectsButton) {
            setVisible(false);
            new ViewProjects();
        } else if (ae.getSource() == contributorsButton) {
            setVisible(false);
            new ViewContributerz();
        } else if (ae.getSource() == contributionButton) {
            setVisible(false);
            new ViewContributions();
        }else if (ae.getSource() == issuesButton) {
            setVisible(false);
            new ViewIssues();
        }
        else if (ae.getSource() == leaderButton) {
            setVisible(false);
            new ViewProjectLeader();
        }
        
        else {
            setVisible(false);
            new Login();
        }
    }
     
     public static void main(String [] args){
       OpenHome frame = new OpenHome();
   
      frame.setVisible(true);
        
     }
    
}
