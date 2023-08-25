package javatest;
/*
 * 응용문제 1)
 * 외부 클래스명은 data2를 활용하여 조건문을 완성하는 코드를 작성하시오.
 * "첫번째 숫자를 입력합니다."
 * "두번째 숫자를 입력합니다."
 * 어느 값이 큰지를 콘솔로 출력하시오.
 * 단, 첫번째, 두번째 숫자 중 하나라도 미 입력시 재 호출 되도록합니다. 
 * */

import java.util.Scanner;

class data2{
	
	Scanner sc = null;
	// intern(), equals() :문자
	// 숫자 : 연산기호(==,===, !=,>=,<=,<>);
	
	static int a1,b1 = 0;
	
	public void abc(int a , int b) {
		this.a1 = a;
		this.b1 = b;
		
		
		System.out.println("첫번째 숫자를 입력합니다.");
		
		this.sc = new Scanner(System.in);
		String firstNo = sc.nextLine().intern();
		System.out.println("두번째 숫자를 입력하세요.");
		String secondNo = sc.nextLine().intern();
		

		// if(firstNo == null || secondNo = "") 로 처리도 가능.
		if(firstNo.isEmpty() || secondNo.isEmpty()) {
			abc(this.a1,this.b1);	// 재호출
		}
		else if(Integer.valueOf(firstNo) > Integer.valueOf(firstNo)) {
			System.out.println(firstNo);
		}
		else if (firstNo == secondNo){
			System.out.println("서로 같은 값입니다.");
		}
		else {
			System.out.println(secondNo);
			this.sc.close();
		}
	}
}

public class java5 {
	String a;
	String b;
	public static void main(String[] args) {
		
		data2 d2 = new data2();
		d2.abc(3, 5);
	}

}
