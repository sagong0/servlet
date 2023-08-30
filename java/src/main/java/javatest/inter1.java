package javatest;

import java.util.*;

public interface inter1 {
	String name = "홍길동";	// 필드에 적용된 전역 변수.
	String userid ="hong";
	//default String useremail = "hong@nate.com"; 변수에는 default ㅌ
	
	//처음부터 객체와 인스턴스를 활용하여 api class를 생성시킴.
	Scanner sc = new Scanner(System.in);
	
	public void a1();	// 일반 메소드
	//public void a1(String a);	// 일반 메소드
	default void aa1() {	// override를 필수로 하지않고 필요할때만 로드하여 사용 할때 default를 이용함
		System.out.println(this.userid);	
	} 
	
	class zzz{	// interface 안에  자식 클래스 사용
		public void zzjj() {	// 자식 클래스 메소드
			System.out.println("인터페이스 안에 외부 클래스 활용!!");
		}
	}
}
