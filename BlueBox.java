import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueBox extends ColoredBox{
	
	BufferedImage image = null;
	public BlueBox(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLUE, false);
		try {image = ImageIO.read(new File("C:\\Users\\Edvin\\Desktop\\temp-20230208T223341Z-001\\temp\\Bounce001\\BlueBox.png"));} 
		catch (IOException e) {e.printStackTrace();}
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}
}
