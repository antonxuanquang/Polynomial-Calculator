package Controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface.PolyNameNode;
import Interface.Term;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Views.DisplayArithmeticView;

public class DisplayArithmeticControl implements ActionListener {
	
	private DisplayArithmeticView view;
	private Lab1Model model;
	private Lab1 lab1;
	
	private int xCordinate, yCordinate = 0;
	private PolyNameNode temporaryPoly;
	private Term currentTerm;
	
	public DisplayArithmeticControl (DisplayArithmeticView fromView) {
		view = fromView;
		model = view.model;
		lab1 = view.lab1;
		
		initiate();
	}

// initialize
	private void initiate() {
		createTemporaryPoly();
		createFirstTerm();
	}
	
	private void createTemporaryPoly() {
		temporaryPoly = new PolyNameNode("Temp");
		currentTerm = new Term(lab1.primaryColor, lab1.secondaryColor);
		temporaryPoly.setRightPtr(currentTerm);
		currentTerm.setCoeffAndXYZ(-99, 0, 0, 0);
		currentTerm = temporaryPoly.getRightPtr();
	}
	
	private void createFirstTerm() {
		Term firstTerm = new Term(lab1.primaryColor, lab1.secondaryColor, false);
		addTermIntoPanel(0, 0, firstTerm);		
		currentTerm.setPtr(firstTerm);
		currentTerm = currentTerm.getPtr();
		
//		delete later
		firstTerm.setXPower(3);
		firstTerm.setYPower(4);
		firstTerm.setZPower(10);
		firstTerm.setCoeff(3);
	
		
	}
	
	
	
// add a term button
	private void addTerm() {
		Term term = new Term(lab1.primaryColor, lab1.secondaryColor);
		currentTerm.setPtr(term);
		currentTerm = currentTerm.getPtr();
		addTermInGUI(term);
		
//		delete later
		term.setXPower(4);
		term.setYPower(4);
		term.setZPower(4);
		term.setCoeff(4);
		
	}
	
	private void addTermInTemporaryPoly(Term currentTerm, Term nextTerm) {
		currentTerm.setPtr(nextTerm);
		currentTerm = currentTerm.getPtr();
	}

	private void addTermInGUI(Term term) {
		//manipulate x and y coordinate
		if (xCordinate == 440) {
			xCordinate = 0;
			yCordinate += 50;
		} else {
			xCordinate += 110;
		}
		addTermIntoPanel(xCordinate, yCordinate, term);
		//check for x and y coordinates bounds
		if (xCordinate == 440 && yCordinate == 50) {
			view.btnAddTerm.setEnabled(false);
		}
		lab1.validate();
		lab1.repaint();
	}
	
	private void addTermIntoPanel (int xCordinate, int yCordinate, Term term) {
		term.setBounds(xCordinate, yCordinate, 110, 32);
		view.panelOfTerms.add(term);
		term.setLayout(null);
	}

	
// add a new poly button
	private void addPoly() {
		if (!(model.isInPolyLinkedList(view.tfPolyName.getText()))) {
			temporaryPoly.setPolyName(view.tfPolyName.getText());
			linkToHead();
		} else {
			promptUserForAnotherName();
			return;
		}
		if (passCheckingTemporaryPolyTest()) {
			cleanUpTemporaryPoly();
			addNewPolyToModel();
			updateGUI();
		} else {
			return;
		}
	}

	private void linkToHead() {
		addTermInTemporaryPoly(currentTerm, temporaryPoly.getRightPtr());
	}
	
	private void promptUserForAnotherName() {
		view.lblShowingProcess.setText("'" + view.tfPolyName.getText() + "' is "
				+ "already in the polynomial lists. Please choose another name ");
		view.tfPolyName.setText("");
	}

	private boolean passCheckingTemporaryPolyTest() {
		// TODO Auto-generated method stub
		Term currentTerm = temporaryPoly.getRightPtr();
		currentTerm = currentTerm.getPtr();
		while (currentTerm != temporaryPoly.getRightPtr()) {
			try {
				System.out.println(currentTerm.toString());
			} catch (NumberFormatException e) {
				System.out.println("catch error");
				return false;
			}
			currentTerm = currentTerm.getPtr();
		}
		return true;
	}
	
	private void cleanUpTemporaryPoly() {
		 
	}

	private void addNewPolyToModel() {
		// TODO Auto-generated method stub
		
	}
	
	private void updateGUI() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	public void actionPerformed (ActionEvent ae) {
		Object event = ae.getSource();
		
		if (event.equals(view.btnAddTerm)) addTerm();
		else if (event.equals(view.btnAddPoly)) addPoly();
	}

	public void setUpActionListeners() {
		view.btnAddTerm.addActionListener(this);
		view.btnAddPoly.addActionListener(this);
		view.btnLoad.addActionListener(this);
		view.btnSaveToDb.addActionListener(this);
	}
	

}
