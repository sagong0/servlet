package javatest;

import java.util.Scanner;

public class java9 {

	public static void main(String[] args) {
		System.out.println("단어 입력 실시");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int ea = word.length();
		System.out.println(ea);
	}

}
