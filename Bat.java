import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;

public class Bat extends Sprite{
	
	BufferedImage image = null;
	String imagePath;
	String currentDir;
	private int dx;
	private int dnorth, dsouth, dwest, deast;
	public Bat(int x, int y, int width, int height, int dx) {
		super(x, y, width, height);
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
	
	
	
	public int checkCol(Ball ball) {
		if(ball.getP1x()<getP2x()&&ball.getP2x()>getP1x()&&ball.getP1y()<getP2y()&&ball.getP2y()>getP1y()) {
			dnorth = Math.abs(ball.getP2y()-getP1y()); dsouth = Math.abs(ball.getP1y()-getP2y());
			dwest = Math.abs(ball.getP2x()-getP1x()); deast = Math.abs(ball.getP1x()-getP2x());
			
			if(dnorth<dsouth&&dnorth<dwest&&dnorth<deast) {ball.setY(ball.getY()-10); return 1;}
			if(dsouth<dnorth&&dsouth<dwest&&dsouth<deast) {ball.setY(ball.getY()+10); return 1;}
			if(dwest<dsouth&&dwest<dnorth&&dwest<deast) {ball.setX(ball.getX()-10); return 0;}
			if(deast<dsouth&&deast<dwest&&deast<dnorth) {ball.setX(ball.getX()+10); return 0;}
			else return -1;
			
		}	
		else return 2;
		
	}
}