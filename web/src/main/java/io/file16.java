package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * InputStream > InputStreamReader > BufferedReader (0)
 * InputStream > BufferedInputStream (0)
 * FileinputStream > BufferReader (X)
 * FileWriter > FileOutputStream (X)
 * */



//InputStreamReader, OutputSreamWriter, BufferedReader, BufferdWriter
public class file16 {

	public static void main(String[] args) {
		data16 a = new data16();
		try {
			a.abc();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}

class data16{
	// InputStreamReader : Stream => Reader 변환 !!!!!
	// OutputSreamWriter : Stream => Reader 저장시킴
	public void abc() throws Exception {
		String fileUrl = "E:\\project\\web\\src\\main\\webapp\\number.txt";
		InputStream is =new FileInputStream(fileUrl); 
		InputStreamReader ir = new InputStreamReader(is);	//단독으로 못씀(바이너리 -> 아스키)
		BufferedReader br = new BufferedReader(ir);
		
		//System.out.println(br.readLine());
		String data;
		while((data = br.readLine()) != null) {
			System.out.println(data);
		}
		//byte f[] = new byte[];
		br.close();
		ir.close();
		is.close();
		
	}
}