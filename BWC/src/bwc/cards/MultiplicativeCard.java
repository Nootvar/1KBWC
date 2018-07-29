package bwc.cards;

public class MultiplicativeCard extends Card {
	
	private int multiplier;

	public MultiplicativeCard(String name, String description, int multiplier) {
		super(name, description);
		this.multiplier = multiplier;
	}
	
	public int getMultiplier() {
		return multiplier;
	}
	
}
