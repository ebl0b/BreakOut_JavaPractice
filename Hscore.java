import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Hscore
{
	private String name;
	private int score;
	private Vector<Object> vec;
	private Vector<Object> vecScore;

	public Hscore(String name, int score)
	{
		vec = new Vector<Object>();
		vecScore = new Vector<Object>();
		this.name = name;
		this.score = score;
		vecScore.add(0, score);
		vec.add(0, name);
		vec.add(1, score);
	}

	public String getName(){return name;}
	public Vector<Object> getScore(){return vecScore;}
	public Vector<Object> getVec(){return vec;}
}