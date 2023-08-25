package javatest;
/*
 * 반복문 for, while, do while 문
 * */
public class java6 {
	public  static void main(String[] args) {
		new data3().abc();
	}
}
/* 1~5 까지 출력문 */
class data3{
	public void abc() {
		/*
		int f;
		for(f=1; f<=5; f++) {
			System.out.println(f);
		}
		*/
		/*
		int w = 1;
		while(w <= 5) {
			System.out.println(w);
			w++;
		}
		*/
		/*
		int w= 1;
		do {
			System.out.println(w);
			w++;
		}while(w<=5);
		*/
		/*
		 * 응용문제 2. 해당 숫자를 역순으로 출력합니다.
		 * 10 ~ 1	(while문 사용)
		 * */
		int w = 10;
		while(w > 0) {
			//System.out.println(w);
			w--;
		}
		/*
		 * 응용문제 3. 구구단 9단 9*1 부터 9*9 까지 결과값 출력
		 * 단, do while 사용
		 * */
		/*
		int ww = 1;
		do {
			System.out.println(9*ww);
			ww++;
		}while(ww <10);
		*/
		
		/*
		 * 응용문제 4
		 * 100 ~ 150 까지 모든 수를 합한 결과 값 출력.!!!!
		 * while문 사용
		 * */
		/*
		int a = 100;
		int sum= 0;
		while(a <= 150) {
			sum+=a;
			a++;
		}
		System.out.println(sum);
		*/
		
		/*
		 * 응용문제 5
		 * 100 ~ 150 까지 모든 수를 곱한 결과 값 출력.!!!!
		 * for문 사용
		 * */
		int i = 1;
		double sum = 1;
		//100 101 102 103
		for(i=100; i<=150; i++) {
			sum *= i;
		}
		System.out.println(sum);
		
		byte b = 127;		// byte : -128 ~ 127
		System.out.println(b);
	}
}