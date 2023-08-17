package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// 이미지 파일 처리 (Stream)
public class file13 {
	public static void main(String[] args) {
		try {
			data11 a = new data11();
			a.abc();
		} catch (Exception e) {
			System.out.println("에러");
		}
	}
}
class data11{
	public void abc() throws Exception{
		InputStream is = new FileInputStream("E:\\project\\web\\src\\main\\webapp\\dog.jpg");
		//System.out.println(is.available());
		/*
		byte[] file = new byte[is.available()];
		int b = is.read(file);
		*/
		OutputStream os = new FileOutputStream("dog2.jpg");	// web 프로젝트 에 생성됨 (디렉토리 경로 안잡아줘서)
		
		// %로 확인
		byte[] file = new byte[is.available()/100];		// 한번에 읽어 들일 수 있는 크기.
		
		int img = 0;	// 읽어 들이는 byte수
		int check = 0;	// 읽는 횟수
		/* 복사율을 표시하면서 progress-bar를 이용하여 보여줄 때  */
		while(true) {
			img = is.read(file);
			if(img == -1) {		//읽어 들일 수 있는 용량 만큼 읽기
				break;		// 더 이상 byte 가 없을 경우 정지 조건
			}
			else {
				if(check <= 80) {	//80% 이하일 경우 지속적으로 복사
					os.write(file,0, img);					
				}
				else {	// 80% 이상 일 경우 정지.
					break;
				}
			}
			check++;
			if(check % 2 == 0) {	//진행률을 표시하는 기능
				System.out.println(check + "%");
			}
		}
		//os.write(file);
		os.close();
		os.flush();
		is.close();
	}
}
