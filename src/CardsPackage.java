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
	bulidPackege("club", 0);
	bulidPackege("tiltan",12);
	bulidPackege("heart",25);
	bulidPackege("dimond", 38);
	
}
 
public Card pickCard() {
		Card pickCard = cards[curnetCardPick];
		curnetCardPick++;
		pickCard.printInfo();
		return pickCard;
}

public void shuffelPack() {
	Card[] shuffelPack = new Card[52];
	for (int i = 0; i < shuffelPack.length; i++) {
		int random = (int)(Math.random()*52);
		while(cards[random] == null) {
			random = (int)(Math.random()*52);
		}
		shuffelPack[i] = cards[random];
		cards[random] = null;
		}
	for (int i = 0; i < shuffelPack.length; i++) {
		cards[i] = shuffelPack[i];
	}
	}
	
}



