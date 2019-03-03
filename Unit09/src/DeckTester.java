/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		Card a,b,c;
		a = new Card("queen", "heart", 12);
		b= new Card("seven", "spades",7);
		c = new Card("2", "diamonds", 2);
		Deck deck = new Deck(new Card[]{a,b,c});
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.deal());
		System.out.println(deck);
		
		
		
	}
}
