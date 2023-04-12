import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.nio.file.FileSystems;

public class Top {
	
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	Game game;
	public Top(GameBoard board, Game game) {
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "North.png";
		try {image = ImageIO.read(new File(imagePath));} 
		catch (IOException e) {e.printStackTrace();}
		this.game = game;
	}
	
	public void update(Keyboard k) {
		
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 0, null);
		g.setColor(Color.white);
		g.setFont(new Font("Bank Gothic Light BT", Font.PLAIN, C.NORTH_FONT_SIZE));
		g.drawString("Lives: " + game.getLives(), C.NORTH_TEXT_LIVES_X, C.NORTH_TEXT_Y);
		g.drawString("Stage: " + game.getStage(), C.NORTH_TEXT_STAGE_X, C.NORTH_TEXT_Y);
		g.drawString("Score: " + game.getScore(), C.NORTH_TEXT_SCORE_X, C.NORTH_TEXT_Y);
	}
}
