
public class Player {
	private String playerName;
	private int index = 0, dullars = 500, bet = 0;

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
//		sumCards += getNum(card);
	}



	public Card getCard(int index) {
		
		return playerCards[index];
		
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
		int sumCards = 0;
		boolean ace = false;
		for (int i = 0; i < playerCards.length; i++) {
			if (playerCards[i].getNum() == 1 && !ace ) {
				ace = true;
				sumCards+=10;
			}
			sumCards += playerCards[i].getNum();
			if(ace && sumCards > 21) {
				sumCards -= 10;
			}
		}
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

	public boolean getIsInTheGame() {
		return inTheGame;
	}
	
	public void setBat(int bet) {
		if (bet <= dullars) {
			dullars -= bet;
			this.bet += bet;
		}
	}

	public void setDullers(int dullars) {
		this.dullars += dullars;
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
}
