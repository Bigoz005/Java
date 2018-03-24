package day1.examples.Kwadratowa;

public class Kwadratowa {
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Za malo parametrów");
			return;
		}
		try {
			Integer a, b, c;
			double delta;
			a = Integer.valueOf(args[0]);
			b = Integer.valueOf(args[1]);
			c = Integer.valueOf(args[2]);
			/*double a, b, c, delta;
			a = Double.parseDouble(args[0]);
			b = Double.parseDouble(args[1]);
			c = Double.parseDouble(args[2]);
			 */
			System.out.println("a: " + a + "\n" + "b: " + b + "\n" + "c: " + c);

			if (a != 0) // kwadratowa
			{
				delta = b * b - 4 * a * c;
				System.out.println("delta= " + delta);

				if (delta > 0) // +delta -b+pier.delta/2a -b-pier.delta/2a
				{
					double x1, x2;
					x1 = (Math.sqrt(delta) - b) / 2 * a;
					x2 = (-Math.sqrt(delta) - b) / 2 * a;
					System.out.println("F.kwadratowa z dodatnia delta, z dwoma pierwiastkami:\nx1= " + x1 + "\nx2= " + x2);
				} else if (delta == 0) {// delta=0 -b/2a
					double x;
					x = (-b) / 2 * a;
					System.out.println("F.kwadratowa z podwojnym pierwiastkiem:\nx=" + x);
				} else {
					double x_r, x_i;
					delta=-delta;
					x_r=-b/2*a;
					x_i=Math.sqrt(delta)/2*a;
					System.out.println("F.kwadratowa posiada dwa pierwiastki zespolone:\nx1= " + x_r + "+" + x_i + "i" + "\nx2= " + x_r + "-" + x_i + "i");
				}
			} else { // liniowa
				double x;
				x = (-c) / b;
				System.out.println("F.liniowa: x=" + x);
			}
		} catch (NumberFormatException error) {
			System.out.println("Zly format liczby: " + error.getLocalizedMessage());
		}
	}
}
