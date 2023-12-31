package array_test;

import java.util.*;

// 원시배열 형태 (checkbox, radio button => 원시배열?)
public class array1 {

	public static void main(String[] args) {
		// String, int, Object, byte
		// 깂없을떼 => 숫자 : 0, 문자 : null
		// Arrays.toString : 모든 원시 배열에 리스트를 모두 표시하는 클래스이며
		// 단, 라이브러리를 java.util 해당 부분이 아닌 apach, spring...
		// 다른 부분일 경우 버그는 숫자형태의 배열은 출력이 안되는 현상이 발생함. 
		int[] a = new int[5];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		int ea = a.length;
		System.out.println(ea);
		System.out.println(Arrays.toString(a));
		int f;
		for(f=0; f<ea; f++) {
			System.out.println(a[f]);
		}
		
		String b[] = new String[3];
		b[0] = "염무원";
		b[1] = "이순신";
		int ea2 = b.length;
		System.out.println(ea2);
		System.out.println(Arrays.toString(b));
		
		// Object : 문자 + 숫자를 적용할 수 있는 원시배열 데이터 자료형
		/* 단점 : 데이터 입력 쉬움, 활용시 자료형을 무조건 한번은 변환해서 사용해야함. */
		Object c[] = new Object[3];
		c[0] = "hong";
		c[1] = 25;
		int ea3 = c.length;
		System.out.println(ea3);
		System.out.println(Arrays.toString(c));
		
		// 자료형으로 만듬
		int[] d = {1,2,3,4,5};		//null, 0의 값을 적용하지 않고 규격에 맞게 데이터를 입력하는 형태.
		int ea4 = d.length;
		System.out.println(ea4);
		System.out.println(Arrays.toString(d));
		System.out.println("-----------------------------d end-----------------------");
		
		// 클래스 형태로 만든것
		Integer e[] = {10,20,30,40};
		int ea5 = e.length;
		System.out.println(ea5);
		System.out.println(Arrays.toString(e));
		
	}
}
