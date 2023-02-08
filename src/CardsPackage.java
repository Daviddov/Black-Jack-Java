import java.util.Random;

public class CardsPackage {
private Card[] cards;
private int curnetCardPick = 0;

private void bulidPackege(String type, int index) {
	for (int i=0+index;i<=13+index;i++) {
		this.cards[i] = new Card(i%13+1, type);
	}
}

public CardsPackage() {
	cards = new Card[52];
	bulidPackege("Clubs", 0);
	bulidPackege("Spades",12);
	bulidPackege("Hearts",25);
	bulidPackege("Diamonds", 38);
	
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
	Card[] shufflePack = new Card[52];
	for (int i = 0; i < shufflePack.length; i++) {
		int random = (int)(Math.random()*cards.length);

		shufflePack[i] = cards[random];
		cards[random] = null;
		cards = fiterNull(cards);
		}
		cards = new Card[52];
	for (int i = 0; i < shufflePack.length; i++) {
		cards[i] = shufflePack[i];
	}
	}
	
}



