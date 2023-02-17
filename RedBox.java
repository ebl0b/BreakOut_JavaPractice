import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RedBox extends ColoredBox{
	
	BufferedImage image = null;
	public RedBox(int x, int y, int width, int height) {
		super(x, y, width, height, Color.RED, false);
		try {image = ImageIO.read(new File("C:\\Users\\edvin\\OneDrive\\Skrivbord\\Assets\\Assets\\RedBox.png"));} 
		catch (IOException e) {e.printStackTrace();}
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}

}
