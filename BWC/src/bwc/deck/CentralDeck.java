package bwc.deck;

import java.util.ArrayList;
import java.util.List;

import bwc.cards.*;

public class CentralDeck {

	private List<Card> cards = new ArrayList<>();
	
	public void addCrad(Card card) {
		cards.add(card);
	}
	
	public int getPoints() {
		int points = 0;
		for (Card card : cards) {
			if (card instanceof PointCard) {
				points += ((PointCard) card).getValue();
			}
		}
		return points;
	}
	
	public int getMultiplier() {
		int multiplier = 0;
		for (Card card : cards) {
			if (card instanceof MultiplicativeCard) {
				multiplier *= ((MultiplicativeCard) card).getMultiplier();
			}
		}
		return multiplier;
	}

	public int getDivisor() {
		int divisor = 0;
		for (Card card : cards) {
			if (card instanceof DivisiveCard) {
				divisor *= ((DivisiveCard) card).getDivisor();
			}
		}
		return divisor;
	}
	
}
