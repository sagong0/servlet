package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

// Stream으로 파일로드 하는 방식	+ 쓰기
public class file11 {
	//E:\project\web\src\main\webapp\datalist.txt
	public static void main(String[] args) {
		try {
			data8 a = new data8();
			a.abc();
		} catch (Exception e) {
			System.out.println("소스 코드 및 경로 실패");
		}
	}
}

class data8{
	public void abc() throws Exception{
		InputStream is = new FileInputStream("E:\\project\\web\\src\\main\\webapp\\datalist.txt");	// 바이너리
		//System.out.println(is.available());	//available() : 파일 전체 크기 체크 확인 방식.
		//byte temp[] = new byte[is.available()];	// 파일 전체를 모두 byte 배열로 적용
		byte temp[] = new byte[1024 * 10];	// 10KB , 1MB = 1024 * 1024 * 1
		int ea = is.read(temp);			// 파일 전체 크기 확인 방식. , read로 파일 읽어들임
		/*
		read()가 필요한 이유는 해당 파일 바이너리 형태로 
		읽기 때문에 read 메소드로 파일 전체를 읽어 들입니다. 
		 */
		//System.out.println(ea);
		
		// 파일 txt 문자 파일. -> String
		String data = new String(temp,"UTF-8");
		System.out.println(data);
		is.close();
		
		try {
			data9 z = new data9();
			z.zzz();
		}catch(Exception e) {
			System.out.println("데이터 쓰기 부분 오류 발생!");
		}
	}
}

class data9{
	public void zzz() throws Exception{
		String test ="\n연습입니다.";
		FileOutputStream os = new FileOutputStream("E:\\project\\web\\src\\main\\webapp\\datalist.txt", true);
		byte[] data = test.getBytes();	// 문자열을 byte 단위로 변환 (바이너리)
		
		os.write(data);
		os.flush();
		os.close();
	}
}


