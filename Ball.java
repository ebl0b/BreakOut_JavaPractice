import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ball extends Sprite{
	private int dx, dy;

	BufferedImage image = null;
	String imagePath;
	String currentDir;
	public Ball(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height);
		this.dx = dx;
		this.dy = dy;
		currentDir = System.getProperty("user.dir");
		imagePath = currentDir + FileSystems.getDefault().getSeparator() + "Ball.png";
		try {image = ImageIO.read(new File(imagePath));}
		catch (IOException e) {e.printStackTrace();}
	}

	public int getDx() {return dx;}
	public void setDx(int dx) {this.dx = dx;}
	public int getDy() {return dy;}
	public void setDy(int dy) {this.dy = dy;}

	@Override
	public void update(Keyboard k) {
		setX(getX()+dx);
		setY(getY()+dy);
		setP1x(getX()); setP1y(getY());
		setP2x(getX()+getWidth()); setP2y(getY()+getHeight());
	}
	
	public void spin(Keyboard k) {
		if(k.isKeyDown(Key.X)&&getDx()<=0) {setDx(getDx()+2);}
		if(k.isKeyDown(Key.Z)&&getDx()<0) {setDx(getDx()-2);}
		if(k.isKeyDown(Key.X)&&getDx()>0) {setDx(getDx()+2);}
		if(k.isKeyDown(Key.Z)&&getDx()>=0) {setDx(getDx()-2);}
	}
	
	public void invertDy() {setDy(-getDy());}
	public void invertDx() {setDx(-getDx());}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}
	public int checkHeight(Grid grid, int lives) {
		if(getY()>768&&lives<=0) {return 1;}
		if(getY()>768&&lives>0) {return -1;}
		else return 0;
	}
	
	public void reset() {
		setDx(-7);
		setDy(-7);
		setX(497);
		setY(600);
	}

}
