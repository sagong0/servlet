package javatest;

// Thread 란 ? CPU가 이해할수 있는 공간. (메인 Class는 안함)
/*
 * extends => 상속 (Thread)
 * interface => Runnable
 * */
// Thread 란, 1개의 cpu 공간
// MultiThread : 개발자가 1개 이상의 cpu 공간을 활용하는 사항.

public class java18 {
	public static void main(String[] args) {
		int a = 10;
		int w = 0;
		th1 t = new th1();
		th2 t2 = new th2(w);
		
		while(w <= a) {
			//System.out.println(w);
			
			int aa = t.start(w);
			//System.out.println(aa);
			t2 = new th2(w);	// 새로운 10갸의 작업 실행.			
			//t2.start();	// start 는 Thread 중에서 run 메소드를 실행시킴.
			w++;
		}
		
		th3 t3 = null;
		Thread thread = null;
		
		for(int aa = 0; aa<11; aa++) {
			t3 = new th3(aa);
			thread = new Thread(t3);
			thread.start();
		}	
	}
}

class th1{	// 일반 클래스
	int start(int a) {	// return 메소드
		return a;
	}
}

class th2 extends Thread{	// Thread Class 상속
	int b = 0;
	public th2(int a) {	// class 호출시 작동하는 메소드.
		this.b = a;
	}
	
	@Override
	public void run() {	// Thread에서 제공되는 메소드. (실행 메소드)
		super.run();
		System.out.println(this.b);
	}
	
	int run(int a) {
		return a;
	}
}

class th3 implements Runnable{
	
	public int c = 0;
	public th3(int z) {
		this.c = z;
	}
	@Override
	public void run() {
		System.out.println(this.c);
	}
}

