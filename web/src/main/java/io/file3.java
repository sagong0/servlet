package io;

import java.io.FileReader;
import java.io.IOException;

// IOException + Exception + finally (예외처리 후 다시 해당 프로세서 실행 but 강제종료)
public class file3 {
	public static void main(String[] args) {
		try {
			data2 dt = new data2();
			String url = "E:\\project\\web\\src\\main\\webapp\\data1.txt";
			dt.abc(url);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {	// catch로 오류가 발생시 다시 프로세서를 읽어서 해당 메소드를 호출 하는 형태.
			//System.out.println("다른 파일명 설정");
			try {	// 해당 메소드가 throws 를 사용했으므로 다시 try~catch를 꼭 사용해야 합니다.
				data2 dt = new data2();
				String url = "E:\\project\\web\\src\\main\\webapp\\data.txt";
				dt.abc(url);
			}catch(Exception e) {
				System.out.println("파일 완전 또 오류가? 발생 ??");
				// 프로그램 강제종료해버리기.
				System.exit(0);
			}
		}
	}

}

class data2{
	FileReader fr = null;
	
	public void abc(String filename) throws Exception, IOException{
		this.fr = new FileReader(filename);
		System.out.println(this.fr.read());
		this.fr.close();
	}
}
