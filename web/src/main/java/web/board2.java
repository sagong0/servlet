package web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
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
		System.out.println(file.getContentType());	// 파일에 대한 속성 (이미지로만 되게할수잇)
		System.out.println(file.getSubmittedFileName());	// 파일명
		
		String filenm =file.getSubmittedFileName().intern();
		
		// 날짜 . => 파일 업로드 같은 이름일 경우 덮어쓰는 현상을 막기 위해서 사용함.
		Date time = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timetext = sf.format(time);
		
		// 첨부파일 용량
		int filesize = (int) file.getSize();
		
		
		String savepath = request.getServletContext().getRealPath("/board/upload/");
		// 업로드시 사용하는 파일명.
		String filename = timetext +"_"+ file.getSubmittedFileName();
		// 실제 저장되는 형태.
		String uploadfile = savepath + filename;
		
		if(filesize ==0) {
			// 첨부파일이 없을 때의 SQL
			System.out.println("첨부파일 없음");
		}
		else {
			// 첨부파일 저장공간.
			//[Stream 으로 첨부파일 처리]
			InputStream is = file.getInputStream();	// 스트림으로 변환.
			FileOutputStream fs = new FileOutputStream(uploadfile);
			
			
			
			// 첨부파일이 있을 때의 SQL
			byte[] buf = new byte[is.available()];
			int size = 0;
			while((size = is.read(buf)) != -1) {
				fs.write(buf,0,size);
				fs.flush();
			}
			fs.close();
			is.close();
		}
		// 경로지정(DB에 저장되는 경로와 같음.)
		String dbfile = "./upload/"+filename;
		
		// View 로 출력 (view.jsp 전달.)
		request.setAttribute("dbfile", dbfile);
		RequestDispatcher ds = request.getRequestDispatcher("./view.jsp");
		ds.forward(request, response);
		
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
				String sql = "insert into board values('0',?,?,?,?,?,now(),?);";
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
				System.out.println(e);
			}
		}
	}

}
