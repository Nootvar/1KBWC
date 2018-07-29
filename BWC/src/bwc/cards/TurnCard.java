package bwc.cards;

public class TurnCard extends Card {
	
	private int turns;

	public TurnCard(String name, String description, int turns) {
		super(name, description);
		this.turns = turns;
	}
	
	public int getTurns() {
		return turns;
	}

}
