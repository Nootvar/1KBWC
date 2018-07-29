package bwc.cards;

public class DivisiveCard extends Card {

	private int divisor;
	
	public DivisiveCard(String name, String description, int divisor) {
		super(name, description);
		this.divisor = divisor;
	}

	public int getDivisor() {
		return divisor;
	}
	
}
