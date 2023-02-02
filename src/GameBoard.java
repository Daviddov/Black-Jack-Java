
public class GameBoard {
	CardsPackage cardPackage;
	Player player1 ;
	Player player2 ;
	Player curentPlayer;
	public GameBoard() {
		cardPackage = new CardsPackage();
		cardPackage.shuffelPack();
		 player1 =new Player("david");
		 player2 = new Player("Computer") ;
		 curentPlayer = player1;
		 play();
		 play();
		 play();
		 play();
		// turn
	
		// ruls -->  more then 21, black jack, below 21 most close to 
	}
	
	private void hit() {
//		if(!gameOver()) {
			
			curentPlayer.takeCard(cardPackage.pickCard());
			if(isBurned(curentPlayer)) {
				System.out.println(curentPlayer.getName() +" is burned " + curentPlayer.getSum());
				
			}else if(isBlackJack(curentPlayer)) {
				System.out.println(curentPlayer.getName() +"you have Black jack");
			};
			isBlackJack(curentPlayer);
//		}
	}
	
	public void play() {
		hit();
		player1.getAndPrintPlayerCards();
		System.out.println("player1 sum : "+player1.getSum());
		nextPlayer();
		
//		if(!gameOver()) {
		hit();
//		}
	}
	
	public void stand() {
		nextPlayer();
		hit();
	}
	private void nextPlayer() {
		if(curentPlayer == player1) {
			curentPlayer = player2;
		}else {
			curentPlayer = player1;
		}
	}
	public boolean isBurned(Player playerName) {
		if(playerName.getSum() > 21) {
			return true;
		}
		return false;
	}
	public boolean isBlackJack(Player playerName) {
		if(playerName.getSum() == 21) {
			return true;
		}
		return false;
	}
//	public boolean gameOver() {
//		if(isBurned(player1) || isBlackJack(player1)||isBurned(player2) || isBlackJack(player2) ) {
//			return true;
//		}
//		return false;
//	}
}
