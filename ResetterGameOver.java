import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResetterGameOver extends JOptionPane{
	public void reset(GameBoard board, Game game) {

		System.out.println("bruh");
		int choice;
		choice = this.showConfirmDialog(board, "Game Over! Restart?");
		//this.setLocationRelativeTo(board.super);
		if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
		if(choice == JOptionPane.YES_OPTION) {
			game.reset();
		}
	}
}
