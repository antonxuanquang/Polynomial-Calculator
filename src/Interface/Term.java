package Interface;

import javax.swing.JPanel;

import Theme.QTextField;

import java.awt.Color;
import java.awt.Label;

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
		coeffTF.setTabSize(0);
		coeffTF.setBounds(10, 11, 28, 20);
		add(coeffTF);
		coeffTF.setColumns(10);

		JLabel lblX = new JLabel("x");
		lblX.setBounds(40, 13, 14, 17);
		lblX.setForeground(primaryColor);
		add(lblX);

		xTF = new QTextField(primaryColor, secondaryColor);
		xTF.setTabSize(0);
		xTF.setBounds(48, 0, 14, 20);
		add(xTF);
		xTF.setColumns(10);

		JLabel lblY = new JLabel("y");
		lblY.setBounds(63, 14, 14, 17);
		lblY.setForeground(primaryColor);
		add(lblY);

		yTF = new QTextField(primaryColor, secondaryColor);
		yTF.setTabSize(0);
		yTF.setBounds(71, 1, 14, 20);
		yTF.setColumns(10);
		add(yTF);

		JLabel lblZ = new JLabel("z");
		lblZ.setBounds(86, 14, 14, 17);
		lblZ.setForeground(primaryColor);
		add(lblZ);

		zTF = new QTextField(primaryColor, secondaryColor);
		zTF.setTabSize(0);
		zTF.setBounds(94, 1, 14, 20);
		zTF.setColumns(10);
		add(zTF);

		plusLb = new JLabel("+");
		plusLb.setBounds(0, 14, 14, 14);
		plusLb.setForeground(primaryColor);
		add(plusLb);
	}

	public void changeTFsIntoLabels() {
		remove(coeffTF);
		remove(xTF);
		remove(yTF);
		remove(zTF);
		
		String label = "";
		if (coeff < 0) {
			label = "(" + coeff + ")";
		} else {
			label = "" + coeff;
		}
		Label lblCoeff = new Label(label);
		lblCoeff.setForeground(primaryColor);
		lblCoeff.setBounds(12, 10, 25, 23);
		add(lblCoeff);

		Label lblXPower = new Label("" + x);
		lblXPower.setForeground(primaryColor);
		lblXPower.setBounds(46, -3, 25, 23);
		add(lblXPower);

		Label lblYPower = new Label("" + y);
		lblYPower.setForeground(primaryColor);
		lblYPower.setBounds(71, -3, 25, 23);
		add(lblYPower);

		Label lblZPower = new Label("" + z);
		lblZPower.setForeground(primaryColor);
		lblZPower.setBounds(96, -3, 25, 23);
		add(lblZPower);
	}

	public int getCoeff() {
		if (coeffTF.getText().equals("")) {
			setCoeff(coeff);
			return coeff;
		} else {
			coeff = Integer.parseInt(coeffTF.getText().trim());
			return coeff;
		}
	}

	public void setCoeff(int c) {
		coeff = c;
		coeffTF.setText("" + c);
		coeffTF.setToolTipText("" + c);
	}

	public int getXPower() {
		if (xTF.getText().equals("")) {
			setXPower(x);
			return x;
		} else {
			x = Integer.parseInt(xTF.getText().trim());
			return x;
		}
	}

	public void setXPower(int ix) {
		x = ix;
		xTF.setText("" + ix);
		xTF.setToolTipText("" + ix);
	}

	public int getYPower() {
		if (yTF.getText().equals("")) {
			setYPower(y);
			return y;
		} else {
			y = Integer.parseInt(yTF.getText().trim());
			return y;
		}
	}

	public void setYPower(int iy) {
		y = iy;
		yTF.setText("" + iy);
		yTF.setToolTipText("" + iy);
	}

	public int getZPower() {
		if (zTF.getText().equals("")) {
			setZPower(z);
			return z;
		} else {
			z = Integer.parseInt(zTF.getText().trim());
			return z;
		}
	}

	public void setZPower(int iz) {
		z = iz;
		zTF.setText("" + iz);
		zTF.setToolTipText("" + iz);
	}

	public void setCoeffAndXYZ(int coeff, int x, int y, int z) {
		setCoeff(coeff);
		;
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

	public Term addLikeTerm(Term term) {
		this.setCoeff(this.getCoeff() + term.getCoeff());
		return this;
	}

	public boolean isEqualPowersTo(Term nextTerm) {
		return this.getXPower() == nextTerm.getXPower() && this.getYPower() == nextTerm.getYPower()
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
		result = getCoeff() * Math.pow(x, getXPower()) * Math.pow(y, getYPower()) * Math.pow(z, getZPower());
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
