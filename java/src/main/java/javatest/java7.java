package javatest;
// double loop
public class java7 {

	public static void main(String[] args) {
		new data4().abc();
	}

}

class data4{
	public void abc() {
		// for + for
		/*
		int f,j;
		int total;
		
		for(f=1; f<=5; f++) {
			for(j=1; j<=9; j++) {
				total = f + j;
				System.out.println(total);
			}
		}
		*/
		
		/*
		int w = 1;
		int total = 0;
		
		while(w<=5) {			
			int ww = 1;	// 초기화 실행 필요 (while, do while문 모두 동일)
			while(ww <=5) {
				total = w+ww;
				System.out.println(total);
				ww++;
			}
			w++;
		}
		*/
		/*
		int z = 1;
		int total;
		do {
			int zz = 1;	// 초기화
			
			do {
				total = z + zz;
				System.out.println(total);
				zz++;
			}while(zz<=5);
			
			z++;
		}while(z<=5);
		*
		*/
		
		/* for + while 
		 * 1+1=2
		 * 1+2=3 
		 * 1+3=4
		 * 2+1=3
		 * 2+1=4
		 * 2+3=5
		 * 3+1=4
		 * 3+2=5
		 * 3+3=6 
		 * */
		int i;
		for(i=1; i<=3; i++) {
			int j = 1;
			while(j <=3) {
				System.out.println(i + "+" +j + "=" + (i+j));
				j++;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}