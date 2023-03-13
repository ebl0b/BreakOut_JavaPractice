import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class RecentPlays extends JScrollPane
{
	private final int MAXIMUM_SIZE = 10;
	private Object[] columnNames = {"Score"};
	private DefaultTableModel model;
	private JTable table;
	Color darkGray;

	public RecentPlays()
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

	public void addPlay(int score)
	{
		Hscore hs = new Hscore("", score);
		if(!full())
		{
			model.insertRow(0, hs.getScore());
		}
		else 
		{
			model.insertRow(0, hs.getScore());
			model.removeRow(MAXIMUM_SIZE);
		}
	}

	private Boolean full()
	{
		if(getCurrentModelSize()>=MAXIMUM_SIZE){return true;}
		else {return false;}
	}
}