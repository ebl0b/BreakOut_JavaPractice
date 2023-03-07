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
	int view = 0;
	private Game game;
	private Menu menu;
	private Left left;
	private Top top;
	private Right right;
	private Keyboard keyboard;
	private Mouse mouse;
	Color darkGray;
	
	MouseListener l;
	CardLayout crdl;
	GridBagConstraints gbc;
	GridBagConstraints gbc2;
	JPanel crd2;
	Crd1 crd1;
	North north;
	West west;
	East east;
	South south;
	Center center;
	HighScore highScore;
	RecentPlays recentPlays;
	
	public GameBoard() {
		darkGray = new Color(40,36,36);
		keyboard = new Keyboard();
		mouse = new Mouse();
		setSize(new Dimension(1454, 937));

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
		gbc.insets = new Insets(0, 45, 0, 0);
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.ipadx = 250;
        gbc.ipady = 290;
		gbc.weightx = 1;
        gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		east.add(highScore, gbc);

		gbc2.insets = new Insets(364, -293, 0, 0);
		gbc2.gridx = GridBagConstraints.RELATIVE;
		gbc2.gridy = GridBagConstraints.RELATIVE;
		gbc2.ipadx = 250;
        gbc2.ipady = 290;
		gbc2.weightx = 1;
        gbc2.weighty = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;
		east.add(recentPlays, gbc2);

		//if(highScore.scoreCmp(999)==true)
			//highScore.addHighScore("test", 999);
		//center.requestFocusInWindow();

		north.setPreferredSize(new Dimension(1440, 135));
		west.setPreferredSize(new Dimension(45, 795));
		east.setPreferredSize(new Dimension(360, 795));
		center.setPreferredSize(new Dimension(1035, 795));
		south.setPreferredSize(new Dimension(1035, 0));
		crd1.setLayout(null);
		
		
		game = new Game(this);
		menu = new Menu(this);
		left = new Left(this);
		right = new Right(this, game);
		top = new Top(this, game);

		addMouseListener(l);
	}

	public class Crd1 extends JPanel{
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D graphics = (Graphics2D)arg0;
			graphics.setColor(Color.BLUE);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			menu.draw(graphics);
		}
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
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true){
			while(view==1) {
				//Component focusedComponent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
				//System.out.println(focusedComponent);
				game.update(keyboard);
				try {
					Thread.sleep(1000 / FPS); //Throttle thread
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				north.repaint();
				west.repaint();
				east.repaint();
				center.repaint();
				//this.repaint();
			}
			crdl.show(this, "Menu");
			while(view==0){
				
				crd1.repaint();
			}
			crdl.show(this, "Game");
			requestFocus();
			game.setPlayer();
            
		}
	}
}
