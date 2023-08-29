package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");	// 사용자가 입력한 패스워드.(미암호화)
	
		try {
			dbconfig db = new dbconfig();
			PreparedStatement ps = null; 
			Connection con = db.dbinfo();	// DB 환경설정 연결.
			/*사용자가 입력한 패스워드를 sql 문법으로 암호화 변경하는 작업.*/
			String password = "select password('"+upw+"') as pwd";
			//String password = "select * from shop";
			ps = con.prepareStatement(password);
			// execute() -> boolean(O) 
			// executeupdate -> 무조건 int(0 ,1 만나옴) => (insert,update,delete,alter,create)
			// executeQuery() -> select 전용, Resultset (배열) 으로받음.
			ResultSet rs = ps.executeQuery();		//ResultSet => select된 값을 배열화
			String user_pw = null;
			
			while(rs.next()) {	//rs.next() => true(무한loop 정지),false
				user_pw = rs.getString("pwd");	//getString("컬럼명")
			}
			con.close();
			/* 사용자 아이디와 패스워드를 Database에서 가져오는 코드 */
			Connection con2 = db.dbinfo();
			String sql = "select * from shop where juserid=?";
			ps = con2.prepareStatement(sql);
			ps.setString(1, uid);	// 아이디값.
			ResultSet rs2 = ps.executeQuery();
			
			String sql_id = "";	// DB에 저장된 사용자 아이디
			String sql_pw = "";	// DB에 저장된 사용자 비밀번호.
			String sql_use = ""; //로그인 가능여부 : Y/N
			
			while(rs2.next()) {	// Database에서 문자형 변수로 변환작업.
				sql_id = rs2.getString("juserid").intern();
				sql_pw = rs2.getString("jpw").intern();
				sql_use = rs2.getString("juse").intern();	// 로그인 유/무
			}
			con2.close();
			ps.close();
			PrintWriter pw = response.getWriter();
			
			if(sql_id == "") {	// sql 문법 실행시 해당 정보가 없을 경우.
				pw.write("<script>alert('해당사용자 정보를 확인 하지 못하였습니다.'); "
						+ "history.go(-1);</script>");
			}
				else {	// id가 확인되고, 패스워드를 검토할 때 사용
					//System.out.println(sql_pw+ " "+user_pw);
				if(sql_pw.intern() == user_pw.intern()) {	// 동일한 패스워드일 경우	
					if(sql_use =="Y") {
						pw.write("<script>alert('로그인 하셨습니다.');</script>");
					}
					else {
						pw.write("<script>alert('관리자권한으로 로그인 하실수 없습니다.'); history.go(-1);</script>");
					}
					
					pw.write("<script>alert('로그인 하셨습니다.');</script>");
				}
				else {
					pw.write("<script>alert('패스워드가 틀립니다.');"
							+ "history.go(-1);</script>");
				}
			}
			pw.close();
		}
		catch(Exception e) {
			System.out.println("DB 접속 오류 발생.....!!");
		}
	}

}
