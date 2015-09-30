package Controls;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Interface.PolyNameNode;
import Interface.Term;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Theme.PanelOfTerm;
import Views.DisplayArithmeticView;

public class DisplayArithmeticControl implements ActionListener {

	private DisplayArithmeticView view;
	private Lab1Model model;
	private Lab1 lab1;

	private int xCordinate, yCordinate;
	private PolyNameNode temporaryPoly;
	private Term currentTerm;

	public DisplayArithmeticControl(DisplayArithmeticView fromView) {
		view = fromView;
		model = view.model;
		lab1 = view.lab1;

		initiate();
	}

	// initialize
	private void initiate() {
		xCordinate = 0;
		yCordinate = 0;
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

		// delete later
		firstTerm.setCoeffAndXYZ(4, 4, 5, 6);
		view.tfPolyName.setText("abc");
	}

	
	
	// add a term button
	private void addTerm() {
		// Term term = new Term(lab1.primaryColor, lab1.secondaryColor);
		// currentTerm = addTermInTemporaryPolyAndSetPointer(currentTerm, term);
		// addTermInGUI(term);

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
		// manipulate x and y coordinate
		if (xCordinate == 440) {
			xCordinate = 0;
			yCordinate += 50;
		} else {
			xCordinate += 110;
		}
		addTermIntoPanel(xCordinate, yCordinate, term);
		// check for x and y coordinates bounds
		// if (xCordinate == 440 && yCordinate == 50) {
		// view.btnAddTerm.setEnabled(false);
		// }
		view.panelOfTerms.setPreferredSize(new Dimension(10, yCordinate + 50));
		lab1.validate();
		lab1.repaint();
	}

	private void addTermIntoPanel(int xCordinate, int yCordinate, Term term) {
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
		if (!(model.getHeadOfPolyLists().isInPolyLinkedList(polyName))) {
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
		model.getHeadOfPolyLists().addPoly(newPoly);
	}

	private void updateGUI() {
		updatePanelOfTerms();
		updatePanelOfPolies(model.getHeadOfPolyLists());
	}

	private void updatePanelOfTerms() {
		view.lblShowingProcess.setText("");
		view.panelOfTerms.removeAll();
		view.tfPolyName.setText("");
		initiate();
	}

	public void updatePanelOfPolies(PolyNameNode poly) {
		view.panelOfPoly.removeAll();
		PolyNameNode currentPoly = poly.getDownPtr();
		int yCordinate = 0;
		while (currentPoly != poly) {
			PanelOfTerm panelOfTerm = new PanelOfTerm(currentPoly, this);
			view.panelOfPoly.add(panelOfTerm);
			System.out.println(yCordinate);
			yCordinate += panelOfTerm.getYCordinate();
			currentPoly = currentPoly.getDownPtr();
		}
		view.panelOfPoly.setPreferredSize(new Dimension(830, yCordinate + 50));
		lab1.repaint();
		lab1.validate();
	}

	
	
	//serach for polynomials
	private void searchPoly(String text) {
		if (text.equals("")) {
			updatePanelOfPolies(model.getHeadOfPolyLists());
		} else {
			PolyNameNode result = copyPolyByText(text);
			updatePanelOfPolies(result);
		}
	}

	private PolyNameNode copyPolyByText(String text) {
		PolyNameNode result = new PolyNameNode();
		result = new PolyNameNode("Head");
		result.setDownPtr(result);
		result.setRightPtr(null);		
		PolyNameNode currentPoly = model.getHeadOfPolyLists().getDownPtr();
		while (currentPoly != model.getHeadOfPolyLists()) {
			if (currentPoly.getPolyName().contains(text)) {
				PolyNameNode temp = new PolyNameNode();
				temp.buildHeadTerm(lab1.primaryColor, lab1.secondaryColor);
				System.out.println(currentPoly);
				temp.copy(currentPoly);
				result.addPoly(temp);
			}
			currentPoly = currentPoly.getDownPtr();
		}
		
		return result;
	}

	public Lab1Model getModel() {
		return model;
	}

	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if (event.equals(view.btnAddTerm)) addTerm();
		else if (event.equals(view.btnAddPoly)) addPoly();
	}

	public void setUpActionListeners() {
		view.btnAddTerm.addActionListener(this);
		view.btnAddPoly.addActionListener(this);
		view.btnLoad.addActionListener(this);
		view.btnSaveToDb.addActionListener(this);
		view.tfSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				searchPoly(view.tfSearch.getText());
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});
	}

}
