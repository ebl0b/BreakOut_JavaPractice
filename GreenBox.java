import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GreenBox extends ColoredBox{
	
	BufferedImage image = null;
	public GreenBox(int x, int y, int width, int height) {
		super(x, y, width, height, Color.GREEN, false);
		try {image = ImageIO.read(new File("C:\\Users\\Edvin\\Desktop\\temp-20230208T223341Z-001\\temp\\Bounce001\\GreenBox.png"));} 
		catch (IOException e) {e.printStackTrace();}
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}
	
}
