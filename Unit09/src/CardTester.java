/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** Implemented *** */
		Card a,b,c;
		a = new Card("queen", "heart", 12);
		b= new Card("seven", "spades",7);
		c = new Card("2", "diamonds", 2);
		System.out.println(b);
		System.out.println(a.equals(a.rank() + " " + a.suit() + " " + a.pointValue()));
		System.out.println(c.matches(a));
		System.out.println(c.matches(c));
		
	}
}
