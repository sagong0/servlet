package example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

/*
 * 응용문제2.
 * 해당 buffer.txt 파일을 읽어 들인 후 배열로 내용을 저장 후 
 * 짝수 배열값만 출력시키는 프로세서를 제작하시오.
 * 
 * 결과)	출력확인 하는 중입니다...	0
		JAVA BufferReader 힘듬..	0

 * */

public class file2 {

	public static void main(String[] args) {
		try {
			new bufferdata().abc();
		} catch (Exception e) {
			System.out.println("error");
		}
	}

}

class bufferdata{
	// Reader -> BufferedReader -> ArrayList	byte(X)
	// Stream -> BuffredStream -> ArrayList		byte(O)
	// Stream -> BufferedStreamReader -> Reader -> ArrayList	byte(O)
	
	FileReader fr = null;
	BufferedReader br = null;
	ArrayList<String> ar = null;
	
	public void abc() throws Exception{
		String url = "E:\\project\\example\\src\\main\\webapp\\buffer.txt";
		this.fr = new FileReader(url);
		this.br = new BufferedReader(this.fr);	//메모리로 올림(버퍼가 핸들링할거)
		this.ar = new ArrayList<String>();
		
		String data = null;
		
		int count = 1;
		
		while((data = this.br.readLine()) != null) {
			if(count % 2 == 0) {
				this.ar.add(data);
			}
			count++;
		}
		System.out.println(this.ar);
		this.br.close();
		this.fr.close();
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
		
		//System.out.println(br.readLine());
		
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> resultArr = new ArrayList<String>();
		
		String a = "";
		while((a = br.readLine()) != null) {
			arr.add(a);
		}
			for(int i= 0; i < arr.size(); i++) {
				if(i % 2 == 1) {
					resultArr.add(arr.get(i));
				}
			}
		System.out.println(resultArr);
		
		br.close();
	*/
	}
}



