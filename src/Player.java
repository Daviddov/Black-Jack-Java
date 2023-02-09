
public class Player {
	private String playerName;
	private int sumCards = 0, index = 0, dullars = 50, bet=0;
	
	private Card[] playerCards = new Card[0];
	private boolean inTheGame = true;

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
				System.out.print("|" + getRankOfNum(num) + "    |  ");
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
				System.out.print("|____" + getRankOfNum(num) + "|  ");
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

	private int getNum(Card card) {
		int num = card.getNum();
		if (num > 10) {
			num = 10;
		}
		return num;
	}

	private char getRankOfNum(int num) {
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
public int getBet() {
	return bet;
}
public int getDullers() {
	return dullars;
}
	public void setBat(int bet) {
		if(bet <= dullars) {
			dullars -= bet;
			this.bet += bet;
		}
		}
	
	public void fold() {
		inTheGame = false;
		System.out.println(playerName + " fold");
	}

//	public void setWon() {
//		winning++;
//	}
//
//	public int getWinning() {
//		return winning;
//	}

	public boolean isInTheGame() {
		return inTheGame;
	}

	public void resetHend() {
		playerCards = new Card[0];
		sumCards = 0;
		index = 0;
		inTheGame = true;
	}
}
