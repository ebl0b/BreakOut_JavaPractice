import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Mouse
{
	MouseListener l;
	private Boolean state = false;
	private int x;
	private int y;
	public Mouse()
	{

		l = new MouseAdapter(){
			public void mouseClicked(MouseEvent m){
				if(m.getClickCount()>0){
					x = m.getX();
					y = m.getY();
					state = true;
				}
			}
			public void mouseReleased(MouseEvent m){
				if(m.getClickCount()==0){
					state = false;
				}
			}

		};
	}
	public Boolean getState(){return state;}
	public int getX(){return x;}
	public int getY(){return y;}
}