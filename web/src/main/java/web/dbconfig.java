package web;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {

	public static Connection dbinfo() throws Exception {
		
		String db_drive = "com.mysql.jdbc.Driver";	//5.1 이상 mysql.cj.jdbc 이렇게 써야함
		String db_url = "jdbc:mysql://localhost:3306/web";
		String db_user = "hong";
		String db_pass = "a123456";
		
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		
		return con;
	}
}
