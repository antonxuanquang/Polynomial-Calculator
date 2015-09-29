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
		rightPointer.setCoeffAndXYZ(-99, 0, 0, 0);
		rightPointer = this.getRightPtr();
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
		if (getFirstTerm() == null) {
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
				} else {
					term.setPtr(currentTerm);
					previousTerm.setPtr(term);
					break;
				}
			}
		}
	}

}
