import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class RecentPlays extends JScrollPane
{

	Object[][] recentPlays = {
		{0},
		{0},
		{0},
		{0},
		{0},
		{0},
		{0},
		{0},
		{0},
		{0}
	};
	Object[] columnNames = {"Score"};
	DefaultTableModel model;
	JTable table;
	public RecentPlays()
	{
		model = new DefaultTableModel(recentPlays, columnNames);
		table = new JTable(model);
		setViewportView(table);
		table.setEnabled(false);
		table.setRowHeight(29);
		
	}

	public void addPlay(int score){
		for(int i = 9; i>0; i--){
			recentPlays[i][0] = recentPlays[i-1][0];
			model.setValueAt(recentPlays[i-1][0], i, 0);
		}
		recentPlays[0][0] = score;
		model.setValueAt(score, 0, 0);
	}
}