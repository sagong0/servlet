package io;

import java.io.FileWriter;
import java.util.Scanner;
// Scanner를 이용한 파일 쓰기 기능 활성화.
public class file5 {

	
	// static main 에는 this를 사용하지못함.
	/*
	 * static 사용시 new 인스턴스를 호출시 새롭게 읽어 들이므로 기존에 있는 코드를
	 * 인식 하지 못하는 상황이 발생함.
	 * **/
	public static void main(String[] args) {
		try {
			/* 객체 생성 */
			FileWriter fw = null;
			Scanner sc = null;
			/* 인스턴스 생성 */
			fw = new FileWriter("E:\\project\\web\\src\\main\\webapp\\user.txt", true);
			sc = new Scanner(System.in);
			int f;
			// for무한루프 
			for(f=0; f<3; f++) {
				System.out.println("사용자 이름을 입력해 주세요? ");
				String name = sc.nextLine().intern();
				if(name == "exit") {
					break;
				}else {
					fw.write(name + "\n");
				}
			}
			System.out.println("모든 데이터 내용이 저장 되었습니다.");
			// 닫을때는 역순으로
			sc.close();
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("파일 오류발생!!");
		}
	}

}
