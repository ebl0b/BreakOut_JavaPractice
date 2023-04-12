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
	int score = C.SCORE_0;
	int lives = C.MAX_HP;
	int stage = C.FIRST_STAGE;	
	String playerName = C.NAME_PLACEHOLDER;

	Ball ball = new Ball();
	Bat bat = new Bat();
	Edges edges = new Edges();
	Grid grid = new Grid();
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
		
		if(batc==C.HORIZONTAL_COL) {ball.spin(keyboard); ball.invertDy();}
		if(edgesc==C.HORIZONTAL_COL||gridc==C.HORIZONTAL_COL) {ball.invertDy();}
		if(batc==C.VERTICAL_COL||edgesc==C.VERTICAL_COL||gridc==C.VERTICAL_COL) {ball.invertDx();}
		if(batc==C.CORNER_COL||edgesc==C.CORNER_COL||gridc==C.CORNER_COL) {ball.invertDx(); ball.invertDy();}
		
		if(ball.checkHeight(grid, lives)==C.CASE_GAME_OVER) {resetterGameOver.reset(board, this);}
		if(ball.checkHeight(grid, lives)==C.CASE_OUT_OF_BOUNDS) {lives--; ball.reset();}
		if(grid.checkGridCleared()==true) {stage++; lives=C.MAX_HP; resetterStageComplete.reset(board, this);}
	}
	
	public void draw(Graphics2D graphics) {
		ball.draw(graphics);
		bat.draw(graphics);
		grid.draw(graphics);
	}

	public void setPlayer(){playerName = JOptionPane.showInputDialog("Who's playing?");}

	public void reset(int resetType){
		board.requestFocusInWindow();
		grid.reset();
		ball.reset();
		bat.reset();
		if(resetType==C.FULL_RESET){
			board.getHighScore().addHighScore(playerName, score);
			board.getRecentPlays().addPlay(score);
			stage = C.FIRST_STAGE;
			lives = C.MAX_HP;
			grid.setScore(C.SCORE_0);
		}
	}
}
