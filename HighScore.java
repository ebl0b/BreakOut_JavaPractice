import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class HighScore extends JScrollPane
{

	Object[][] highScores = {
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0},
		{"-", 0}
	};
	Object[] columnNames = {"Name", "Score"};
	DefaultTableModel model;
	JTable table;
	public HighScore()
	{
		model = new DefaultTableModel(highScores, columnNames);
		table = new JTable(model);
		setViewportView(table);
		table.setEnabled(false);
		table.setRowHeight(29);
		
	}

	private void mov(int index){
		for(int i = 9; index!=0 ? i>=index : i>index; i--){
			highScores[i][0] = highScores[i-1][0];
			highScores[i][1] = highScores[i-1][1];
			model.setValueAt(highScores[i-1][0], i, 0);
			model.setValueAt(highScores[i-1][1], i, 1);
		}
	}

	public void addHighScore(String name, int score){
		Integer lScore = new Integer(score);
		for(int i = 9; i>=0; i--){
			if(lScore<(Integer)(highScores[i][1])){
				mov(i+1);
				highScores[i+1][0] = name;
				highScores[i+1][1] = score;
				model.setValueAt(name, i+1, 0);
				model.setValueAt(score, i+1, 1);
				return;
			}
		}
		mov(0);
		highScores[0][0] = name;
		highScores[0][1] = score;
		model.setValueAt(name, 0, 0);
		model.setValueAt(score, 0, 1);
	}

	public Boolean scoreCmp(int score){
		Integer lScore = new Integer(score);
		for(int i = 0; i<10; i++){
			if(lScore>(Integer)(highScores[i][1])){System.out.println("ja"); return true;}
		}
		System.out.println("fel");
		return false;
	}
}