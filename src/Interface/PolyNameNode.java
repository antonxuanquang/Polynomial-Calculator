package Interface;

import java.awt.Color;

import Lab1.Lab1;

public class PolyNameNode implements PolyNameNodeInterface{
	
	private String name;
	private PolyNameNode downPointer;
	private Term rightPointer;
	
	public PolyNameNode() {}
	
	public PolyNameNode(String name) {
		this.name = name;
	}
	
	public String getPolyName() {
		return name;
	}

	public void setPolyName(String s) {
		name = s;
	}

	public PolyNameNode getDownPtr() {
		return downPointer;
	}

	public void setDownPtr(PolyNameNode p) {
		downPointer = p;
	}

	public Term getRightPtr() {
		return rightPointer;
	}

	public void setRightPtr(Term p) {
		rightPointer = p;
	}
	
	public void buildHeadTerm(Color primaryColor, Color secondaryColor) {
		rightPointer = new Term(primaryColor, secondaryColor);
		this.setRightPtr(rightPointer);
		rightPointer.setCoeffAndXYZ(0, -99, -99, -99);
		rightPointer = this.getRightPtr();
		rightPointer.setPtr(rightPointer);
	}
	
	public boolean isEmpty() {
		return downPointer == this || downPointer == null;
	}
	
	public Term getFirstTerm() {
		return rightPointer.getPtr();
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "PolyName is: " + this.getPolyName() + "\n"
				+ "**************\n";
		Term currentTerm = this.getRightPtr();
		result = result + currentTerm.toString() + "\n";
		currentTerm = currentTerm.getPtr();
		while (currentTerm != this.getRightPtr()) {
			result = result + currentTerm.toString() + "\n";
			currentTerm = currentTerm.getPtr();
		}
		return result;
	}
	
	public void removeTerm (Term previousTerm, Term currentTerm) {
		previousTerm.setPtr(currentTerm.getPtr());
	}
	
	public void addTerm (Term term) {
		if (getFirstTerm() == rightPointer) {
			term.setPtr(rightPointer);
			rightPointer.setPtr(term);
		} else {
			Term head = rightPointer;
			Term previousTerm = head;
			Term currentTerm = getFirstTerm();
			while (currentTerm != head) {
				if (term.isHavingLessPower(currentTerm)) {
					previousTerm = previousTerm.getPtr();
					currentTerm = currentTerm.getPtr();
					if (currentTerm == head) {
						term.setPtr(currentTerm);
						previousTerm.setPtr(term);
					}
				} else {
					term.setPtr(currentTerm);
					previousTerm.setPtr(term);
					break;
				}
			}
		}
	}
	
	public void copy (PolyNameNode poly) {
		setPolyName(poly.getPolyName());
		Term currentTerm = poly.getFirstTerm();
		while (currentTerm != poly.getRightPtr()) {
			Term term = new Term(currentTerm.primaryColor, 
					currentTerm.secondaryColor);
			term.copy(currentTerm);
			addTerm(term);
			currentTerm = currentTerm.getPtr();
		}
	}
	
	public PolyNameNode getHeadOfPolyLists() {
		return this;
	}
	
	public boolean isInPolyLinkedList(String name) {	
		PolyNameNode currentPoly = this.getDownPtr();
		while (currentPoly != getHeadOfPolyLists()) {
			if (currentPoly.getPolyName().equals(name)) {
				return true;
			}
			currentPoly = currentPoly.getDownPtr();
		}
		return false;
	}
	
	public void addPoly(PolyNameNode poly) {
		poly.setDownPtr(this.getDownPtr());
		this.setDownPtr(poly);
	}
	
	public void removePoly(PolyNameNode previousPoly, PolyNameNode currentPoly) {
		previousPoly.setDownPtr(currentPoly.getDownPtr());
	}

	public String getAllPolyNames() {
		String result = "";
		PolyNameNode currentPoly = this.getDownPtr();
		while (currentPoly != getHeadOfPolyLists()) {
			result += currentPoly.getPolyName() + "\n";
			currentPoly = currentPoly.getDownPtr();
		}
		return result;
	}

	public void removeByName(String text) {
		PolyNameNode previousPoly = this;
		PolyNameNode currentPoly = this.getDownPtr();
		while (currentPoly != getHeadOfPolyLists()) {
			if (currentPoly.getPolyName().equals(text)) {
				removePoly(previousPoly, currentPoly);
				return;
			} else {
				previousPoly = previousPoly.getDownPtr();
				currentPoly = currentPoly.getDownPtr();
			}
		}
	}

	

	public PolyNameNode add(PolyNameNode poly) {
		// TODO Auto-generated method stub
		PolyNameNode result = new PolyNameNode();
		result.buildHeadTerm(getFirstTerm().primaryColor, getFirstTerm().secondaryColor);
		Term termP = this.getFirstTerm();
		Term termQ = poly.getFirstTerm();
		while (termP != this.getRightPtr() && termQ != poly.getRightPtr()) {
			Term term = new Term(termP.primaryColor, termP.secondaryColor);
			if (termP.isEqualPowersTo(termQ)) {
				term.copy(termQ);
				int sumCoeff = termP.getCoeff() + termQ.getCoeff();
				term.setCoeff(sumCoeff);
				if (sumCoeff != 0) {
					result.addTerm(term);
				}
				termP = termP.getPtr();
				termQ = termQ.getPtr();
			} else {
				if (termP.isHavingLessPower(termQ)) {
					term.copy(termQ);
					result.addTerm(term);
					termQ = termQ.getPtr();
				} else {
					term.copy(termP);
					result.addTerm(term);
					termP = termP.getPtr();
				}
			}
		}
		return result;
	}

	public PolyNameNode subtract(PolyNameNode poly) {
		PolyNameNode result = new PolyNameNode();
		result.buildHeadTerm(getFirstTerm().primaryColor, getFirstTerm().secondaryColor);
		
		return result;
	}

	public PolyNameNode multiply(PolyNameNode poly) {
		PolyNameNode result = new PolyNameNode();
		result.buildHeadTerm(getFirstTerm().primaryColor, getFirstTerm().secondaryColor);
		
		return result;
	}

}
