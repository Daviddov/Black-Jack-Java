import java.util.Random;

public class CardsPackage {
	private Card[] cards;
	private int curnetCardPick = 0;

	public CardsPackage() {
		cards = new Card[52];
		setDeck();

	}

	public CardsPackage(String juker) {
		cards = new Card[54];
		setDeck();
		setJoker();
	}

	private void setDeck() {
		bulidSuit("Clubs", 0);
		bulidSuit("Spades", 12);
		bulidSuit("Hearts", 25);
		bulidSuit("Diamonds", 38);
	}

	private void setJoker() {
		this.cards[52] = new Card("joker");
		this.cards[53] = new Card("joker");
	}

	private void bulidSuit(String type, int index) {
		for (int i = 0 + index; i <= 13 + index; i++) {
			this.cards[i] = new Card(i % 13 + 1, type);
		}
	}

	public Card pickCard() {
		Card pickCard = cards[curnetCardPick];
		curnetCardPick++;
		return pickCard;
	}


	public void shufflePack() {
	    Random rnd = new Random();
	    for (int i = cards.length - 1; i > 0; i--) {
	        int j = rnd.nextInt(i + 1);
	        Card temp = cards[i];
	        cards[i] = cards[j];
	        cards[j] = temp;
	    }
	}


}
