package Interface;

import javax.swing.JPanel;

import Theme.QTextField;

import java.awt.Color;

import javax.swing.JLabel;

public class Term extends JPanel implements TermInterface {
	private QTextField coeffTF;
	private QTextField xTF;
	private QTextField yTF;
	private QTextField zTF;
	private JLabel plusLb;
	
	private Term ptr;

	/**
	 * Create the panel.
	 */
	public Term(Color primaryColor, Color secondaryColor) {
		buildUpPanel(primaryColor, secondaryColor);
	}
	
	public Term(Color primaryColor, Color secondaryColor, boolean withoutPlus) {
		buildUpPanel(primaryColor, secondaryColor);
		addPlusLabel(withoutPlus);
	}
	
	private void addPlusLabel(boolean withoutPlus) {
		plusLb.setVisible(withoutPlus);
	}

	private void buildUpPanel(Color primaryColor, Color secondaryColor) {
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
	
	public void setCoeffAndXYZ (int coeff, int x, int y, int z) {
		coeffTF.setText("" + coeff);
		xTF.setText("" + x);
		yTF.setText("" + y);
		zTF.setText("" + z);
	}

	public Term getPtr() {
		return ptr;
	}

	public void setPtr(Term p) {
		 ptr = p;
	}
	
	@Override
	public String toString() {
		return "Coefficient = " + Integer.parseInt(coeffTF.getText()) + "\n"
				+ "x-exponent = " + Integer.parseInt(xTF.getText()) + "\n"
				+ "y-exponent = " + Integer.parseInt(yTF.getText()) + "\n"
				+ "z-exponent = " + Integer.parseInt(zTF.getText()) + "\n";
	}

}
