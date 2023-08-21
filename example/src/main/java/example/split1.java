package example;

import java.util.Arrays;

public class split1 {

	public static void main(String[] args) {
		String test = "어벤져스-홈커밍+1위+2500";
		String data[] = test.split("[+]");
		System.out.println(data[0]);
		
		System.out.println(Arrays.toString(data));
	}

}
