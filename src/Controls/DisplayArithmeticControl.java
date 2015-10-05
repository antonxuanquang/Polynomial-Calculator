package Controls;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Interface.PolyNameNode;
import Interface.Term;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Theme.PanelOfTerm;
import Views.DisplayArithmeticView;

public class DisplayArithmeticControl implements ActionListener {

	public DisplayArithmeticView view;
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
		createFirstTerm();
	}

	private PolyNameNode createTemporaryPoly(String name) {
		PolyNameNode temporaryPoly = new PolyNameNode("Temp");
		temporaryPoly.buildHeadTerm(lab1.primaryColor, lab1.secondaryColor);
		currentTerm = temporaryPoly.getRightPtr();
		return temporaryPoly;
	}

	private void createFirstTerm() {
		 Term term = new Term(lab1.primaryColor, lab1.secondaryColor);
		 term.setPtr(temporaryPoly.getFirstTerm());
		 temporaryPoly.getRightPtr().setPtr(term);
		 addTermInGUI(term);
		 term.addPlusLabel(false);
	}
	
	
	// add a term button
	private void addTerm() {
		 Term term = new Term(lab1.primaryColor, lab1.secondaryColor);
		 term.setPtr(temporaryPoly.getFirstTerm());
		 temporaryPoly.getRightPtr().setPtr(term);
		 addTermInGUI(term);
	}

	private void addTermInGUI(Term term) {
		// manipulate x and y coordinate
		addTermIntoPanel(xCordinate, yCordinate, term);
		if (xCordinate == 440) {
			xCordinate = 0;
			yCordinate += 50;
		} else {
			xCordinate += 110;
		}
		view.panelOfTerms.setPreferredSize(new Dimension(10, yCordinate + 50));
		try {
			lab1.displayView.validate();
			lab1.displayView.repaint();
		} catch (NullPointerException e) {}
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
		if (model.getHeadOfPolyLists().isInPolyLinkedList(polyName)) {
			promptUserForAnotherName();
			return;
		}else if (passCheckingTemporaryPolyTest()) {
			cleanUpTemporaryPoly();
			addNewPolyToModel();
			updateGUI();
		} else {
			promptUserForValidInput();
			return;
		}

	}

	private void promptUserForValidInput() {
		view.lblShowingProcess.setText("Please provide valid inputs");
	}

	private void promptUserForAName() {
		view.lblShowingProcess.setText("Please provide a Polynomial Name");
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
		temporaryPoly.loookForLikeTermsAndAdds();
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
		lab1.performView.control.updateJComboBox(model.getHeadOfPolyLists());
		try {
			lab1.evaluateView.control.updateJComboBox(model.getHeadOfPolyLists());
		} catch (NullPointerException e) {}
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
			yCordinate += panelOfTerm.getYCordinate() + 2;
			currentPoly = currentPoly.getDownPtr();
		}
		view.panelOfPoly.setPreferredSize(new Dimension(830, yCordinate + 50));
		lab1.displayView.repaint();
		lab1.displayView.validate();
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
				temp.copy(currentPoly);
				result.addPoly(temp);
			}
			currentPoly = currentPoly.getDownPtr();
		}
		return result;
	}
	
	//save Polynomials to DB
	private void savePolyToDB() {
		try{
			FileOutputStream saveFile=new FileOutputStream("polynomials.sav");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			PolyNameNode poly = model.getHeadOfPolyLists().getDownPtr();
			while (poly != model.getHeadOfPolyLists()) {
				save.writeObject(poly);
				poly = poly.getDownPtr();
			}
			save.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		view.lblSaveAndLoad.setText("Successfully SAVE Polynomials to Database!!!!");
	}

	//load Polynomials from DB
	private void loadPoly() {
		try{
			FileInputStream saveFile = new FileInputStream("polynomials.sav");
			ObjectInputStream save = new ObjectInputStream(saveFile);

			PolyNameNode polyLinkFromDB = getPolyFromDB(save);
			model.adjustPointerTo(polyLinkFromDB);
			
			updatePanelOfPolies(model.getHeadOfPolyLists());
			
			save.close();
		} catch (IOException exc) {
			exc.printStackTrace(); 
		}
		try {
			lab1.performView.control.updateJComboBox(model.getHeadOfPolyLists());
			lab1.evaluateView.control.updateJComboBox(model.getHeadOfPolyLists());
		} catch (NullPointerException e) {}
		view.lblSaveAndLoad.setText("Successfully LOAD Polynomials from Database!!!!");
	}
	
	private PolyNameNode getPolyFromDB(ObjectInputStream save) {
		PolyNameNode poly = new PolyNameNode("Head");
		poly.setDownPtr(poly);
		poly.setRightPtr(null);
		try {
			PolyNameNode newPoly = (PolyNameNode) save.readObject();
			while (newPoly != null) {
				poly.addPoly(newPoly);
				try {
					newPoly = (PolyNameNode) save.readObject();
				} catch (EOFException e) {
					return poly;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return poly;
	}

	
	
	
	// Events and set up Listeners
	public DisplayArithmeticView getView() {
		return view;
	}
	
	public Lab1Model getModel() {
		return model;
	}

	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if (event.equals(view.btnAddTerm)) addTerm();
		else if (event.equals(view.btnAddPoly)) addPoly();
		else if (event.equals(view.btnLoad)) loadPoly();
		else if (event.equals(view.btnSaveToDb)) savePolyToDB();
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
