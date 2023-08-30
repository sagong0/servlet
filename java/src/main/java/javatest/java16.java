package javatest;

// Interface 활용
// Interface 일반 메소드를 활용 할 수 있음.
public class java16 {
	
	public static void main(String[] args) {
		new box6().aa1();
		new box6().a1();
		new box6().b1();
	}
}

// extends => abstract, 외부 클래스를 로드할 때 사용.
// interface => implements  (무조건 Override 활용해야함.)
class box6 implements inter1,inter2{
	
	@Override
	public void a1() {
		System.out.println("문자열을 입력하세요");
		String text = this.sc.nextLine();
		System.out.println(text);
		System.out.println(this.level);
		System.out.println(this.name);	// inter1.java 에 있는 전역변수 값 호출
	}
	
	@Override
	public void aa1() {
		inter1.super.aa1();
		/*
		 * interface안에 외부클래스를 객체 및 인스턴스 생성 후 해당 머소드 호출
		 * */
		inter1.zzz h = new inter1.zzz();
		h.zzjj();
	}
	
	@Override
	public void b1() {	
		System.out.println(this.name);	// inter1.java 에 있는 전역변수 값 호출
	}
	@Override
	public String b2() {
		return null;
	}
}