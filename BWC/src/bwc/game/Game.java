package bwc.game;

import bwc.deck.CentralDeck;
import bwc.deck.Deck;
import bwc.player.Player;

public class Game {

	private Player[] players;
	private Deck deck;
	private CentralDeck centralDeck;
	
	private int currentPlayerIndex;
	
	public Game(Player...players) {
		this.players = players;
		this.deck = new Deck();
	}
	
	public String getPlayerName(int playerIndex) {
		return players[playerIndex].getName();
	}
	
	public int getPlayerPoints(int playerIndex) {
		return players[playerIndex].getPoints(centralDeck);
	}
	
	
	public String getCurrentPlayerHand() {
		return getCurrentPlayer().getHand();
	}
	
	public void playCard(int cardIndex,int playerIndex) {
		if (playerIndex < 0) {
			centralDeck.addCrad(getCurrentPlayer().drawCard(cardIndex));
		} else {
			getPlayer(playerIndex).giveCard(getCurrentPlayer().drawCard(cardIndex));
		}
		switchPlayerWithTurnCheck();
		
	}
	
	private void switchPlayerWithTurnCheck() {
		switchPlayer();	
		checkTurn();
	}
	
	private void checkTurn() {
		while (getCurrentPlayer().loseTurn()) {
			switchPlayer();
		}
	}
	
	private Player getCurrentPlayer() {
		return players[currentPlayerIndex];
	}
	
	private Player getPlayer(int playerIndex) {
		return players[playerIndex];
	}
	
	private void switchPlayer() {
		if (currentPlayerIndex == players.length - 1) {
			currentPlayerIndex = 0;
		} else {
			currentPlayerIndex++;
		}
	}

	public boolean isEnded() {
		return deck.isEmpty();
	}
	
}
