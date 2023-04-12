import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResetterGameOver extends JOptionPane{
	public void reset(GameBoard board, Game game) {

		int choice;
		choice = this.showConfirmDialog(board, "Game Over!\nYour score was: " + game.score + " \nRestart?");
		//this.setLocationRelativeTo(board.super);
		if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
		if(choice == JOptionPane.YES_OPTION) {
			game.reset(C.FULL_RESET);
		}
	}
}
