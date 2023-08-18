package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

// HOMEWORK
/*
 * Scanner를 이용하여 총 10개의 숫자를 입력합니다.
 * 단, 1 ~ 100 까지의 숫자만 입력이 가능하며, 100이상 숫자를 입력할 경우
 * 해당 콘솔로 "100까지의 숫자만 입력 가능합니다." 라고 메세지가 출력 되어야 합니다.
 * 무조건 10개의 숫자를 받아야 하며, 해당 숫자는 모두 data_num.txt 파일로
 * 저장 되어야 합니다.
 * 
 * 
 * hint ) 무한 반복 사용 및 counting 을 이용해야함. 
 * */

public class file18 {

	public static void main(String[] args) {
		try {
			data18 a = new data18();
			a.abc();
		}catch(NumberFormatException e) {
			System.out.println(e);
		} 
		catch (Exception e) {
			System.out.println("error");
			System.out.println(e);
		}
	}

}

class data18{
	public void abc() throws Exception{
		//Files.createFile(Paths.get("E:\\project\\web\\src\\main\\webapp\\data_num.txt"));
		String url = "E:\\project\\web\\src\\main\\webapp\\data_num.txt";
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url)));
		
		int a = 0;

		while(true) {
			System.out.println("1~100 까지의 숫자 중 한가지를 입력하세요");
			String data = sc.nextLine().intern();
			
			if(data == "quit") {
				System.out.println("종료 됩니다.");
				break;
			}else if(a >= 10) {
				System.out.println("10개 꽉찼습니다.");
				break;
			}
			else{
				if(Integer.parseInt(data) > 100 || Integer.parseInt(data) <= 0) {
					System.out.println("0 ~ 100까지의 숫자만 입력 가능합니다.");
				}
				else {
					bw.write(data + "\n");
					++a;
					bw.flush();
				}
			}
		}
		bw.close();
		sc.close();
	}
}
