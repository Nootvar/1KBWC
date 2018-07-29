package bwc.player;

import bwc.cards.Card;
import bwc.deck.AffectedDeck;
import bwc.deck.CentralDeck;
import bwc.deck.PlayerHand;

public class Player {

	private String name;
	private PlayerHand hand;
	private AffectedDeck affected;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoints(CentralDeck centralDeck) {
		return affected.getPoints(centralDeck);
	}
	
	@Override
	public String toString() {
		return String.format("%s - Points : %d", name);
	}

	public String getHand() {
		return hand.getCardsList();
	}
	
	public Card drawCard(int cardIndex) {
		return hand.drawnCard(cardIndex);
	}
	
	public void giveCard(Card card) {
		affected.addCrad(card);
	}
	
}
