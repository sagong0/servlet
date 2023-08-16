package io;

import java.io.FileWriter;
import java.util.Scanner;

/*  응용문제1.
 *  Scanner를 이용하여 사용자가 입력한 숫자를 모두 저장 되도록 합니다.
 *  "1~100 까지의 숫자 중 한가지를 입력하세요? "
 *  단, 한줄에 하나의 숫자가 입력 되도록 하며,quit라는 명령어를 입력시
 *  더 이상 프로세서는 작동 되지 않도록 합니다.
 *  저장 파일명은 number.txt 로 저장 되도록 하시오.
 *  */
public class file6 {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = null;
			Scanner sc = null;
			
			fw = new FileWriter("E:\\project\\web\\src\\main\\webapp\\number.txt", true);
			sc = new Scanner(System.in);
			
			for(;;) {
				System.out.println("1~100 까지의 숫자 중 한가지를 입력하세요?");
				String num = sc.nextLine().intern();	// quit 로 인하여 String으로 처리
				
				
				if(num == "quit") {
					break;
				}else {
					if(Integer.parseInt(num) > 100) {
						System.out.println("숫자는 제발 100 이하로 입력하세요.");
					}
					else {
						fw.write(num + "\n");
					}
				}
				
			}
			// 꼭 닫아주기 
			sc.close(); // 파일 저장 (close를 안할 경우 해당 파일 오픈되있어 저장되지 않는 상황이 발생.)
			fw.close();
			System.out.println("모든 숫자가 저장되었습니다.");
			
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("파일 오류발생");
		}
	}

}



