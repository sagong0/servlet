package array_test;

import java.util.Arrays;

// 2차 배열

public class array6 {

	public static void main(String[] args) {
		new array6().test6();
	}
	public void test6() {
		String member[][] = {
				{"박초롬","윤보미","정은지","김남주","오하영"},
				{"31","29","33","31","32"}
		};
		int ea = member.length;
		//System.out.println(ea);
		int data_ea = member[0].length;
		//System.out.println(data_ea);
		
		/*
		 * 응용문제 7  : 다음 코드를 활용하여 결과값을 예시처럼 출력 되도록 하시오.
		 * */
		
		int f,ff;
		for(f=0; f < data_ea; f++) {		//5
			for(ff=0; ff<ea; ff++) {		//2
				//System.out.println(member[ff][f]);
			}
		}
		
		/*
		 * 응용문제 8.
		 * 해당 데이터 배열에 있는 모든 값 중 짝수 값만 모두 더하여 결과값을
		 * 출력 하는 코드를 작성하시오.
		 * 1번 데이터 : 11 42 22 16
		 * 2번 데이터 : 7 33 10 29
		 * */
		
		
		
		int age [][] = {
				{11,42,22,16},
				{7,33,10,29}
		};
		int count = age.length;
		int sum = 0;
		// 내가푼거
		for(int i = 0; i< age.length; i++) {
			for(int j =0; j< age[i].length; j++) {
				if(age[i][j] % 2 == 0) {
					sum += age[i][j];
				}
			}
		}
		//System.out.println(sum);
		
		// 선생님 풀이 
		int totall = 0;		// 합산 결과 변수값
		
		for(int a[] :age) {	// 2차배열을 1차 배열로 따로따로 구성.
			for(int b : a) {	// 위에서 구성된 1차배열에 있는 데이터를 분리
				if(b % 2 ==0) {	// 짝수 조건
					totall += b;
				}
			}
		}
		System.out.println(totall);
	
		
		/*
		 * 숙제 : 해당 두개의 배열 데이터가 있습니다. 각 배열별로 인덱스가 같은 번호를
		 * 더하여 짝수, 홀수 인지를 배열 결과 데이터로 재설정하여 출력하시오.
		 * 
		 * Adata = 5 17 19 22 23
		 * Bdata = 1 2 3 4 5
		 * 
		 * 결과 예시) :
		 * 			["짝수","홀수","짝수","짝수","짝수"]
		 * */
	}
}
