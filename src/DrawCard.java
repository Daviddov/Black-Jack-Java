
public class DrawCard {
	private String[] backCard = new String[4];
	private String[] faceCard = new String[4];
	private String shapeASCII;

	public DrawCard(int num, String type) {
		setBack();
		setShapeASCII(type);
		setFront(num);
	}


	public String[] getBackCard() {
		return backCard;
	}

	public String[] getFaceCard() {
		return faceCard;
	}

	private void setBack() {
		backCard = new String[4];
		backCard[0] = " _____ ";
		backCard[1] = "|#####|";
		backCard[2] = "|#####|";
		backCard[3] = " _____ ";

	}

	private void setFront(int num) {
		if (num == 10) {
			drawTenCard();
		} else if (num == 14) {
			drawJokerCard();
		} else {
			drawCard(num);
		}
	}

	private void setShapeASCII(String type) {
		switch (type) {
		case "Clubs":
			shapeASCII = "\u2663";
			break;
		case "Spades":
			shapeASCII = "\u2660";
			break;
		case "Diamonds":
			shapeASCII = "\u2662";
			break;
		case "Joker":
			shapeASCII = "JOKER";
			break;
		default:
			shapeASCII = "\u2661";
			break;
		}
	}

	public void drawJokerCard() {
		faceCard[0] = " _____ ";
		faceCard[1] = "|JOKER|";
		faceCard[2] = "|(_ _)|";
		faceCard[3] = " _____ ";

	}

	private void drawTenCard() {
		faceCard[0] = " _____";
		faceCard[1] = "|" + 10 + "   |";
		faceCard[2] = "|  " + shapeASCII + "  |";
		faceCard[3] = "|___" + 10 + "|";

	}


	private void drawCard(int num) {
		if (num < 10 && num > 1) {
			faceCard[0] = " _____";
			faceCard[1] = "|" + num + "    |";
			faceCard[2] = "|  " + shapeASCII + "  |";
			faceCard[3] = "|____" + num + "|";
		} else {
			char rank;
			rank = numToRank(num);
			faceCard[0] = " _____";
			faceCard[1] = "|" + rank + "    |";
			faceCard[2] = "|  " + shapeASCII + "  |";
			faceCard[3] = "|____" + rank + "|";
		}
	}

	private char numToRank(int num) {
		switch (num) {
		case 11:
			return 'J';
		case 12:
			return 'Q';
		case 13:
			return 'K';
		default:
			return 'A';
		}
	}
	

	public void printBack() {
		for (int i = 0; i < backCard.length; i++) {
			System.out.println(backCard[i]);
		}
	}

	public void printFace() {
		for (int i = 0; i < faceCard.length; i++) {
			System.out.println(faceCard[i]);
		}
	}
}
