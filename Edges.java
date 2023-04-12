import java.awt.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Edges {
	ArrayList<Box> arr;
	public Edges() {
		arr = new ArrayList<Box>();
		arr.add(new RedBox(C.EAST_EDGE_BOUNDS));
		arr.add(new RedBox(C.WEST_EDGE_BOUNDS));
		arr.add(new RedBox(C.NORTH_EDGE_BOUNDS));
	}
	public int checkCol(Ball ball) {
		for(Box i : arr) {
			int tmp = i.checkCol(ball);
			if(tmp==C.HORIZONTAL_COL) {i.audio(); return C.HORIZONTAL_COL;}
			if(tmp==C.VERTICAL_COL) {i.audio(); return C.VERTICAL_COL;}
			if(tmp==C.CORNER_COL){i.audio(); return C.CORNER_COL;}
		}
		return 2;
	}
}
