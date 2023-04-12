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
		setPreferredSize(C.PAUSE_SIZE);

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
				game.reset(C.FULL_RESET);
				state = true;
			}
		});
		returnTo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				game.reset(C.FULL_RESET);
				board.setView(C.MENU);
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
			this.show(board, C.PAUSE_X, C.PAUSE_Y);
			while(state==false){
				try {Thread.sleep(1000 / board.getFPS());} 
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