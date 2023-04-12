import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.IOException;

public class GameBoard extends JComponent {
	private final int FPS = 80; 
	private int view = C.MENU;
	private Game game;
	private Menu menu;
	private Left left;
	private Top top;
	private Right right;
	
	private CardLayout crdl;
	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;
	public JPanel crd2;
	public Crd1 crd1;
	public North north;
	public West west;
	public East east;
	public South south;
	public Center center;

	private Keyboard keyboard;
	private Color darkGray;
	private HighScore highScore;
	private RecentPlays recentPlays;
	
	public HighScore getHighScore(){return highScore;}
	public RecentPlays getRecentPlays(){return recentPlays;}
	public int getView(){return view;}
	public int getFPS(){return FPS;}

	public void setView(int view){this.view = view;}

	public GameBoard() {
		keyboard = new Keyboard();
		//setSize(new Dimension(1454, 937));

		crd1 = new Crd1();
		crd2 = new JPanel();
		crdl = new CardLayout();
		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();
		setLayout(crdl);
		add("Menu", crd1);
		add("Game", crd2);
		crd2.setLayout(new BorderLayout());

		north = new North();
		west = new West();
		east = new East();
		south = new South();
		center = new Center();
		highScore = new HighScore();
		recentPlays = new RecentPlays();
		
		crd2.add(north, BorderLayout.NORTH);
		crd2.add(west, BorderLayout.WEST);
		crd2.add(center, BorderLayout.CENTER);
		crd2.add(east, BorderLayout.EAST);
		crd2.add(south, BorderLayout.SOUTH);
		east.setLayout(new GridBagLayout());

		gbc.insets = C.HS_INSETS;
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.ipadx = C.LIST_WIDTH;
        gbc.ipady = C.LIST_HEIGHT;
		gbc.weightx = C.LIST_STD_WEIGHT;
        gbc.weighty = C.LIST_STD_WEIGHT;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		east.add(highScore, gbc);

		gbc2.insets = C.RP_INSETS;
		gbc2.gridx = GridBagConstraints.RELATIVE;
		gbc2.gridy = GridBagConstraints.RELATIVE;
		gbc2.ipadx = C.LIST_WIDTH;
        gbc2.ipady = C.LIST_HEIGHT;
		gbc2.weightx = C.LIST_STD_WEIGHT;
        gbc2.weighty = C.LIST_STD_WEIGHT;
		gbc2.anchor = GridBagConstraints.LINE_START;
		east.add(recentPlays, gbc2);

		north.setPreferredSize(C.NORTH_SIZE);
		west.setPreferredSize(C.WEST_SIZE);
		east.setPreferredSize(C.EAST_SIZE);
		center.setPreferredSize(C.CENTER_SIZE);
		south.setPreferredSize(C.SOUTH_SIZE);
		crd1.setLayout(null);
		
		game = new Game(this);
		menu = new Menu(this);
		left = new Left(this);
		right = new Right(this, game);
		top = new Top(this, game);
	}

	public class Crd1 extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(C.DARK_GRAY);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			menu.draw(graphics);
		}
	}
	
	public class North extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(C.DARK_GRAY);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			top.draw(graphics);
		}
	}
	public class West extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(C.DARK_GRAY);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			left.draw(graphics);
		}
	}
	public class Center extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(C.DARK_GRAY);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			game.draw(graphics);
		}
	}
	public class East extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(C.DARK_GRAY);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			right.draw(graphics);
		}
	}
	public class South extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(C.DARK_GRAY);
			graphics.fillRect(0, 0, getWidth(), getHeight());
		}
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
		while(true){
			while(view==C.GAME) {
				game.update(keyboard);
				try {Thread.sleep(1000 / FPS);} 
				catch (InterruptedException e) {e.printStackTrace();}
				north.repaint();
				west.repaint();
				east.repaint();
				center.repaint();
			}
			crdl.show(this, "Menu");
			while(view==C.MENU){
				crd1.repaint();
			}
			crdl.show(this, "Game");
			requestFocus();
			game.setPlayer();
            
		}
	}
}
