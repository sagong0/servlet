package javatest;

import java.sql.Connection;
import java.sql.DriverManager;

// java17에 활용

// DB활용 인터페이스 및 각종 문법.
public interface setdb {

	// 해당 필드에 사용되는 변수는 final형태로 상수화 되어버리는 상황입니다.
	
	public void dbConnect(String user, String passwd, String db) throws Exception;
	
	public void select(String table,String dataid);
	/*
	public void delete(int idx);
	public void update(String dataid,int idex);
	public void insert(String[] a);
	*/
	public static Connection info(String user, String passwd, String db) throws Exception {
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/" + db;
		String db_user = user;
		String db_pw = passwd;
		
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pw);
		
		
		return con;
	}
	
}


