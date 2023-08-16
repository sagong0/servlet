package passlossnoform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pwcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public pwcontroller() {
        super();
    }
    /*
    숙제 : 가입자 이름, 아이디, 이메일 모두 입력이 되어야 하며,
    입력 완료 되었을 경우 pass_loss.do로 post 전송 합니다.
    해당 post 전송 후 해당 정보가 맞을 경우 Controll에서 console로
    임시패스워드 : a123456 을 출력시키면 되며,
    만약 세가지 입력 값에 하나라도 틀릴 경우 console로 "해당 정보를 확인하지 못하였습니다." 라는 메세지가 출력 되도록 합니다.
  */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		// username/userid/useremail
		String username = request.getParameter("username").intern();
		String userid = request.getParameter("userid").intern();
		String useremail = request.getParameter("useremail").intern();
		
		//System.out.printf("%s %s %s", username,userid,useremail);
		String members[][] = {
				{"장진호","배유미","염무원","김승균","김경민","장진호","김경민"},
				{"jang_ho@nate.com","bae_mi@nate.com","number1@gmail.com","kim@nate.com",
					"min@nate.com","ho@naver.com","k_min@gmail.com"},
				{"jang_ho","bae_mi","number1","kim","min","ho","k_min"}
		};
		String password = "a123456";
		
		int count = 0;
		String msg_c = "";
		
		
		int w = 0;
		while(w < members[0].length) {
			if(username == members[0][w]) {		// 이름확인
				if(useremail == members[1][w]) {	// email 확인
					if(userid == members[2][w]) {	// id 확인
						count = 1;
						msg_c= password;
						break;
					}
				}
			}			
			w++;
		}
	
		if(count == 0) {
			msg_c = "error";
		}
		System.out.println(msg_c);
		PrintWriter pw = response.getWriter();
		pw.write(msg_c);
	}

}
