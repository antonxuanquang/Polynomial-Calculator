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
	
	private int xCordinate, yCordinate;
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
		xCordinate = 0; yCordinate = 0;
		temporaryPoly = createTemporaryPoly("Temp");
	}
	
	private PolyNameNode createTemporaryPoly(String name) {
		PolyNameNode temporaryPoly = new PolyNameNode("Temp");
		temporaryPoly.buildHeadTerm(lab1.primaryColor, lab1.secondaryColor);
		currentTerm = temporaryPoly.getRightPtr();
		createFirstTerm();
		return temporaryPoly;
	}
	
	private void createFirstTerm() {
		Term firstTerm = new Term(lab1.primaryColor, lab1.secondaryColor);
		firstTerm.addPlusLabel(false);
		addTermIntoPanel(0, 0, firstTerm);		
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, firstTerm);
		
//		delete later
		firstTerm.setCoeffAndXYZ(4, 4, 5, 6);
		view.tfPolyName.setText("abc");
	}
	
	
	
// add a term button
	private void addTerm() {
//		Term term = new Term(lab1.primaryColor, lab1.secondaryColor);
//		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, term);
//		addTermInGUI(term);	
		
		Term secondTerm = new Term(lab1.primaryColor, lab1.secondaryColor);	
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, secondTerm);
		secondTerm.setCoeffAndXYZ(4, 5, 6, 7);
		addTermInGUI(secondTerm);
		
		Term third = new Term(lab1.primaryColor, lab1.secondaryColor);	
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, third);
		third.setCoeffAndXYZ(4, 6, 7, 8);
		addTermInGUI(third);
		
		Term fourth = new Term(lab1.primaryColor, lab1.secondaryColor);	
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, fourth);
		fourth.setCoeffAndXYZ(4, 7, 8, 9);
		addTermInGUI(fourth);
		
		Term fifth = new Term(lab1.primaryColor, lab1.secondaryColor);	
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, fifth);
		fifth.setCoeffAndXYZ(5, 5, 6, 7);
		addTermInGUI(fifth);
		
		Term sixth = new Term(lab1.primaryColor, lab1.secondaryColor);	
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, sixth);
		sixth.setCoeffAndXYZ(4, 4, 5, 6);
		addTermInGUI(sixth);
	}
	
	private Term addTermInTemporaryPolyAndSetPointer(Term currentTerm, Term nextTerm) {
		currentTerm.setPtr(nextTerm);
		currentTerm = currentTerm.getPtr();
		return currentTerm;
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
		String polyName = view.tfPolyName.getText();
		if (polyName.equals("")) {
			promptUserForAName();
			return;
		}
		if (!(model.isInPolyLinkedList(polyName))) {
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

	private void promptUserForAName() {
		view.lblShowingProcess.setText("Please provide a Polynomial Name");
	}

	private void linkToHead() {
		currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, temporaryPoly.getRightPtr());
	}
	
	private void promptUserForAnotherName() {
		view.lblShowingProcess.setText("'" + view.tfPolyName.getText() + "' is "
				+ "already in the polynomial lists. Please choose another name ");
		view.tfPolyName.setText("");
	}

	private boolean passCheckingTemporaryPolyTest() {
		Term currentTerm = temporaryPoly.getRightPtr();
		currentTerm = currentTerm.getPtr();
		while (currentTerm != temporaryPoly.getRightPtr()) {
			try {
				currentTerm.toString();
			} catch (NumberFormatException e) {
				System.out.println("catch error");
				return false;
			}
			currentTerm = currentTerm.getPtr();
		}
		return true;
	}
	
	private void cleanUpTemporaryPoly() {
		// exclude zeroes coefficient
		temporaryPoly = arrangeInDescendingOrder();
		loookForLikeTermsAndAdds();
	}
	
	private PolyNameNode arrangeInDescendingOrder() {
		PolyNameNode resultPoly = new PolyNameNode();
		resultPoly.buildHeadTerm(lab1.primaryColor, lab1.secondaryColor);
		Term headTerm = temporaryPoly.getRightPtr();
		Term currentTerm = headTerm.getPtr();
		while (currentTerm != headTerm) {
			Term term = currentTerm;
			temporaryPoly.removeTerm(headTerm, currentTerm);
			resultPoly.addTerm(term);
			currentTerm = headTerm.getPtr();
		}
		return resultPoly;
	}

	private void loookForLikeTermsAndAdds() {
		Term headTerm = temporaryPoly.getRightPtr();
		Term currentTerm = headTerm.getPtr();
		while (currentTerm != headTerm) {
			Term nextTerm = currentTerm.getPtr();
			if (currentTerm.isEqualPowersTo(nextTerm)) {
				currentTerm = currentTerm.addLikeTerm(nextTerm);
				temporaryPoly.removeTerm(currentTerm, nextTerm);
				nextTerm = currentTerm.getPtr();
			} else {
				currentTerm = currentTerm.getPtr();	
			}
		}
	}

	private void addNewPolyToModel() {
		temporaryPoly.setPolyName(view.tfPolyName.getText());
		PolyNameNode newPoly = new PolyNameNode();
		newPoly.buildHeadTerm(lab1.primaryColor, lab1.secondaryColor);
		newPoly.copy(temporaryPoly);
		model.addPoly(newPoly);
	}
	
	
	private void updateGUI() {
		view.panelOfTerms.removeAll();
		view.tfPolyName.setText("");
		initiate();
		lab1.repaint();
		lab1.validate();
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
