import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Edges {
	ArrayList<Box> arr;
	public Edges() {
		arr = new ArrayList<Box>();
		arr.add(new RedBox(1035, 0, 30, 765));
		arr.add(new RedBox(-30, 0, 30, 765));
		arr.add(new RedBox(0, -30, 1035, 30));
	}
	public int checkCol(Ball ball) {
		for(int i = 0; i<3; i++) {
			int tmp = arr.get(i).checkCol(ball);
			if(tmp==1) {arr.get(i).audio(); return 1;}
			if(tmp==0) {arr.get(i).audio(); return 0;}
		}
		return 2;
	}
}
