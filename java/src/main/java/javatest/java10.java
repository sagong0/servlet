package javatest;
// 즉시실행 메소드 + 일반 메소드 부분

/*
 * 인자값에 대한 자료형 또는 인자값 갯수에 따라 여러개의 같은 이름을 가진
 * 즉시 실행 메소드와 일반메소드를 생성 시킬 수 있음.
 * */
import java.util.*;

public class java10 {
	

	public static void main(String[] args) {
		box1 b = new box1();
		//box1 b2 = new box1("홍길동");
		//box1 b3 = new box1(30);
		b.box1();
		//b.box1("채찍 좋아하는 사라");
		//b.box1();
		
		/*
		// 질문사항 배열로 돌려버림
		String q[] = {"고객명을 입력하세요?","아이디를 입력하세요?","패스워드를 입력하세요?"};
		Scanner sc = new Scanner(System.in);
		String a[] = new String[q.length];
		
		int w  = 0;
		while(w< q.length) {
			System.out.println(q[w]);
			a[w] = sc.nextLine();
			w++;
		}
		System.out.println(Arrays.toString(a));
		*/
	}
}
class box1{
	Scanner sc = null;
	public box1() {	// 즉시실행 메소드 와	(Constructor)
		this.sc = new Scanner(System.in);
		System.out.println("즉시 실행 메소드 1");
	}
	public box1(String a) {				//(인자값이 있는 Constructor)
		System.out.println("즉시 실행 메소드 2");
	}
	public box1(int a) {
		System.out.println("즉시 실행 메소드 2");
	}
	
	public box1(String a, String c) {
		System.out.println("즉시 실행 메소드 2");
		String result = this.sc.nextLine();
	}
	
	public void box1() {	// 일반 메소드 구조가 다름. 
		System.out.println("일반실행 메소드 1");
	}
	
	public void box1(String a) {	// 일반 메소드 구조가 다름. 
		System.out.println("일반실행 메소드 2");
	}
	
	String box2() {
		return null;
	}
	String box2(String a) {
		return null;
	}
}
