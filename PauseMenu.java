import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PauseMenu extends JPopupMenu{
	JMenuItem continu;
	JMenuItem restart;
	JMenuItem quit;
	JMenuItem returnTo;
	GameBoard board;
	Game game;

	public PauseMenu(GameBoard board, Game game){

		this.board = board;
		this.game = game;

		continu = new JMenuItem("Continue");
		restart = new JMenuItem("Restart");
		returnTo = new JMenuItem("Return to menu");
		quit = new JMenuItem("Quit");
		setPreferredSize(new Dimension(300, 400));

		add(continu);
		add(restart);
		add(returnTo);
		add(quit);

		continu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				board.requestFocusInWindow();
			}
		});
		restart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				board.requestFocusInWindow();
				game.reset();
			}
		});
		returnTo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				game.reset();
				board.view = 0;
			}
		});
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}

	public void show(Keyboard k){
		int tmp = 0;
		while(k.isKeyDown(Key.Escape)){
			if(tmp == 0)
				this.show(board, 410, 250);
			tmp++;
		}
	}
	public void close(Keyboard k){
		int tmp = 0;
		while(k.isKeyDown(Key.Escape)){
			if(tmp == 0){
				this.setVisible(false);
			}
			tmp++;
		}
	}

}