package Views;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Lab1.Lab1;

import javax.swing.JLabel;
import java.awt.Font;

public class ExitView extends JPanel {
	
	Lab1 lab1;

	/**
	 * Create the panel.
	 */
	public ExitView(Lab1 fromLab1) {
		
		lab1 = fromLab1;
		
		setLayout(null);
		
		JLabel lblGoodBye = new JLabel("Good Bye!!!");
		lblGoodBye.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblGoodBye.setBounds(362, 298, 334, 86);
		lblGoodBye.setForeground(lab1.primaryColor);
		add(lblGoodBye);

	}
}
