package javatest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class work4 {

	public static void main(String[] args) {
		try {
			new work4_1().membership();
		}
		catch(NullPointerException ne) {
			System.out.println("-----------");
			ne.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("err");
			e.printStackTrace();
		}
	}
}

class work4_1{
	Connection ct = null;
	Scanner sc = null;
	
	static String m_level ="";
	static String userid ="";
	static String userpw ="";
	static String c_info = "";
	static String usertell ="";
	static String useremail = "";
	static String businessNo = "";
	
	public void membership() throws Exception {
		dbconfig db = new dbconfig();
		this.sc = new Scanner(System.in);
		this.ct = db.info();
		
		work4_1.m_level = level_ck();
		work4_1.userid = id_ck();
		work4_1.userpw = pw_ck();
		work4_1.c_info = company_ck();
		work4_1.usertell = tell_ck();
		work4_1.useremail = email_ck();
		//work4_1.businessNo = businessNo_ck();
	
		
		if(work4_1.m_level.isEmpty() || work4_1.userid.isEmpty() || work4_1.userpw.isEmpty() || work4_1.c_info.isEmpty() || work4_1.usertell.isEmpty()|| work4_1.useremail.isEmpty()) {
			System.out.println("빈칸 발생");
			membership();
		}
		else {
			String insert = "insert into membership values('0','"+m_level+"','"+userid+"',password('"+userpw+"'),'"+c_info+"','"+usertell+"','"+useremail+"','"+businessNo+"');";
			PreparedStatement ps = ct.prepareStatement(insert);
			
			int oksign = ps.executeUpdate();
			if(oksign == 1) {
				System.out.println("저장완료~!");
				ps.close();
				ct.close();
				sc.close();
			}
			else {
				System.out.println("저장실패");
			}			
		}
		
	}

	
	private String level_ck() {
		System.out.println("회원가입 형태");
		System.out.println("1.일반고객, 2.사업자 고객");
		
		work4_1.m_level = this.sc.nextLine().intern();
		
		if(work4_1.m_level.isEmpty()) {
			System.out.println("회원가입 형태를 골라주세요.");
			level_ck();
		}
		else if(work4_1.m_level == "1") {
			work4_1.m_level ="일반고객";
			System.out.println("일반고객");
		}
		else if(work4_1.m_level == "2") {
			work4_1.m_level ="사업자고객";
			System.out.println("사업자고객");
			businessNo_ck();
		}
		else {
			System.out.println("1번 or 2번만 선택가능합니다. 다시 입력해주세요.");
			level_ck();
		}
		return work4_1.m_level;
	}
	private String id_ck() {

		System.out.println("회원 아이디 :");
		work4_1.userid = this.sc.nextLine().intern();
		
		if(work4_1.userid.isEmpty()) {
			System.out.println("아이디를 입력해주세요.");
			id_ck();
		}else {
			return work4_1.userid;
		}
		
		return work4_1.userid;
	}
	private String pw_ck() {

		System.out.println("회원 패스워드 : ");
		
		work4_1.userpw = this.sc.nextLine().intern();
		if(work4_1.userpw.isEmpty()) {
			System.out.println("패스워드를 입력해주세요.");
			pw_ck();
		}
		else if(work4_1.userpw.length() < 6) {
			System.out.println("패스워드는 6자 이상이여야 합니다.");
			work4_1.userpw = "";
			pw_ck();
		}else {
			return work4_1.userpw;
		}
		return work4_1.userpw;
	}
	
	private String company_ck() {

		System.out.println("회원 이름 및 회사명");
		work4_1.c_info = this.sc.nextLine().intern();
		
		if(work4_1.c_info.isEmpty()) {
			System.out.println("회원 이름 및 회사명을 입력해주세요.");
			company_ck();
		}		
		System.out.println(work4_1.c_info);
		return work4_1.c_info;
	}

	private String tell_ck() {
				
		System.out.println("전화번호 또는 휴대전화번호 (숫자만 입력) : ");
//		work4_1.usertell = this.sc.nextLine().intern();
		String tell_ck = this.sc.nextLine().intern();
		
		work4_1.usertell = "";
		
		if(tell_ck.length() < 11) {
			System.out.println("11자 이상의 번호를 입력해주세요.");
			tell_ck = "";
			tell_ck();
		}
		else {			
			try{
				Long.parseLong(tell_ck);
				work4_1.usertell = tell_ck;
			}
			catch(Exception e) {
				System.out.println("전화번호 숫자변환 불가");
				System.out.println(e);
				work4_1.usertell = "";
				tell_ck();
			}
		}
		return work4_1.usertell;
	}
	
	private String email_ck() {
		System.out.println("이메일 주소 :");
		
		work4_1.useremail = this.sc.nextLine().intern();
		
		if(!work4_1.useremail.contains("@") || work4_1.useremail.length() < 10) {	// false (@ 포함 안됨)
			System.out.println("올바른 이메일 형식을 사용해주세요.");
			work4_1.useremail = "";
			email_ck();
		}
		return work4_1.useremail;
	}
	
	private String businessNo_ck() {
				
		System.out.println("사업자 번호 10자리");
		
		//work4_1.businessNo = this.sc.nextLine().intern();
		String b_no_ck = this.sc.nextLine().intern();
		
		work4_1.businessNo = "";
		
		if(b_no_ck.length() < 10) {
			System.out.println("10자리 이상의 번호를 입력해주세요.");
			b_no_ck ="";
			businessNo_ck();
		}
		else if(b_no_ck.length() > 10) {
			System.out.println("10자리 번호를 입력해주세요.");
			b_no_ck ="";
			businessNo_ck();
		}
		else {
			try {
				Long.parseLong(b_no_ck);
				work4_1.businessNo = b_no_ck;
			}
			catch(Exception e) {
				System.out.println("사업자 번호 숫자 오류");
				System.out.println(e);
				work4_1.businessNo = "";
				businessNo_ck();
			}
		}
		
		return work4_1.businessNo;
	}
	
}
