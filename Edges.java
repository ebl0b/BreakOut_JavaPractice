import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Edges {
	ArrayList<ColoredBox> arr;
	public Edges() {
		arr = new ArrayList<ColoredBox>();
		arr.add(new ColoredBox(1035, 0, 30, 765, Color.GRAY, false));
		arr.add(new ColoredBox(-30, 0, 30, 765, Color.GRAY, false));
		arr.add(new ColoredBox(0, -30, 1035, 30, Color.GRAY, false));
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.GRAY);
		for(int i = 0; i<3; i++) {
			g.fillRect(arr.get(i).getX(), arr.get(i).getY(), arr.get(i).getWidth(), arr.get(i).getHeight());
		}
	}
	public int checkCol(Ball ball) {
		for(int i = 0; i<3; i++) {
			if(arr.get(i).checkCol(ball)==1) {return 1;}
			if(arr.get(i).checkCol(ball)==0) {return 0;}
		}
		return 2;
	}
}
