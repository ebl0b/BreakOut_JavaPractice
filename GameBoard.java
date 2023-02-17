import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JComponent {
	private final int FPS = 80; 
	private Game game;
	private Left left;
	private Top top;
	private Right right;
	private Keyboard keyboard;
	Color darkGray;
	
	North north;
	West west;
	East east;
	South south;
	Center center;
	
	public GameBoard() {
		darkGray = new Color(40,36,36);
		keyboard = new Keyboard();
		setLayout(new BorderLayout());
		setSize(new Dimension(1454, 937));
		
		north = new North();
		west = new West();
		east = new East();
		south = new South();
		center = new Center();
		
		add(north, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		
		north.setPreferredSize(new Dimension(1440, 135));
		west.setPreferredSize(new Dimension(45, 795));
		east.setPreferredSize(new Dimension(360, 795));
		center.setPreferredSize(new Dimension(1035, 795));
		south.setPreferredSize(new Dimension(1035, 0));
		
		game = new Game(this);
		left = new Left(this);
		right = new Right(this, game);
		top = new Top(this, game);
		
	}
	
	public class North extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(darkGray);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			top.draw(graphics);
		}
	}
	public class West extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(darkGray);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			left.draw(graphics);
		}
	}
	public class Center extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(darkGray);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			game.draw(graphics);
		}
	}
	public class East extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(darkGray);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			right.draw(graphics);
		}
	}
	public class South extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(darkGray);
			graphics.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1440, 900);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		game.draw(graphics);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true) {
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
