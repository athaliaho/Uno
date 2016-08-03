
package uno;

import java.util.ArrayList;


public class Pile {

	private ArrayList<Card> pile = new ArrayList<Card>();

	
	public void addToPile(Card toAdd) {
		pile.add(toAdd);
	}

	public ArrayList<Card> getPile() {
		ArrayList<Card> toReturn = new ArrayList<Card>();

		for (Card c : pile) {
			toReturn.add(c);
		}

		return toReturn;
	}
}


