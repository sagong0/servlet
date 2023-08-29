package javatest;

import app.app1;		// 패키지명.public class명
//import : 가져오는 기능, export : 내보내는 기능.

/*
 * 1. 패키지가 다를 경우 public class 핸들링
 * 
 * */

public class java9 {
	// package app (app1.java) 연계 프로세서.
	public static void main(String[] args) {
		// 다른 패키지에 있는 public calss만 호출 하여 가져올 수 있음.
		app1 ap = new app1();
		ap.main(args);
		
		// 추상 클래스를 상속 받아서 처리하는 클래스를 배열화 하여 순차적으로 작동 시키는 형태
		ddd[] d = {new abox(), new bbox(), new cbox()};	
		
		/*
		for(ddd z : d) {
			System.out.println(z);
			z.dataload();
		}
		*/
		
		/* 반복문으로 배열에 있는 class를 순차적으로 실행 시키는 상황 */
		int w = 0;
		while(w <d.length) {
			if(w != 1) {	// 해당 class 외에 다른 class만 실행 하도록 핸들링.
				d[w].dataload();				
			}
			w++;
		}
		
	}
}


// abstract : 추상 클래스 + 추상 메소드. (프레임워크에 활용.)
/*
 * public class가 없을 경우 abstract에서도 public으로 핸들링 할 수 있으며,
 * 단, public class가 있을 경우 default로 abstract를 이용합니다.
 * 
 * default(해당 파일에서 활용하는 변수선언) ,public(공개), private(같은 class에서만), protected(반공개 - 패키지가 같으면 바꿀수있음) : 접근에 해당됨.
 * */
abstract class ddd{
	public String userid = "guest";	// 공용으로 사용하는 변수. (this를 모두 활용가능)
	public String useremail = null;
	public int userpoint = 0;
	public int a,b,c,d;
	public abstract void dataload();
}

class abox extends ddd{
	
	@Override
	public void dataload() {
		this.userpoint = 2500;
		System.out.println(this.userpoint);
		System.out.println("abox Class");
	}
}
class bbox extends ddd{
	@Override
	public void dataload() {
		System.out.println("bbox Class");
	}
}

class cbox extends ddd{
	@Override
	public void dataload() {
		System.out.println("cbox class");
	}
}






