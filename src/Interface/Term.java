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
			setCoeff(0);
			return 0;
		}
		return Integer.parseInt(coeffTF.getText());
	}

	public void setCoeff(int c) {
		coeffTF.setText("" + c);
	}

	public int getXPower() {
		if (xTF.getText().equals(null)) {
			setXPower(0);
			return 0;
		}
		return Integer.parseInt(xTF.getText());
	}

	public void setXPower(int ix) {
		xTF.setText("" + ix);
	}

	public int getYPower() {
		if (yTF.getText().equals(null)) {
			setYPower(0);
			return 0;
		}
		return Integer.parseInt(yTF.getText());
	}

	public void setYPower(int iy) {
		yTF.setText("" + iy);
	}

	public int getZPower() {
		if (zTF.getText().equals(null)) {
			setZPower(0);
			return 0;
		}
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
	
	@Override
	public String toString() {
		return "Coefficient = " + getCoeff() + "\n"
				+ "x-exponent = " + getXPower() + "\n"
				+ "y-exponent = " + getYPower() + "\n"
				+ "z-exponent = " + getZPower() + "\n";
	}
}
