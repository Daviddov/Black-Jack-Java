
public class GameBoard {
	CardsPackage cardPackage;
	Player player1;
	Player player2;
	Player curentPlayer;

	public GameBoard() {
		cardPackage = new CardsPackage();
		cardPackage.shuffelPack();
		player1 = new Player("david");
		player2 = new Player("Computer");
		curentPlayer = player1;
		play();
		player1.getAndPrintPlayerCards();
		System.out.println("player1 sum : " + player1.getSum());
		play();
		player1.getAndPrintPlayerCards();
		System.out.println("player1 sum : " + player1.getSum());
		play();
		player1.getAndPrintPlayerCards();
		System.out.println("player1 sum : " + player1.getSum());
		play();
		player1.getAndPrintPlayerCards();
		System.out.println("player1 sum : " + player1.getSum());
		// turn
		// ruls --> more then 21, black jack, below 21 most close to
	}

	private void hit() {
		if(gameOver()) {
			return;
		}
		curentPlayer.takeCard(cardPackage.pickCard());
		if (isBurned(curentPlayer)) {
			System.out.println(curentPlayer.getName() + " is burned " + curentPlayer.getSum());

		} else if (isBlackJack(curentPlayer)) {
			System.out.println(curentPlayer.getName() + "you have Black jack");
		}
		
		isBlackJack(curentPlayer);

	}

	private void computerTurn() {
		nextPlayer();
		hit();
	}

	public void play() {
		
			hit();

			computerTurn();
		}

	public void stand() {
		nextPlayer();
		hit();
	}

	private void nextPlayer() {
		if (curentPlayer == player1) {
			curentPlayer = player2;
		} else {
			curentPlayer = player1;
		}
	}

	public boolean isBurned(Player playerName) {
		if (playerName.getSum() > 21) {
			return true;
		}
		return false;
	}

	public boolean isBlackJack(Player playerName) {
		if (playerName.getSum() == 21) {
			return true;
		}
		return false;
	}

	public boolean gameOver() {
		if (isBurned(player1) || isBlackJack(player1) || isBurned(player2) || isBlackJack(player2)) {
			return true;
		}
		return false;
	}
}
