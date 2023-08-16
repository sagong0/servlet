package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

//inputStream + OutputStream + flush 사용법 (메모리)
/*
*inputStream 2개를 활성화 시 메모리 구조상 신규 인스턴스를 생성하지 않을 경우
*연속으로 Stream을 사용하지 못합니다.
*/
public class file10 {

	public static void main(String[] args) throws Exception{
		
		data7 aa = new data7();
		aa.abc();
		/*
		InputStream in = System.in;		// 값을 적용
		OutputStream os = System.out;	// 값을 출력
		
		int a = in.read();	// 입력된 사항을 읽어들임.
		os.write(a);	// 쓰기
		os.flush();
		os.close();	// OutputStream 닫기
		in.close();	// inputStream 닫기
		*/ 
		
	}
}

class data7{
	
	public void abc() {
		String data = "abcde";
		byte[] b = data.getBytes();
		System.out.println(Arrays.toString(b));
		OutputStream os = System.out;
		try {
			os.write(b,0,b.length);
			os.flush();
			os.close();
		}
		catch(Exception e){
			
		}
	}
}