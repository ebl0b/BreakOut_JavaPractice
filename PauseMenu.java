import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PauseMenu extends JPopupMenu{
	JMenuItem continu;
	JMenuItem restart;
	JMenuItem quit;
	JMenuItem returnTo;
	GameBoard board;
	Game game;
	Boolean state = false;

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

		 setInvoker(null);
         //setModal(true);

		continu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				board.requestFocusInWindow();
				state = true;
				
			}
		});
		restart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				board.requestFocusInWindow();
				game.reset();
				state = true;
			}
		});
		returnTo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				game.reset();
				board.view = 0;
				state = true;
				
			}
		});
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}

	public void showc(Keyboard k){
		Boolean tmp = false;

		while(k.isKeyDown(Key.Escape)){
			tmp = true;
		}
		if(tmp == true){
			this.show(board, 410, 250);
			while(state==false){
				try {Thread.sleep(1000 / board.FPS);} 
				catch (InterruptedException e) {e.printStackTrace();}
			}
			state = false;
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