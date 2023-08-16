package io;

import java.io.FileReader;

// I/O 파일 데이터 읽어오기
public class file2 {

	public static void main(String[] args) {
		try {
			data1 d = new data1();
			d.aaa();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

class data1{
	
	public void aaa() throws Exception {
		// 문서파일일 경우 utf8, ansi 확인 후 저장 합니다.
		FileReader fr = new FileReader("E:\\project\\web\\src\\main\\webapp\\data.txt");
		System.out.println(fr.getEncoding());		// 파일을 읽어오는 인코더 형식.
		
		
		while(true) {		// 무한loop
			int m = fr.read();
			//System.out.println(m);
			System.out.println((char) m);	// byte를 문자화 하여 변환해서 출력
			// 1024 byte == 1kbyte
			// 1024kb = 1mb
			if(m == -1) {
				break;
			}
		}
		// 파일 닫아주기 !
		fr.close();
	} 
}
