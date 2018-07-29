package bwc.deck;

import bwc.cards.Card;
import bwc.cards.PointCard;

public class Deck {

	private Card[] cards;
	private int remainingCards;
	
	public Deck() {
		cards = new Card[100];
		cards[0] = new PointCard("Jambon", "C'est bon le jambon +100 points", 100);
		remainingCards = 1;
	}
	
	public Card drawCard() {
		int rand;
		Card card = null;
		do {
			rand = (int)(Math.random() * (1L + cards.length));
			if (cards[rand] != null) {
				card = cards[rand];
				cards[rand] = null;
			}
		} while (card == null);
		remainingCards --;
		return card;
	}

	public boolean isEmpty() {
		return remainingCards == 0;
	}
}
