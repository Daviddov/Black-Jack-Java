
public class Player {
private String playerName;
private int sumCards = 0, index=0;
private Card[] playerCards = new Card[0];

public Player(String name) {
	this.playerName = name;
}


private Card[] addCardPlace() {
	Card[] newCardArr = new Card[playerCards.length+1];
	for (int i = 0; i < playerCards.length; i++) {
		newCardArr[i] = playerCards[i];
	}
	return newCardArr;
}
private int getNum(Card card) {
	int num = card.getNum();
	if (num > 10) {
		num = 10;
	}
	return num;
}

public void takeCard(Card card) {
	playerCards = addCardPlace();
	playerCards[playerCards.length-1] = card;
	sumCards += getNum(card);
}

 public Card[] getAndPrintPlayerCards() {
	 for (int i = 0; i < playerCards.length; i++) {
		playerCards[i].printInfo(); 
	}
	return playerCards;
 }
 public int getSum() {
	 return sumCards;
 }
 public String getName() {
	 return playerName;
 }

}
