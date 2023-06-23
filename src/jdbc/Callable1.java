package jdbc;

import java.sql.*;

public class Callable1 {
	public static void main(String[] args)  {
    	String url="jdbc:mysql://10.0.2.134:3306/employee1";
    	String uname="sharanyas";
    	String pas="Sharanya@SQL_DB";
    	
    	
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pas);
			CallableStatement cstmt=con.prepareCall("{CALL get_employe(?,?)}");
			//register the out parameter
			cstmt.setInt(1,2);
			cstmt.setString(2,"");
			
			cstmt.execute();
			
			// retrive the value of out parameter
	
			String name=cstmt.getString(2);
			System.out.println("employee name: "+name);
			
			

			 cstmt.close();
		       con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}
}

