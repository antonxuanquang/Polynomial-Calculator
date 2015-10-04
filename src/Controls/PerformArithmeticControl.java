package Controls;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Interface.PolyNameNode;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Theme.PanelOfTerm;
import Views.DisplayArithmeticView;
import Views.PerformArithmeticView;

public class PerformArithmeticControl implements ActionListener {
	
	private PerformArithmeticView view;
	private Lab1Model model;
	private Lab1 lab1;
	private DisplayArithmeticView displayView;
	
	private PolyNameNode firstOperand, secondOperand, resultPoly;
	private PanelOfTerm resultPanel;
	
	public PerformArithmeticControl (PerformArithmeticView fromView) {
		view = fromView;
		model = view.model;
		lab1 = view.lab1;
		displayView = lab1.displayView;
		
		updateJComboBox(model.getHeadOfPolyLists());
	}
	
	public void updateJComboBox(PolyNameNode polyLinkedList) {
		String first = "" + view.firstOperand.getSelectedItem();
		String second = "" + view.secondOperand.getSelectedItem();
		resetJComboBox(view.firstOperand);
		resetJComboBox(view.secondOperand);
		PolyNameNode currentPoly = polyLinkedList.getDownPtr();
		while (currentPoly != polyLinkedList) {
			view.firstOperand.addItem(currentPoly.getPolyName());
			view.secondOperand.addItem(currentPoly.getPolyName());
			currentPoly = currentPoly.getDownPtr();
		}
		manipulateJComboBoxAndPanelsOfTerms(first, second);
	}
	
	private void resetJComboBox(JComboBox jcb) {
		jcb.removeAllItems();
		jcb.addItem("**Choose a polynomial");
	}
	
	private void manipulateJComboBoxAndPanelsOfTerms(String first, String second) {
		if (isInJComboBox(view.firstOperand, first)) {
			view.firstOperand.setSelectedItem(first);
		} else {
			view.panelOfFirstTerm.removeAll();
			view.firstOperand.setSelectedIndex(0);
			view.secondOperand.setEnabled(false);
		}
		if (isInJComboBox(view.secondOperand, second)) {
			view.secondOperand.setSelectedItem(second);
			if (view.firstOperand.getSelectedIndex() == 0) {
				view.operator.setEnabled(false);
			}
		} else {
			view.panelOfSecondTerm.removeAll();
			view.secondOperand.setSelectedIndex(0);
			view.operator.setEnabled(false);
		}
		view.panelResultTerm.removeAll();
	}

	private boolean isInJComboBox(JComboBox combo, String name) {
		for (int index = 0; index < combo.getItemCount(); index++) {
			if (name.equals(combo.getItemAt(index))) {
				return true;
			}
		}
		return false;
	}
	
	
	
	//updateGUI after each selection from JComboBox and prepare two Polynomials
	//to perform polynomial arithmetic calculations
	private void displayFirstOperand() {
		if(view.firstOperand.getSelectedIndex() > 0) {
			view.secondOperand.setEnabled(true);
			firstOperand = selectOperand(model.getHeadOfPolyLists(),
					"" + view.firstOperand.getSelectedItem());
			displayOperand(firstOperand, view.panelOfFirstTerm);
			view.lblShowingProcess.setText("Please choose second operand");
		} else {
			return;
		}
	}
	
	private void displaySecondOperand() {
		if(view.secondOperand.getSelectedIndex() > 0) {
			view.operator.setEnabled(true);
			secondOperand = selectOperand(model.getHeadOfPolyLists(),
					"" + view.secondOperand.getSelectedItem());
			displayOperand(secondOperand, view.panelOfSecondTerm);
			view.lblShowingProcess.setText("Please choose an operator");
		} else {
			return;
		}
	}
	
	public PanelOfTerm  displayOperand(PolyNameNode operand, JPanel panel) {
		panel.removeAll();
		PanelOfTerm firstPanel = new PanelOfTerm(operand, displayView.control);
		firstPanel.removeDeleteBtn();
		firstPanel.setPreferredSize(new Dimension (800, firstPanel.getYCordinate()));
		panel.add(firstPanel);
		lab1.panel_1.repaint();
		lab1.panel_1.validate();
		return firstPanel;
	}
	
	public PolyNameNode selectOperand(PolyNameNode polyLinkedList, String name) {
		PolyNameNode currentPoly = polyLinkedList.getDownPtr();
		while (currentPoly != polyLinkedList) {
			if (currentPoly.getPolyName().equals(name)) {
				PolyNameNode temp = new PolyNameNode();
				temp.setPolyName(currentPoly.getPolyName());
				temp.buildHeadTerm(lab1.primaryColor, lab1.secondaryColor);
				temp.copy(currentPoly);
				return temp;
			}
			currentPoly = currentPoly.getDownPtr();
		}
		return currentPoly;
	}
	
	
	
	private void performArithmetic() {
		resultPoly = new PolyNameNode();
		switch (view.operator.getSelectedIndex()) {
			case 1: resultPoly = firstOperand.add(secondOperand); break;
			case 2: resultPoly = firstOperand.subtract(secondOperand); break;
			case 3: resultPoly = firstOperand.multiply(secondOperand); break;
		}
		resultPanel = displayOperand(resultPoly, view.panelResultTerm);
		resultPanel.replaceLblNameAsTextField();
		
		view.btnSave.setVisible(true);
		view.lblShowingProcess.setText("Successful!!");
	}
	
	
	
	
	private void saveResult() {
		resultPoly.setPolyName(resultPanel.getPolyName());
		if (model.getHeadOfPolyLists().isInPolyLinkedList(resultPoly.getPolyName())) {
			promptUserForAnotherName();
		} else {
			model.getHeadOfPolyLists().addPoly(resultPoly);
			displayView.control.updatePanelOfPolies(model.getHeadOfPolyLists());
			lab1.setUpPerformPolynomialView();
			lab1.performView.lblShowingProcess.setText("Every thing has been saved");
		}
	}
	
	private void promptUserForAnotherName() {
		System.out.println(resultPanel.getPolyName());
		view.lblShowingProcess.setText("'" + resultPanel.getPolyName() + "' is "
				+ "already in the polynomial lists. Please choose another name ");
		resultPanel.setPolyName("");
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if (event.equals(view.firstOperand)) displayFirstOperand();
		else if (event.equals(view.secondOperand)) displaySecondOperand();
		else if (event.equals(view.operator)) performArithmetic();
		else if (event.equals(view.btnSave)) saveResult();
	}

	public void setActionListeners() {
		view.firstOperand.addActionListener(this);
		view.operator.addActionListener(this);
		view.secondOperand.addActionListener(this);
		view.btnSave.addActionListener(this);
	}
}
