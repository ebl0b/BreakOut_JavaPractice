import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.applet.*;
import javax.swing.JOptionPane;

public class Game {
	
	Ball ball = new Ball(497, 600, 30, 30, -7, -7);
	Bat bat = new Bat(422, 700, 160, 30, 10);
	Edges edges = new Edges();
	Grid grid = new Grid(4, 10);
	private int score, lives, stage;
	
	public Game(GameBoard board) {
		score = 0;
		lives = 3;
		stage = 1;
	}

	public void update(Keyboard keyboard) {
		
		ball.update(keyboard);
		bat.update(keyboard);
		
		int batc = bat.checkCol(ball);
		int gridc = grid.checkCol(ball);
		int edgesc = edges.checkCol(ball);
		
		if(batc!=2||gridc!=2||edgesc!=2) {audio();}
		
		if(batc==1) {ball.spin(keyboard); ball.invertDy();}
		if(edgesc==1||gridc==1) {ball.invertDy();}
		if(batc==0||edgesc==0||gridc==0) {ball.invertDx();}
		
		ball.checkHeight(grid);
	}
	
	public void audio() {
		try {
			Clip krock = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Edvin\\Desktop\\temp-20230208T223341Z-001\\temp\\Bounce001\\krock.wav"));
			krock.open(inputStream);
			krock.start();}
			catch (Exception e) {}
	}

	public void draw(Graphics2D graphics) {
		ball.draw(graphics);
		bat.draw(graphics);
		grid.draw(graphics);
		
		
	}
}
