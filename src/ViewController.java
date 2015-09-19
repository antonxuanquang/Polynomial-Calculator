import javax.swing.JPanel;

import Theme.QButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ViewController extends JPanel {

	Lab1 lab1;
	
	/**
	 * Create the panel.
	 */
	public ViewController(Lab1 lab1) {
		this.lab1 = lab1;
		setLayout(null);
		
		QButton btnPerformArithmetic = new QButton("Perform Arithmetic", lab1.primaryColor, lab1.secondaryColor);
		btnPerformArithmetic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lab1.setUpPerformPolynomialView();
			}
		});
		btnPerformArithmetic.setBounds(83, 71, 132, 50);
		add(btnPerformArithmetic);
		
		QButton btnAvaluateArithmetic = new QButton("Avaluate Arithmetic", lab1.primaryColor, lab1.secondaryColor);
		btnAvaluateArithmetic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab1.setUpEvaluatePolynomialView();
			}
		});
		btnAvaluateArithmetic.setBounds(83, 150, 132, 50);
		add(btnAvaluateArithmetic);
	}
}
