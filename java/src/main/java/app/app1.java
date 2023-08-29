package app;

// javatest package java9 와 연계. 

// 외부 패키지에서 외부 클래스까지 적용할려면 public class에서 상속 받은 후 
// 해당 public class 를 호출하면 외부 클래스까지 로드하여 실행시킬수 있음
public class app1  extends app1_box{
	
	public static void main(String[] args) {
		app1 ap = new app1();
		ap.abc();
		System.out.println("외부 패키지 class 입니다.");
	}
	
	@Override
	public void abc() {
		super.abc();
	}
}

class app1_box{		// package가 다른 외부 class는 직접적으로 호출하여 사용하지못함.
	public void abc() {
		System.out.println("외부 class 중 abc 메소드");
	}
}