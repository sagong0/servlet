package io;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


// I/O 응용편~~~~~~~~~~~~~~
/*
 * 응용문제 1
 * 해당 데이터를 파일로 저장 후 출력하는 프로세서를 제작하시오.
 * "hong","kim","park","lee"
 * "25","30","44", "26"
 * "홍길동","김유신","박찬호","이순신"
 * 
 * 파일에 저장 형태는 다음과 같습니다.
 * 홍길동:hong(25)
 * 김유신:kim(40)
 * 박찬호:park(44)
 * 이순신:lee(26)
 * 
 * 단, 파일명은 member_list.txt
 * */
public class file14 {

	public static void main(String[] args) {
		try {
			data12 a = new data12();
			a.abc();
		} catch (Exception e) {
			System.out.println("error");
			System.out.println(e);
		}
	}

}

class data12{
		
	public void abc() throws Exception{
		
		
		Path dir = Paths.get("E:\\project\\web\\src\\main\\webapp\\test2\\member_list.txt");
		//Files.createFile(dir);
		

		String data[][] = {
				{"홍길동","김유신","박찬호","이순신"},
				{"hong","kim","park","lee"},
				{"25","30","44", "26"}
		};
		
		/*
		data[0][0] data[0][1] data[0][2]
		data[1][0] data[1][1] data[1][2]
		data[2][0] data[2][1] data[2][2]
		data[3][0] data[3][1] data[3][2]
		*/
		
		String new_Data[] = new String [data[0].length];
		
		for(int i = 0; i< data[0].length; i++) {	// 4
			new_Data[i] = data[0][i] + data[1][i] + data[2][i];
		}
		
		String result1 =""; 
		for(int j=0; j< new_Data.length; j++) {
			result1 += new_Data[j];
		}
		
		String result = Arrays.toString(new_Data);
		byte[] resultb = result.getBytes();
		byte[] resultaa = result1.getBytes();
		
		OutputStream os = new FileOutputStream("E:\\project\\web\\src\\main\\webapp\\test2\\member_list.txt");
		os.write(resultaa,0, resultaa.length);
		os.flush();
		os.close();
	}
}
