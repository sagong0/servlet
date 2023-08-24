package javatest;

class java5{	// 외부 클래스
	public void java5_1() {
		
	}
}

public class java4 {
	int a,b = 0;
	
	public void java1() {
		this.a = 20;
		this.b = 30;
		java2();	// 같은 클래스에서 해당 메소드로 실행.
	}
	
	public void java2() {
		int sum = this.a+this.b;
		
		System.out.println(sum);
	}
}
