package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * HOMEWORK : user_tl.txt 파일을 로드 후 해당 사용자에 맞게 전화번호가 등록 되도록
 * 배열화 하여 콘솔로 출력 되도록 합니다.
 * 단,cms_db.txt로 해당 내용이 저장 되어야 합니다.
 * 
 * 결과 : 
 * 홍길동(01011245564)
 * 김유신(01020041004)
 * */
public class file3 {
	public static void main(String[] args) {
		try{
			new data1().abc();
		}catch(Exception e) {
			System.out.println("errrr");
			System.out.println(e);
		}
	}
}

class data1{
	InputStream is = null;
	public void abc() throws Exception {
		String url = "E:\\project\\example\\src\\main\\webapp\\cms_db.txt";
		//Files.createFile(Paths.get(url));
		this.is = new FileInputStream("E:\\project\\example\\src\\main\\webapp\\user_tel.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url)));
		
		String data = "";
		ArrayList<String> arr = new ArrayList<String>();
		
		
		
		while((data = br.readLine()) != null) {
			arr.add(data);
		}
		/*
		//System.out.println(arr);
		
		int w =0;
		while(w < arr.size()) {
			String result[] = arr.get(w).split("[|]");
		//System.out.println(Arrays.toString(result));
			System.out.println(result[0]+"("+result[1]+")");
			
			bw.write(result[0]+"("+result[1]+")" + "\n");
			bw.flush();
			
			w++;
		}
		bw.close();
		br.close();
	*/
		
//		System.out.println(arr);
		String rr="";
		int w = 0;
		while(w < arr.size()) {
			rr += arr.get(w)+",";
			w++;
		}
		System.out.println(rr);
		
		//String[] oper = str.split("-|\\+");
		ArrayList<String> resultArr = new ArrayList<String>(Arrays.asList(rr.split("[|]|[,]")));
//		System.out.println(resultArr);
		
		String a  = "";
		String b = "";
		String c = "";
		
		for(int i=0; i< resultArr.size(); i++) {
			if(i == 0 || i % 2==0) {
				a = resultArr.get(i);
			}
			else if(i % 2!=0) {
				b = resultArr.get(i);
			}
			if(i !=0)
			c = a+"("+b+")"+"\n";
			System.out.println(c);
		}
		
	}
}
