package io;

import java.io.FileWriter;

// 파일쓰기 (write)

public class file4 {

	public static void main(String[] args) {
		try {
			new data3().abc();
		}
		catch(Exception e) {
			System.out.println("파일 오류 발생!!");
		}
	}
}


class data3{
	FileWriter fw = null;
	// FileWriter : 문자 데이터를 파일에 쓰는 class
	public void abc() throws Exception {
		String user[] = {"홍길동3","유관순3","이순신3", "강감찬3","안중근3"};
		//this.fw = new FileWriter("E:\\project\\web\\src\\main\\webapp\\data.txt");
		this.fw = new FileWriter("E:\\project\\web\\src\\main\\webapp\\data.txt", true);
		//FileWriter true : 기존데이터 삭제 하지않고 지속적으로 데이터를 추가하는 형태
		for(String name : user) {
			this.fw.write(name);	// write 메소드 : 해당 파일에 데이터를 쓰기 용도.
		}
		this.fw.close();	// 파일 오픈 종료
	}
}