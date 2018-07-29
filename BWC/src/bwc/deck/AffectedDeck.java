package bwc.deck;

import java.util.ArrayList;
import java.util.List;

import bwc.cards.Card;
import bwc.cards.DivisiveCard;
import bwc.cards.MultiplicativeCard;
import bwc.cards.PointCard;
import bwc.cards.TurnCard;

public class AffectedDeck {

	private List<Card> cards = new ArrayList<>();
	
	public void addCrad(Card card) {
		cards.add(card);
	}
	
	public int getPoints(CentralDeck centralDeck) {
		int points = 0;
		int multiplier = 1;
		int divisor = 1;
		for (Card card : cards) {
			if (card instanceof PointCard) {
				points += ((PointCard) card).getValue();
			}
			if (card instanceof MultiplicativeCard) {
				multiplier *= ((MultiplicativeCard) card).getMultiplier();
			}
			if (card instanceof DivisiveCard) {
				divisor *= ((DivisiveCard) card).getDivisor();
			}
		}
		points += centralDeck.getPoints();
		multiplier *= centralDeck.getMultiplier();
		divisor *= centralDeck.getDivisor();
		
		points = (points*multiplier)/divisor;
		
		return points;
	}
	
	public boolean loseTurn() {
		for (Card card : cards) {
			if (card instanceof TurnCard) {
				if (((TurnCard) card).addAffected()) {
					cards.remove(card);
				}
				return true;
			}
		}
		return false;
	}
	
}
