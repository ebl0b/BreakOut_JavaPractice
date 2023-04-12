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
import java.util.*;

public class Ball extends Sprite
{
	private int dx, dy;
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	public Ball() 
	{
		super(C.BALL_BOUNDS);
		dRandomize();
		this.dy = C.BALL_DY;
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
		if(k.isKeyDown(Key.X)&&getDx()<=0) {setDx(getDx()+C.BALL_SPIN);}
		if(k.isKeyDown(Key.Z)&&getDx()<0) {setDx(getDx()-C.BALL_SPIN);}
		if(k.isKeyDown(Key.X)&&getDx()>0) {setDx(getDx()+C.BALL_SPIN);}
		if(k.isKeyDown(Key.Z)&&getDx()>=0) {setDx(getDx()-C.BALL_SPIN);}
	}
	
	public void invertDy() {setDy(-getDy());}
	public void invertDx() {setDx(-getDx());}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, getX(), getY(), null);
	}
	public int checkHeight(Grid grid, int lives) {
		if(getY()>C.SOUTH_EDGE && lives<=0) {return C.CASE_GAME_OVER;}
		if(getY()>C.SOUTH_EDGE && lives>0) {return C.CASE_OUT_OF_BOUNDS;}
		else return 0;
	}

	private void dRandomize()
	{
		int rdx;
		Random rand = new Random();
		rdx = rand.nextInt(15)-7; //genererar ett slumpat tal mellan -7 och 7
		setDx(rdx);
	}
	
	//test
	public void reset() {
		dRandomize();
		setDy(C.BALL_DY);
		setX(C.BALL_START_X);
		setY(C.BALL_START_Y);
	}

}
