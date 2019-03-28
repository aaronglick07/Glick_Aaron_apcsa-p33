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
		size = ranks.length*suits.length;
		cards = new Card[size];
		int index = 0;
		for(int i = 0; i<suits.length;i++) {
			for(int n = 0; n<ranks.length;n++) {
				cards[index] = new Card(ranks[n], suits[i], values[n]) ;
				
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
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** Implemented *** */
		cards = Shuffler.selectionShuffle(cards);
		size = cards.length;
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
		if(size==0) {
			return null;
		}
		size--;
		return cards[size];
		
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
