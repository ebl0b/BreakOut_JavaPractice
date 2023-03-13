import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class HighScore extends JScrollPane
{
	private final int MAXIMUM_SIZE = 10;
	private Object[] columnNames = {"Name", "Score"};
	private DefaultTableModel model;
	private JTable table;
	Color darkGray;

	public HighScore()
	{
		model = new DefaultTableModel(columnNames, 0);
		darkGray = new Color(40,36,36);
		table = new JTable(model);
		setViewportView(table);
		getViewport().setBackground(darkGray);
		table.setEnabled(false);
		table.setRowHeight(29);
	}

	private int getCurrentModelSize(){return model.getRowCount();}

	private int loc(int score)
	{
		int i;
		for(i = 0; i<getCurrentModelSize(); i++)
		{
			if(score>(int)model.getValueAt(i, 1)){break;}
		}
		return i;
	}

	public void addHighScore(String name, int score)
	{
		Hscore hs = new Hscore(name, score);
		switch(scoreCmp(score))
		{
			case 0: model.insertRow(loc(score), hs.getVec()); break;
			case 1: model.insertRow(loc(score), hs.getVec()); model.removeRow(MAXIMUM_SIZE); break;
			default: break;
		}
	}

	private int scoreCmp(int score)
	{
		if(getCurrentModelSize()<MAXIMUM_SIZE){return 0;}
		for(int i = 0; i<MAXIMUM_SIZE; i++)
		{
			if(score>(int)model.getValueAt(i, 1)){return 1;}
		}
		return -1;
	}
}