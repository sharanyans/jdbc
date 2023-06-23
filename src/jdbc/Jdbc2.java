package jdbc;
import java.sql.*;

public class Jdbc2 {
public static void main(String[] args)  {
    	String url="jdbc:mysql://10.0.2.134:3306";
    	String uname="sharanyas";
    	String pas="Sharanya@SQL_DB";
    	
    	String sql="select * from employee1.employee1 where department='HR'";
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pas);
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));			       }
			 pstmt.close();
		       con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}
}
