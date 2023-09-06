package oppg1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppg1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
//		int a1 = Integer.parseInt(a);
//		int b1 = Integer.parseInt(b);
		Collections.sort(listen, (a,b) ->{ int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b); return Integer.compare(a1,b1);
		});
//		Collections.sort(listen, (a,b) ->Integer.compare(a,b));
		
		System.out.println(listen);

	}

}
