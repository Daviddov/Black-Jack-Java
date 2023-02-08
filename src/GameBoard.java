import java.util.Scanner;

public class GameBoard {
	CardsPackage cardPackage;
	private Player player1;
	private Player player2;
	private Player currentPlayer;

	public GameBoard() {
		cardPackage = new CardsPackage();
		cardPackage.shufflePack();
		player1 = new Player("david");
		player2 = new Player("Computer");
		currentPlayer = player1;	
		play();
	
		// ruls -->  below 21 most close to
	}

	public void play() {
		
		Scanner in = new Scanner(System.in);
		while(!gameOver()) {
			System.out.println("enter your move:");
			System.out.println("1. Hit");
			System.out.println("2. Stend");
			if(in.nextInt()==1) {
				makeTurn();
				player1.getAndPrintPlayerCards();
				System.out.println(player1.getName()+" Points : " + player1.getSum());
				System.out.println();
			}else if(in.nextInt()==2){
				stand();
			}
		}
		while(in.nextInt()!= 3) {
		System.out.println("Enter 3. for new game:");
		if(in.nextInt()== 3) {
			GameBoard newGame = new GameBoard();
		}
		}
		}
	private void hit() {
		if(gameOver()) {
			return;
		}
		currentPlayer.takeCard(cardPackage.pickCard());
		if (isBurned(currentPlayer)) {
			System.out.println(currentPlayer.getName() + " is burned " + currentPlayer.getSum());

		} else if (isBlackJack(currentPlayer)) {
			System.out.println(currentPlayer.getName() + " have Black jack");
		}
		
		isBlackJack(currentPlayer);
		
	}

	private void computerTurn() {
		nextPlayer();
		double random = Math.random();
		if(random>0.5) {	
		hit();
		}else {
			nextPlayer();
		}
	}

	private void makeTurn() {
			hit();
			computerTurn();
		}

	public void stand() {
		nextPlayer();
		hit();
	}

	private void nextPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
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

			player2.getAndPrintPlayerCards();
			System.out.println(player2.getName()+" Points : " + player2.getSum());
			System.out.println();
			return true;
		}
		return false;
	}
	
	
}
