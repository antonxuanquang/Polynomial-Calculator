package Lab1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test extends JFrame {
	public Test() {
		JScrollPane sp1 = new JScrollPane();
		JScrollBar sBar1 = sp1.getVerticalScrollBar();
		JScrollPane sp2 = new JScrollPane();
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER); // <---- get rid of the vertical scrollbar
		sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollBar sBar2 = sp2.getVerticalScrollBar();
		sBar2.setModel(sBar1.getModel()); // <--------------synchronize
		getContentPane().setLayout(new GridLayout(1, 2));
		getContentPane().add(sp1);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 1000));
		sp1.setViewportView(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(170, 200));
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(170, 200));
		panel.add(panel_2);
		getContentPane().add(sp2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(400, 300);		
	}

	public static void main(String[] args) {
		new Test().setVisible(true);
	}
}

class ScrollPanel extends JPanel {
	public ScrollPanel() {
		setLayout(new GridLayout(70, 1));
		for (int x = 0; x < 50; x++)
			add(new JLabel("" + (x + 1), JLabel.CENTER));
	}
}