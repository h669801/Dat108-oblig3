package oppg3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import oppg2.Ansatt;
import oppg2.Kjonn;
import oppg2.Oppg2main;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = new ArrayList<>();
		ansatte.add(new Ansatt ("Thomas", "Eliassen", Kjonn.MANN, "Sjef", 123456));
		ansatte.add(new Ansatt ("Th", "Eli", Kjonn.MANN, "Den stillingen", 500));
		ansatte.add(new Ansatt ("Thom", "Elias", Kjonn.MANN, "Den stillingen", 10000));
		ansatte.add(new Ansatt ("T", "E", Kjonn.KVINNE, "Den stillingen", 50000));
		ansatte.add(new Ansatt ("PER", "BJARTE", Kjonn.MANN, "Den stillingen", 20000));

		
		
//		a) Lag en ny liste som kun inneholder etternavnene til de ansatte.
//		ansatte.stream().collect()
//		Stream<String> s5 = Arrays.stream(ansatte);
		
//		List<List<Ansatt>> a = Stream.of(ansatte)
//				.toList();
//		System.out.println(a);
		
		List<String> etternavn = ansatte.stream()
                .map(Ansatt::getEtternavn)
                .toList();
		System.out.println(etternavn);
		
		
//		b) Finn ut antall kvinner blant de ansatte.
		double kvinner = ansatte.stream()
				.filter(ansatt -> ansatt.getKjonn() == Kjonn.KVINNE)
				.count();
		System.out.println(kvinner);
		
		
//		c) Regn ut gjennomsnittslønnen til kvinnene.
		double gjennomsnittsLonn = ansatte.stream()
				.filter(ansatt -> ansatt.getKjonn() == Kjonn.KVINNE)
				.mapToDouble(Ansatt::getAarslonn)
				.average()
				.orElse(0.0);
		System.out.println(gjennomsnittsLonn);
		
		
//		d) Gi alle sjefer (stilling inneholder noe med "sjef") en lønnsøkning på 7% ved å bruke	 
//		streams direkte i stedet for metoden du laget i Oppg2. Skriv ut listen av ansatte etter lønnsøkningen.
		ansatte.stream()
				.filter(ansatt -> ansatt.getStilling().contains("Sjef"))
				.forEach(ansatt -> {int LonnsEndring = (int) ( ansatt.getAarslonn() * 1.07); ansatt.setAarslonn(LonnsEndring);});
				Oppg2main.skrivUtAlle(ansatte);
//				}
//		System.out.println(nyListe);
		
//		e) Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
				Boolean hogLonn = ansatte.stream()
						.anyMatch(ansatt -> ansatt.getAarslonn() > 800000);
				System.out.println(hogLonn);
		
		
//		f) Skriv ut alle de ansatte med System.out.println() uten å bruke løkke.
		ansatte.forEach(System.out::println);
		
		
//		g) Finn den/de ansatte som har lavest lønn.
//		List<String> lavestLonn = ansatte.stream()
				
		
		
//		h) Finn ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5.
		int sum = IntStream.range(1, 1000)
		.filter(a -> a % 3 == 0 || a % 5 == 0)
		.sum();
		System.out.println("summen: "  + sum);
		
	}

}
