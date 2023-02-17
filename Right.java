import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Right {
	
	BufferedImage image = null;
	public Right(GameBoard board, Game game) {
		try {image = ImageIO.read(new File("C:\\Users\\edvin\\OneDrive\\Skrivbord\\Assets\\Assets\\East.png"));} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void update(Keyboard k) {
		
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 0, null);
	}
}
