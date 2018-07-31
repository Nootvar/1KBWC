package bwc.game;

import bwc.deck.CentralDeck;
import bwc.deck.Deck;
import bwc.player.Player;

public class Game {

	private Player[] players;
	private Deck deck = new Deck();
	private CentralDeck centralDeck = new CentralDeck();
	
	private int currentPlayerIndex;
	
	public Game(Player...players) {
		this.players = players;
		drawInitialCards();
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
		if (!deck.isEmpty()) {
			getCurrentPlayer().getCard(deck.drawCard());
		}
		
	}
	
	private void switchPlayerWithTurnCheck() {
		switchPlayer();	
		checkTurn();
	}
	
	private void checkTurn() {
		while ((getCurrentPlayer().loseTurn() || getCurrentPlayer().isHandEmpty()) && isEnded()) {
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
		return deck.isEmpty() && playersOutOfCards();
	}
	
	private void drawInitialCards() {
		for (Player player : players) {
			for (int i = 0; i < 3; i++) {
				player.getCard(deck.drawCard());
			}
		}
		players[0].getCard(deck.drawCard());
	}
	
	public String getPlayerList() {
		String list = "";
		for (int i = 0; i < players.length; i++) {
			list += i + ". " + players[i].toString(centralDeck) + "\n";
		}
		return list;
	}

	public String getCurrentPlayerName() {
		return getCurrentPlayer().getName();
	}
	
	private boolean playersOutOfCards() {
		for (Player player : players) {
			if (!player.isHandEmpty()) {
				return false;
			}
		}
		return true;
	}
	
}
