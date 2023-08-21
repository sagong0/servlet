package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class file1 {

	public static void main(String[] args) {
		try {
			new box_office().abc(); 
		} catch (Exception e) {
			System.out.println("file load error !");
			e.printStackTrace();
		}
	}
}

/* Scanner를 이용하여 다음과 같이 실행 되도록 합니다.
 * 1. 개봉작 리스트 출력, 2.프로그램 종료	: 고르세요
 * 
 * 1번 입력 후 엔터 실행시 영화 리스트가 출력 되어야 하며,
 * 2번 입력시 프로그램을 강제 종료 합니다. (System.exit=0)
 *  */
class box_office{
	Scanner sc = null;
	public void abc() throws Exception {
		String url = "E:\\project\\example\\src\\main\\webapp\\movie_db.txt";
		InputStream is = new FileInputStream(url);
		this.sc = new Scanner(System.in);
		System.out.println("1. 개봉작 리스트 출력 || 2.프로그램 종료 ?");
		int no = sc.nextInt();
		if(no == 1) {
			// 해당 모든 파일의 용량을 byte 배열로 변환
			byte temp[] = new byte[is.available()];
			is.read(temp);	// 변환된 배열값을 모두 읽어드림
			String data = new String(temp,"UTF-8");	// 해당 배열을 문자화 하여 적용
			System.out.println(data);
		}
		else {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
		is.close();
		this.sc.close();
		
		
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\project\\example\\src\\main\\webapp\\movie_db.txt")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		System.out.println("1. 개봉작 리스트 출력, 2.프로그램 종료	: 고르세요");
		
		Scanner sc = new Scanner(System.in);

		
		String inputData = sc.nextLine().intern();
		String a = "";
		
		while(true) {
			if(inputData == "2") {
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
			}
			else {
				if(inputData == "1") {
					if((a=br.readLine()) != null) {						
						a=br.readLine();
						bw.write(a + "\n");
						bw.flush();
					}
					else if((a=br.readLine()) == null) {
						break;
					}
				}
			}
		}
		sc.close();
		br.close();
		bw.close();
		*/
	}
}
