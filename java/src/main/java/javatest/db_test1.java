package javatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * 응용편 Java + Database
 * Library 추가 필요 : MySqlConnectJ( https://mvnrepository.com/) -> mysql 검색
 * 
 * */

public class db_test1 {
	

	public static void main(String[] args) {
		/*
		String times = new timezone().now_time(3);
		System.out.println(times);
		*/
		Scanner sc = new Scanner(System.in);
		Connection ct = null;
		try {
			dbconfig3 db = new dbconfig3();
			ct = db.info();
			//System.out.println(ct.toString());	//DB접속 확인.
			System.out.println("제목을 입력하세요");
			String subject = sc.nextLine();		//Scanner에 입력된 내용 값
			
			// DB문법
			String insert = "insert into email values('0','채찍사라','cha@nate.com','"+subject+"','에이핑크~~~~!! 화이팅!!',now());";
			PreparedStatement ps = ct.prepareStatement(insert);	// SQL문법을 작업 준비과정(cmd에서 명령어 치는역할 해줌)
			/*
			execute();	: select 문법에서만 사용
			executeUpdate()	: insert, update, delete, alter, create 에 사용
			*/
			
			int oksign = ps.executeUpdate();	// SQL에 Query에 대한 값은 숫자로 처리 (cmd 엔터 떄림).
			if(oksign == 1) {	// 1: 정상 저장.
				System.out.println("저장이 잘 되었습니다 ~~!");
				ps.close();
				ct.close();
				sc.close();
			}
			else {	// 0 : 저장오류 or sql문법오류 or DB접속오류, 컬럼에 대한 범위오류.
				System.out.println("SQL 문법 오류로 인하여 저장 실패 하였습니다......ㅠ");
			}
			
		}catch(Exception e) {
			System.out.println("DB 정보가 올바르지 않습니다. .....");
			System.out.println(e);
		}
	}

}

// DB 접속 환경설정 클래스
class dbconfig3{
	// Connection : Interface 사용.
	public static Connection info() throws Exception {
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/web";
		String db_user = "hong";
		String db_pass = "a123456";
		
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		
		return con;
	}
}