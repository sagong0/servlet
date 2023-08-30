package javatest;

import java.util.*;

public class work6 {
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("회원 목록 : 홍길동,이순신,유관순,강감찬,장보고");
      String name = sc.nextLine().intern();

      box a = new box();
      //a.f_method(name);
      a.f_method(name);
   }
}
/*
 * 숙제.
 * 추상클래스 + 중첩클래스를 이용하여 프로세서를 제작합니다.
 * 추상 클래스에서는 father라는 이름을 가지고 있으며,
 * 메소드는 f_method라는 이름을 가집니다.
 * 또한 변수도 u_name 이라는 문자형 변수를 생성합니다.
 * f_mehtod 에 문자형으로 인자값을 하나 받는 형태로 제작합니다.
 * 
 * 메인에서 Scanner를 이용하여 사용자 이름을 입력하는 프로세서를 구성합니다.
 * 구성 후 외부 클래스로 f_method로 값을 전달함.
 * 
 * 전달된 값을 자식 클래스에 전달하며 해당 메소드에 다음과 같이 처리합니다.
 * 홍길동,이순신,유관순은 일반회원 입니다. 라고 출력을 하며,
 * 강감찬,장보고 는 실버회원 입니다. 라고 출력합니다.
 * 그 외에 사용자 이름을 입력시 "해당 사용자는 비회원 입니다." 라고 출력되도록 하시오.
 * */

abstract class father{
   abstract public void f_method(String name);
}

class box extends father{
   
   String name2 = "";
   
   @Override
   public void f_method(String name) {
	   this.name2 = name;
	   new box2().box2();
   }
   
   class box2{
      
      public box2() {
         String name = box.this.name2;
         
         
         if(name == "홍길동"|| name =="이순신" ||name =="유관순") {
            System.out.println("일반 회원");
         }
         else if(name == "강감찬"|| name =="장보고") {
            System.out.println("실버 회원");
         }
         else {
            System.out.println("해당 사용자는 비회원 입니다.");
         }
      }

	public void box2() {
		// TODO Auto-generated method stub
		
	}
   }
}