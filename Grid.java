import java.awt.Graphics2D;
import java.util.*;

public class Grid {
	ArrayList<Row> grid;
	private int y = 80;
	private int rows, columns;
	
	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		grid = new ArrayList<Row>();
		for(int i = 0; i<rows; i++) {
			grid.add(new Row(columns, y));
			y+=55;
		}
	}
	public void draw(Graphics2D g) {
		for(int i = 0; i<rows; i++) {
			grid.get(i).draw(g);
		}
	}
	public int checkCol(Ball ball) {
		for(int i = 0; i<rows; i++) {
			int gridc = grid.get(i).checkCol(ball);
			if(gridc==1) {return 1;}
			if(gridc==0) {return 0;}
		}
		return 2;
	}
	public void reset() {
		for(int i = 0; i<rows; i++)
			grid.get(i).reset();
	}
	
	public Boolean checkState() {
		for(int i = 0; i<rows; i++) {
			if(grid.get(i).checkState()==false) {return false;}
		}
		return true;
	}
}
