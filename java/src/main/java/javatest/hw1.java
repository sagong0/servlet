package javatest;
public class hw1 {

	public static void main(String[] args) {
		int w = 1;
		while(w < 10) {
			h_tt ht1 = new h_tt(w);
			ht1.start();
			w++;
		}
	}
}


class h_tt extends Thread{
	
	int a = 0;
	int d = 7;
	
	public h_tt(int no1) {
		this.a = no1;
	}
	
	@Override
	public void run() {
		System.out.println(d +"*"+a +"=" + d*a);
	}
}
