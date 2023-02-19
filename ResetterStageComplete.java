import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResetterStageComplete extends Resetter{
	private int score;
	public void reset(Grid grid, Ball ball, int score) {
		JFrame f = new JFrame();
		JOptionPane mes = new JOptionPane();
		int choice = mes.showConfirmDialog(f, "Stage Completed with a score of: " + score + "! Continue?");
		if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
		if(choice == JOptionPane.YES_OPTION) {grid.reset(); ball.reset();}
	}
}
