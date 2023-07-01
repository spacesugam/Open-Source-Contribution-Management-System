
package opensource.contribution.management;


import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///ossms", "root", "1qaz2wsx");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}