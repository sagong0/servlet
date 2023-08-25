package javatest;

import java.sql.Connection;

// 외부 db 정보 클래스를 로드하여 연결하기.
public class db_test3 {

	public static void main(String[] args) {
		try {
			dbconfig db =new dbconfig();
			Connection con = db.info();
			System.out.println(con.toString());
		}catch(Exception e) {
			System.out.println("Database 접속 오류!!");
		}
	}

}
