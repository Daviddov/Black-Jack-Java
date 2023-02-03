
public class Card {
	private int num;
	public String type;
	public String color;

	public Card(int num, String type) {
		this.type = type;
		this.num = num;

		if (type == "club" || type == "tiltan") {
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

	public void printInfo() {
		System.out.println(this.num + " " + this.color + " " + this.type);

	}
}
