import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResetterStageComplete extends Resetter{
	public void reset(Grid grid, Ball ball) {
		JFrame f = new JFrame();
		JOptionPane mes = new JOptionPane();
		int choice = mes.showConfirmDialog(f, "Stage Complete! Continue?");
		if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
		if(choice == JOptionPane.YES_OPTION) {grid.reset(); ball.reset();}
	}
}
