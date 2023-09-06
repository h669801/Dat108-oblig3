package oppg1;

import java.util.function.BiFunction;

public class Oppg1b {

	public static void main(String[] args) {
//		i. Summen av 12 og 13
		int summer = beregn(12,13, (x,y) -> x+y);
		System.out.println(summer);
		
//		ii. Den største av -5 og 3
		int største = beregn(-5,3, (x,y) -> Math.max(x,y));
		System.out.println(største);

		
//		ii. Avstanden (absoluttverdien av differansen) mellom 54 og 45
		int avstand = beregn(54,45, (x,y) -> Math.abs(x-y));
		System.out.println(avstand);
	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> o) {
		return o.apply(a, b);
		}

}
