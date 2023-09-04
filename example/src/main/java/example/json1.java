package example;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// js14.html 에서 사용한 data.json을 제작하여 활용하는 형태.
/*
 * Json1.java 에서 원시 배열값으로 json으로 변환 후 Front가 해당데이터를
 * ajax로 로드하여 웹 페이지에 출력하는 형태.*/
public class json1 {
	
	public static void main(String[] args) throws Exception{
		JSONObject jo = new JSONObject();// put만 사용, key만 생성.
		JSONArray ja = new JSONArray();	// add만 사용 ,data를 생성하는 용도.
		
		int user[] = {2600,3200,1900};	// 숫자형태 json 숫자로 데이터가 생성.
		int w = 0;
		while(w < user.length) {
			//ja.add(user[w]);	// 키가 없는 형태의 배열
			JSONObject jo2 = new JSONObject();	// 키 생성시 반복문으로 작동하면 객체 및 인스턴스를 새롭게 생성하면서 적용해야함.
			jo2.put("product"+w, user[w]);// ("키이름",데이터값)
			ja.add(jo2);// 배열화
			w++;
		}
		jo.put("adata", ja);	// 대표키 생성 하는 형태.
		FileWriter fw = new FileWriter("E:\\project\\example\\src\\main\\webapp\\data.json",false);
		BufferedWriter bw = new BufferedWriter(fw);
		//bw.write(jo.toJSONString());
		bw.write(jo.toString());	//배열형태를 문자열로 변환 후 저장.
		//bw.write("ajax_data("+jo.toString()+")");	// CORS 해결하기위한 함수호출 적용.
		bw.flush();
		bw.close();
		fw.close();
	}
}
