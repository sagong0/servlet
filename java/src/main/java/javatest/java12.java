package javatest;
// 상속에 관련된 문제사항 (extends = 1개의 클래스에서 사용),
// 단, 상속 받은 클래스에서 다시 상속을 사용하면 여러개의 extends를 사용할 수 있음.

public class java12 {

	public static void main(String[] args) {
		box5 b = new box5();
		b.aa();
		b.bb();
	}
}

class login_ex{	//부모 클래스
	public void aa() {
		System.out.println("login method");
	}
}

class logout_ex extends login_ex{	//부모 클래스 상속 받은 자식 클래스
	@Override
	public void aa() {
		super.aa();
	}
	public void bb() {
		System.out.println("logOut method");
	}
}
class box5 extends logout_ex{	// 두개의 부모 클래스를 상속 받아서 처리.
	@Override
	public void aa() {
		super.aa();
	}
	@Override
	public void bb() {
		super.bb();
	}
}