import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ball extends Sprite{
	private int dx, dy, hp;

	BufferedImage image = null;
	public Ball(int x, int y, int width, int height, int dx, int dy) {
		super(x, y, width, height);
		this.dx = dx;
		this.dy = dy;
		hp = 3;
		try {image = ImageIO.read(new File("C:\\Users\\Edvin\\Desktop\\temp-20230208T223341Z-001\\temp\\Bounce001\\Ball.png"));}
		catch (IOException e) {e.printStackTrace();}
	}

	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
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
	public void checkHeight(Grid grid) {
		if(getY()>768) {
			hp--;
			if(hp<0) {
				JFrame f = new JFrame();
				JOptionPane mes = new JOptionPane();
				int choice = mes.showConfirmDialog(f, "Game Over! Restart?");
				if(choice == JOptionPane.NO_OPTION) {System.exit(0);}
				if(choice == JOptionPane.YES_OPTION) {
					grid.reset();
					setDx(-7);
					setDy(-7);
					setX(497);
					setY(600);
					setHp(3);
				}
			}
			else {
				setDx(-7);
				setDy(-7);
				setX(497);
				setY(600);
			}
		}
	}

}
