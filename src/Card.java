
public class Card {
	private int num;
	public String type;
	public String color;
	public String shapeASCII;

	public Card(int num, String type) {
		this.type = type;
		this.num = num;
		shapeASCII();

		if (type == "Clubs" || type == "Spades") {
			this.color = "black";
		} else {
			this.color = "red";
		}
	}

	public int getNum() {
		return num;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	public String getShapeASCII() {
		return shapeASCII;
	}

	public void shapeASCII() {
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
		default:
			shapeASCII = "\u2661";
			break;
		}
	}

	public void printCard() {
		if (num == 10) {
			printTen();
		} else if (num < 10 && num > 1) {
			print(num);
		} else {
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
			print(rank);
		}

	}

	private void printTen() {
		System.out.println(" _____");
		System.out.println("|" + 10 + "   |");
		System.out.println("|  " + shapeASCII + "  |");
		System.out.println("|___" + 10 + "|");
		System.out.println();
	}

	private void print(int num) {
		System.out.println(" _____");
		System.out.println("|" + num + "    |");
		System.out.println("|  " + shapeASCII + "  |");
		System.out.println("|____" + num + "|");
		System.out.println();
	}

	private void print(char rank) {
		System.out.println(" _____");
		System.out.println("|" + rank + "    |");
		System.out.println("|  " + shapeASCII + "  |");
		System.out.println("|____" + rank + "|");
		System.out.println();
	}

}
