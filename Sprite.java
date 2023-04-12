import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.FileSystems;
import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.*;

public abstract class Sprite {
	private String audioPath;
	private String currentDir;
	private int x, y, width, height, p1x, p1y, p2x, p2y;
	public int getP1x() {return p1x;}
	public void setP1x(int p1x) {this.p1x = p1x;}
	public int getP1y() {return p1y;}
	public void setP1y(int p1y) {this.p1y = p1y;}
	public int getP2x() {return p2x;}
	public void setP2x(int p2x) {this.p2x = p2x;}
	public int getP2y() {return p2y;}
	public void setP2y(int p2y) {this.p2y = p2y;}
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public void setX(int x) { this.x = x; };
	public void setY(int y) { this.y = y; };
	public void setWidth(int width) { this.width = width; };
	public void setHeight(int height) { this.height = height; };
	public Sprite(Rectangle bounds) {
		this.x = bounds.x;
		this.y = bounds.y;
		this.width = bounds.width;
		this.height = bounds.height;
	}
	public abstract void update(Keyboard keyboard);
	public abstract void draw(Graphics2D graphics);
}
