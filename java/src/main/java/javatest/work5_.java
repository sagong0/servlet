package javatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.apache.catalina.tribes.util.Arrays;

/*
 * [숙제] 상속 형태의 클래스를 이용하여 다음문제에 맞는 결과값을 돌출하는 코드를 
 * 작성하시오.
 * [DB] = {55,1,6,8,10,22,96,33,31,45,48,60}
 * 
 * "해당 데이터를 1. 짝수, 2.홀수 를 선택하세요."
 * 
 * [결과]
 * 짝수값 : 1,6,8,10,22,96,48,60
 * 홀수값 : 55,1,33,31,45
 * 
 * 최종값에 대한 (오름차순 정렬)하여 최종출력 합니다. (sort)	// ex)(짝수) : 6,8,10,22,48,60,96
 * */
public class work5_ {

	public static void main(String[] args) {
		execute ex = new execute();
		ex.list();
	}

}

class db_list{
	Integer[] db = null;
	public void list() {
		this.db = new Integer[]{55,1,6,8,10,22,96,33,31,45,48,60};
	}
}

class execute extends db_list{
	
	Scanner sc = null;
	
	@Override
	public void list() {
		super.list();
		
		ArrayList<Integer> evenArr = new ArrayList<Integer>();
		ArrayList<Integer> oddArr = new ArrayList<Integer>();
		
		int w = 0;
		while(w < db.length) {
			if(db[w] % 2 ==0) {
				evenArr.add(db[w]);
			}
			else {
				oddArr.add(db[w]);
			}
			w++;
		}
		
		this.sc = new Scanner(System.in);
		
		System.out.println("해당 데이터를 1. 짝수, 2.홀수 를 선택하세요.");
		String a = this.sc.nextLine();
		if(Integer.valueOf(a) == 1) {
			Collections.sort(evenArr);
			System.out.println(evenArr);
		}
		else if(Integer.valueOf(a) == 2){
			Collections.sort(oddArr);
			System.out.println(oddArr);
		}
		else {
			System.out.println("1번 혹은 2번 선택 해주세요.");
			list();
		}
		this.sc.close();
	}
}
