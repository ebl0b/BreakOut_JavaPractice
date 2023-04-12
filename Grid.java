import java.awt.Graphics2D;
import java.util.*;
import java.awt.*;

public class Grid {
	private ArrayList<Row> grid;
	private int y = C.GRID_Y_DISPLACEMENT;
	private int rows, score = C.SCORE_0;
	
	public Grid() 
	{
		rows = C.ROWS;
		grid = new ArrayList<Row>();
		for(int i = 0; i<rows; i++) {
			grid.add(new Row(y, this));
			y+=C.ROW_Y_DISPLACEMENT;
		}
	}
	public void draw(Graphics2D g) 
	{
		for(int i = 0; i<rows; i++) {
			grid.get(i).draw(g);
		}
	}
	public int checkCol(Ball ball) 
	{
		for(int i = 0; i<rows; i++) {
			int gridc = grid.get(i).checkCol(ball);
			if(gridc==C.HORIZONTAL_COL) {return C.HORIZONTAL_COL;}
			if(gridc==C.VERTICAL_COL) {return C.VERTICAL_COL;}
			if(gridc==C.CORNER_COL) {return C.CORNER_COL;}
		}
		return 2;
	}
	public void reset() 
	{
		for(int i = 0; i<rows; i++)
			grid.get(i).reset();
	}

	public int getScore(){return score;}
	public void setScore(int val){score = val;}
	
	public Boolean checkGridCleared() 
	{
		for(int i = 0; i<rows; i++) {
			if(grid.get(i).checkRowCleared()==false) {return false;}
		}
		return true;
	}
}
