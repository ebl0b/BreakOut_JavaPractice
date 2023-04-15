import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class HighScoreList extends JScrollPane
{
	private DefaultListModel<String> model;
	private JList<String> list;

	public HighScoreList()
	{
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		setViewportView(list);
		getViewport().setBackground(C.DARK_GRAY);
		list.setEnabled(false);
	}

	private int getCurrentModelSize(){return model.getSize();}

	public void addHighScore(String name, int score)
	{
		String hs = name + " " + score;
		int cmp = scoreCmp(score);

		if(cmp > -1){
			model.add(cmp, hs);
		}
		else{
			model.addElement(hs);
		}
		if(getCurrentModelSize()>C.MAX_LIST_SIZE){model.remove(C.MAX_LIST_SIZE);}
	}

	private int scoreCmp(int score)
	{
		for(int i = 0; i<getCurrentModelSize(); i++){
			int scoreVal = Integer.parseInt(model.get(i).split("\\s")[1]);
			if(score>scoreVal){return i;}
		}
		return -1;
	}
}
