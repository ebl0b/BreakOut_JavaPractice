import java.awt.*;
import java.awt.Graphics2D;
import java.util.*;

public class Row 
{
	private ArrayList<Box> row;
	private int columns;
	private int tmpx, tmpy;
	private int x, y;
	private Grid grid;

	public Row(int y, Grid grid) 
	{
		row = new ArrayList<Box>();
		row.ensureCapacity(10);
		columns = C.COLUMNS;
		this.y = y;
		this.grid = grid;
		reset();
	}

	public void draw(Graphics2D g) 
	{
		for(int i = 0; i<columns; i++) {
			if(row.get(i).getIsTransparent()==false) {row.get(i).draw(g);}
		}
	}

	private void boxConversion(int i)
	{
		row.get(i).audio();
		tmpx = row.get(i).getX(); tmpy = row.get(i).getY();
		if(row.get(i) instanceof GreenBox){
			row.set(i, new BlueBox(tmpx, tmpy, C.BOX_SIZE)); 
			grid.setScore(grid.getScore()+1);
		}
		else if(row.get(i) instanceof BlueBox){
			row.set(i, new RedBox(tmpx, tmpy, C.BOX_SIZE));
			grid.setScore(grid.getScore()+1);
		}
		else if(row.get(i) instanceof RedBox){
			row.get(i).setIsTransparent(true);
			grid.setScore(grid.getScore()+1);
		}
		else if(row.get(i) instanceof PurpleBox){
			row.get(i).setIsTransparent(true);
			grid.setScore(grid.getScore()+2);
		}
	}
	public int checkCol(Ball ball) 
	{
		for(int i = 0; i<columns; i++) {
			int rowc = row.get(i).checkCol(ball);
			if(rowc==C.HORIZONTAL_COL&&row.get(i).getIsTransparent()==false) {
				boxConversion(i);
				return C.HORIZONTAL_COL;
			}
			else if(rowc==C.VERTICAL_COL&&row.get(i).getIsTransparent()==false) {
				boxConversion(i);
				return C.VERTICAL_COL;
			}
			else if(rowc==C.CORNER_COL&&row.get(i).getIsTransparent()==false){
				boxConversion(i);
				return C.CORNER_COL;
			}
		}
		return 2;
	}
	public void reset() {
		x = C.GRID_X_DISPLACEMENT;
		Random rand = new Random();
		for(int i = 0; i<columns; i++) {
			//row.clear();
			rand = new Random();
			int rnum = rand.nextInt(10); //genererar slumpat tal mellan 0 och 9
			System.out.println("reset " + i + " " + rnum);
			if(rnum==0||rnum==1||rnum==2) {row.add(i, new RedBox(x, y, C.BOX_SIZE));}
			if(rnum==3||rnum==4||rnum==5) {row.add(i, new BlueBox(x, y, C.BOX_SIZE));}
			if(rnum==6||rnum==7) {row.add(i, new GreenBox(x, y, C.BOX_SIZE));}
			if(rnum==8||rnum==9) {row.add(i, new PurpleBox(x, y, C.BOX_SIZE));}
			x+=C.BOX_X_DISPLACEMENT;
		}
	}

	public Boolean checkRowCleared() {
		for(int i = 0; i<columns; i++) {
			if(row.get(i).getIsTransparent()==false) {return false;}
		}
		return true;
	}
}
