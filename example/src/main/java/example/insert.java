package example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insert() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// name 값이 1개이상 동일한 사항일 경우 getParameterValues 메소드로 받아서 처리합니다.!!!!!
		String user[] = request.getParameterValues("user");
		ArrayList<String> userArr = new ArrayList<String>();
		int w = 0;
		while(w < user.length) {
			if(user[w] != "") {
				userArr.add(user[w]);
			}
			w++;
		}
		System.out.println(userArr);
		
	}
}











