/**
 * 
 * Constructs a new OthelloController class with a new Othello game, ready to play
 * with two human users at the console. Player1 and Player2 and both PlayHuman classes
 * @author code by UTM Computer Science department staff and JavaDoc comments 
 * by Student Name: Ahmed Al-Mandalawi
 */
public class OthelloControllerHumanVSHuman {

	protected Othello othello;
	PlayerHuman player1, player2;

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with two users at the console.
	 */
	public OthelloControllerHumanVSHuman() {
		this.othello = new Othello();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerHuman(this.othello, OthelloBoard.P2);
	}
	
	/**
	 * This method takes in no parameters but once it is called it constructs 
	 * the game this functions brings in all other helper functions in this 
	 * class as well as other classes such PlayerHuman class, OthelloBoard class,
	 * and the Othello class using their methods as helper functions such as:
	 * reportMove(char whosTurn, Move move), report(), reportFinal(),
	 * othello.isGameOver(), player.getMove(), reportMove(), 
	 * othello.move(int row, int col), and othello.getWhoseTurn() 
	 * this method keeps the game rolling while othello.isGameOver() is not ture
	 * meaning the game is not over but once othello.isGameOver() is ture and 
	 * the game is over this function returns this.reportFinal() which is the 
	 * final score of the game indicating which player has won or it is a daw
	 * depending on the number of tokens earned by each player1 and player2
	 */
	public void play() {
		
		while (!othello.isGameOver()) {
			this.report();

			Move move = null;
			char whosTurn = othello.getWhoseTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}
	/**
	 * The method takes in the player with the whosTurn Player and a valid 
	 * coordinates(int row,int col) for a move then it constructs and prints
	 * a report of the move the player in turn to the provided move row and column.
	 * 
	 * @param whosTurn the player which takes the turn player1 or player2
	 * @param a valid move to the a specific coordinates (int row,int col)
	 * @return prints move report line "player makes move (int row,int col)"
	 */
	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}
	/**
	 * This method creates a string variable "s" which takes in the player's scores
	 * by using helper function othello.getCount(player) to display the tokens for each
	 * OthelloBoard.P1/player1 and OthelloBoard.P2/player2 as well as the player who 
	 * has the turn next and constructs and prints a line to display all in the form.
	 * 
	 * @return prints string variable s which shows for i.e. "X:2 O:2  X moves next"
	 */
	private void report() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  " 
				+ othello.getWhoseTurn() + " moves next";
		System.out.println(s);
	}

	/**
	 * This method creates a string variable "s" which takes in the player's final scores
	 * by using helper function othello.getCount(player) to display the final tokens for each
	 * OthelloBoard.P1/player1 and OthelloBoard.P2/player2 as well as the player who 
	 * has won the game and constructs and prints a line to display all in the form.
	 * 
	 * @return prints string variable s which shows for i.e. "X:13 O:0  X won"
	 */
	private void reportFinal() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) 
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}
	
	/**
	 * Run main to play two Humans against each other at the console.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman();
		oc.play();
	}

}
