package bwc.cards;

public abstract class Card implements CardI {

	private String name;
	private String description;
	
	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %s", name, description);
	}
	
}
