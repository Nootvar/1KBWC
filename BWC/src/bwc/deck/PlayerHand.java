package bwc.deck;

import java.util.ArrayList;
import java.util.List;

import bwc.cards.Card;

public class PlayerHand {

	private List<Card> cards = new ArrayList<>();
	
	public void addCrad(Card card) {
		cards.add(card);
	}
	
	public Card drawnCard(int cardIndex) {
		Card card = cards.get(cardIndex);
		cards.remove(cardIndex);
		return card;
	}
	
	public String getCardsList() {
		String list = "";
		for (int i = 0; i < cards.size(); i++) {
			list += i + ". " + cards.get(i).toString();
		}
		return list;
	}
	
}
