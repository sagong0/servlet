package javatest;
public class hw2 {

	public static void main(String[] args) {
		int product[][] = {
				{2000,3000,1500,2300,3200,1100,3300,4200,6100,4300},
				{2,1,1,2,3,2,1,1,2,3}
		};
		
		int w = 0;
		
		int price = 0;
		int ea = 0;
		int total = 0;
		
		while(w < product[0].length) {
			price = product[0][w];
			ea = product[1][w];
			total = price * ea;
			
			h_tt2 h2 = new h_tt2(total);
			Thread th = new Thread(h2);
			th.start();
			
			w++;
		}
	}
}

class h_tt2 implements Runnable{
	int result = 0;
	
	public h_tt2(int no) {
		this.result = no;
	}
	
	@Override
	public void run() {	
		System.out.println("상품금액은 : " +  this.result + " 입니다.");
	}
}
