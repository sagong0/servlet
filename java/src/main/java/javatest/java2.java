package javatest;

// this : 외부 class에서 사용가능.
class abc{
	String data = "";	// 일반 변수선언
	static String data2="";	// 메모리에 변수값을 생성시켜 놓음.
	int number = 3;
	int aa,bb,cc = 0;	//기본값 적용.
	final String adata = "이순신";	// 상수 : 값 변경이 불가능함.
	
	public abc() {	// 즉시 실행 메소드.
		this.data = "20";
		this.data2= "30";
		System.out.println(this.data);	
	}
	
	public void data() {	// 일반 메소드
		String user = "홍길동";
		System.out.println(user);
		System.out.println(this.aa);
		System.out.println(this.bb);
		System.out.println(this.cc);
	}
	public static void data2() {	// 메모리 등록 메소드
		String user2 = "이순신";
		System.out.println(user2);
	}
	
	String data3(int a,int b) {	// return 메소드.
		int sum = a+b;
		this.data2 = String.valueOf(sum);	// 숫자를 문자로 변환
		
		return this.data2;
	}
	public int data4(String a, String b) {
		int sum = Integer.parseInt(a) + Integer.valueOf(b);
		
		return sum;
	}
}
