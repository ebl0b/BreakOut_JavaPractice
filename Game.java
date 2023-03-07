import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.FileSystems;
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
	GameBoard board;
	ResetterGameOver resetterGameOver = new ResetterGameOver();
	ResetterStageComplete resetterStageComplete = new ResetterStageComplete();
	int score, lives, stage;
	String audioPath;
	String currentDir;
	String playerName = "---";
	JOptionPane playerNameInput;
	PauseMenu pauseMenu;
	
	public int getScore() {return score;}
	public int getLives() {return lives;}
	public int getStage() {return stage;}

	public Game(GameBoard board) {
		score = grid.getScore();
		lives = 3;
		stage = 1;
		currentDir = System.getProperty("user.dir");
		audioPath = currentDir + FileSystems.getDefault().getSeparator() + "krock.wav.";
		this.board = board;
		pauseMenu = new PauseMenu(board, this);
	}

	public void update(Keyboard keyboard) {

		if(!pauseMenu.isVisible()){pauseMenu.show(keyboard);}
		if(pauseMenu.isVisible()) board.requestFocusInWindow();

		ball.update(keyboard);
		bat.update(keyboard);
		
		int batc = bat.checkCol(ball);
		int gridc = grid.checkCol(ball);
		int edgesc = edges.checkCol(ball);
		
		score = grid.getScore();
		if(batc!=2||gridc!=2||edgesc!=2) {audio();}
		
		if(batc==1) {ball.spin(keyboard); ball.invertDy();}
		if(edgesc==1||gridc==1) {ball.invertDy();}
		if(batc==0||edgesc==0||gridc==0) {ball.invertDx();}
		if(batc==-1||edgesc==-1||gridc==-1) {ball.invertDx(); ball.invertDy();}
		
		if(ball.checkHeight(grid, lives)==1) {resetterGameOver.reset(board, this);}
		if(ball.checkHeight(grid, lives)==-1) {lives--; ball.reset();}
		if(grid.checkState()==true) {stage++; lives=3; resetterStageComplete.reset(grid, ball, score);}
	}
	
	public void audio() {
		try {
			Clip krock = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(audioPath));
			krock.open(inputStream);
			krock.start();}
			catch (Exception e) {}
	}

	public void draw(Graphics2D graphics) {
		ball.draw(graphics);
		bat.draw(graphics);
		grid.draw(graphics);
	}

	public void setPlayer(){
		JFrame tmp = new JFrame();
		playerName = JOptionPane.showInputDialog("Who's playing?");
		
	}
	public void reset(){
		board.requestFocusInWindow();
		grid.reset();
		ball.reset();
		bat.reset();
		if(board.highScore.scoreCmp(score)==true){
			board.highScore.addHighScore(playerName, score);
		}
		board.recentPlays.addPlay(score);
		stage = 1;
		lives = 3;
		grid.setScore(0);
	}
}
