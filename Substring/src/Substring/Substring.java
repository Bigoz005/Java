public class Substring {

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Za ma³o argumentów.");
			return;
		}
		try {
			int i = Integer.parseInt(args[1]);
			int j = Integer.parseInt(args[2]);
			System.out.println(args[0].substring(i, j + 1));
		} catch (NumberFormatException error) {
			System.out.println("Z³y format liczby: " + error.getLocalizedMessage());
		} catch (StringIndexOutOfBoundsException error) {
			System.out.println("Nieprawid³owe indeksy: " + error.getLocalizedMessage());
		}
	}
}
