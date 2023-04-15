import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class RecentPlaysList extends JScrollPane
{
	private DefaultListModel<Integer> model;
	private JList<Integer> list;

	public RecentPlaysList()
	{
		model = new DefaultListModel<Integer>();
		list = new JList<Integer>(model);
		setViewportView(list);
		getViewport().setBackground(C.DARK_GRAY);
		list.setEnabled(false);
	}

	private int getCurrentModelSize(){return model.getSize();}

	public void addPlay(int score)
	{
		if(!full())
		{
			model.add(0, score);
		}
		else 
		{
			model.add(0, score);
			model.remove(C.MAX_LIST_SIZE);
		}
	}

	private Boolean full()
	{
		if(getCurrentModelSize()>=C.MAX_LIST_SIZE){return true;}
		else {return false;}
	}
}