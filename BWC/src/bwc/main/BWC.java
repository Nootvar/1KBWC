package bwc.main;

import bwc.game.Game;
import bwc.player.Player;
import io.Console;

public class BWC {

	private static Game game;
	
	public static void main(String[] args) {
		game = new Game(new Player("Michel"), new Player("Jacky"), new Player("John"));
		
		do {
			System.out.println(game.getPlayerList());
			System.out.println("Au tour de " + game.getCurrentPlayerName());
			System.out.println(game.getCurrentPlayerHand());
			
			System.out.println("Num de la carte � jouer ?");
			int cardIndex = Console.lireInt();
			
			System.out.println("Num du joueur � qui la donn� ?");
			int playerIndex = Console.lireInt();
			
			game.playCard(cardIndex, playerIndex);
			
		} while (!game.isEnded());
		
		System.out.println("Jeux termin�");
		System.out.println("R�sultat :");
		System.out.println(game.getPlayerList());
		
	}
	
}
