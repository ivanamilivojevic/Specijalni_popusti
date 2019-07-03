package domaci;

import java.util.Scanner;

public class SpecijalniPopusti {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodo�li u Bra�ko++ pametnu kasu!");
		System.out.print("Koji je danas dan (Pon/Uto/Sre/�et/Pet/Sub/Ned): ");
		String dan = sc.next().toLowerCase();
		while(!dan.equals("pon") && !dan.equals("uto") && !dan.equals("sre") && !dan.equals("�et") && !dan.equals("pet") && !dan.equals("sub") && !dan.equals("ned")) {
			System.err.print("Gre�ka u unosu. Poku�ajte ponovo: ");
			dan = sc.next().toLowerCase();
		}
                double dnevna_id = 0;
		String dnevna_naziv = "";
		double dnevna_procenat = 0;
		
		switch (dan) {
			case "Uto": dnevna_id = 5; dnevna_naziv = "Vesuvio"; dnevna_procenat = 0.1; break;
			case "�et": dnevna_id = 2; dnevna_naziv = "Capricciosa"; dnevna_procenat = 0.1; break;
			case "Sub": //koristimo mo� case-a da propada da razresimo oba uslova jednim kodom
			case "Ned": dnevna_id = 2*3*5; dnevna_naziv = "SVE";  dnevna_procenat = 0.15; break; 
		}
		
		int ukupno_pizza = 1;
		int id_musterije = 1;
		
		System.out.print("\nMu�terija id#" + id_musterije + ": ");
		int broj_narucenih = sc.nextInt();
		while(broj_narucenih != -1) {			
			double akcija_dnevna = 0;
			double ukupna_cena = 0;
			System.out.println("-- Ra�un za mu�teriju id#" + id_musterije + " ---");
			for(int i=1; i<= broj_narucenih; i++) {
				int id = sc.nextInt();
				
				int cena = 0;
				String naziv;
				
				switch(id) {
					case 2: cena=320; naziv="Cappricciosa"; break;
					case 3: cena=290; naziv="Pepperoni"; break;
					case 5: cena=310; naziv="Vesuvio"; break;
					default:
						System.err.print("Uneli ste neispravan id. Poku�ajte ponovo: ");
						continue; 
				String prefix = "Pizza"; 
				
				if(i % 4 == 0) {
					cena = 0;
					prefix = "AKCIJA 3+1";
				}else if(ukupno_pizza % 7 == 0) {
					cena = 0;
					prefix = "AKCIJA #7";
				}

				ukupna_cena += cena;
			
				System.out.printf("%s %s \t%d \n", prefix, naziv, cena);
				
				
				if(dnevna_id % id == 0) { 
					akcija_dnevna += dnevna_procenat * cena;
				}
				
				ukupno_pizza++;
			}
			System.out.printf("\t\t\t ukupno: %.1f \n", ukupna_cena);
			System.out.println("------------------------------");
			if(akcija_dnevna > 0) {
				System.out.printf("DNEVNA 10%% %s \t %.1f \n", dnevna_naziv, -akcija_dnevna);
				System.out.printf("\t\t\t ukupno: %.1f \n", ukupna_cena - akcija_dnevna);
			}
			System.out.println("------------------------------");
			id_musterije++;
			System.out.print("Mu�terija id#" + id_musterije + ":");
			broj_narucenih = sc.nextInt();
		}
	}

}

