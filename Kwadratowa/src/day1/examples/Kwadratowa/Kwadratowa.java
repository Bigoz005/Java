package day1.examples.Kwadratowa;

public class Kwadratowa {
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Za ma³o parametrów");
			return;
		}
		try {
			double a, b, c, delta;
			a = Double.parseDouble(args[0]);
			b = Double.parseDouble(args[1]);
			c = Double.parseDouble(args[2]);

			System.out.println("a: " + a + "\n" + "b: " + b + "\n" + "c: " + c);

			if (a != 0) // kwadratowa
			{
				double x1, x2;
				delta = b * b - 4 * a * c;
				System.out.println("delta=" + delta);

				if (delta > 0) // +delta -b+pier.delta/2a -b-pier.delta/2a
				{
					x1 = (Math.sqrt(delta) - b) / 2 * a;
					x2 = (-Math.sqrt(delta) - b) / 2 * a;
					System.out
							.println("F.kwadratowa z dodatnia delta, z dwoma pierwiastkami: x1=" + x1 + " i x2=" + x2);
				} else if (delta == 0) { // delta=0 -b/2a
					x1 = (-b) / 2 * a;
					System.out.println("F.kwadratowa z podwojnym pierwiastkiem: x=" + x1);
				} else {
					System.out.println("F.kwadratowa nie posiada pierwiastków");
				}
			} else { // liniowa
				double x;
				x = (-c) / b;
				System.out.println("F.liniowa: x=" + x);
			}
		} catch (NumberFormatException e) {
			System.out.println("Zly format liczby: " + e.getLocalizedMessage());
		}
	}
}
