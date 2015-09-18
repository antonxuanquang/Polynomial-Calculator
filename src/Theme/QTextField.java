package Theme;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class QTextField extends JTextArea implements MouseListener{
Color hoverColor, mainColor;
	
	public QTextField (Color hoverColor, Color mainColor) {
		this.hoverColor = hoverColor;
		this.mainColor = mainColor;
		addMouseListener(this);
		setBorder(BorderFactory.createLineBorder(mainColor, 2));
	}
	
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		setBorder(BorderFactory.createLineBorder(hoverColor, 2));
	}

	public void mouseExited(MouseEvent e) {
		setBorder(BorderFactory.createLineBorder(mainColor, 2));
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
