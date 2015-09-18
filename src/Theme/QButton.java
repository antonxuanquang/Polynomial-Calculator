package Theme;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class QButton extends JButton implements MouseListener{
	
	Color hoverColor, mainColor;
	
	public QButton (String name, Color hoverColor, Color mainColor) {
		this.hoverColor = hoverColor;
		this.mainColor = mainColor;
		addMouseListener(this);
		setBackground(mainColor);
		setText(name);
	}
	
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		Object event = e.getSource();
		if (event.equals(this)) {
			setBackground(hoverColor);
		}
	}

	public void mouseExited(MouseEvent e) {
		Object event = e.getSource();
		if (event.equals(this)) {
			setBackground(mainColor);
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
}
