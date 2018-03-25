package losowanie;

import java.util.*;

public class losowanie {
	static int MAX_RAND = 100;

	public static void main(String[] args) {
		try {
			Random rand = new Random();
			int r = rand.nextInt(MAX_RAND + 1); // od 1 do 100
			// System.out.println(r);
			int p = 0;
			Scanner in = new Scanner(System.in);
			for (;;) {
				System.out.print("Podaj liczbê: ");
				++p; // zwiekszenie wartosci przed wykonaniem operacji, zeby nie byloproby nr.0
				int i = in.nextInt();
				if (i == r) {
					System.out.println("Poprawna odpowiedŸ. Liczba prób=" + p);
					p = 0;
					String c;
					r = rand.nextInt(MAX_RAND + 1);
					// System.out.println(r);
					do {
						System.out.println("Chcesz graæ dalej? [T/N] ");
						c = in.next();
						if (c.equalsIgnoreCase("N"))
							return;
					} while (!c.equalsIgnoreCase("T"));
				} else if (i < r)
					System.out.println("Za ma³o.");
				else
					System.out.println("Za du¿o.");
			}
		} catch (InputMismatchException error) {
			System.out.println("Zły format liczby. Error");
		}
	}
}
