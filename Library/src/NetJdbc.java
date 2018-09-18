

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
class Net {

	public static void main(String[] args) {
        // create three connections to three different databases on localhost
        Connection conn1 = null;
        
 
        try {
            // Connect method #1
            String dbURL1 = "jdbc:postgresql:Book?user=postgres&password=4008";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected to database #1");
            }
            try { 
            	 
            	 String sql = "SELECT * FROM Book";
            	 PreparedStatement ps = conn1.prepareStatement(sql);
            	 ResultSet rs = ps.executeQuery();
            	 System.out.println("Book Name "+" Qty ");
            	 while(rs.next()) {
            	 
            		 System.out.println(rs.getString(1) + "   "+ rs.getInt(2));
            	 System.out.println("---------------");
            	 
            	 
            	 
            	System.out.println("");
            	}
            	 
            	} catch (Exception e) {
            	 
            	 System.out.println(e.getMessage());
            	 e.printStackTrace();
            	}
            	
                     
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
               
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}
}
