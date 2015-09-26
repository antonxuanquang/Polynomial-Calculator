package Interface;

import javax.swing.JPanel;

import Theme.QTextField;

import java.awt.Color;

import javax.swing.JLabel;

public class TermWithPlus extends JPanel{
	private QTextField coeffTF;
	private QTextField xTF;
	private QTextField yTF;
	private QTextField zTF;
	private JLabel plusLb;

	/**
	 * Create the panel.
	 */
	public TermWithPlus(Color primaryColor, Color secondaryColor) {
		setLayout(null);
		
		coeffTF = new QTextField(primaryColor, secondaryColor);
		coeffTF.setBounds(10, 11, 28, 20);
		add(coeffTF);
		coeffTF.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(40, 13, 22, 17);
		lblX.setForeground(primaryColor);
		add(lblX);
		
		xTF = new QTextField(primaryColor, secondaryColor);
		xTF.setBounds(48, 0, 14, 20);
		add(xTF);
		xTF.setColumns(10);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(63, 14, 22, 17);
		lblY.setForeground(primaryColor);
		add(lblY);
		
		yTF = new QTextField(primaryColor, secondaryColor);
		yTF.setBounds(71, 1, 14, 20);
		yTF.setColumns(10);
		add(yTF);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setBounds(86, 14, 22, 17);
		lblZ.setForeground(primaryColor);
		add(lblZ);
		
		zTF = new QTextField(primaryColor, secondaryColor);
		zTF.setBounds(94, 1, 14, 20);
		zTF.setColumns(10);
		add(zTF);
		
		plusLb = new JLabel("+");
		plusLb.setBounds(0, 14, 46, 14);
		plusLb.setForeground(primaryColor);
		add(plusLb);
	}

}
