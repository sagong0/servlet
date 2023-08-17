package io;
//BufferedInputStream, BufferedOutputSream

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class file15 {
	public static void main(String[] args) {
		try {
			data15 a = new data15();
			a.abc();
		} catch (Exception e) {
			System.out.println("파일 저장 코드 오류");
			e.printStackTrace();
		}
	}
}
// 

class data15{
	public void abc() throws Exception{
		String file = "E:\\project\\web\\src\\main\\webapp\\dog.jpg";
		
		//아래 두개같은거
		//InputStream is = new FileInputStream(file);
//		FileInputStream fs = new FileInputStream(file);
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
		byte filesize[] = new byte[bi.available()];
		int total = bi.read(filesize);
		//System.out.println(Arrays.toString(filesize));
		
		if(total > 50000) {
			System.out.println("이미지 제한 용량을 초과합니다.");
		}else {
			System.out.println("이미지 제한 용량 확인");
			OutputStream os = new FileOutputStream("dog2.jpg");
			os.write(filesize);	// 무조건 byte 단위로 write
			os.flush();
			os.close();
			bi.close();
		}
		
	}
}
