import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.FileSystems;
import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.*;

public class Game 
{
	int score = 0;
	int lives = 3;
	int stage = 1;	
	String playerName = "---";

	Ball ball = new Ball(497, 600, 30, 30, -7);
	Bat bat = new Bat(422, 700, 160, 30, 10);
	Edges edges = new Edges();
	Grid grid = new Grid(4, 10);
	GameBoard board;
	ResetterGameOver resetterGameOver = new ResetterGameOver();
	ResetterStageComplete resetterStageComplete = new ResetterStageComplete();
	PauseMenu pauseMenu;
	
	public int getScore() {return score;}
	public int getLives() {return lives;}
	public int getStage() {return stage;}

	public Game(GameBoard board) {
		this.board = board;
		pauseMenu = new PauseMenu(board, this);
	}

	public void update(Keyboard keyboard) {

		if(!pauseMenu.isVisible()){pauseMenu.showc(keyboard);}

		ball.update(keyboard);
		bat.update(keyboard);
		
		int batc = bat.checkCol(ball);
		int gridc = grid.checkCol(ball);
		int edgesc = edges.checkCol(ball);
		
		score = grid.getScore();
		
		if(batc==1) {ball.spin(keyboard); ball.invertDy();}
		if(edgesc==1||gridc==1) {ball.invertDy();}
		if(batc==0||edgesc==0||gridc==0) {ball.invertDx();}
		if(batc==-1||edgesc==-1||gridc==-1) {ball.invertDx(); ball.invertDy();}
		
		if(ball.checkHeight(grid, lives)==1) {resetterGameOver.reset(board, this);}
		if(ball.checkHeight(grid, lives)==-1) {lives--; ball.reset();}
		if(grid.checkState()==true) {stage++; lives=3; resetterStageComplete.reset(board, this);}
	}
	
	public void draw(Graphics2D graphics) {
		ball.draw(graphics);
		bat.draw(graphics);
		grid.draw(graphics);
	}

	public void setPlayer()
	{
		playerName = JOptionPane.showInputDialog("Who's playing?");
	}

	public void reset(){
		board.requestFocusInWindow();
		grid.reset();
		ball.reset();
		bat.reset();
		board.getHighScore().addHighScore(playerName, score);
		board.getRecentPlays().addPlay(score);
		stage = 1;
		lives = 3;
		grid.setScore(0);
	}
}
