
public class Player {
	private String playerName;
	private int index = 0, dollars = 500, bet = 0;
	private boolean inTheGame = true;
	private Card[] playerCards = new Card[0];

	public Player(String name) {
		this.playerName = name;
	}

	public Card[] getPlayerCards() {
		return playerCards;
	}
	public Card getCard(int index) {
		return playerCards[index];
	}

	public String getName() {
		return playerName;
	}

	public int getBet() {
		return bet;
	}

	public int getDollars() {
		return dollars;
	}

	public boolean getIsInTheGame() {
		return inTheGame;
	}

	public void setBat(int bet) {
		if (bet <= dollars) {
			dollars -= bet;
			this.bet += bet;
		}
	}

	public void setDollars(int dollars) {
		this.dollars += dollars;
	}

	public void setResetHend() {
		playerCards = new Card[0];
		index = 0;
		inTheGame = true;
		bet = 0;
	}

	public void printPlayerCards() {
		for (int i = 0; i < playerCards.length; i++) {
			int num = playerCards[i].getNum();
		}
		printCards();

	}

	private Card[] addCardPlace() {
		Card[] newCardArr = new Card[playerCards.length + 1];
		for (int i = 0; i < playerCards.length; i++) {
			newCardArr[i] = playerCards[i];
		}
		return newCardArr;
	}

	public void takeCard(Card card) {
		playerCards = addCardPlace();
		playerCards[playerCards.length - 1] = card;
	}

	public void printCards() {
		int rewsOfCard = playerCards[0].getDrawCard().getFaceCard().length;
		for (int i = 0; i < rewsOfCard; i++) {
			for (int j = 0; j < playerCards.length; j++) {
				String cardRew = playerCards[j].getDrawCard().getFaceCard()[i];
				System.out.print(cardRew);
			}
			System.out.println();
		}
	}

}
