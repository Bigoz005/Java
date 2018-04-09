import java.util.*;
import java.util.Map.Entry;

public class zad6 {

	public static void main(String[] args) {
		//Utworz kilka obiektow klasy Osoba i kilka obiektow klasy Firma i umiesc je w kontenerze TreeMap, poslugujac sie jako kluczem numerem telefonicznym.
			TreeMap<NrTelefoniczny, Wpis> phoneBook = new TreeMap<NrTelefoniczny, Wpis>();

			Osoba wpis1 = new Osoba("Jan", "Kowalski", "Warszawa");
			wpis1.nr_tel = new NrTelefoniczny(48,841883931);
			phoneBook.put(wpis1.nr_tel, wpis1);

			Osoba wpis2 = new Osoba("Johnny", "English", "London");
			wpis2.nr_tel = new NrTelefoniczny(44, 5237997);
			phoneBook.put(wpis2.nr_tel, wpis2);

			Firma wpis3 = new Firma("Serwis Rtv Agd", "¯ywiec");
			wpis3.nr_tel = new NrTelefoniczny(48, 535451974);
			phoneBook.put(wpis3.nr_tel, wpis3);

			Firma wpis4 = new Firma("Olsztyñskie Centrum Kszta³cenia", "Olsztyn");
			wpis4.nr_tel = new NrTelefoniczny( 48, 468213151);
			phoneBook.put(wpis4.nr_tel, wpis4);

			Set<Entry<NrTelefoniczny, Wpis>> set = phoneBook.entrySet();
			Iterator<Entry<NrTelefoniczny, Wpis>> iterator = set.iterator();
	        while(iterator.hasNext()) {
	           Entry<NrTelefoniczny, Wpis> item = iterator.next();
	           System.out.println("\n" + item.getKey().printNumber());
	          System.out.println(item.getValue().opis());
	        }
	}
}

//Klasa Wpis ma abstrakcyjna metode opis, ktora opisuje dany wpis.
 abstract class Wpis {
	public NrTelefoniczny nr_tel;
	public abstract String opis();
}

//Klasa Osoba ma zawierac informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu). Dziedziczenie z Wpis
 class Osoba extends Wpis {
	String imie;
	String nazwisko;
	String adres;	
	
	public Osoba(String imie, String nazwisko, String adres){
	        this.imie = imie;
	        this.nazwisko = nazwisko;
	        this.adres = adres;
	};
	public String opis() {
		return String.format("%s", "Osoba: " + imie + " " + nazwisko + "\tAdres: " + adres);
	}
}

 //Napisz klase NrTelefoniczny, posiadajaca 2 pola: nrkierunkowy i nrTelefonu i implementujaca interfejs Comparable.
 class NrTelefoniczny implements Comparable<NrTelefoniczny> {
	int nrKierunkowy;
	int nrTelefonu;
	public NrTelefoniczny(int nrKierunkowy, int nrTelefonu) {
		this.nrKierunkowy = nrKierunkowy;
		this.nrTelefonu = nrTelefonu;
	}
	public String printNumber() {
	    return String.format("%s", "Numer: +" + nrKierunkowy + " " + nrTelefonu);
	}
	public int compareTo(NrTelefoniczny other) {
		return Integer.compare(this.nrTelefonu, other.nrTelefonu);
	}
}
 
 //Klasa Firma ma miec nazwe i adres( w tym NrTelefonu). Dziedziczenie z Wpis
 class Firma extends Wpis {
	String nazwa;
	String adres ;
	public Firma(String nazwa, String adres){
	        this.nazwa = nazwa;
			this.adres = adres;
	}
	public String opis() {
		return String.format("%s", "Nazwa firmy: " + nazwa + "\tAdres: " + adres);
	}
}
