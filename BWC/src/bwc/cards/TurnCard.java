package bwc.cards;

public class TurnCard extends Card {
	
	private int turns;
	private int affected = 0;

	public TurnCard(String name, String description, int turns) {
		super(name, description);
		this.turns = turns;
	}
	
	public int getTurns() {
		return turns;
	}
	
	public boolean addAffected() {
		affected++;
		if (affected == turns) {
			return true;
		} else {
			return false;
		}
	}

}
