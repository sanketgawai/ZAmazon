package temp;

public class TempTest {

	public static void main(String[] args) {
		
		String text = "Parker Frontier Fountain Pen | Matte Black Body with Gold Trim |... was removed from Shopping Cart.";
		
		String newtxt = text.substring(text.indexOf("was")).trim();
		System.out.println(newtxt);
		
	}
}
