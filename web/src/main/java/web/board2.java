package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 1,
	maxFileSize =  1024 * 1024 * 10,
	maxRequestSize = 1024 * 1024 * 100
)
public class board2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dbconfig db = null;
	PreparedStatement ps = null;

    public board2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String title = request.getParameter("mtitle").intern();
		String writer = request.getParameter("mwriter").intern();
		String pw = request.getParameter("mpw").intern();
		Part file = request.getPart("file");
		System.out.println(file.getName());	// name값명
		System.out.println(file.getSize());	// 파일 사이즈
		System.out.println(file.getHeaderNames());
		System.out.println(file.getContentType());	// 파일에 대한 속성
		System.out.println(file.getSubmittedFileName());	// 파일명
		
		String filenm =file.getSubmittedFileName().intern();
		if(filenm =="") {
			System.out.println("첨부파일 없음");
		}
		else {
			System.out.println("첨부파일 있음");
		}
		
		String content = request.getParameter("mcontent").intern();
		
		PrintWriter pw2 = response.getWriter();
		
		if(title == "" || writer=="" || pw == "" || content == "") {
			pw2.write("<script>"
					+"alert('모든 항목을 입력해주세요.');"
					+"history.go(-1);"
					+"</script>");
		}
		else {
			try {
				this.db = new dbconfig();
				Connection con = this.db.dbinfo();
				String sql = "insert into board values("
						+"'0',?,?,?,?,?,now(),?);";
				this.ps = con.prepareStatement(sql);
				this.ps.setString(1, title);
				this.ps.setString(2, writer);
				this.ps.setString(3, pw);
				this.ps.setString(4, filenm);
				this.ps.setString(5, content);
				this.ps.setInt(6, 0);
				
				int oksign = this.ps.executeUpdate();
				String msg = "";
				if(oksign >0) {
					msg = "성공적으로 작성이 완료되었습니다.";
				}
				else {
					msg = "작성 실패,,, 다시 작성해주세요....!";
				}
				this.ps.close();
				con.close();
				pw2.write("<script>"
						+ "alert('"+msg+"'); location.href='./list.html';</script>");
				
				pw2.close();
			}
			catch(Exception e) {
				System.out.println("DB 오류 .. ㅜㅠ.ㅠㅜ.ㅜ.ㅜ.ㅜ.ㅜ.ㅜ");
			}
		}
	}

}
