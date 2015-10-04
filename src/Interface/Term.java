package Interface;

import javax.swing.JPanel;

import Theme.QTextField;

import java.awt.Color;

import javax.swing.JLabel;

public class Term extends JPanel implements TermInterface {
	private QTextField coeffTF, xTF, yTF, zTF;
	private JLabel plusLb;
	public Color primaryColor, secondaryColor;
	private Term ptr;
	private int coeff, x, y, z;

	/**
	 * Create the panel.
	 */
	
	public Term(Color primaryColor, Color secondaryColor) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		buildUpPanel(primaryColor, secondaryColor);
	}
	
	public void addPlusLabel(boolean withoutPlus) {
		plusLb.setVisible(withoutPlus);
	}
	
	public void setTFsEnable(boolean enabled) {
		coeffTF.setEnabled(enabled);
		xTF.setEnabled(enabled);
		yTF.setEnabled(enabled);
		zTF.setEnabled(enabled);
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
		if (coeffTF.getText().equals(null)) {
			coeff = 0;
			setCoeff(coeff);
			return coeff;
		}
		return coeff;
	}

	public void setCoeff(int c) {
		coeff = c;
		coeffTF.setText("" + c);
	}

	public int getXPower() {
		if (xTF.getText().equals(null)) {
			x = 0;
			setCoeff(x);
			return x;
		}
		return x;
	}

	public void setXPower(int ix) {
		x = ix;
		xTF.setText("" + ix);
	}

	public int getYPower() {
		if (yTF.getText().equals(null)) {
			y = 0;
			setCoeff(y);
			return y;
		}
		return y;
	}

	public void setYPower(int iy) {
		y = iy;
		yTF.setText("" + iy);
	}

	public int getZPower() {
		if (zTF.getText().equals(null)) {
			z = 0;
			setCoeff(z);
			return z;
		}
		return z;
	}

	public void setZPower(int iz) {
		z = iz;
		zTF.setText("" + iz);
	}
	
	public void setCoeffAndXYZ (int coeff, int x, int y, int z) {
		setCoeff(coeff);;
		setXPower(x);
		setYPower(y);
		setZPower(z);
	}

	public Term getPtr() {
		return ptr;
	}

	public void setPtr(Term p) {
		 ptr = p;
	}
	
	public Term addLikeTerm(Term term){
		this.setCoeff(this.getCoeff() + term.getCoeff());
		return this;
	}
	

	public boolean isEqualPowersTo(Term nextTerm) {
		return this.getXPower() == nextTerm.getXPower()
				&& this.getYPower() == nextTerm.getYPower()
				&& this.getZPower() == nextTerm.getZPower();
	}
	
	public boolean isHavingLessPower(Term term) {
		if (this.getXPower() == term.getXPower()) {
			if (this.getYPower() == term.getYPower()) {
				return this.getZPower() < term.getZPower();
			} else {
				return this.getYPower() < term.getYPower();
			}
		} else {
			return this.getXPower() < term.getXPower();
		}
	}
	
	public void copy(Term term) {
		this.setCoeff(term.getCoeff());
		this.setXPower(term.getXPower());
		this.setYPower(term.getYPower());
		this.setZPower(term.getZPower());
	}
	
	public double evaluate(double x, double y, double z) {
		double result;
		result = getCoeff() 
				* Math.pow(x, getXPower()) 
				* Math.pow(y, getYPower()) 
				* Math.pow(z, getZPower());
		return result;
	}
	
	@Override
	public String toString() {
		return "Coefficient = " + getCoeff() + "\n"
				+ "x-exponent = " + getXPower() + "\n"
				+ "y-exponent = " + getYPower() + "\n"
				+ "z-exponent = " + getZPower() + "\n";
	}
}
