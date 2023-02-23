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
	setJuker();
}
 
private void setDeck() {
	bulidSuit("Clubs", 0);
	bulidSuit("Spades",12);
	bulidSuit("Hearts",25);
	bulidSuit("Diamonds", 38);
}
private void setJuker() {
	this.cards[52] = new Card("juker");
	this.cards[53] = new Card("juker");
}

private void bulidSuit(String type, int index) {
	for (int i=0+index;i<=13+index;i++) {
		this.cards[i] = new Card(i%13+1, type);
	}
}

public Card pickCard() {
		Card pickCard = cards[curnetCardPick];
		curnetCardPick++;
		return pickCard;
}

private Card[] fiterNull(Card[] cards) {
	Card[] copyCards = new Card[cards.length-1];
	int counter = 0;
	for (int i = 0; i < cards.length; i++) {
		if (cards[i] != null) {
		copyCards[counter] = cards[i];
		counter++;	
	}
	}
	return copyCards;
}

public void shufflePack() {
	int lengthPack = cards.length;
	Card[] shufflePack = new Card[lengthPack];
	for (int i = 0; i < shufflePack.length; i++) {
		int random = (int)(Math.random()*cards.length);

		shufflePack[i] = cards[random];
		cards[random] = null;
		cards = fiterNull(cards);
		}
		cards = new Card[lengthPack];
	for (int i = 0; i < shufflePack.length; i++) {
		cards[i] = shufflePack[i];
	}
	}
	
}



