import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Constructs a new Human Player class with a new Othello game, the player is ready to
 * play with other users or with the computer (if applicable) the player can be 
 * used by giving human interaction input at the console 
 * @author code by UTM Computer Science department staff and JavaDoc comments 
 * by Student Name: Ahmed Al-Mandalawi
 */
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;

	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}
	/**
	 * This method is a helper function for the other getMove() method 
	 * takes/records and registers human typing inputs from the 
	 * console for the row as well as for the column and plugs them into a 
	 * new Move method as user input parameters for the returned method.
	 * 
	 * @return returns a new Move method with the used console inputs row 
	 * and col (inputted by human) as it's two parameters
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}
	/**
	 * This method handles and analysis human interaction inputs at the console  
	 * this method takes in a parameter string message which is given by the 
	 * human player and prints it out and assigns it as a line string variable 
	 * then it converts it to an integer and assigns it to the variable move
	 * the integer variable move then gets handled by an if statement
	 * which returns the variable iff it was bigger and equal to 0 and
	 * smaller and equal to 7 otherwise it will print line INVALID_INPUT_MESSAGE
	 * the methods also handles "IOException e" and "NumberFormatException e"
	 * of the human user typed console and input. Once caught these two Exceptions
	 * the methods prints line INVALID_INPUT_MESSAGE.
	 * 
	 * @param String message human user typing console input 
	 * @return integer move if it was a right move -1 otherwise
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
