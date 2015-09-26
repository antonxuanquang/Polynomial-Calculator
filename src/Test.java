import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Interface.PolyNode;

class Test extends JFrame {
	public Test() {
		JScrollPane sp1 = new JScrollPane(new ScrollPanel());
		JScrollBar sBar1 = sp1.getVerticalScrollBar();
		JScrollPane sp2 = new JScrollPane(new ScrollPanel());
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER); // <---- get rid of the vertical scrollbar
		JScrollBar sBar2 = sp2.getVerticalScrollBar();
		sBar2.setModel(sBar1.getModel()); // <--------------synchronize
		getContentPane().setLayout(new GridLayout(1, 2));
		getContentPane().add(sp1);
		getContentPane().add(sp2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(400, 300);
		
		
		
	}

	public static void main(String[] args) {
		new Test().setVisible(true);
	}

	
	public int getCoeff() {
		return Integer.parseInt(coeffTF.getText());
	}

	public void setCoeff(int c) {
		coeffTF.setText("" + c);
	}

	public int getXPower() {
		return Integer.parseInt(xTF.getText());
	}

	public void setXPower(int ix) {
		xTF.setText("" + ix);
	}

	public int getYPower() {
		return Integer.parseInt(yTF.getText());
	}

	public void setYPower(int iy) {
		yTF.setText("" + iy);
	}

	public int getZPower() {
		return Integer.parseInt(zTF.getText());
	}

	public void setZPower(int iz) {
		zTF.setText("" + iz);
	}

	public PolyNode getPtr();

	public void setPtr(PolyNode p);
}

class ScrollPanel extends JPanel {
	public ScrollPanel() {
		setLayout(new GridLayout(50, 1));
		for (int x = 0; x < 50; x++)
			add(new JLabel("" + (x + 1), JLabel.CENTER));
	}
}