package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

@WebServlet("/join2")
public class join2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dbconfig db = null;
	PreparedStatement ps = null;
	
    public join2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uid = request.getParameter("uid").intern();
		String uname = request.getParameter("uname").intern();
		String upw = request.getParameter("upw").intern();
		String tellcorp = request.getParameter("tellcorp").intern();
		String uno = request.getParameter("uno").intern();
		String uemail = request.getParameter("uemail").intern();
		
		PrintWriter pw = response.getWriter();	// 스크립트 출력
		if(uid=="" || uname =="" || upw=="" || tellcorp==""|| uno==""||uemail=="") {
			pw.write("<script>"
					+"alert('올바른 정보가 전달 되지않으셨습니다.');"
					+"history.go(-1);"
					+"</script>");
		}
		else {
			try {
				this.db = new dbconfig();
				Connection con = this.db.dbinfo();
				// 람다식 형태의 코드로 작성.
				String sql = "insert into shop values("
						+ "'0',?,?,password(?),?,?,?,now(),'Y');";
				this.ps = con.prepareStatement(sql);
				this.ps.setString(1, uid);
				this.ps.setString(2, uname);
				this.ps.setString(3, upw);
				this.ps.setString(4, tellcorp);
				this.ps.setString(5, uno);
				this.ps.setString(6, uemail);
				int call = this.ps.executeUpdate();
				String msg = "";
				if(call > 0) {
					msg = "정상적으로 가입이 완료되었습니다.";
				}
				else {
					msg = "가입이 원활하게 진행 되지않았습니다.";
				}
				
				this.ps.close();
				con.close();
				pw.write("<script> alert('"+msg+"'); location.href='./login.html';</script>");
			}
			catch(Exception e) {
				System.out.println("Database 정보 오류 !! ");
			}
		}
		
	}
}
