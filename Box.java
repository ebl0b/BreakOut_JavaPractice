import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.FileSystems;
import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.*;

public abstract class Box extends Sprite
{
	private Boolean isTransparent;
	private int dnorth, dsouth, dwest, deast;
	private String audioPath;
	private String currentDir;
	private File audioFile;

	public Box(Rectangle bounds, Boolean isTransparent){
		super(bounds);
		this.isTransparent = isTransparent;
		currentDir = System.getProperty("user.dir");
		audioPath = currentDir + FileSystems.getDefault().getSeparator() + "krock.wav.";
		audioFile = new File(audioPath);
		setP1x(bounds.x);
		setP1y(bounds.y);
		setP2x(bounds.x+bounds.width);
		setP2y(bounds.y+bounds.height);
	}

	public Boolean getIsTransparent() {return isTransparent;}
	public void setIsTransparent(Boolean isTransparent) {this.isTransparent = isTransparent;}

	public void audio() {
		try {
			Clip krock = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioFile);
			krock.open(inputStream);
			krock.start();}
			catch (Exception e) {}
	}
	public int checkCol(Ball ball) {
		if(ball.getP1x()<getP2x()&&ball.getP2x()>getP1x()&&ball.getP1y()<getP2y()&&ball.getP2y()>getP1y()) {
			dnorth = Math.abs(ball.getP2y()-getP1y()); dsouth = Math.abs(ball.getP1y()-getP2y());
			dwest = Math.abs(ball.getP2x()-getP1x()); deast = Math.abs(ball.getP1x()-getP2x());
	
			if(dnorth<dsouth&&dnorth<dwest&&dnorth<deast) {if(!getIsTransparent())ball.setY(ball.getY()-dnorth); return C.HORIZONTAL_COL;}
			if(dsouth<dnorth&&dsouth<dwest&&dsouth<deast) {if(!getIsTransparent())ball.setY(ball.getY()+dsouth); return C.HORIZONTAL_COL;}
			if(dwest<dsouth&&dwest<dnorth&&dwest<deast) {if(!getIsTransparent())ball.setX(ball.getX()-dwest); return C.VERTICAL_COL;}
			if(deast<dsouth&&deast<dwest&&deast<dnorth) {if(!getIsTransparent())ball.setX(ball.getX()+deast); return C.VERTICAL_COL;}
			else return C.CORNER_COL;
		}	
		else return 2;
	}
}