package javatest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class work3 {

	
	public static void main(String[] args) {
		try {
			new work3_1().survey();
			
		} catch (Exception e) {
			System.out.println("err");
			e.printStackTrace();
		}
	}
}

class work3_1{
	
	Connection ct = null;
	Scanner sc = null;
	
	static String gender = "";
	static String age = "";
	static String climate ="";
	
	public void survey() throws Exception{
		dbconfig db = new dbconfig();
		this.ct = db.info();
		this.sc = new Scanner(System.in);

		work3_1.gender = gender_ck();
		work3_1.age= age_ck();
		work3_1.climate = climate_ck();
		
		if(work3_1.gender.isEmpty() || work3_1.age.isEmpty() || work3_1.climate.isEmpty()) {
			System.out.println("빈 칸 을 모 두 채 워 주 세요 .");
			survey();
		}
		else {
			String insert ="insert into survey values('0','"+gender+"','"+age+"','"+climate+"',now());";
			PreparedStatement ps = ct.prepareStatement(insert);
			
			int oksign = ps.executeUpdate();
			
			if(oksign == 1) {
				System.out.println("저장완료");
				ps.close();
				ct.close();
				sc.close();
			}
			else {
				System.out.println("저장실패.... sql 구문 오류인듯.?");
			}			
		}
	}

	private String gender_ck() {
		System.out.println("당신의 성별은 ? ");
		System.out.println("1.남성 ,  2.여성");		
		//Scanner sc = new Scanner(System.in);
		work3_1.gender = this.sc.nextLine().intern();
		if(work3_1.gender == "1") {
			work3_1.gender = "남성";
			System.out.println(gender);
		}
		else if(work3_1.gender == "2") {
			work3_1.gender = "여성";
			System.out.println(gender);
		}
		else if(work3_1.gender.isEmpty()) {
			System.out.println("남 or 여 를 선택해주세요.");
			gender_ck();
		}
		else {
			System.out.println("남성 혹은 여성만 선택 가능합니다.");
			work3_1.gender = "";
			gender_ck();
		}
		//System.out.println(gender);
		return work3_1.gender;
	}
	

	private String age_ck() {
		System.out.println("당신의 연령층은?");
		System.out.println("1.10대, 2.20대, 3.30대, 4.40대, 5.50대 이상");
		
		//Scanner sc = new Scanner(System.in);
		work3_1.age = this.sc.nextLine().intern();
		
		if(age.isEmpty()) {
			System.out.println("연령층을 선택해 주세요.");
			age_ck();
		}
		else if(age == "1") {
			work3_1.age = "10대";
			System.out.println("10대");
		}
		else if(age == "2") {
			work3_1.age = "20대";
			System.out.println("20대");
		}
		else if(age == "3") {
			work3_1.age = "30대";
			System.out.println("30대");
		}
		else if(age == "4") {
			work3_1.age = "40대";
			System.out.println("40대");
		}
		else if(age == "5") {
			work3_1.age = "50대이상";
			System.out.println("50대이상");
		}
		else {
			work3_1.age = "60대 이상";
			System.out.println("60대 이상입니다.");
		}
		return work3_1.age;
	}

	
	
	private String climate_ck() {
		System.out.println("현재 기후 위기 단계 수준은?");
		System.out.println("1.매우심각하다, 2.심각하다, 3.보통이다, 4.심각하지 않은 편이다.");
		
		work3_1.climate = this.sc.nextLine().intern();
		if(work3_1.climate.isEmpty()) {
			climate_ck();
		}
		else if(work3_1.climate == "1") {
			work3_1.climate = "매우심각하다";
			System.out.println(climate);
		}
		else if(work3_1.climate == "2") {
			climate = "심각하다";
			System.out.println(climate);
		}
		else if(work3_1.climate == "3") {
			work3_1.climate = "보통이다.";
			System.out.println(climate);
		}
		else if(work3_1.climate == "4") {
			work3_1.climate = "심각하지 않은 편이다.";
			System.out.println(climate);
		}else {
			System.out.println("1~4 번만 입력가능합니다.");
			work3_1.climate = "";
			climate_ck();
		}
		return work3_1.climate;
	}
}
