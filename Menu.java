import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class Menu implements ActionListener
{
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	GameBoard board;
	JButton play;
	JButton quit;

	public Menu(GameBoard board)
	{
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "Menu.png";
		try {image = ImageIO.read(new File(imagePath));} 
		catch (IOException e) {e.printStackTrace();}
		this.board = board;
		play = new JButton();
		quit = new JButton();
		play.addActionListener(this);
		quit.addActionListener(this);
		board.crd1.add(play);
		board.crd1.add(quit);
		play.setBounds(C.PLAY_BOUNDS);
		quit.setBounds(C.QUIT_BOUNDS);
		play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		play.setOpaque(false);
		quit.setOpaque(false);
		play.setContentAreaFilled(false);
		quit.setContentAreaFilled(false);
		play.setBorderPainted(false);
		quit.setBorderPainted(false);
	}

	public void draw(Graphics g)
	{
		g.drawImage(image, 0, 0, null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == play){
			board.setView(C.GAME);
		}
		if(e.getSource() == quit){
			System.exit(0);
		}
	}
}