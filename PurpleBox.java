import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;

public class PurpleBox extends Box{
	
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	public PurpleBox(Rectangle bounds) {
		super(bounds, false);
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "PurpleBox.png";
		try {image = ImageIO.read(new File(imagePath));} 
		catch (IOException e) {e.printStackTrace();}
	}
	public PurpleBox(int x, int y, Dimension size) {
		super(new Rectangle(new Point(x, y), size), false);
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "PurpleBox.png";
		try {image = ImageIO.read(new File(imagePath));} 
		catch (IOException e) {e.printStackTrace();}
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}
	@Override
	public void update(Keyboard k){}
}