package Controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface.Term;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Views.DisplayArithmeticView;

public class DisplayArithmeticControl implements ActionListener {
	
	private DisplayArithmeticView view;
	private Lab1Model model;
	private Lab1 lab1;
	
	private int xCordinate, yCordinate = 0;
	
	public DisplayArithmeticControl (DisplayArithmeticView fromView) {
		view = fromView;
		model = view.model;
		lab1 = view.lab1;
	}
	
	public void actionPerformed (ActionEvent ae) {
		Object event = ae.getSource();
		
		if (event.equals(view.btnAddTerm)) addTerm();
	}

	private void addTerm() {
		Term term = new Term(lab1.primaryColor, lab1.secondaryColor);
		if (xCordinate == 440) {
			xCordinate = 0;
			yCordinate += 50;
		} else {
			xCordinate += 110;
		}
		term.setBounds(xCordinate, yCordinate, 111, 32);
		view.panelOfTerms.add(term);
		term.setLayout(null);
		if (xCordinate == 440 && yCordinate == 50) {
			view.btnAddTerm.setEnabled(false);
		}
		lab1.validate();
		lab1.repaint();
	}
	
	public void setUpActionListeners() {
		view.btnAddTerm.addActionListener(this);
		view.btnAddPoly.addActionListener(this);
		view.btnLoad.addActionListener(this);
		view.btnSaveToDb.addActionListener(this);
	}

}
