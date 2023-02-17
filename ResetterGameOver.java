import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResetterGameOver extends Resetter{
	public void reset(Grid grid, Ball ball) {
		JFrame f = new JFrame();
		JOptionPane mes = new JOptionPane();
		int choice = mes.showConfirmDialog(f, "Game Over! Restart?");
		if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
		if(choice == JOptionPane.YES_OPTION) {
			grid.reset();
			ball.reset();
		}
	}
}
