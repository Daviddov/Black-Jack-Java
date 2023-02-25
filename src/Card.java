
public class Card {
	private int num;
	private String type;
	private String color;
	private String shapeASCII;
	private DrawCard drawCard;


	public Card(int num, String type) {
		this.type = type;
		this.num = num;
		shapeASCII();
		setColor();
		drawCard =new DrawCard(num,type);
	}

	public Card(String type) {
		this.type = type;
		this.num = 14;
		this.color = "black";
	}

	public DrawCard getDrawCard() {
		return drawCard;
	}

	public int getNum() {
		return num;
	}

	public int getNumRound() {
		if (num > 10) {
			num = 10;
		}
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
	
	private void setColor() {
		if (type == "Clubs" || type == "Spades") {
			this.color = "black";
		} else {
			this.color = "red";
		}
	}

	public void printCard() {
		drawCard.printFace();
	}
	public void printBackCard() {
		drawCard.printBack();
	}
	
	private void shapeASCII() {
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
		case "Juker":
			shapeASCII = "JOKER";
			break;
		default:
			shapeASCII = "\u2661";
			break;
		}
	}

}
