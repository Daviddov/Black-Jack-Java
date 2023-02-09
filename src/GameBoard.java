import java.util.Scanner;

public class GameBoard {
	CardsPackage cardPackage;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private boolean gameOver = false;

	public GameBoard() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter player name:");
		String playerName = in.next();
		player1 = new Player(playerName);
		player2 = new Player("Computer");
		
		cardPackage = new CardsPackage();
		cardPackage.shufflePack();
		currentPlayer = player1;
		System.out.println("You have "+ currentPlayer.getDullers()+" Dullers, Enter your bet:");
		currentPlayer.setBat(in.nextInt());
		play();
	}

	public void play() {

		System.out.println("Hello " + currentPlayer.getName());

		Scanner in = new Scanner(System.in);
		while (!gameOver()) {

				System.out.println(currentPlayer.getName() + " turn");
				System.out.println("You bet is "+ currentPlayer.getBet());

				System.out.println("Enter your move: 1. Hit		2.Stend		3.fold");

				if (currentPlayer.isInTheGame()) {
				int chois = in.nextInt();
				if (chois == 1) {
					makeTurn();

					player1.getAndPrintPlayerCards();
					System.out.println(player1.getName() + " Points : " + player1.getSum());
					System.out.println();

				} else if (chois == 2) {
					stand();
				} else if (chois == 3) {
					outOfRound();
				}
			} else {
				stand();

			}
		}

		int chois = 0;
		while (chois != 4 || chois != 3) {
			System.out.println("3. play again:");
			System.out.println("4. for reset game:");
			chois = in.nextInt();
			if (chois == 3) {
				nextRound();
			} else if (chois == 4) {
				GameBoard newGame = new GameBoard();
			}
		}

	}

	private void makeTurn() {
		hit();
		computerTurn();
	}

	private void hit() {
		if (!gameOver()) {

			if (!currentPlayer.isInTheGame()) {
				computerTurn();
				return;
			}

			currentPlayer.takeCard(cardPackage.pickCard());
			if (isBurned(currentPlayer)) {
				System.out.println(currentPlayer.getName() + " is burned " + currentPlayer.getSum());

			} else if (isBlackJack(currentPlayer)) {
				System.out.println(currentPlayer.getName() + " have Black jack");
			}
			nextPlayer();

		}
	}

	private void computerTurn() {
		double random = Math.random();
		if (random > 0.3) {
			hit();

		} else if (currentPlayer.getSum() > 15) {
			random = Math.random();
			if (random > 0.5) {
				nextPlayer();
			} else {
				outOfRound();
			}
		}
	}

	private void stand() {
		nextPlayer();
		computerTurn();
	}

	private void nextPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	private boolean isBurned(Player playerName) {
		if (playerName.getSum() > 21) {
			gameOver = true;
			return true;
		}
		return false;
	}

	private boolean isBlackJack(Player playerName) {
		if (playerName.getSum() == 21) {
			gameOver = true;
			return true;
		}
		return false;
	}

	public boolean gameOver() {
		if (gameOver) {
			player1.getAndPrintPlayerCards();
			System.out.println(player1.getName() + " Points : " + player1.getSum());
			player2.getAndPrintPlayerCards();
			System.out.println(player2.getName() + " Points : " + player2.getSum());
			chackWinning();
			return true;
		}
		return false;
	}

	private void chackWinning() {
		Player winner = player1;
		if (player1.getSum() > 21) {
			winner = player2;
		} else if (player2.getSum() > 21) {
			winner = player1;
		} else {
			if (player1.getSum() > player2.getSum()) {
				winner = player1;
			} else {
				winner = player2;
			}
		}
		System.out.println(winner.getName() + " is won");

	}

	private void nextRound() {
		gameOver = false;
		player1.resetHend();
		player2.resetHend();
		currentPlayer = player1;
		play();
	}

	private void outOfRound() {
		currentPlayer.fold();
		if (!player1.isInTheGame() && !player2.isInTheGame()) {
			gameOver = true;
		}
	}
}
