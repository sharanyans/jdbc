package jdbc;

import java.sql.*;


public class JDbc1 {
    public static void main(String[] args)  {
    	
    	String uname="sharanyas";
    	String pas="Sharanya@SQL_DB";
    	String query="Select * from employee1.employee1 limit 10";
       try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://10.0.2.134:3306/?user=sharanyas",uname,pas);
		 Statement st= con.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 while(rs.next()) {
		       System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		       }
		       
		       st.close();
		       con.close();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
     
    }
}

