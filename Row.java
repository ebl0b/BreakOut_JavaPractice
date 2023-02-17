import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Row {
	Random rand;
	ArrayList<ColoredBox> row;
	private int len;
	private int rnum;
	private int tmpx, tmpy;
	int x = 20, y;
	public Row(int len, int y) {
		row = new ArrayList<ColoredBox>();
		this.len = len;
		this.y = y;
		for(int i = 0; i<len; i++) {
			rand = new Random();
			rnum = rand.nextInt(3);
			if(rnum==0) {row.add(new RedBox(x, y, 90, 45));}
			if(rnum==1) {row.add(new BlueBox(x, y, 90, 45));}
			if(rnum==2) {row.add(new GreenBox(x, y, 90, 45));}
			x+=100;
		}
	}
	public void draw(Graphics2D g) {
		for(int i = 0; i<len; i++) {
			if(row.get(i).getIsTransparent()==false) {
				row.get(i).draw(g);
				//g.fillRect(row.get(i).getX(), row.get(i).getY(), row.get(i).getWidth(), row.get(i).getHeight());
			}
		}
	}
	public int checkCol(Ball ball) {
		for(int i = 0; i<len; i++) {
			int rowc = row.get(i).checkCol(ball);
			if(rowc==1&&row.get(i).getIsTransparent()==false) {
				tmpx = row.get(i).getX(); tmpy = row.get(i).getY();
				if(row.get(i) instanceof GreenBox)
					row.set(i, new BlueBox(tmpx, tmpy, 90, 45)); 
				else if(row.get(i) instanceof BlueBox)
					row.set(i, new RedBox(tmpx, tmpy, 90, 45));
				else if(row.get(i) instanceof RedBox)
					row.get(i).setIsTransparent(true);
				return 1;
			}
			else if(rowc==0&&row.get(i).getIsTransparent()==false) {
				tmpx = row.get(i).getX(); tmpy = row.get(i).getY();
				if(row.get(i) instanceof GreenBox)
					row.set(i, new BlueBox(tmpx, tmpy, 90, 45)); 
				else if(row.get(i) instanceof BlueBox)
					row.set(i, new RedBox(tmpx, tmpy, 90, 45));
				else if(row.get(i) instanceof RedBox)
					row.get(i).setIsTransparent(true); 
				return 0;
			}
		}
		return 2;
	}
	public void reset() {
		x = 20;
		for(int i = 0; i<len; i++) {
			Random rand = new Random();
			int tmp = rand.nextInt(3);
			if(tmp==0) {row.set(i, new RedBox(x, y, 90, 45));}
			if(tmp==1) {row.set(i, new BlueBox(x, y, 90, 45));}
			if(tmp==2) {row.set(i, new GreenBox(x, y, 90, 45));}
			x+=100;
			
		}
	}
	public Boolean checkState() {
		for(int i = 0; i<len; i++) {
			if(row.get(i).getIsTransparent()==false) {return false;}
		}
		return true;
	}
}
