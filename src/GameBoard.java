import java.util.Scanner;

public class GameBoard {
	CardsPackage cardPackage;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private boolean gameOver = false;
	private int dackRoundNum = 0;
	
	public GameBoard() {
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter player name:");
		String playerName = in.next();

		player1 = new Player(playerName);
		player2 = new Player("Computer");

		cardPackage = new CardsPackage();
		cardPackage.shufflePack();
		currentPlayer = player1;

		play();
	}

	public void play() {
		dackRoundNum++;
		startTheGame();

		Scanner in = new Scanner(System.in);
		while (!isGameOver()) {

			System.out.println("You bet is " + currentPlayer.getBet());
			System.out.println("Enter your move: 1. Hit		2.Stend		3.double");

			if (currentPlayer.getIsInTheGame()) {
				int chois = in.nextInt();
				if (chois == 1) {
					hit();

					System.out.println(player2.getName() + " hend");
					printFirstCardWithBack();

					player1.printPlayerCards();
					System.out.println(player1.getName() + " Points : " + player1.getSum());

				} else if (chois == 2) {
					stand();
				} else if (chois == 3) {
					currentPlayer.setBat(currentPlayer.getBet());
				}
			}
		}

		endOfRound();

	}

	private void startTheGame() {
		if (currentPlayer.getDullers() <= 0) {
			endOfRound();
		}
		System.out.println("Hello " + currentPlayer.getName());
		chooseBet();
		System.out.println("You bet is " + currentPlayer.getBet());
		makeUserAndComputerTurn();
		makeUserAndComputerTurn();

		System.out.println(player2.getName() + " hend");
		printFirstCardWithBack();

		System.out.println();

		System.out.println(player1.getName() + " hend");
		player1.printPlayerCards();
		System.out.println(player1.getName() + " Points : " + player1.getSum());

	}

	private void hit() {
		if (!isGameOver()) {
			currentPlayer.takeCard(cardPackage.pickCard());
			if (isBurned(currentPlayer)) {
				System.out.println(currentPlayer.getName() + " is burned " + currentPlayer.getSum());

			} else if (isBlackJack(currentPlayer)) {
				System.out.println(currentPlayer.getName() + " have Black jack");
			}

		}
	}

	private void stand() {
		nextPlayer();
		computerTurn();
		gameOver = true;
	}

	private void computerTurn() {
		while (currentPlayer.getSum() < 17) {
			hit();

		}
		nextPlayer();
	}

	private void nextPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	private void makeUserAndComputerTurn() {
		hit();
		nextPlayer();
		currentPlayer.takeCard(cardPackage.pickCard());
		nextPlayer();

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

	public boolean isGameOver() {
		if (gameOver) {
			printPlayersCards();
			chackWinning();
			System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
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
			} else if (player2.getSum() > player1.getSum()) {
				winner = player2;
			} else {
				winner.setDullers(winner.getBet());
				System.out.println("Dead heat");
				return;
			}
		}

		winner.setDullers(winner.getBet() * 2);
		System.out.println(winner.getName() + " is won");

	}

	private void playAgain() {
		gameOver = false;
		player1.setResetHend();
		player2.setResetHend();
		currentPlayer = player1;
		play();
		if(dackRoundNum > 5) {
			newDeck();
		}
	}

	private void newDeck() {
		dackRoundNum=0;
		cardPackage = new CardsPackage();
		cardPackage.shufflePack();
	}
	
	private void chooseBet() {
		Scanner in = new Scanner(System.in);
		System.out.println("You have $" + currentPlayer.getDullers());
		System.out.println("Enter your bet: 1. $50		2. $100			3. $250");
		int bet = in.nextInt();
		if (bet == 1) {
			currentPlayer.setBat(50);
		} else if (bet == 2) {
			currentPlayer.setBat(100);
		} else if (bet == 3) {
			currentPlayer.setBat(250);
		}

	}

	private void endOfRound() {
		Scanner in = new Scanner(System.in);
		int chois = 0;
		while (chois != 1 || chois != 2) {
			System.out.println("You have $" + currentPlayer.getDullers());
			System.out.println("1. play again:");
			System.out.println("2. for reset game:");
			chois = in.nextInt();
			if (chois == 1) {
				playAgain();
			} else if (chois == 2) {
				GameBoard newGame = new GameBoard();
			}
		}

	}

	private void printFirstCardWithBack() {
		player2.getCard(0).printCard();
		player2.getCard(0).printBackCard();
		System.out.println(player2.getName() + " Points : " + player2.getCard(0).getNumRound());
	}

	private void printPlayersCards() {
		player2.printPlayerCards();
		System.out.println(player2.getName() + " Points : " + player2.getSum());
		player1.printPlayerCards();
		System.out.println(player1.getName() + " Points : " + player1.getSum());
		System.out.println();
	}

}
