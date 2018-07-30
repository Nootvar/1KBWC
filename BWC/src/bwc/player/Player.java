package bwc.player;

import bwc.cards.Card;
import bwc.deck.AffectedDeck;
import bwc.deck.CentralDeck;
import bwc.deck.PlayerHand;

public class Player {

	private String name;
	private PlayerHand hand = new PlayerHand();
	private AffectedDeck affected = new AffectedDeck();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoints(CentralDeck centralDeck) {
		return affected.getPoints(centralDeck);
	}
	
	public String toString(CentralDeck centralDeck) {
		return String.format("%s - Points : %d", name, getPoints(centralDeck));
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
	
	public boolean loseTurn() {
		return affected.loseTurn();
	}
	
	public void getCard(Card card) {
		hand.addCrad(card);
	}
	
}
