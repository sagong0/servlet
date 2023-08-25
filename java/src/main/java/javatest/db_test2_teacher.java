package javatest;

import java.util.Scanner;

public class db_test2_teacher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문의제목을 입력하세요");
		
		String subject = sc.nextLine();
		System.out.println("고객명을 입력하세요");
		
		String person = sc.nextLine();
		// 재귀함수로 핸들링
		//String result = new db_test_teacher().passwordck();
		// 무한 loop 사용법
		for(;;) {
			System.out.println("패스워드를 입력하세요.");
			String pw = sc.nextLine();
			
			if(pw.length() < 6) {
				System.out.println("제발 좀 6자리 이상 입력해주세요...");
				new db_test2_teacher().passwordck();
			}
			else {
				break;
			}
		}
		System.out.println("문의내용을 입력하세요");
		String texts = sc.nextLine();
		sc.close();
	}

	public String passwordck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("패스워드를 입력하세요.");
		String pw = sc.nextLine();
		
		if(pw.length() < 6) {
			System.out.println("제발 좀 6자리 이상 입력해주세요...");
			new db_test2_teacher().passwordck();
		}
		return pw;
		
	}
}
