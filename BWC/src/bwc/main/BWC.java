package bwc.main;

import bwc.game.Game;
import bwc.player.Player;

public class BWC {

	private static Game game;
	
	public static void main(String[] args) {
		game = new Game(new Player("Michel"), new Player("Jacky"), new Player("John"));
		
		do {
			
		} while (!game.isEnded());
		
	}
	
}
