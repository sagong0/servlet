package array_test;

// 원시배열 + 조건문 + 반복분 
public class array2 {

	public static void main(String[] args) {
		array2 ar = new array2();
		ar.test();
		
		//new array2().test();
	}

	public void test() {
		String id[] = {"hong","kim","park","lee","jang","so"};
		// 힌트
		int word = id[0].length();
		System.out.println(word);
		/**
		 * 응용문제 1) 
		 * 해당 사용자 아이디 배열값 중 아이디가 3자리 이하의 사용자만 출력하시요.
		 **/
		for(int i = 0; i< id.length; i++) {
				if(id[i].length() <=3) {
					System.out.println(id[i]);
				}
			}
		
		int w = 0;
		do {
			
			if(id[w].length() <= 3) {
				System.out.println(id[w]);
			}
			w++;
		}while(w < id.length);
		
		
		/*
		 * 응용문제 2
		 * 데이터 : 15 60 11 14 27 의 총 5개의 숫자가 있으며
		 * 해당 데이터의 모든 합한 결과값을 출력시키세요.*/
		int num[] = {15,60,11,14,27};
		int sum = 0;
		
		for(int i = 0; i<num.length; i++) {
			sum += num[i];
			System.out.println(sum);
		}
		
		
		/*
		 * 응용문제 3 
		 * 다음 숫자 데이터 리스트 중 짝수의 값만 모두 더한 최종 결과값을 출력하시요.
		 * 숫자데이터 : 5 10 15 20 25 30 35
		 * */
		
		int num2[] = {5,10,15,20,25,30,35};
		int sum2 = 0;
		for (int i = 0; i< num2.length; i++) {
			if(num2[i] % 2 == 0) {
				sum2 += num2[i];
			}
		}
			System.out.println(sum2);
		
	}
}
