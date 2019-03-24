import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private Card[] cards;
	//List<Card> cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		/* *** Implemented *** */
		int index = 0;
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				cards[index] = new Card(ranks[j], suits[i], values[j]);
				index++;
			}
		}
		size = cards.length;
		shuffle();
		/*
		 cards = new ArrayListList<Cards>
		 for(int i = o; i < ranks.length, i++){
		 	for(String suitString : suits){
		 		cards.add new Card(ranks[i], suits[i], values[i]);
		 	}
		 }
		 size = cards.size
		 shuffle();
		 */
	}


	public Deck(List<Card> cards){
		this.cards = (Card[]) cards.toArray();
	}


	public Deck(Card[] cards) {
		// TODO Auto-generated constructor stub
		this.cards = cards;
	}





	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		/* *** Implemented *** */
		if(size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		/* *** Implemented *** */
		return cards.length;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** Implemented *** */
		Random rand = new Random();
		ArrayList<Card> temp = new ArrayList<Card>();
		temp.addAll(Arrays.asList(cards));
		ArrayList<Card> list = new ArrayList<>();
		for(Card c : temp){
			if(rand.nextBoolean()){
				list.add(c);
			}
			else if(rand.nextBoolean()){
				list.add(0,c);
			}
			else{
				list.add(list.size()/2,c);
			}
		}
		Card [] Shuffled = new Card[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Shuffled[i] = list.get(i);
		}
		cards = Shuffled;
		/* for(int i = cards.size() -1; i > 0; i--){
		 * 	int howMany = i + 1;
		 * 	int start = 0;
		 * 	int randPos = (int) (Math.random() * howMany) + start;
		 * 	card temp = cards.get(i);
		 * 	cards.set(i, cards.get(randPos));
		 * 	cards.set(randPos,temp);
		 * }
		 * size = cards.size();
		 */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		/* *** Implemented *** */
		if (cards.length > 1) {
			Card[] temp = new Card[cards.length-1];
			Card r = cards[0];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = cards[i+1];
			}
			return r;
		}
		return null;
		
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards[k];
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.length - 1; k >= size; k--) {
			rtn = rtn + cards[k];
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.length) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
