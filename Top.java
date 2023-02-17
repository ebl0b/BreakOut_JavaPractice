import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Top {
	
	BufferedImage image = null;
	Game game;
	public Top(GameBoard board, Game game) {
		try {image = ImageIO.read(new File("C:\\Users\\Edvin\\Desktop\\temp-20230208T223341Z-001\\temp\\Bounce001\\North.png"));} 
		catch (IOException e) {e.printStackTrace();}
		this.game = game;
	}
	
	public void update(Keyboard k) {
		
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 0, null);
		g.setColor(Color.white);
		g.setFont(new Font("Bank Gothic Light BT", Font.PLAIN, 35));
		g.drawString("Lives: " + game.ball.getHp(), 55, 75);
		g.drawString("Stage: ", 415, 75);
		g.drawString("Score: " + game.grid.getScore(), 820, 75);
	}
	
}
