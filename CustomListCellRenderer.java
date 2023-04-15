import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomListCellRenderer extends DefaultListCellRenderer {
    JLabel label;
    public CustomListCellRenderer(){
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        label.setBackground(Color.WHITE);
        return label;
    }
}