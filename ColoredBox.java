
import java.awt.Color;
import java.awt.Graphics2D;

public class ColoredBox extends Sprite{
	private Color color;
	private Boolean isTransparent;
	private int dnorth, dsouth, dwest, deast;
	public Boolean getIsTransparent() {
		return isTransparent;
	}

	public void setIsTransparent(Boolean isTransparent) {
		this.isTransparent = isTransparent;
	}

	public Color getColor() {
		return color;
	}

	public ColoredBox(int x, int y, int width, int height, Color color, Boolean isTransparent) {
		super(x, y, width, height);
		this.color = color;
		this.isTransparent = isTransparent;
		setP1x(x);
		setP1y(y);
		setP2x(x+width);
		setP2y(y+height);
	}

	@Override
	public void update(Keyboard k) {

	}

	@Override
	public void draw(Graphics2D g) {
		
	}
	public int checkCol(Ball ball) {
		if(ball.getP1x()<getP2x()&&ball.getP2x()>getP1x()&&ball.getP1y()<getP2y()&&ball.getP2y()>getP1y()) {
			dnorth = Math.abs(ball.getP2y()-getP1y()); dsouth = Math.abs(ball.getP1y()-getP2y());
			dwest = Math.abs(ball.getP2x()-getP1x()); deast = Math.abs(ball.getP1x()-getP2x());
			
			if(dnorth<dsouth&&dnorth<dwest&&dnorth<deast) return 1;
			if(dsouth<dnorth&&dsouth<dwest&&dsouth<deast) return 1;
			if(dwest<dsouth&&dwest<dnorth&&dwest<deast) return 0;
			if(deast<dsouth&&deast<dwest&&deast<dnorth) return 0;
			else return 1;
			
		}	
		else return 2;
		
	}
}
