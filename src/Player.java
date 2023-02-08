
public class Player {
	private String playerName;
	private int sumCards = 0, index = 0;
	private Card[] playerCards = new Card[0];

	public Player(String name) {
		this.playerName = name;
	}

	private Card[] addCardPlace() {
		Card[] newCardArr = new Card[playerCards.length + 1];
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
		playerCards[playerCards.length - 1] = card;
		sumCards += getNum(card);
	}

	public Card[] getAndPrintPlayerCards() {
		for (int i = 0; i < playerCards.length; i++) {
			int num = playerCards[i].getNum();
//			playerCards[i].printCard();
		}
		printCards();
		return playerCards;
	}

	public void printCards() {
		int n = playerCards.length;
		int num;
		for (int i = 0; i < n; i++) {
			System.out.print(" _____   ");
		}
		System.out.println();

		for (int i = 0; i < n; i++) {
			num = playerCards[i].getNum();
			if (num < 10 && num > 1) {
				System.out.print("|" + num + "    |  ");
			} else if (num == 10) {
				System.out.print("|" + num + "   |  ");
			} else {
				System.out.print("|" + rankOfNum(num) + "    |  ");
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("|  " + playerCards[i].getShapeASCII() + "  |  ");
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			num = playerCards[i].getNum();
			if (num < 10 && num > 1) {
				System.out.print("|____" + num + "|  ");
			} else if (num == 10) {
				System.out.print("|___" + num + "|  ");
			} else {
				System.out.print("|____" + rankOfNum(num) + "|  ");
			}


		}
		System.out.println();
	}

	public int getSum() {
		return sumCards;
	}

	public String getName() {
		return playerName;
	}

	private char rankOfNum(int num) {
		char rank;
		switch (num) {
		case 1:
			rank = 'A';
			break;
		case 11:
			rank = 'J';
			break;
		case 12:
			rank = 'Q';
			break;
		default:
			rank = 'K';
			break;
		}
		return rank;
	}

}
