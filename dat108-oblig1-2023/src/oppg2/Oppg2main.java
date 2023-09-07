package oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2main {

	public static void main(String[] args) {
		List<Ansatt> ansatte = new ArrayList<>();
		ansatte.add(new Ansatt ("Thomas", "Eliassen", Kjonn.MANN, "Sjef", 123456));
		ansatte.add(new Ansatt ("Th", "Eli", Kjonn.MANN, "Den stillingen", 500));
		ansatte.add(new Ansatt ("Thom", "Elias", Kjonn.MANN, "Den stillingen", 10000));
		ansatte.add(new Ansatt ("T", "E", Kjonn.KVINNE, "Den stillingen", 50000));
		ansatte.add(new Ansatt ("PER", "BJARTE", Kjonn.MANN, "Den stillingen", 20000));
		
		
//		i. Et fast kronetillegg
		lonnsoppgjor(ansatte, ansatt -> ansatt.getAarslonn() + 100);
		
//		ii. Et fast prosenttillegg
		lonnsoppgjor(ansatte, ansatt -> (int) (ansatt.getAarslonn() * 1.05));
		
//		iii. Et fast kronetillegg hvis du har lav lønn
		lonnsoppgjor(ansatte, ansatt -> ansatt.getAarslonn() < 20000 ? +5000 : ansatt.getAarslonn());
		
//		iv. Et fast prosenttillegg hvis du er mann
		lonnsoppgjor(ansatte, ansatt -> ansatt.getKjonn() == Kjonn.MANN ? (int)(ansatt.getAarslonn() * 1.03) : ansatt.getAarslonn());
		
		skrivUtAlle(ansatte);
		
		

	}
//	public List<Integer> getAnsatte() {
//		       return ansatte;
//		   }
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function <Ansatt, Integer> rekn) {
		for (Ansatt ansatt : ansatte) {
            int nyLon= rekn.apply(ansatt);
            ansatt.setAarslonn(nyLon);
            }
	}
	
	public static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt ansatt : ansatte) {
            System.out.println(ansatt);
        }
	}
}
