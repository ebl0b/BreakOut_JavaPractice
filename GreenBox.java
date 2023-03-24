import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;

public class GreenBox extends Box{
	
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	public GreenBox(int x, int y, int width, int height) {
		super(x, y, width, height, false);
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "GreenBox.png";
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
