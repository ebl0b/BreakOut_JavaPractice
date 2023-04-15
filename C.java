import java.awt.*;
import java.util.*;
import javax.swing.*;

public class C{
	public static final Dimension SCREEN_SIZE = new Dimension(1454, 937);
	public static final Dimension NORTH_SIZE = new Dimension(1440, 135);
	public static final Dimension WEST_SIZE = new Dimension(45, 795);
	public static final Dimension EAST_SIZE = new Dimension(360, 795);
	public static final Dimension CENTER_SIZE = new Dimension(1035, 795);
	public static final Dimension SOUTH_SIZE = new Dimension(1035, 0);
	public static final Dimension PAUSE_SIZE = new Dimension(300, 400);

	public static final Insets HS_INSETS = new Insets(0, 45, 0, 0);
	public static final Insets RP_INSETS = new Insets(364, -293, 0, 0);
	public static final int LIST_WIDTH = 250;
	public static final int LIST_HEIGHT = 290;
	public static final int LIST_STD_WEIGHT = 1;

	public static final int MENU = 0;
	public static final int GAME = 1;
	public static final int SCORE_0 = 0;
	public static final int MAX_HP = 3;
	public static final int FIRST_STAGE = 1;
	public static final int BALL_START_X = 497;
	public static final int BALL_START_Y = 600;
	public static final int BALL_WIDTH = 30;
	public static final int BALL_HEIGHT = 30;
	public static final int BALL_DY = -7;
	public static final int BALL_SPIN = 2;
	public static final int SOUTH_EDGE = 768;
	public static final int WEST_EDGE = 0;
	public static final int EAST_EDGE = 1035;
	public static final int NORTH_EDGE = 0;
	public static final int VERTICAL_COL = 0;
	public static final int HORIZONTAL_COL = 1;
	public static final int CORNER_COL = -1;
	public static final String NAME_PLACEHOLDER = "---";
	public static final int NORMAL_RESET = 0;
	public static final int FULL_RESET = 1;
	public static final int CASE_GAME_OVER = 1;
	public static final int CASE_OUT_OF_BOUNDS = -1;
	public static final int COLUMNS = 10;
	public static final int ROWS = 4;
	public static final int GRID_Y_DISPLACEMENT = 80;
	public static final int ROW_Y_DISPLACEMENT = 55;
	public static final int DEFAULT_BOX_WIDTH = 90;
	public static final int DEFAULT_BOX_HEIGHT = 45;
	public static final int BOX_X_DISPLACEMENT = 100;
	public static final int GRID_X_DISPLACEMENT = 20;
	public static final int BAT_START_X = 422;
	public static final int BAT_START_Y = 700;
	public static final int BAT_WIDTH = 160;
	public static final int BAT_HEIGHT = 30;
	public static final int BAT_DX = 10;
	public static final int PAUSE_X = 410;
	public static final int PAUSE_Y = 250;
	public static final int NORTH_TEXT_Y = 75;
	public static final int NORTH_TEXT_SCORE_X = 820;
	public static final int NORTH_TEXT_STAGE_X = 415; 
	public static final int NORTH_TEXT_LIVES_X = 55;
	public static final int NORTH_FONT_SIZE = 35;
	public static final int MAX_LIST_SIZE = 10;

	public static final Rectangle BAT_BOUNDS = new Rectangle(422, 700, 160, 30);
	public static final Rectangle BALL_BOUNDS = new Rectangle(497, 600, 30, 30);
	public static final Rectangle NORTH_EDGE_BOUNDS = new Rectangle(0, -30, 1035, 30);
	public static final Rectangle WEST_EDGE_BOUNDS = new Rectangle(-30, 0, 30, 765);
	public static final Rectangle EAST_EDGE_BOUNDS = new Rectangle(1035, 0, 30, 765);
	public static final Dimension BOX_SIZE = new Dimension(90, 45);
	public static final Rectangle PLAY_BOUNDS = new Rectangle(432, 351, 576, 108);
	public static final Rectangle QUIT_BOUNDS = new Rectangle(432, 504, 576, 108);

	public static final Color DARK_GRAY = new Color(40, 36, 36);
}