package javatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * Java + Database 응용편1
 * 게시판을 작성하는 프로세서를 제작합니다.
 * 문의제목, 고객명, 패스워드는 6자리 이상, 문의내용
 * 단, 패스워드는 암호화 하지 않고 제작합니다. 패스워드 6자리 이하 입력시 DB에 저장 안됩니다. 
 * 
 *  */
public class db_test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection ct = null;
		try {
			dbconfig2 db2 = new dbconfig2();
			ct = db2.info();
			
			/*
			 * 제목 : b_title
			 * 고객명 : username
			 * 패스워드 : userpw
			 * 문의내용 :b_content
			 * */
			System.out.println("문의 제목을 입력하세요");
			String b_title = sc.nextLine();
			
			System.out.println("고객명을 입력하세요");
			String username = sc.nextLine();
			
			System.out.println("패스워드를 6자리 이상 입력하세요.");
			String userpw = sc.nextLine();
			
			System.out.println("문의 내용을 입력하세요.");
			String b_content = sc.nextLine();
			
			
			
			if(b_title.isEmpty() || username.isEmpty() || userpw.isEmpty() || b_content.isEmpty()) {
				System.out.println("고객 정보를 모두 입력해주세요.");
			}
			else if(userpw.length() < 6){
				System.out.println("패스워드를 6자리 이상 입력해주세요 제발.....");
				new db_test2().main(null);
			}
			else {
				//String insert = "insert into board values('0','"+b_title+"','"+username+"','"+userpw+"','"+b_content+"',now());";
				String insert = "insert into board values('0','"+b_title+"','"+username+"',password('"+userpw+"'),'"+b_content+"',now());";
				PreparedStatement ps = ct.prepareStatement(insert);	
				
				int oksign = ps.executeUpdate();
				if(oksign == 1) {
					System.out.println("저장이 잘 되었습니다.");
					ps.close();
					ct.close();
					sc.close();
				}
				else {
					System.out.println("SQL 문법 오류.... 실패 ! ");
				}
				
			}
		}catch(Exception e) {
			System.out.println("DB 연결 실패");
			System.out.println(e);
		}
	}

}

class dbconfig2{
	public static Connection info()throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/web";
		String db_user = "hong";
		String db_pass = "a123456";
		
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		
		return con;
	}
}