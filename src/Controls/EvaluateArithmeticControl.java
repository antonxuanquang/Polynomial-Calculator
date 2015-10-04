package Controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Interface.PolyNameNode;
import Interface.Term;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Theme.PanelOfTerm;
import Views.EvaluateArithmeticView;

public class EvaluateArithmeticControl implements ActionListener {
	
	private EvaluateArithmeticView view;
	private Lab1Model model;
	private Lab1 lab1;
	private PolyNameNode evaluatingPoly;
	
	public EvaluateArithmeticControl (EvaluateArithmeticView fromView) {
		view = fromView;
		lab1 = view.lab1;
		model = view.model;
		
		updateJComboBox(model.getHeadOfPolyLists());
		enableTFs(false);
	}
	
	private void enableTFs(boolean b) {
		view.xTF.setEnabled(b);
		view.zTF.setEnabled(b);
		view.yTF.setEnabled(b);
	}

	public void updateJComboBox(PolyNameNode polyLinkedList) {
		String name = "" + view.cbPolynomials.getSelectedItem();
		resetJComboBox(view.cbPolynomials);
		PolyNameNode currentPoly = polyLinkedList.getDownPtr();
		while (currentPoly != polyLinkedList) {
			view.cbPolynomials.addItem(currentPoly.getPolyName());
			currentPoly = currentPoly.getDownPtr();
		}
		manipulateJComboBox(name);
	} 
	
	private void resetJComboBox(JComboBox jcb) {
		jcb.removeAllItems();
		jcb.addItem("**Choose a polynomial");
	}
	
	private void manipulateJComboBox(String name) {
		if (isInJComboBox(view.cbPolynomials, name)) {
			view.cbPolynomials.setSelectedItem(name);
		} else {
			view.panelOfEvaluatingPoly.removeAll();
			view.cbPolynomials.setSelectedIndex(0);
			enableTFs(false);
		}
	}

	private boolean isInJComboBox(JComboBox combo, String name) {
		for (int index = 0; index < combo.getItemCount(); index++) {
			if (name.equals(combo.getItemAt(index))) {
				return true;
			}
		}
		return false;
	}

	
	

	
	private void updateGUI() {
		if(view.cbPolynomials.getSelectedIndex() > 0) {
			evaluatingPoly = lab1.performView.control.selectOperand(
					model.getHeadOfPolyLists(),
					"" + view.cbPolynomials.getSelectedItem());
			lab1.performView.control.displayOperand(evaluatingPoly, view.panelOfEvaluatingPoly);
			
			view.btnEvaluate.setEnabled(true);
			enableTFs(true);
			view.lblResult.setText("Please input value for x, y, and z");
		} else {
			view.panelOfEvaluatingPoly.removeAll();
			enableTFs(false);
			view.btnEvaluate.setEnabled(false);
			view.lblResult.setText("");
		}
	}

	private void evaluatePolynomial() {
		double x, y, z;
		try {
			x = Double.parseDouble(view.xTF.getText());
			y = Double.parseDouble(view.yTF.getText());
			z = Double.parseDouble(view.zTF.getText());
		} catch (NumberFormatException e) {
			String variable = "";
			if (e.equals(view.xTF)) variable += "x";
			else if (e.equals(view.yTF)) variable += "y";
			else if (e.equals(view.zTF)) variable += "z";
			view.lblResult.setText("Please provide valid input for " + variable);
			return;
		}
		double result = evaluate(evaluatingPoly, x, y, z);
		view.lblResult.setText("The result is " + result);
	}

	private double evaluate(PolyNameNode poly, double x, double y, double z) {
		double result = 0;
		Term currentTerm = poly.getFirstTerm();
		while (currentTerm != poly.getRightPtr()) {
			result += currentTerm.evaluate(x, y, z);
			currentTerm = currentTerm.getPtr();
		}
		return result;
	}


	

	public void actionPerformed (ActionEvent ae) {
		Object event = ae.getSource();
		if (event.equals(view.btnEvaluate)) evaluatePolynomial();
		else if (event.equals(view.cbPolynomials)) updateGUI(); 
	}

	public void setUpListener() {
		view.btnEvaluate.addActionListener(this);
		view.cbPolynomials.addActionListener(this);
	}
}
