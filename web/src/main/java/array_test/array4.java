package array_test;

import java.util.Arrays;

// 1차배열 중 필요한 데이터만 추출하여 신규 배열로 커스텀
public class array4 {

	public static void main(String[] args) {
		new array4().test2();
	}

	public void test2() {
		int a[] = new int[5];		//5개의 빈배열 선언
		int b[] = {1,2,3,4,5,6,7}; // 실제 데이터가 있는 배열
		int w = 0;
		int array = 0;		// 배열 인덱스를 지정하기 위한 변수
		
		while(w < b.length ) {			//&& array < a.length
			if(b[w] % 2 ==0) {	// 짝수 조건
				a[array] = b[w];	// 해당 조건이 맞을 경우 빈배열 0부터 순차적으로 값을 이관.
				array++;	// 빈배열 순차적으로 +1씩 증가.
			}
			w++;
		}
		System.out.println(Arrays.toString(a));
		/*
		 * 응용문제6
		 * 다음 데이터 값 중 아이디가 4글자 이상 아이디만 추출하여
		 * 새로운 데이터 배열로 출력하시오.
		 * hong,kim,park,jang,sun,so,han,jung
		 * */
		String name[] = {"hong","kim","park","jang","sun","so","han","jung"};
		// 빈배열 생성
		String newName[] = new String [4];
		int a1 =0;
		int array1= 0;
		while(a1 < name.length) {
			if(name[a1].length() >= 4) {
				newName[array1] = name[a1];
				array1++;
			}
			a1++;
		}
		System.out.println(Arrays.toString(newName));
		
		int ct = 0;
		for(String m : newName) {
			if(m.length() >=4) {		// 배열 값중 단어가 4자리 이상 조건
				newName[ct] =m;			// 신규 빈배열 값을 이관하는 작업.
				ct++;
			}
		}
		System.out.println(Arrays.toString(newName));
	}
	
}
