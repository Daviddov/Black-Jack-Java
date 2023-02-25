import java.util.Scanner;

public class BlackJackGameBoard {
	private CardsPackage cardPackage;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private boolean gameOver = false;
	private int deckRoundNumber = 0;
	private final int bet1 = 50;
	private final int bet2 = 100;
	private final int bet3 = 250;
	
	public BlackJackGameBoard() {
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
		deckRoundNumber++;
		startTheGame();

		Scanner in = new Scanner(System.in);
		while (!isGameOver()) {

			System.out.println("You bet is " + currentPlayer.getBet() +
					"\nEnter your move: 1. Hit \t 2.Stend \t 3.double" );

			if (currentPlayer.getIsInTheGame()) {
				int userChoice = in.nextInt();
				switch (userChoice) {
				case 1: {
					hit();

					System.out.println(player2.getName() + " hend");
					printFirstCardWithBack();

					player1.printPlayerCards();
					System.out.println(player1.getName() + " Points : " + sumPoints(player1));
					break;
				}
				case 2: {
					stand();
					break;
				}
				case 3: {
					currentPlayer.setBat(currentPlayer.getBet());
					break;
				}

				default:
					System.out.println("worng user choice");
				}
			}
		}

		endOfRound();

	}

	private void startTheGame() {
		if (currentPlayer.getDollars() <= 0) {
			endOfRound();
		}
		System.out.println("Hello " + currentPlayer.getName());
		chooseBet();
		System.out.println("You bet is " + currentPlayer.getBet());
		makeUserAndComputerTurn();
		makeUserAndComputerTurn();
		
		System.out.println(player2.getName() + " hend");
		printFirstCardWithBack();
		
		System.out.println(player1.getName() + " hend");
		player1.printPlayerCards();
		System.out.println(player1.getName() + " Points : " + sumPoints(player1));

	}

	private void hit() {
	    if (!isGameOver()) {
	        currentPlayer.takeCard(cardPackage.pickCard());
	        if (isBurned(currentPlayer)) {
	            printBurnMessage(currentPlayer);
	        } else if (isBlackJack(currentPlayer)) {
	            printBlackjackMessage(currentPlayer);
	        }
	    }
	}

	private void printBurnMessage(Player player) {
		System.out.println(currentPlayer.getName() + " is burned " + sumPoints(currentPlayer));
	}

	private void printBlackjackMessage(Player player) {
	    System.out.println(player.getName() + " has blackjack");
	}

	
	private void stand() {
		nextPlayer();
		computerTurn();
		gameOver = true;
	}

	private void computerTurn() {
		while (sumPoints(currentPlayer) < 17) {
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

	private boolean isBurned(Player player) {
		if (sumPoints(player) > 21) {
			gameOver = true;
			return true;
		}
		return false;
	}

	private boolean isBlackJack(Player player) {
		if (sumPoints(player) == 21) {
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
		 // Check if player 1 busted
		if (sumPoints(player1) > 21) {
			winner = player2;
		}
		// Check if player 2 busted
		else if (sumPoints(player2) > 21) {
			winner = player1;
		} else {
			// If no winner has been determined, check who has the highest score
			if (sumPoints(player1) > sumPoints(player2)) {
				winner = player1;
			} else if (sumPoints(player2) > sumPoints(player1)) {
				winner = player2;
			} else {
				   // If the scores are equal, it's a tie
				winner.setDollars(winner.getBet());
				System.out.println("Dead heat");
				return;
			}
		}
	    // Otherwise, the winner collects their bet from the loser
		winner.setDollars(winner.getBet() * 2);
		System.out.println(winner.getName() + " is won");

	}

	private void playAgain() {
		gameOver = false;
		player1.setResetHend();
		player2.setResetHend();
		currentPlayer = player1;
		play();
		if(deckRoundNumber > 4) {
			newDeck();
		}
	}

	private void newDeck() {
		deckRoundNumber=0;
		cardPackage = new CardsPackage();
		cardPackage.shufflePack();
	}
	
	private void chooseBet() {
		Scanner in = new Scanner(System.in);
		System.out.println("You have $" + currentPlayer.getDollars() +
				"\nEnter your bet: 1. $"+bet1+" \t 2. $"+bet2+ "\t 3. $"+bet3);
		int bet = in.nextInt();
		if (bet == 1) {
			currentPlayer.setBat(bet1);
		} else if (bet == 2) {
			currentPlayer.setBat(bet2);
		} else if (bet == 3) {
			currentPlayer.setBat(bet3);
		}

	}

	private void endOfRound() {
		Scanner in = new Scanner(System.in);
		int chois = 0;
		while (chois != 1 || chois != 2) {
			System.out.println("You have $" + currentPlayer.getDollars());
			System.out.println("Select an option:");
			System.out.println("1. play again \n2. for reset game");
			chois = in.nextInt();
			if (chois == 1) {
				playAgain();
			} else if (chois == 2) {
				BlackJackGameBoard newGame = new BlackJackGameBoard();
			}
		}

	}

	private void printFirstCardWithBack() {
		String[] faceCard = player2.getCard(0).getDrawCard().getFaceCard();
		String[] backCard = player2.getCard(0).getDrawCard().getBackCard();

		for (int i = 0; i < faceCard.length; i++) {
			System.out.print(faceCard[i] + " " + backCard[i]);
			System.out.println();
		}
		System.out.println(player2.getName() + " Points : " + player2.getCard(0).getNumRound());
		System.out.println();
	}

	private void printPlayersCards() {
		player2.printPlayerCards();
		System.out.println(player2.getName() + " Points : " + sumPoints(player2));

		player1.printPlayerCards();
		System.out.println(player1.getName() + " Points : " + sumPoints(player1));
		System.out.println();
	}
	
	private int sumPoints(Player player) {
		int sumCards = 0;
		int countAces = 0;
		Card[] playerCards = player.getPlayerCards();
		for (int i = 0; i < playerCards.length; i++) {
			if (playerCards[i].getNumRound() == 1) {
				countAces++;
				sumCards += 10;
			}
			sumCards += playerCards[i].getNumRound();
			if (sumCards > 21) {
				while (countAces > 0 && sumCards > 21) {
					sumCards -= 10;
					countAces--;
				}
			}
		}
		return sumCards;
	}

}
