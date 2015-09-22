import javax.swing.JPanel;

import Theme.QButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ViewController extends JPanel {

	Lab1 lab1;
	
	private QButton btnPerformArithmetic, btnAvaluateArithmetic;
	
	/**
	 * Create the panel.
	 */
	public ViewController(Lab1 lab1) {
		this.lab1 = lab1;
		setLayout(null);
		
		btnPerformArithmetic = new QButton("Perform Arithmetic", lab1.primaryColor, lab1.secondaryColor);
		btnPerformArithmetic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lab1.setUpPerformPolynomialView();
				btnPerformArithmetic.setEnabled(false);
				btnAvaluateArithmetic.setEnabled(true);
			}
		});
		btnPerformArithmetic.setBounds(71, 71, 154, 50);
		btnPerformArithmetic.setEnabled(false);
		add(btnPerformArithmetic);
		
		btnAvaluateArithmetic = new QButton("Avaluate Arithmetic", lab1.primaryColor, lab1.secondaryColor);
		btnAvaluateArithmetic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab1.setUpEvaluatePolynomialView();
				btnPerformArithmetic.setEnabled(true);
				btnAvaluateArithmetic.setEnabled(false);
			}
		});
		btnAvaluateArithmetic.setBounds(71, 150, 154, 50);
		add(btnAvaluateArithmetic);
	}
}
