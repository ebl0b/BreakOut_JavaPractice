import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;

public class Bat extends Box{
	
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	private int dx;
	public Bat(int x, int y, int width, int height, int dx) {
		super(x, y, width, height, false);
		this.dx = dx;
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "Bat.png";
		try {image = ImageIO.read(new File(imagePath));} 
		catch (IOException e) {e.printStackTrace();}
	}

	@Override
	public void update(Keyboard k) {

		if(k.isKeyDown(Key.Z)&&getX()>10) {setX(getX()-dx);}
		if(k.isKeyDown(Key.X)&&getX()+getWidth()<1025) {setX(getX()+dx);}
		if(k.isKeyDown(Key.Z)&&getX()>10&&k.isKeyDown(Key.Space)) {setX(getX()-2*dx);}
		if(k.isKeyDown(Key.X)&&getX()+getWidth()<1025&&k.isKeyDown(Key.Space)) {setX(getX()+2*dx);}
		
		setP1x(getX());
		setP1y(getY());
		setP2x(getX()+getWidth());
		setP2y(getY()+getHeight());
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}
	
	public void reset(){
		setX(422);
		setY(700);
	}
}