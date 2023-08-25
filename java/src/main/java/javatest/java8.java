package javatest;

import java.util.Scanner;

public class java8 {
	public static void main(String[] args) {
		
		System.out.println("구구단 2단 ~ 9단 까지 숫자를 하나 입력하세요:");
		Scanner sc = new Scanner(System.in);
		String no1 = sc.nextLine().intern();
		
		
		new data5().abc(no1);
		/*
		 * 응용문제5 Scanner를 이용하여 다음과 같이 결과값이 나오도록 합니다.
		 * "구구단 2단 ~ 9단 까지 숫자를 하나 입력하세요:"
		 * 사용자가 5를 입력시 
		 * 5*1  ~  5*9=45 까지 출력 되도록합니다.
		 * 단 , 메인 메소드에서 입력을 받은 후 외부 클래스 메소드로 전송하여 출력함.
		 * */
	}
}
/*
 * double loop 응용편 (do~while + for)
 * 다음 결과값 처럼 출력 되도록 하시오.
 * 9*1 = 9
 * 9*2 = 18
 * 9*3 = 27
 * 8*1 = 8
 * 8*2 = 16
 * 8*3 = 24
 * 7*1 = 7
 * 7*2 = 14
 * 7*3 = 24
 * 
 * */
class data5{
	public void abc(String no1) {
		
		int i;
		for(i=2; i<10; i++) {
			System.out.println(Integer.valueOf(no1) + "*"+ i + "=" + Integer.valueOf(no1) * i);
		}
		
		/*
		int w =9;
		int i;
		do {
			
			for(i =1; i<=3; i++) {
				System.out.println(w + "*" + i + "=" + w*i);
			}
			w--;
		}while(w >6);
		*/
	}
}
