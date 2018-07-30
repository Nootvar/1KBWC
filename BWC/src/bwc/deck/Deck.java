package bwc.deck;

import bwc.cards.Card;
import bwc.cards.DivisiveCard;
import bwc.cards.MultiplicativeCard;
import bwc.cards.PointCard;
import bwc.cards.TurnCard;

public class Deck {

	private Card[] cards;
	private int remainingCards;
	
	public Deck() {
		cards = new Card[100];
		cards[0] = new PointCard("Jambon", "C'est bon le jambon +100 points", 100);
		cards[1] = new PointCard("Fromage", "Le fromage ça pue -100 points", -100);
		cards[2] = new PointCard("Poupoule", "Piou piou prend c'est 150 points", 150);
		cards[3] = new PointCard("Motus", "Boule noir ! -200 points (ou c'est raciste)", -200);
		cards[4] = new PointCard("Jackpote", "Gagne 500 points avec le lotto", 500);
		cards[5] = new MultiplicativeCard("Gros sapin", "C'est noel ! Donc x2 pour les points", 2);
		cards[6] = new MultiplicativeCard("Super +", "Tu gagne le jocker x3 pour toi", 3);
		cards[7] = new DivisiveCard("Passage de l'état", "L'état viens récupéré ses impots :2", 2);
		cards[8] = new DivisiveCard("Rekt", "Tout :4 total rekt", 4);
		cards[9] = new TurnCard("Père fourace", "Nique ta race et tu passe un tour", 1);
		cards[10] = new TurnCard("Shéma", "Tu doit réalisé un shéma géographique qui te prend 2 tours", 2);
		remainingCards = 11;
	}
	
	public Card drawCard() {
		if (isEmpty()) {
			return null;
		}
		int rand;
		Card card = null;
		do {
			rand = (int)(Math.random() * (1L + cards.length - 1));
			if (cards[rand] != null) {
				card = cards[rand];
				cards[rand] = null;
			}
		} while (card == null);
		remainingCards --;
		return card;
	}

	public boolean isEmpty() {
		return remainingCards == 0;
	}
}
