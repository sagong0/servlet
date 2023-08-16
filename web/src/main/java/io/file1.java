package io;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * I/O : inputStream, OutputStream
 * 입력 스트림 : 프로그램으로 들어오는 데이터. (키보드, 마우스, SSD, HDD)
 * 출력 스트림 : 프로그램에 해당 데이터를 출력하는 형태. (모니터, 프린터, 데이터값)
 * Stream : input, output 사용자가 처리하는 데이터.
 * java.io : 라이브러리.
 * java.util : 객체지향.
 * StreamAPI
 * File, FileReader (일반적사용) -> FileinputStream
 * FileWriter -> FileOutputStream 
 *  
 *  - 예외처리 방식 -
 *  
 *  1. 메소드에 throws Exception을 사용시 해당 메소드를 외부에서 호출 시 무조건
 *  	try~ catch를 사용해야함 !.
 *  
 *  2. 해당 메소드에서 try~catch를 사용할 경우 호출 받은 메소드에서 throws를 사용했을 때
 *  또는 해당 메소드는 throws를 사용하지 않고, 호출 받은 메소드 자체에 오류가 발생시
 *  호출하는 메소드에서 예외 처리하는 상황.
 *  
 *  3. 예외처리를 하지않을 경우 해당 프로세서는 종료하지 못하고 정지하는 형태가 발생함.
 *   
 * */
public class file1 {

	public static void main(String[] args){
		abc a = new abc();
		
		try {			//여러번 사용가능
			a.aa();
			String nm = "10";
			Integer number = Integer.parseInt(nm);
			
		}
		catch(FileNotFoundException fe) {
			System.out.println("해당 파일을 찾을 수 없습니다.!!!");
		}
		catch(NumberFormatException nf) {
			System.out.println("숫자로 변환하지 못하였습니다.");
		}
		catch(Exception e) {
			// Exception 은 여러가지 오류사항 예외처리를 모두 확인 할 수 있는 
			// Default 클래스 입니다.
			//System.out.println("해당 파일을 찾을 수 없습니다.");
			//System.out.println(e.getMessage());
			System.out.println(e);
		}
	}

}
class abc{
	/* 
	 * \\: 자신의 PC에 있는 파일을 사용함.	(이미지 미리보기)
	 * / : Server를 이용하여 파일을 사용함.
	 * */
	public void aa() throws Exception {
		//file 읽어옴
		FileReader fr = new FileReader("E:\\project\\web\\src\\main\\webapp\\data.txt");
		System.out.println(fr.read());
		// read() : 데이터 크기를 읽어 들이는 메소드 입니다.
		// -1 : 파일이 아무것도 없는 상태, -1외에는 파일이 있는 상태.
	}
}


