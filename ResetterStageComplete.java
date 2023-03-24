import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResetterStageComplete{
	private int score;
	public void reset(GameBoard board, Game game) {
		JOptionPane mes = new JOptionPane();
		int choice = mes.showConfirmDialog(board, "Stage cleared!\nYour score was: " + game.score + "\nContinue?");
		if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
		if(choice == JOptionPane.YES_OPTION) {game.reset(0);}
	}
}
