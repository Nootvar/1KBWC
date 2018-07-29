package bwc.cards;

public class PointCard extends Card {
	
	private int points;
	
	public PointCard(String name, String description, int points) {
		super(name, description);
		this.points = points;
	}
	
	public int getValue() {
		return points;
	}

}
